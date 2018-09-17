package com.zhiyou100.controller;

import com.aliyuncs.exceptions.ClientException;
import com.zhiyou100.pojo.User;
import com.zhiyou100.util.SMSUtil;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.ReqUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * 用来管理用户的注册
 */
@Controller
@RequestMapping("/register")
public class Register {
    private final static Logger log = LoggerFactory.getLogger(Register.class);

    private String codes;
    @Autowired
    UserService userService;
    /***
     * 用于注册
     * @param code
     * @param usName
     * @param usPassword
     * @param req
     * @param
     * @throws IOException
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public String register(String code, String usName, String usPassword,
                           HttpServletRequest req) {
        try {
            if (StringUtils.isBlank(usName) || StringUtils.isBlank(usPassword) || StringUtils.isBlank(code)) {
                return Response.responseError("账号密码不能为空或验证码不能为空");
            }
            System.out.println(codes);
            if (codes.equals(code)) {
                //如果验证码对应，则注册，将信息填入数据库
                User user = ReqUtil.reqUtil(req, User.class);
                int i = userService.insertSelective(user);
                if (i == 1) {
                    return Response.responseSucceed("注册成功");
                } else {
                    return Response.responseError("注册失败");
                }
            } else {
                return Response.responseError("验证码错误");
            }
        } catch (Exception e) {
            log.error("error", e);
            return Response.responseError("服务器错误");
        }
    }

    /***
     *生成验证码
     * @param cellPhone
     * @throws ClientException
     */
    @ResponseBody
    @RequestMapping("/code.do")
    public void verification(String cellPhone) throws ClientException {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        System.out.println(result);
        //验证码
        codes = result;
        // System.out.println(cellPhone);
        //发送验证码
        SMSUtil.sendSms(cellPhone, codes);
    }
}
