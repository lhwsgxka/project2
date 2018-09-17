package com.zhiyou100.controller;

import com.zhiyou100.pojo.Projects;
import com.zhiyou100.pojo.User;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.ProjectsService;
import com.zhiyou100.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/***
 * 用来身份校验,身份的完善
 */
@Controller
@RequestMapping("/id")
@Slf4j
public class Identity {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/verify.do")
    public String verify(int usId, String usIdcard) throws IOException {
        User user = userService.selectByPrimaryKey(usId);
        //身份证添加
        user.setUsIdcard(usIdcard);
        //激活状态
        user.setUsRole(1);
        Date date = new Date();
        user.setUsUpdateTime(date);
        //提交更新
        int i = userService.updateByPrimaryKeySelective(user);
        if (i == 1) {
            return Response.responseSucceed("成功");
        }
        return Response.responseError("失败");
    }
}
