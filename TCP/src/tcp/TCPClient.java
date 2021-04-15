package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author:飞哥
 * @date: 2021/4/15 19:53
 */
public class TCPClient {
    private static final String ip="127.0.0.1";
    private static final int port=9001;
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(ip,port);
        try(BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
            BufferedWriter bufferedWriter=new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            Scanner input=new Scanner(System.in)
        ){
            while(true){
                System.out.print("我->");
                String msg=input.nextLine();
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                String serMsg=bufferedReader.readLine();
                System.out.println("服务器:"+serMsg);
            }
        }
    }
}
