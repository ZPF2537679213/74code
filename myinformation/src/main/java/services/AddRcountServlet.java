package services;

import dao.WorkDatabase;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/addcount")
public class AddRcountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        int succ=-1;
        String msg="";
        HashMap<String,Object>map=new HashMap<>();
        if(id>0){
            WorkDatabase workDatabase=new WorkDatabase();
            try {
                succ=workDatabase.addRcount(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg="文章编号有误!";
        }
        map.put("succ",succ);
        map.put("msg",msg);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
