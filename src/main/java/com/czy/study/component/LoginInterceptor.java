package com.czy.study.component;

import com.alibaba.fastjson.JSONObject;
import com.czy.study.core.UserContent;
import com.czy.study.core.UserLoginHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    private Map<String,Object> map = new HashMap<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //token值是登陆后记录到对应的用户表的信息的中，再返回给前端，前端请求的时候需要带上token的属性请求。
        //这里处理需要校验token值是否过期，是否是正确的。
        if (StringUtils.equals(token,"1")) {
            UserContent u = UserLoginHandler.getCurrentUser(token);
            if (u == null) {
                u = new UserContent(1L,"aa");
                UserLoginHandler.setUserMap(token,u);
            }
            UserLoginHandler.set(u);
        }
        UserContent userContent = UserLoginHandler.get();

        return userContent != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserContent userContent = UserLoginHandler.get();
        log.info("post:"+JSONObject.toJSONString(userContent));
    }
}
