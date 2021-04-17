package text;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author:飞哥
 * @date: 2021/4/17 18:04
 */
public class CrawlerFirst {
    public static void main(String[] args) throws IOException {
    //打开浏览器——创建一个HeepClient对象
      CloseableHttpClient httpClient= HttpClients.createDefault();
      //输入网址
        HttpGet get=new HttpGet("http://word.iciba.com");//输入网址
    //按回车，发起请求，返回响应
        CloseableHttpResponse response=httpClient.execute(get);//返回响应
        //解析响应
        //判断状态码是不是200
        if(response.getStatusLine().getStatusCode()==200){
        //创建响应体
            HttpEntity httpEntity=response.getEntity();
            //拿到响应体中的html页面的信息
            String content=EntityUtils.toString(httpEntity,"utf-8");//第一个参数位响应体，第二个为编码格式
            System.out.println(content);
        }
    }
}
