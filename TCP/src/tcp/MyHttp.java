package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:飞哥
 * @date: 2021/4/15 21:28
 */
public class MyHttp {
    private static final int port=9002;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(port);
        System.out.println("欢迎来到服务器");
        Socket socket=serverSocket.accept();
        try(
                BufferedReader bufferedReader=new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter bufferedWriter=new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                )
                ){
            String request=bufferedReader.readLine();
            String[]res=request.split(" ");
            String method=res[0];
            String uri=res[1];
            String content="";
            if(uri.contains("404")){
               content="<h1>访问不存在</h1>";
            }
            if(uri.contains("200")){
               content="<h1>你好,世界</h1>";
            }
            String httpVersion=res[2];
            System.out.println(String.format("方法:%s URI:%s 协议版本号:%s",method,uri,httpVersion));
            bufferedWriter.write(String.format("%s 200 ok\n",httpVersion));
            bufferedWriter.write("Content-type: text/html;charset=utf-8\n");
            bufferedWriter.write(String.format("Content-length: %d\n",content.getBytes().length));
            bufferedWriter.write("\n");
            bufferedWriter.write(content+"\n");
            bufferedWriter.flush();
        }
    }
}
