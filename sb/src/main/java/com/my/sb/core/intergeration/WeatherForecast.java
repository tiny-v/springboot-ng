package com.my.sb.core.intergeration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
	
	private static String url = "http://v.juhe.cn/weather/index";
	
	private static String key = "8aa062e7ef31ef4e4be4a65320e98e96";
	
	public static String queryData(String format,String dtype,String cityname){
        Map<String, String> params = new HashMap<String, String>();
        params.put("cityname", cityname);
        params.put("dtype", dtype);
        params.put("format", format);
        params.put("key", key);
        return post(url, params);
    }
	
    public static String get(String url){
        return post(url,null);
    }
    /**
     * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
     * @param url 网络地址
     * @param param 请求参数键值对
     * @return 返回读取数据
     */
   public static  String post(String  url,Map<String, String>  param){
        HttpURLConnection conn=null;
        try {
        	//此处要改
        	StringBuffer sb=null;
        	if(param!=null){//如果请求参数不为空
                sb=new StringBuffer();
                //将参数封装成键值对的形式
                for(Map.Entry<String,String> s:param.entrySet()){
                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
                }
                System.out.println(sb);
                url += "?"+sb.toString();
                sb=null;
            }
            URL u=new URL(url);
            conn=(HttpURLConnection) u.openConnection();
            conn.connect();//建立连接
            sb=new StringBuffer();
            //获取连接状态码
            int recode=conn.getResponseCode();
            BufferedReader reader=null;
            if(recode==200){
                //Returns an input stream that reads from this open connection
                //从连接中获取输入流
                InputStream in=conn.getInputStream();
                //对输入流进行封装
                reader=new BufferedReader(new InputStreamReader(in));
                String str=null;
                sb=new StringBuffer();
                //从输入流中读取数据
                while((str=reader.readLine())!=null){
                    sb.append(str).append(System.getProperty("line.separator"));
                }
                //关闭输入流
                reader.close();
                if (sb.toString().length() == 0) {
                    return null;
                }
                return sb.toString().substring(0,
                        sb.toString().length() - System.getProperty("line.separator").length());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if(conn!=null)//关闭连接
                conn.disconnect();
        }
        return null;
    }
  
}
