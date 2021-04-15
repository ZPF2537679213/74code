package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:飞哥
 * @date: 2021/4/15 19:27
 */
public class TCPServer {
    private static final int port=9001;
    public static void main(String[] args) throws IOException {
        //创建服务器并启动
        ServerSocket serverSocket=new ServerSocket(port);
        System.out.println("服务器已启动");
        //等待客户端连接
        Socket socket=serverSocket.accept();
        //当执行到这一步，表示已经有客户端连接了
        System.out.println(String.format("已经有客户端连接了,IP:%s   端口号:%s",socket.getInetAddress().getHostAddress(),
                socket.getPort()));
        //收发消息
        try (
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))
        ) {
            // 3.收、发消息
            // 接收客户端的消息
            while(true){
                String msg = reader.readLine();
                if(msg!=null&&!msg.equals("")){
                    System.out.println("接收到客户端消息：" + msg);
                    // 给客户端一个反馈消息
                    String serMsg = "我收到了";
                    writer.write(serMsg + "\n"); // \n 不能省略
                    // 发送缓冲区刷新操作【执行此步骤意味着里面将缓冲区的消息发送出去】
                    writer.flush();
                }
            }
        }
    }
}
