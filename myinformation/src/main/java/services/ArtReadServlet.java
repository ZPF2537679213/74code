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

@WebServlet("/artread")
public class ArtReadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ=-1;
        String msg="";
        int id=Integer.parseInt(req.getParameter("id"));
        HashMap<String,Object>map=new HashMap<>();
        if(id<=0){
            msg="文章编号异常!";
        }else{
            WorkDatabase workDatabase=new WorkDatabase();
            Article article=null;
            try {
               article=workDatabase.search(id);
                if(article!=null){
                    succ=1;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            map.put("succ",succ);
            map.put("msg",msg);
            map.put("art",article);
        }
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }
}
