import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //创建cookie
        Cookie username=new Cookie("name","pwd");
        //设置Cookie最大存活时间
        username.setMaxAge(60);//可以为-1，表示cookie在浏览器关闭之前一直存在
        //用来告诉客户端存储cookie信息
        response.addCookie(username);
        PrintWriter print=response.getWriter();
        print.println("<h1>cookie存储成功</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
