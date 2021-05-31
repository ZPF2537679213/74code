package services;

import dao.WorkDatabase;
import models.vo.Article;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/list")
public class PaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int succ=-1;
       String msg="";
        int pase=Integer.parseInt(req.getParameter("pase"));
       int psize=Integer.parseInt(req.getParameter("psize"));
        WorkDatabase work=new WorkDatabase();
        List<Article> list=null;
        try {
            list=work.paseart(pase,psize);
            succ=1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HashMap<String,Object>map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        map.put("list",list);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
