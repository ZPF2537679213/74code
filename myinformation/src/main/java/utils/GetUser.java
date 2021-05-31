package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class GetUser {
    public void getUser(HttpServletResponse response, HashMap<String,Object>map) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        ObjectMapper mapper=new ObjectMapper();
       String str=mapper.writeValueAsString(map);
        PrintWriter print=response.getWriter();
        print.println(str);
    }
}
