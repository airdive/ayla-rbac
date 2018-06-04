package com.sunseaiot.rbac.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * HttpClient工具类
 */
@Slf4j
public class HttpClientUtil {
    /**
     * 为HttpPost设置CONTENT_TYPE和ACCEPT
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @return
     */
    public static HttpPost headerSetForPost(String url,String contentType,String accept){
        HttpPost post = new HttpPost(url);
        //设置请求参数的类型
        post.setHeader(HttpHeaders.CONTENT_TYPE, StringUtils.isEmpty(contentType) ? MediaType.APPLICATION_JSON_VALUE : contentType);
        //设置响应参数的类型
        post.setHeader(HttpHeaders.ACCEPT, StringUtils.isEmpty(accept) ? MediaType.APPLICATION_JSON_VALUE : accept);

        return post;
    }

    /**
     * 为HttpPost设置CONTENT_TYPE和ACCEPT,AUTHORIZATION
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @param request
     * @return
     */
    public static HttpPost headerSetForPost(String url,String contentType,String accept, HttpServletRequest request) {
        HttpPost post = headerSetForPost(url,contentType,accept);
        //从HttpSession中获取
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if(!StringUtils.isEmpty(access_token)){
            String auth_token = "auth_token "+access_token.replaceAll("\"","");
            //设置token
            post.setHeader(HttpHeaders.AUTHORIZATION,auth_token);
        }
        return post;
    }

    /**
     * 为HttpGet设置CONTENT_TYPE和ACCEPT，CONTENT_TYPE和ACCEPT默认都设置为application/json
     * @param url
     * @return
     */
    public static HttpPost headerSetForPost(String url){
        return headerSetForPost(url,null,null);
    }

    /**
     * 为HttpGet设置CONTENT_TYPE和ACCEPT，AUTHORIZATION，CONTENT_TYPE和ACCEPT默认都设置为application/json
     * @param url
     * @param request
     * @return
     */
    public static HttpPost headerSetForPost(String url, HttpServletRequest request){
        return headerSetForPost(url,null,null, request);
    }

    /**
     * 为HttpGet设置CONTENT_TYPE和ACCEPT,AUTHORIZATION
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @return
     */
    public static HttpGet headerSetForGet(String url, String contentType, String accept){
        HttpGet get = new HttpGet(url);
        //设置请求参数的类型
        get.setHeader(HttpHeaders.CONTENT_TYPE, StringUtils.isEmpty(contentType) ? MediaType.APPLICATION_JSON_VALUE : contentType);
        //设置响应参数的类型
        get.setHeader(HttpHeaders.ACCEPT, StringUtils.isEmpty(accept) ? MediaType.APPLICATION_JSON_VALUE : accept);

        return get;
    }

    /**
     * 为HttpGet设置CONTENT_TYPE和ACCEPT,AUTHORIZATION
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @param request
     * @return
     */
    public static HttpGet headerSetForGet(String url, String contentType, String accept, HttpServletRequest request){
        HttpGet get = headerSetForGet(url, contentType, accept);
        //从HttpSession中获取
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if(!StringUtils.isEmpty(access_token)){
            String auth_token = "auth_token "+access_token.replaceAll("\"","");
            //设置token
            get.setHeader(HttpHeaders.AUTHORIZATION,auth_token);
        }
        return get;
    }

    /**
     * 为HttpGet设置CONTENT_TYPE和ACCEPT，AUTHORIZATION，CONTENT_TYPE和ACCEPT默认都设置为application/json
     * @param url
     * @param request
     * @return
     */
    public static HttpGet headerSetForGet(String url,HttpServletRequest request){
        return headerSetForGet(url,null,null,request);
    }

    /**
     * 为HttpPut设置CONTENT_TYPE和ACCEPT
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @return
     */
    public static HttpPut headerSetForPut(String url, String contentType, String accept){
        HttpPut put = new HttpPut(url);
        //设置请求参数的类型
        put.setHeader(HttpHeaders.CONTENT_TYPE, StringUtils.isEmpty(contentType) ? MediaType.APPLICATION_JSON_VALUE : contentType);
        //设置响应参数的类型
        put.setHeader(HttpHeaders.ACCEPT, StringUtils.isEmpty(accept) ? MediaType.APPLICATION_JSON_VALUE : accept);

        return put;
    }

    /**
     * 为HttpPut设置CONTENT_TYPE和ACCEPT,AUTHORIZATION
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @param request
     * @return
     */
    public static HttpPut headerSetForPut(String url, String contentType, String accept,HttpServletRequest request){
        HttpPut put = headerSetForPut(url, contentType, accept);
        //从HttpSession中获取
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if(!StringUtils.isEmpty(access_token)){
            String auth_token = "auth_token "+access_token.replaceAll("\"","");
            //设置token
            put.setHeader(HttpHeaders.AUTHORIZATION,auth_token);
        }
        return put;
    }

    /**
     * 为HttpPut设置CONTENT_TYPE和ACCEPT，AUTHORIZATION，CONTENT_TYPE和ACCEPT默认都设置为application/json
     * @param url
     * @param request
     * @return
     */
    public static HttpPut headerSetForPut(String url, HttpServletRequest request){
        return headerSetForPut(url,null,null,request);
    }

    /**
     * 为HttpDelete设置CONTENT_TYPE和ACCEPT
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @return
     */
    public static HttpDelete headerSetForDelete(String url, String contentType, String accept){
        HttpDelete delete = new HttpDelete(url);
        //设置请求参数的类型
        delete.setHeader(HttpHeaders.CONTENT_TYPE, StringUtils.isEmpty(contentType) ? MediaType.APPLICATION_JSON_VALUE : contentType);
        //设置响应参数的类型
        delete.setHeader(HttpHeaders.ACCEPT, StringUtils.isEmpty(accept) ? MediaType.APPLICATION_JSON_VALUE : accept);

        return delete;
    }

    /**
     * 为HttpDelete设置CONTENT_TYPE和ACCEPT,AUTHORIZATION
     * @param url
     * @param contentType 默认application/json
     * @param accept 默认application/json
     * @param request
     * @return
     */
    public static HttpDelete headerSetForDelete(String url, String contentType, String accept,HttpServletRequest request){
        HttpDelete delete = headerSetForDelete(url, contentType, accept);
        //从HttpSession中获取
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if(!StringUtils.isEmpty(access_token)){
            String auth_token = "auth_token "+access_token.replaceAll("\"","");
            //设置token
            delete.setHeader(HttpHeaders.AUTHORIZATION,auth_token);
        }
        return delete;
    }

    /**
     * 为HttpDelete设置CONTENT_TYPE和ACCEPT，AUTHORIZATION，CONTENT_TYPE和ACCEPT默认都设置为application/json
     * @param url
     * @param request
     * @return
     */
    public static HttpDelete headerSetForDelete(String url, HttpServletRequest request){
        return headerSetForDelete(url,null,null,request);
    }

}
