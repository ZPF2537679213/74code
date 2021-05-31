package services;

import dao.WorkDatabase;
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

@WebServlet("/addart")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        UserInfo userInfo=(UserInfo) session.getAttribute("userinfo");
        int uid=userInfo.getId();
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        int succ=-1;
        String msg="";
        if(title==null||title.equals("")||content==null||content.equals("")){
            msg="标题或者内容不能为空!";
        }else{
            WorkDatabase workDatabase=new WorkDatabase();
            try {
                succ=workDatabase.addArt(uid,title,content);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        HashMap<String,Object>map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }
}
