/**
 * @Copyright (C), 2015-2021, XXX有限公司
 * @FileName: ClientTest
 * @Author: qintianyu
 * @Date: 2021/3/2 11:32
 * @Description:
 * @Version: 1.0
 */
package com.ytc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description
 *
 * @author qintianyu
 * @create 2021/3/2
 * @since 1.0.0
 */
public class ClientTest {
    public static void main(String[] args) {
        reg();
    }

    private static void reg(){
        System.err.println("注册");
        String result = request("http://localhost:8087/getConfig");
        if (result != null){
            //配置有更新，重新拉取配置
            //.....
            System.out.println("更新配置");
        }
        //重新注册
        reg();
    }

    private static String request(String url){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL getUrl = new URL(url);
            connection  = (HttpURLConnection) getUrl.openConnection();
            connection.setReadTimeout(90000);
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Charset", "UTF-8");
            /**
             * 得到一个HTTP响应信息的状态码
             * <li> 1xx: Informational
             * <li> 2xx: Success
             * <li> 3xx: Redirection
             * <li> 4xx: Client Error
             * <li> 5xx: Server Error
             */
            System.out.println(connection.getResponseCode());

            if (200 == connection.getResponseCode()){
                //获取此连接的一个输入流
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
                StringBuilder result = new StringBuilder();
                String line = null;
                //readLine()：Reads a line of text
                while ((line = reader.readLine()) !=null){
                    result.append(line);
                }
                System.out.println("结果："+result);
                return result.toString();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (connection!=null){
                //关闭连接
                connection.disconnect();
            }
        }
        return null;
    }
}
