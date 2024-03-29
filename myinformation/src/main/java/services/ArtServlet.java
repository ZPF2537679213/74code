package services;

import dao.WorkDatabase;
import models.MyArtical;
import models.UserInfo;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
@WebServlet("/art")
public class ArtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";
        List<MyArtical> list=null;
        HttpSession session=request.getSession(false);
        if(session==null){
            msg="非法登陆!";
        }else{
            UserInfo userInfo=(UserInfo)session.getAttribute("userinfo");
              int  uid=userInfo.getId();
              int pase=Integer.parseInt(request.getParameter("pase"));
              int psize=Integer.parseInt(request.getParameter("psize"));
            WorkDatabase work=new WorkDatabase();
            try {
                list=work.select(uid,pase,psize);
                succ=list.size();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        HashMap<String,Object> map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        map.put("list",list);
        GetUser getUser=new GetUser();
        getUser.getUser(response,map);
    }
}
