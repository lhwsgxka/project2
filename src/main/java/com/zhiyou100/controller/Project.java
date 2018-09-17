package com.zhiyou100.controller;

import com.google.gson.Gson;
import com.zhiyou100.pojo.Projects;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.service.ProjectsService;
import com.zhiyou100.util.ReqUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用来管理查询项目
 */
@Controller
@RequestMapping("/project")
public class Project {
    private final static Logger log = LoggerFactory.getLogger(Register.class);
    @Autowired
    ProjectsService projectsService;

    /***
     * 分页查询项目
     * @param page
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/page.do")
    public void projectQueryPage(String page, HttpServletResponse resp) throws IOException {
        List<Projects> projects = projectsService.selectByPage(Integer.valueOf(page));
        String json = new Gson().toJson(projects);
        Response.responseSucceed(resp, json);
    }

    /***
     * 添加
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/add.do")
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            //将请求转变成对象
            Projects projects = ReqUtil.reqUtil(req, Projects.class);
            //添加
            int i = projectsService.insertSelective(projects);
            if (i == 1) {
                Response.responseSucceed(resp, "succeed");
            }
        } catch (Exception e) {
            log.error("error", e);
            Response.responseError(resp, "服务器错误");
        }
    }

    /***
     * 删除
     * @param req
     * @param resp
     * @throws IOException
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        int i = projectsService.deleteByPrimaryKey(Integer.valueOf(id));
        if (i == 1) {
            try {
                Response.responseSucceed(resp, "succeed");
            } catch (IOException e) {
                log.error("error", e);
                Response.responseError(resp, "服务器错误");
            }
        }
    }

    /****
     * 更新
     * @param req
     * @param resp
     * @throws IOException
     */

    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //将请求转变成对象
        try {
            Projects projects = ReqUtil.reqUtil(req, Projects.class);
            int i = projectsService.updateByPrimaryKeySelective(projects);
            if (i == 1) {
                Response.responseSucceed(resp, "succeed");
            }
        } catch (Exception e) {
            log.error("error", e);
            Response.responseError(resp, "服务器错误");
        }
    }
}
