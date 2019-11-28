package com.julibo.pig.cms.tools.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 拦截器
 * @author carson
 * @date 2019-11-28
 */
@Component
@Log4j2
public class HttpInterceptor extends BaseInterceptor {

    /**
     * 输出结果
     */
    private void output(HttpServletResponse response, String result) throws Exception {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = "";
        // 去掉最后一个空格
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);
        log.info(String.format("请求参数, url: %s, method: %s, params: %s", url, method, queryString));

        // hello不做拦截
        if (uri.equals("/cms/test/hello")) {
            return super.preHandle(request, response, handler);
        }

        // 其他拦截请求（请求必须都带上用户id）
        String userId = request.getParameter("userId");
        if (userId != null) {
            return super.preHandle(request, response, handler);

        } else {
            this.output(response, "{\n"
                    + "\"code\": \"4001\",\n"
                    + "\"message\": \"参数错误\"\n"
                    + "}");
            return false;
        }


    }
}
