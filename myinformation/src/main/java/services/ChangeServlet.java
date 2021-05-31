package services;

import dao.WorkDatabase;
import models.MyArtical;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/change")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ=-1;
        String msg="";
        int id=Integer.parseInt(req.getParameter("id"));
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        if(id>0&&title!=null&&!title.equals("")&&content!=null&&!content.equals("")){
            WorkDatabase work=new WorkDatabase();
            try {
                succ=work.updateArt(id,title,content);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg="参数不完整!";
        }
        HashMap<String,Object>map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

