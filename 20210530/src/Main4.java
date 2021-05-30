
import java.util.*;

/**
 * @author:飞哥
 * @date: 2021/5/30 10:52
 */
public class Main4 {
    public static void main(String[] args) {

    }
}
/**
 * 链接：https://www.nowcoder.com/questionTerminal/05f97d9b29944c018578d98d7f0ce56e
 * 来源：牛客网
 *
 * Web系统通常会频繁地访问数据库，如果每次访问都创建新连接，性能会很差。为了提高性能，架构师决定复用已经创建的连接。当收到请求，并且连接池中没有剩余可用的连接时，系统会创建一个新连接，当请求处理完成时该连接会被放入连接池中，供后续请求使用。
 *
 * 现在提供你处理请求的日志，请你分析一下连接池最多需要创建多少个连接。
 *
 * 输入描述:
 * 输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000），表示请求的数量。
 *
 * 紧接着n行，每行包含一个请求编号id（A、B、C……、Z）和操作（connect或disconnect）。
 *
 *
 * 输出描述:
 * 对应每一组数据，输出连接池最多需要创建多少个连接。
 * 示例1
 * 输入
 * 6
 * A connect
 * A disconnect
 * B connect
 * C connect
 * B disconnect
 * C disconnect
 * 输出
 * 2
 * **/
class Main5{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String s=input.nextLine();
            int n=Integer.valueOf(s);
            String[]connect=new String[n];
            int maxnum=0,count=0;
            for(int i=0;i<n;++i){
                connect[i]=input.nextLine();
                if(!connect[i].contains("disconnect")){
                    count++;
                }else{
                    count--;
                }
                if(count>maxnum){
                    maxnum=count;
                }
            }
            System.out.println(maxnum);
        }
        input.close();
    }
}
/**
 * 链接：https://www.nowcoder.com/questionTerminal/433c0c6a1e604a4795291d9cd7a60c7a
 * 来源：牛客网
 *
 * 工作中，每当要部署一台新机器的时候，就意味着有一堆目录需要创建。例如要创建目录“/usr/local/bin”，就需要此次创建“/usr”、“/usr/local”以及“/usr/local/bin”。好在，Linux下mkdir提供了强大的“-p”选项，只要一条命令“mkdir -p /usr/local/bin”就能自动创建需要的上级目录。
 * 现在给你一些需要创建的文件夹目录，请你帮忙生成相应的“mkdir -p”命令。
 *
 * 输入描述:
 * 输入包含多组数据。
 *
 * 每组数据第一行为一个正整数n(1≤n≤1024)。
 *
 * 紧接着n行，每行包含一个待创建的目录名，目录名仅由数字和字母组成，长度不超过200个字符。
 *
 *
 * 输出描述:
 * 对应每一组数据，输出相应的、按照字典顺序排序的“mkdir -p”命令。
 *
 * 每组数据之后输出一个空行作为分隔。
 * 示例1
 * 输入
 * 3
 * /a
 * /a/b
 * /a/b/c
 * 3
 * /usr/local/bin
 * /usr/bin
 * /usr/local/share/bin
 * 输出
 * mkdir -p /a/b/c
 *
 * mkdir -p /usr/bin
 * mkdir -p /usr/local/bin
 * mkdir -p /usr/local/share/bin
 * **/

class Main6{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            String[]url=new String[n];
            for(int i=0;i<n;++i){
                url[i]=input.next();
            }
            Arrays.sort(url);
            ArrayList<String>list=new ArrayList<>();
            for(int i=1;i<n;++i){
                if(!url[i].startsWith(url[i-1]+"/")){
                    list.add(url[i-1]);
                }
            }
            list.add(url[n-1]);
            for(String x:list){
                System.out.println("mkdir -p "+x);
            }
            System.out.println();
        }
    }
}