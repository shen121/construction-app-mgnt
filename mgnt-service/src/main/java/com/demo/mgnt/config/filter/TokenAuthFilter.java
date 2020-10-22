package com.demo.mgnt.config.filter;

import com.alibaba.fastjson.JSON;
import com.demo.mgnt.api.util.RestResponseEnum;
import com.demo.mgnt.config.exception.TokenAuthErrorException;
import com.demo.mgnt.config.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Order(1)
@WebFilter(urlPatterns = {"/v1/user/*"})
public class TokenAuthFilter implements Filter {
    private Logger logger= LoggerFactory.getLogger(TokenAuthFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request= (HttpServletRequest) servletRequest;
            String token = request.getHeader("token");
            if(token==null || "".equals(token)){
                throw new TokenAuthErrorException("token not be null");
            }
            logger.info("token===>>  "+token+"    =========");
            JwtUtil.authToken(token);
        }catch (TokenAuthErrorException e){
            Map<String,String> map=new HashMap<>();
            map.put("respCode", RestResponseEnum.token_error.getCode());
            map.put("respMsg",e.getMessage());
            servletResponse.getWriter();
            servletResponse.setCharacterEncoding("utf-8");
            servletResponse.getWriter().print(JSON.toJSONString(map));
            ((HttpServletResponse)servletResponse).setStatus(401);
            servletResponse.getWriter().flush();
            servletResponse.getWriter().close();
            servletResponse.flushBuffer();
            return;
        }

       // filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }


}
