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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article myArtical=new Article();
        int succ=-1;
        String msg="";
        int id=Integer.parseInt(req.getParameter("id"));
        if(id>0){
            WorkDatabase work=new WorkDatabase();
            try {
                myArtical=work.search(id);
                succ=1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg="查找错误!";
        }
        HashMap<String,Object>map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        map.put("myart",myArtical);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
