package com.zhiyou100.controller;

import com.google.gson.Gson;
import com.zhiyou100.pojo.Comments;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.CommentsService;
import com.zhiyou100.util.ReqUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("/comment")
public class Comment {
    @Autowired
    CommentsService commentsService;

    /***
     * 添加评论
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public String add(String cmUsId, String cmPsId, String cmContent) {
        if (StringUtils.isBlank(cmUsId) || StringUtils.isBlank(cmPsId) || StringUtils.isBlank(cmContent)) {
            return Response.responseError("不能为空");
        }
        Comments comments = new Comments();
        comments.setCmContent(cmContent);
        comments.setCmPsId(Integer.valueOf(cmPsId));
        comments.setCmUsId(Integer.valueOf(cmUsId));
        Date date = new Date();
        comments.setCmTime(date);
        int selective = commentsService.insertSelective(comments);
        if (selective == 1) {
            return Response.responseSucceed("添加成功");
        } else {
            return Response.responseError("添加失败");
        }
    }

    /***
     * 删除
     * @param cmId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(String cmId) {
        if (StringUtils.isBlank(cmId)) {
            return Response.responseError("输入有误");
        }
        int i = commentsService.deleteByPrimaryKey(Integer.valueOf(cmId));
        if (i == 1) {
            return Response.responseSucceed("添加成功");
        } else {
            return Response.responseError("添加失败");
        }
    }

    /**
     * 更新
     * @param req
     * @return
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(HttpServletRequest req) {
        try {
            Comments comments = ReqUtil.reqUtil(req, Comments.class);
            int i = commentsService.updateByPrimaryKeySelective(comments);
            if (i == 1) {
                return Response.responseSucceed("添加成功");
            } else {
                return Response.responseError("添加失败");
            }
        } catch (Exception e) {

            log.error("error", e);
            return Response.responseError("服务器错误");
        }
    }
}

