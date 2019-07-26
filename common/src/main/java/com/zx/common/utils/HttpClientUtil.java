package com.zx.common.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * @author zhouxiong
 * @Title: HttpClientUtil
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/7/2610:41
 */
public class HttpClientUtil {
    public static String doGet(String uri, Map<String,String> parameter){
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(uri);
            if(parameter !=null){
                for (String key:parameter.keySet()){
                    builder.addParameter(key, parameter.get(key));
                }
            }
            URI uri1 = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri1);

            // 执行请求i
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                //System.out.println(response.getAllHeaders());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
}

}

