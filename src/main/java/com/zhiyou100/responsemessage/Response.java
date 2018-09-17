package com.zhiyou100.responsemessage;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response{

    //成功de
    public static void responseSucceed(HttpServletResponse resp,String message) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(200);
        responseMessage.setSuccess(true);
        responseMessage.setMessage(message);
        String s = new Gson().toJson(responseMessage);
        resp.getWriter().println(s);
    }
    //失败的
    public static void responseError(HttpServletResponse resp,String error) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setSuccess(false);
        responseMessage.setCode(400);
        responseMessage.setError(error);
        String json = new Gson().toJson(responseMessage);
        resp.getWriter().println(json);
    }
}
