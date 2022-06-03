package cn.ipangbo.news.interceptor;

import cn.ipangbo.news.utils.JwtUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        System.out.println(token);
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (token != null && !"".equals(token) && token.startsWith("Bearer ") && JwtUtils.validateToken(token.substring(7))) {
            return true;
        }
        response.setStatus(401);
        return false;
    }
}