package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.tool.MyResponseBody;
import com.example.demo.tool.SessionUtil;
import org.aspectj.bridge.IMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/7/22 17:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static HttpSession session;
    private static volatile int count;
    @Resource
    private UserMapper userMapper;
 @RequestMapping("/login")
    public UserInfo userLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
     if(userMapper.getUserByUsername(username)!=null){
         UserInfo userInfo=userMapper.login(username,password);
         count=userMapper.getCountByUsername(username);
         if(userInfo!=null&&userInfo.getId()>0&&(request.getSession(false)==null||count<5)){
             userMapper.updateLoginTime(userInfo.getId());
             userMapper.updateFailCount(username,0);
             session=request.getSession();
             userInfo.setFailcount(0);
             count=0;
             session.setAttribute("userinfo",userInfo);
         }else{
             userInfo=new UserInfo();
             if(count<5){
                 session=request.getSession();
                 session.setMaxInactiveInterval(120);
                 count++;
                 userMapper.updateFailCount(username,count);
                 userInfo.setUsername(username);
             }
             userInfo.setFailcount(count);
         }
         return userInfo;
     }
     return new UserInfo();
 }
 //查询当前登陆用户的权限
 @RequestMapping("/checkadmin")
 @ResponseBody
 public MyResponseBody<Integer> isAdmin(HttpServletRequest request){
     int data=0;
     int status=-1;
     String message="";
     session=request.getSession(false);
     UserInfo userInfo=(UserInfo) session.getAttribute("userinfo");
     if(session!=null&&userInfo!=null){
         status=200;
         data=userInfo.getIsadmin();
     }else{
         message="用户不存在！";
     }
     return new MyResponseBody<>(status,message,data);
 }
 @RequestMapping("/add")
    public MyResponseBody<Integer> add(UserInfo userInfo,HttpServletRequest request){
     int data=0;
     int status=-1;
     String message="";
      UserInfo user = SessionUtil.getUserBySession(request);
         if(user!=null&&userInfo.getIsadmin()!=user.getIsadmin()){
            message="权限不够！";
            status=-1;
         }else if(user==null){
             if(userInfo==null){
                 message="当前处于未登录非法请求状态！";
             }
         }else{
             data=userMapper.add(userInfo);
             status=200;
         }
     return new MyResponseBody<>(status,message,data);
 }
 @RequestMapping("/getuser")
 public MyResponseBody<UserInfo> getUser(int id){
    UserInfo userInfo= userMapper.getUser(id);
    int status=-1;
    String message="";
    if(userInfo==null){
        message="用户信息获取失败！";
    }else{
        status=200;
    }
    return new MyResponseBody<>(status,message,userInfo);
 }
 @RequestMapping("/update")
    public MyResponseBody<Integer> update(UserInfo userInfo){
     int status=200;
     String message="";
     int data=userMapper.update(userInfo);
     if(data==0){
         message="修改失败！";
         status=-1;
     }
     return new MyResponseBody<>(status,message,data);
 }
 @RequestMapping("/list")
 public MyResponseBody<HashMap<String,Object>>getlist(String name,String address,String email,int cpage,int psize,HttpServletRequest request){
    name=name.equals("")?null:name;
    address=address.equals("")?null:address;
    email=email.equals("")?null:email;
    UserInfo userInfo=SessionUtil.getUserBySession(request);
     Integer isadmin=null;
    if(userInfo==null){
        return new MyResponseBody<>(-1,"未登录！",new HashMap<>());
    }
    if(userInfo.getIsadmin()==0){
        isadmin=0;
    }
     int skipCount=(cpage-1)*psize;
     List<UserInfo> list=userMapper.getListByPage(name,address,email,skipCount,psize,isadmin);
     int status=-1;
     String message="";
     int tcount=userMapper.getCount(name,address,email,isadmin);
     int tpage=(int)Math.ceil(tcount/(psize*1.0));//向上取整
     if(tcount>0){
         status=200;
     }else{
         message="没有用户信息！";
     }
     HashMap<String,Object>map=new HashMap<>();
     map.put("list",list);
     map.put("tcount",tcount);
     map.put("tpage",tpage);
     return new MyResponseBody<>(status,message,map);
 }
 @RequestMapping("/del")
 public MyResponseBody<Integer> del(@RequestParam int id,HttpServletRequest request){
     UserInfo userInfo=SessionUtil.getUserBySession(request);
     if(userInfo==null){
         return new MyResponseBody<>(-1,"未登录！",0);
     }
     if(id==userInfo.getId()){
         return new MyResponseBody<>(-1,"不能删除自己！",0);
     }
     Integer isadmin=null;
     if(userInfo.getIsadmin()==0){
         isadmin=0;
     }
     int data=userMapper.del(id,isadmin);
     return new MyResponseBody<>(200,"",data);
 }
 @RequestMapping("/del2")
 public MyResponseBody<Integer> del2(String ids,HttpServletRequest request){
     UserInfo userInfo=SessionUtil.getUserBySession(request);
     if(userInfo==null){
         return new MyResponseBody<>(-1,"未登陆！",0);
     }
     Integer data=0;
     ids=ids.substring(0,ids.length()-1);

     data=userMapper.del2(ids.split(","));
     if(data==0){
         return new MyResponseBody<>(-1,"没有要删除的用户！",0);
     }
     return new MyResponseBody<>(200,"",data);
 }
}
