package com.springboot.interceptor;

import com.springboot.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的token
        String token = request.getHeader("token");
        // 判断token是否为空，如果为空，也代表未登录
        if (!StringUtils.hasText(token)){
            // 如果出现了异常，说明未登录，需要提醒重新登录(401)
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录，请重新登录~");
        }
        // 解析token，判断是否成功
        try {
            Claims claims = JwtUtil.parseJWT(token);
            // 如果解析过程中没有出现异常，说明是登录状态
            System.out.println(claims.getSubject());
        } catch (Exception e) {
            // 如果出现了异常，说明未登录，需要提醒重新登录(401)
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录，请重新登录~");
        }
        return true;
    }
}
