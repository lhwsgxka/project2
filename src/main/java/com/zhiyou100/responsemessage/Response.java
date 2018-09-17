package com.zhiyou100.responsemessage;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response {

    //成功de
    public static String responseSucceed(String message) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(200);
        responseMessage.setSuccess(true);
        responseMessage.setMessage(message);
        String s = new Gson().toJson(responseMessage);
        return s;
    }

    //失败的
    public static String responseError(String error) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setSuccess(false);
        responseMessage.setCode(400);
        responseMessage.setError(error);
        String json = new Gson().toJson(responseMessage);
        return json;
    }
}
