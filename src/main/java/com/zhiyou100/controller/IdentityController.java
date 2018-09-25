package com.zhiyou100.controller;

import com.google.gson.Gson;
import com.zhiyou100.pojo.RealCheck;
import com.zhiyou100.responsemessage.Response;

import com.zhiyou100.service.RealCheckService;
import com.zhiyou100.util.OosUtil;
import com.zhiyou100.util.ReqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/***
 * 用来身份校验,身份的完善
 */

@Controller
@RequestMapping("/id")
@Slf4j
public class IdentityController {
    @Autowired
    RealCheckService realCheckService;

    /***
     * 图片的上传
     * 首先将照片上传到阿里云oos
     * 再讲新的文件名地址记录在本地数据库中
     */
    @ResponseBody
    @RequestMapping("/pictureUpload.do")
    public String pictureUpload(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            String idCardPositiveUrl = "";
            String idCardNegativeUrl = "";
            String idCardHandUrl = "";

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                System.out.println(file.getName());
                if (file != null) {
                    if (file.getName().contains("positive")) {
                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                        //获得文件类型（可以判断如果不是图片，禁止上传）
                        String contentType = file.getContentType();
                        //获得文件后缀名称
                        String imageName = contentType.substring(contentType.indexOf("/") + 1);
                        String idCardPositive = uuid + "." + imageName;
                        System.out.println("11" + idCardPositive);
                        try {
                            idCardPositiveUrl = OosUtil.uploading("lhwapartment", idCardPositive, file.getInputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (file.getName().contains("negative")) {
                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                        //获得文件类型（可以判断如果不是图片，禁止上传）
                        String contentType = file.getContentType();
                        //获得文件后缀名称
                        String imageName = contentType.substring(contentType.indexOf("/") + 1);
                        String idCardNegative = uuid + "." + imageName;
                        System.out.println("222" + idCardNegative);
                        try {
                            idCardNegativeUrl = OosUtil.uploading("lhwapartment", idCardNegative, file.getInputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (file.getName().contains("hand")) {
                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                        //获得文件类型（可以判断如果不是图片，禁止上传）
                        String contentType = file.getContentType();
                        //获得文件后缀名称
                        String imageName = contentType.substring(contentType.indexOf("/") + 1);
                        String idCardHand = uuid + "." + imageName;
                        System.out.println(idCardHand + "33");
                        try {
                            idCardHandUrl = OosUtil.uploading("lhwapartment", idCardHand, file.getInputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
            //将文件传上去后。存入数据库
            try {
                RealCheck realCheck = ReqUtil.reqUtil(request, RealCheck.class);
                realCheck.setIdCardPositive(idCardPositiveUrl);
                realCheck.setIdCardNegative(idCardNegativeUrl);
                realCheck.setIdCardHand(idCardHandUrl);
                /*0默认
                1 提交
                2成功
                3失败
                * */
                realCheck.setStatus(0);//提交1
                int i = realCheckService.insertSelective(realCheck);
                if (i == 1) {
                    return Response.responseSucceed("succeed");
                } else {
                    return Response.responseError("添加失败");
                }
            } catch (Exception e) {
                log.error("error", e);
            }
        }
        return Response.responseError("上传失败");

    }


}
