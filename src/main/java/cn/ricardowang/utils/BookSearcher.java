package cn.ricardowang.utils;

import cn.ricardowang.bean.Book;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangqin
 * @Date: 2021/2/9 0009 - 02 -09 -14:14
 * @Description: cn.ricardowang.utils
 * @version: 1.0
 */
public class BookSearcher {
    public static SearchResult searchWithISBN(String ISBN){
        String host = "https://jisuisbn.market.alicloudapi.com";
        String path = "/isbn/query";
        String method = "GET";
        String appcode = "db9131cddf2843bb8c42b914a4b4c9d3";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("isbn", "9787302488828");

        SearchResult searchResult=null;
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host,path,method,headers,querys);
//            System.out.println(response.toString());
            //获取response的body
//            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(response.getEntity(), "utf-8");

            Gson gson=new Gson();
             searchResult = gson.fromJson(s, SearchResult.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchResult;
    }

}
