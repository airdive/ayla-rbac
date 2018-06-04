package com.sunseaiot.rbac.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunseaiot.rbac.util.HttpClientUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description : Ayla用户登录Controller
 * @author: liuchuang
 * @date: 2018/4/19 上午10:06
 * @modified by:
 */
@RestController
@RequestMapping("aylausers")
@Slf4j
public class AylaUserController {
    @Value("${ayla.prefixUrl}")
    private String prefixUrl;
    @Value("${ayla.userPort}")
    private String userPort;

    @Autowired
    private CloseableHttpClient httpclient;
    @Autowired
    private RequestConfig config;


    /**
     * 登录
     * @param email
     * @param password
     * @param app_id
     * @param app_secret
     * @param request
     * @return
     * @throws IOException
     */
    @ApiOperation(value="登录", notes="登录Ayla")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "email", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "password",  required = true, dataType = "String"),
            @ApiImplicitParam(name = "app_id", value = "app_id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "app_secret", value = "app_secret", required = true, dataType = "String")
    })
    @PostMapping("sign_in")
    public Object signIn(String email, String password, String app_id, String app_secret, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //工具类方法设置请求的请求参数类型和响应参数类型
        HttpPost post = HttpClientUtil.headerSetForPost(prefixUrl+"/users/sign_in");
        //使用Gson构建请求参数
        JsonObject app = new JsonObject();
        app.addProperty("app_id",app_id);
        app.addProperty("app_secret",app_secret);
        JsonObject pro = new JsonObject();
        pro.addProperty("email",email);
        pro.addProperty("password",password);
        pro.add("application",app);
        JsonObject res = new JsonObject();
        res.add("user",pro);
        log.info(res.toString());
        //设置String类型的请求参数
        final StringEntity entity = new StringEntity(res.toString());
        entity.setContentType("text/json");
        post.setEntity(entity);
        post.setConfig(config);
        CloseableHttpResponse resp = this.httpclient.execute(post);
        log.info("signIn: "+resp.getStatusLine().getStatusCode());
        // 判断状态码是否为200
        if (resp.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            String result = EntityUtils.toString(resp.getEntity(),"UTF-8");
            log.info("entity: "+result);
            HttpSession session = request.getSession();
            //将json字符串转换为json对象后获取属性值
            JsonObject jb = new JsonParser().parse(result).getAsJsonObject();
            String access_token = jb.get("access_token").toString();
            String refresh_token = jb.get("refresh_token").toString();
            session.setAttribute("access_token", access_token);
            session.setAttribute("refresh_token", refresh_token);
            return result;
        }
        response.setStatus(resp.getStatusLine().getStatusCode());
        return null;
    }

    /**
     * 刷新token
     * @param request
     * @return
     * @throws IOException
     */
    @ApiOperation(value="刷新token", notes="通过指定的refresh_token刷新出新的access_token和refresh_token")
    @PostMapping("refresh_token")
    public Object refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String refresh_token = (String)session.getAttribute("refresh_token");
        if (refresh_token == null){
            throw new NullPointerException("refresh_token is null");
        }
        //工具类方法设置请求的请求参数类型和响应参数类型
        HttpPost post = HttpClientUtil.headerSetForPost(prefixUrl+"/users/refresh_token",null,null);
        //使用Gson构建请求参数
        JsonObject token = new JsonObject();
        token.addProperty("refresh_token",refresh_token.replaceAll("\"",""));
        JsonObject res = new JsonObject();
        res.add("user",token);
        log.info(res.toString());
        //设置String类型的请求参数
        final StringEntity entity = new StringEntity(res.toString());
        entity.setContentType("text/json");
        post.setEntity(entity);
        post.setConfig(config);
        CloseableHttpResponse resp = this.httpclient.execute(post);
        log.info("refreshToken : "+resp.getStatusLine().getStatusCode());
        // 判断状态码是否为200
        if (resp.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            String result = EntityUtils.toString(resp.getEntity(),"UTF-8");
            log.info("entity: "+result);
            //将json字符串转换为json对象后获取属性值
            String refresh_token_new = new JsonParser().parse(result).getAsJsonObject().get("refresh_token").toString();
            log.info(refresh_token_new);

            session.setAttribute("refresh_token", refresh_token_new);
            return result;
        }
        response.setStatus(resp.getStatusLine().getStatusCode());
        return null;
    }
}
