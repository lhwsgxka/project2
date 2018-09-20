package com.zhiyou100.controller;

import com.google.gson.Gson;
import com.zhiyou100.annotation.Permission;
import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.pojo.RealCheck;
import com.zhiyou100.pojo.User;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.RealCheckService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.FaceCompareUtil;
import com.zhiyou100.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/***
 * 用来管理 管理员的
 *处理管理员的业务
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RealCheckService realCheckService;


    @ResponseBody
    @Permission(role = "admin")
    @RequestMapping("/admin.do")
    public String admin() {
        return Response.responseSucceed("succeed");
    }

    /***
     * 获取照片
     *z这是人工识别照片
     * @return
     */
    @RequestMapping("/reception.do")
    @ResponseBody
    @Permission(role = "admin")//自定义注解用来验证是否是管理员
    public String pictureReception(String page) {
        int pageNum = 0;
        if (Integer.valueOf(page) > 0) {
            pageNum = Integer.valueOf(page);
        }
        List<RealCheck> realChecks = realCheckService.selectByPage(pageNum);
        String json = new Gson().toJson(realChecks);
        return Response.responseSucceed(json);
    }

    /***
     * z这个是对实名认证的数据处理
     * @param state
     * @param id
     * @throws CrowdFundingException
     */
    @RequestMapping("/inform.do")
    @Permission(role = "admin")
    public void inform(String state, String id) throws CrowdFundingException {
        Integer uid = Integer.valueOf(id);
        realCheckService.inform(state, uid);
    }

}
