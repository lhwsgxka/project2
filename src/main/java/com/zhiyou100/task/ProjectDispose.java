package com.zhiyou100.task;

import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.pojo.Funding;
import com.zhiyou100.pojo.Projects;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.FundingService;
import com.zhiyou100.service.ProjectsService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/***
 * 定时处理项目后续的工作
 * 项目失败之后的工作
 */
@Component
@Slf4j
public class ProjectDispose {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");

    }

    @Autowired
    ProjectsService projectsService;
    @Autowired
    UserService userService;
    @Autowired
    FundingService fundingService;

    //每天定时处理项目失败的
    @Transactional
    public void projectDispose() {
        int page = 1;
        while (true) {
            //查询项目时间到的 并且状态是1或者2
            List<Projects> projectsList = projectsService.selectByFailed(page);

            System.out.println(projectsList + "-----");
            if (projectsList.size() == 0) {
                break;
            }
            //对查询的项目判断众筹是否成功
            for (Projects projects :
                    projectsList) {
                if (projects.getPsGetmoney() < projects.getPsMoney()) {
                    //众筹失败
                    //1改变项目状态
                    projects.setPsType(5);
                    projectsService.updateByPrimaryKeySelective(projects);
                    //2告诉项目发起人
                    Integer psUsId = projects.getPsUsId();
                    //获取项目人
                    User userProjects = userService.selectByPrimaryKey(psUsId);
                    String email = userProjects.getUsEmail();
                    try {
                        MailUtil.sendMail(email, "你的项目" + projects.getPsName() + "众筹失败");
                        //3告诉参与人
                        //通过参与表
                        //项目id
                        Integer psId = projects.getPsId();
                        List<User> users = fundingService.selectByUserAndId(psId);
                        for (User userParticipation :
                                users) {
                            MailUtil.sendMail(userParticipation.getUsEmail(), "你参与的项目" + projects.getPsName() + "众筹失败");
                            //4对参与项目的人返回参与金额
                            //通过项目id 和用户id准确的完成查询参与金币
                            Funding funding = fundingService.selectByUidAndPid(userParticipation.getUsId(), projects.getPsId());
                            BigDecimal fdMoney = funding.getFdMoney();//参与人参与资金
                            BigDecimal usMoney = userParticipation.getUsMoney();
                            userParticipation.setUsMoney(fdMoney.add(usMoney));
                            userService.updateByPrimaryKeySelective(userParticipation);
                            MailUtil.sendMail(userParticipation.getUsEmail(), "你的项目返回资金到账");
                        }
                    } catch (CrowdFundingException e) {
                        log.error("error", e);
                    }
                }
            }
            page++;
        }
    }
}
