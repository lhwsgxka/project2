package com.zhiyou100.controller;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.zhiyou100.pojo.Comments;
import com.zhiyou100.pojo.Projects;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.ProjectsService;
import com.zhiyou100.util.ReqUtil;
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
import java.io.IOException;
import java.util.List;

/**
 * 用来管理查询项目
 */
@Controller
@RequestMapping("/project")
@Slf4j
public class Project {
    //  private final static Logger log = LoggerFactory.getLogger(Register.class);
    @Autowired
    ProjectsService projectsService;

    /***
     * 分页查询项目
     * @param page
     * @param
     * @throws IOException
     */
    @ResponseBody//返json类型
    @RequestMapping("/page.do")
    public String projectQueryPage(String page, String pageSize) throws IOException {
        if (StringUtils.isBlank(page) || StringUtils.isBlank(pageSize)) {
            return Response.responseError("page不能为空");
        }
        //设置页码
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(pageSize));
        List<Projects> projects = projectsService.selectByPage();
        String json = new Gson().toJson(projects);
        return Response.responseSucceed(json);
    }

    /***
     * 通过页码查询评论
     * @param page
     */
    @ResponseBody
    @RequestMapping("/comment.do")
    public String comment(String page, String pageSize) {
        if (StringUtils.isBlank(page) || StringUtils.isBlank(pageSize)) {
            return Response.responseError("page不能为空");

        }
        //设置页码
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(pageSize));
        List<Comments> comments = projectsService.selectCommentByPage();
        String json = new Gson().toJson(comments);
        return Response.responseSucceed(json);
    }

    /***
     * 添加
     * @param req
     * @param
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/add.do")
    public String add(HttpServletRequest req) {
        try {
            //将请求转变成对象
            Projects projects = ReqUtil.reqUtil(req, Projects.class);
            //添加
            int i = projectsService.insertSelective(projects);
            if (i == 1) {
                return Response.responseSucceed("succeed");
            } else {
                return Response.responseError("添加失败");
            }
        } catch (Exception e) {
            log.error("error", e);
            return Response.responseError("服务器错误");
        }
    }

    /***
     * 删除
     * @param req
     * @param
     * @throws IOException
     */
     @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest req)   {

        String id = req.getParameter("psId");
        int i = projectsService.deleteByPrimaryKey(Integer.valueOf(id));
        if (i == 1) {
           return Response.responseSucceed( "succeed");
        }else {
            return Response.responseError("删除失败");
        }
    }

    /****
     * 更新
     * @param req
     * @param
     * @throws IOException
     */
   @ResponseBody
    @RequestMapping("/update.do")
    public String update(HttpServletRequest req )   {
        //将请求转变成对象
        try {
            Projects projects = ReqUtil.reqUtil(req, Projects.class);
            int i = projectsService.updateByPrimaryKeySelective(projects);
            if (i == 1) {
               return Response.responseSucceed( "succeed");
            }else {
                return Response.responseError("更新失败");
            }
        } catch (Exception e) {
            log.error("error", e);
            return Response.responseError("服务器错误");
        }
    }
}
