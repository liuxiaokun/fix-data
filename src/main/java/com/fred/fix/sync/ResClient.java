package com.fred.fix.sync;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResClient {
    private static AsyncHttpClient client;

    public static String pass(DataLineVo vo) throws Exception {

        return post("http://super.lvmama.com/clutter/supplier/passInfo.do", vo);
    }


    private static String post(String url, DataLineVo vo) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        //表单方式
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("signName", vo.getSignName()));
        pairList.add(new BasicNameValuePair("item", vo.getItem()));
        pairList.add(new BasicNameValuePair("userId", vo.getUserId()));
        pairList.add(new BasicNameValuePair("addCode", vo.getAddCode()));
        pairList.add(new BasicNameValuePair("bizType", vo.getBizType()));
        pairList.add(new BasicNameValuePair("performTime", vo.getPerformTime()));
        pairList.add(new BasicNameValuePair("udid", vo.getUdid()));
        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));

        HttpResponse resp = client.execute(httpPost);

        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he, "UTF-8");
        }
        return respContent;
    }

}
