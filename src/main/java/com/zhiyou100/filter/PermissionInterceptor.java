package com.zhiyou100.filter;


import com.zhiyou100.annotation.Permission;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("login");
        if (user == null) {
            return false;
        } else {
            //说明已经登录
            //判断请求路径是否是管理路径
            HandlerMethod method = (HandlerMethod) handler;
            boolean present = method.getMethod().isAnnotationPresent(Permission.class);
            if (!present) {
                //如果请求不是管理路径，让其通过
                System.out.println("一般请求通过");
                return true;
            } else {
                //得到管理的权限数组
                String[] roles = method.getMethod().getAnnotation(Permission.class).role();
                //得到用户的权限
                if (user.getRole() == null) {
                    List<String> stringList = userService.findById(user.getUsId());
                    user.setRole(stringList);
                }
                Collection intersection = CollectionUtils.intersection(user.getRole(), Arrays.asList(roles));
                if (intersection.size() > 0) {
                    System.out.println("管理员认证通过");
                    return true;
                } else {
                    System.out.println("不通过");
                    return false;
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
