package com.lihuia.flyaway.testing.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lihuia.flyaway.testing.http.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

/**
 * @author lihuia.com
 * @date 2022/6/20 10:08 PM
 */

@Slf4j
public class HttpTest extends AbstractTestNGSpringContextTests {

    @BeforeClass
    public void beforeClass() {

    }

    @Test(description = "单元测试GET")
    public void demoTest() {
        String url = "http://127.0.0.1:8888" + "/user/get";

        Map<String, String> headers = Maps.newHashMap();
        headers.put("token", "lihuia.com");

        Map<String, String> params = Maps.newHashMap();
        params.put("id", "2");

        String httpResponse = HttpClientUtil.doGet(url, headers, params);

        JSONObject json = JSONObject.parseObject(httpResponse);
        log.info("json: {}", JSON.toJSONString(json, true));
    }

    @Test(description = "postJson")
    public void postJsonTest() {
        String url = "http://127.0.0.1:8888" + "/user/postJson";

        Map<String, String> headers = Maps.newHashMap();
        headers.put("token", "lihuia.com");

        Map<String, String> body = Maps.newHashMap();
        body.put("id", "33");
        body.put("name", "lihui");

        String httpResponse = HttpClientUtil.doPostJSON(url, headers, body);

        JSONObject json = JSONObject.parseObject(httpResponse);
        log.info("json: {}", JSON.toJSONString(json, true));
    }

    @Test(description = "postForm")
    public void postFormTest() {
        String url = "http://127.0.0.1:8888" + "/user/postJson";

        Map<String, String> headers = Maps.newHashMap();
        headers.put("token", "lihuia.com");
        headers.put("content-type", "application/x-www-form-urlencoded");

        Map<String, String> body = Maps.newHashMap();
        body.put("id", "33");
        body.put("name", "lihui");

        String httpResponse = HttpClientUtil.doPostForm(url, headers, body);

        JSONObject json = JSONObject.parseObject(httpResponse);
        log.info("json: {}", JSON.toJSONString(json, true));
    }
}
