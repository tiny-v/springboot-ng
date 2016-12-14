package com.my.sa.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.my.sa.core.global.Constants;

import net.sf.json.JSONObject;

public class BaiduIpAddressUtils {
	
	
	public static JSONObject post(String ip) {
		String url = "http://api.map.baidu.com/highacciploc/v1?qterm=pc&ak="+Constants.BAIDU_MAP_APIKEY+"&coord=bd09ll&callback_type=jsonp&callback=&extensions=3&qcip=";
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
        	url+=ip;
            HttpPost method = new HttpPost(url);
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(responseText);
        JSONObject json = JSONObject.fromObject(responseText);
        return json;
    }

}
