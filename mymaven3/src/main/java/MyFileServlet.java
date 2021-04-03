import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig
public class MyFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Part part=request.getPart("myfile");
        part.write(String.format("G:\\m.%s",part.getSubmittedFileName()));
        PrintWriter print= response.getWriter();
        print.println(String.format("<h1>上传成功</h1>"));
    }
}
