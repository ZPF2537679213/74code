import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //验证用户名和密码是否正确
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        PrintWriter print=response.getWriter();
        if(name!=null&&pwd!=null&&name.equals("root")&&pwd.equals("root")){

            HttpSession session=request.getSession();//不是false，就会创建一个新的会话信息，在服务器中保存一个密钥和会话相同的信息
            String id=session.getId();//获取sessionid
            print.println("<h2>欢迎访问~</h2>");
            print.println(id);

            //session存储访问数量的key
            String countKey="count";
            if(session.isNew()){//第一次访问
                session.setAttribute(countKey,1);
            }else{
                int con=(int)session.getAttribute(countKey);//拿到当前用户的访问数
                con++;
                session.setAttribute(countKey,con);
            }
            print.println(session.getAttribute(countKey));
        }else{
            print.println("<h1>用户密码错误</h1>");
        }
    }
}
