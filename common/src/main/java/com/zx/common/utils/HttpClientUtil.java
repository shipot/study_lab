package com.zx.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxiong
 * @Title: HttpClientUtil
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/7/2610:41
 */
public class HttpClientUtil {


    public static String doGet(String uri){
        return doGet(uri, null);
    }

    public static String doPost(String uri){
        return doPost(uri, null);
    }


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
    public static String doPost(String urI,Map<String,String> parameter){
        //创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        //创建Response
        CloseableHttpResponse response = null;

        try {
            //创建HttpPost请求
            HttpPost httpPost = new HttpPost(urI);
            //整理参数
            if (parameter != null) {
                JSONObject jsonObject = new JSONObject();
                for (String key : parameter.keySet()){
                    jsonObject.put(key, parameter.get(key));
                }
                StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);

               /* List<NameValuePair> parameterList = new ArrayList<>();
                for (String key : parameter.keySet()) {
                    //利用BasicNameValuePair(key,values)整理参数
                    parameterList.add(new BasicNameValuePair(key, parameter.get(key)));
                }
                //UrlEncodedFormEntity(List)构建post请求表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameterList);
                //将表单放进HttpPost请求体
                httpPost.setEntity(entity);*/
            }
            //执行请求，得到response
            response = httpClient.execute(httpPost);
            //获取响应实体
            result = EntityUtils.toString(response.getEntity());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
            response.close();
        }catch (Exception e){
                e.printStackTrace();
            }
        }
     return result;
    }

}

