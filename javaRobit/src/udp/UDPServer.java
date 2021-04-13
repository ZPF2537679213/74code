package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author:飞哥
 * @date: 2021/4/13 20:52
 */
public class UDPServer {
    private static int port=9002;//设置端口号
    private static int bleng=1024;
    //启动一个UDP服务器端
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(port);
        System.out.println("欢迎来到服务器");
        while(true){
            //初始化数据包
            DatagramPacket packet=new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            //等待客户端连接
            socket.receive(packet);
            //有链接了
            String msg=new String(packet.getData());
            System.out.println("对方:"+msg);
            msg=msg.replaceAll("吗？",".");
            //给客户端一个响应
            String serMsg=msg;
            DatagramPacket serpacket=new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,//字节长度
                    packet.getAddress(),//获取客户端的IP
                    packet.getPort()//获取客户端的端口号
            );
            socket.send(serpacket);
        }
    }
}
