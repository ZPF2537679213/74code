package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author:飞哥
 * @date: 2021/4/13 21:07
 */
public class UDPClient {
    private static final int bleng=1024;
    private static final String ip="127.0.0.1";
    private static final int part=9002;
    public static void main(String[] args) throws IOException {
        //启动客户端
        DatagramSocket socket=new DatagramSocket();//不需要固定端口号
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.print("我:");
            String msg=input.nextLine();
            DatagramPacket packet=new DatagramPacket(
                    msg.getBytes(),//要发送的数据字节数组
                    msg.getBytes().length,//要发送的长度——字节为单位
                    InetAddress.getByName(ip),//创建一个ip对象
                    part//服务器端口号
            );
            socket.send(packet);
            DatagramPacket clipacket=new DatagramPacket(
                    new byte[bleng],//从服务器发送来的字节数据
                    bleng//允许接受的最大字节长度
            );
            socket.receive(clipacket);//接收服务器数据
            String serMsg=new String(clipacket.getData());
            System.out.println("对方:"+serMsg);
        }
    }
}
