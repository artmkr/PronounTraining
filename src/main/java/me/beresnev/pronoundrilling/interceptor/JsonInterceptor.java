package me.beresnev.pronoundrilling.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

/**
 * @author Ignat Beresnev
 * @since 15.04.17
 */
public class JsonInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(JsonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/roundValidate".equals(request.getRequestURI()))
            logger.info("Incoming JSON: " + request.getReader().lines().collect(Collectors.joining()));
        return true;
    }
}
