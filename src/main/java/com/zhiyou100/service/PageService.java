package com.zhiyou100.service;

import com.zhiyou100.dao.PageMapper;
import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.pojo.Page;
import com.zhiyou100.pojo.RealCheck;
import com.zhiyou100.util.FaceCompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class PageService {
    @Autowired
    PageMapper pageMapper;
    @Autowired
    RealCheckService realCheckService;

    public Page selectByPrimaryKey(Integer id) {
        return pageMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Page record) {
        return pageMapper.updateByPrimaryKey(record);
    }

    //事务处理自动识别照片
    @Transactional
    public void selfMotionInform() throws IOException, CrowdFundingException {
        Page page = selectByPrimaryKey(1);
        Integer page1 = page.getPage();
        //从数据库找出没有处理的照片
        List<RealCheck> realChecks = realCheckService.selectByPage(page1);
        for (RealCheck realCheck :
                realChecks) {
            String idCardHand = realCheck.getIdCardHand();
            String idCardNegative = realCheck.getIdCardNegative();
            Object sendPost = FaceCompareUtil.sendPost(idCardHand, idCardNegative);//自动识别
            String string = sendPost.toString();
            Double valueOf = Double.valueOf(string);
            System.out.println(valueOf+"---------------");
            if (valueOf > 60) {
                realCheckService.inform("succeed", realCheck.getId());
            } else {
                realCheckService.inform("failed", realCheck.getId());
            }
        }
        page.setPage(page1 + 1);
        updateByPrimaryKey(page);
    }
}
