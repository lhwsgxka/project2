package com.zhiyou100.service;

import com.github.pagehelper.PageHelper;
import com.zhiyou100.dao.RealCheckMapper;
import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.pojo.RealCheck;
import com.zhiyou100.pojo.User;
import com.zhiyou100.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RealCheckService {
    @Autowired
    RealCheckMapper realCheckMapper;
    @Autowired
    UserService userService;


    public int deleteByPrimaryKey(Integer usId) {
        return realCheckMapper.deleteByPrimaryKey(usId);
    }

    public int insert(RealCheck record) {
        return realCheckMapper.insert(record);
    }

    public int insertSelective(RealCheck record) {
        return realCheckMapper.insertSelective(record);
    }

    //分页查询状态吗为0的用户照片
    public List<RealCheck> selectByPage(int page) {
        PageHelper.startPage(page, 5);
        return realCheckMapper.selectByPage();
    }

    public RealCheck selectByPrimaryKey(Integer usId) {
        return realCheckMapper.selectByPrimaryKey(usId);
    }

    public int updateByPrimaryKeySelective(RealCheck record) {
        return realCheckMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RealCheck record) {
        return realCheckMapper.updateByPrimaryKey(record);
    }

    //业务层处理对认证结果的数据库的变化
    @Transactional
    public void inform(String state, int uid) throws CrowdFundingException {
        if (state.equals("succeed")) {
            RealCheck realCheck = selectByPrimaryKey(uid);
            //将实名认证的状态码改为1
            realCheck.setStatus(2);
            String phone = realCheck.getPhone();//获取电话号码 通过电话号码得到用户
            updateByPrimaryKey(realCheck);//提交上去

            User user = userService.selectByPhone(phone);
            String email = user.getUsEmail();//获取邮箱地址
            MailUtil.sendMail(email, "认证成功，可以发布项目");
            return;
        }
        if (state.equals("failed")) {
            RealCheck realCheck = selectByPrimaryKey(uid);
            realCheck.setStatus(3);
            String phone = realCheck.getPhone();
            updateByPrimaryKey(realCheck);
            User user = userService.selectByPhone(phone);
            String email = user.getUsEmail();
            MailUtil.sendMail(email, "认证失败，请从新提交资料");
            return;
        }
    }


}