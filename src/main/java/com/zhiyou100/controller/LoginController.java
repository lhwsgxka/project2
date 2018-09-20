package com.zhiyou100.controller;

import com.zhiyou100.pojo.User;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用来管理用户的登陆
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    //private final static Logger log = LoggerFactory.getLogger(Register.class);
    @Autowired
    UserService userService;

    /****
     * 用来登陆的校验
     * @param req
     * @param usName
     * @param usPassword
     * @throws IOException
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(HttpServletRequest req, String usName, String usPassword) throws IOException {

        if (StringUtils.isEmpty(usName) || StringUtils.isEmpty(usPassword)) {
            return Response.responseError("账号或密码为空");
        }
        User users = userService.selectBySelective(usName, usPassword);
        System.out.println(users);
        if (users == null) {
            return Response.responseError("账号密码不匹配");

        } else {
            HttpSession session = req.getSession();
            session.setAttribute("login", users);
            return Response.responseSucceed("登陆成功");
        }
    }


}
