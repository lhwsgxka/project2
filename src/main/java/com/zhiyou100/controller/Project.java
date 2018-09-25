package com.zhiyou100.controller;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.pojo.Comments;
import com.zhiyou100.pojo.Projects;
import com.zhiyou100.pojo.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用来管理查询项目
 */
@Controller
@RequestMapping("/project")
@Slf4j
public class Project {
    //  private final static Logger     log = LoggerFactory.getLogger(Register.class);
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
    public String projectQueryPage(String page)  {
        if (StringUtils.isBlank(page) ) {
            return Response.responseError("page不能为空");
        }
        //设置页码
        List<Projects> projects = projectsService.selectByPage(Integer.valueOf(page));
        String json = new Gson().toJson(projects);
        return Response.responseSucceed(json);
    }

    /***
     * 项目的发布
     * 项目的添加需要先添加到数据库 状态码变化
     */
    @RequestMapping("/release.do")
    @ResponseBody
    public String release(HttpServletRequest req) throws CrowdFundingException {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("login");
            Projects projects = ReqUtil.reqUtil(req, Projects.class);
            /*
            * 项目状态(0.待审核1.待上架2.众筹中3.众筹成功4.众筹失败5.审核未通过)*/
            projects.setPsType(0);
            int i = projectsService.updateByPrimaryKeySelective(projects);
            if (i == 1) {
                return Response.responseSucceed( "succeed");
            }else {
                return Response.responseError("更新失败");
            }
        } catch (Exception e) {
            throw  new CrowdFundingException("服务器错误");
        }
    }


    /***
     * 通过页码查询指定项目的评论
     * @param page
     */
    @ResponseBody
    @RequestMapping("/comment.do")
    public String comment(String page,String id) {//这个是项目的id
        if (StringUtils.isBlank(page) ) {
            return Response.responseError("page不能为空");
        }
        //在查询之前我先判断这个项目审核过没有
        Projects projects = projectsService.selectByPrimaryKey(Integer.valueOf(id));
        Integer type = projects.getPsType();
        if (type==0||type==5){
            return Response.responseError("该项目没有通过审核");
        }
        //设置页码
        List<Comments> comments = projectsService.selectCommentByPage(Integer.valueOf(id),Integer.valueOf(page));
        String json = new Gson().toJson(comments);
        return Response.responseSucceed(json);
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
