package text;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author:飞哥
 * @date: 2021/4/17 20:27
 */
public class MyHttpGet {
    public static void main(String[] args) throws URISyntaxException, IOException {
       CloseableHttpClient httpClient= HttpClients.createDefault();
       //创建带参数的GET
        //创建URIBuilder
        URIBuilder uriBuilder=new URIBuilder("http://word.iciba.com/");
        //设置参数
        //"http://word.iciba.com/?action=words&class=11&course=1"
        uriBuilder.setParameter("action","words").setParameter("class","11").setParameter("course","1");
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet);
        if(closeableHttpResponse.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=closeableHttpResponse.getEntity();
            String msg=EntityUtils.toString(httpEntity,"utf8");
            System.out.println(msg);
        }
    }
}
