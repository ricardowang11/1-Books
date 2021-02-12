package cn.ricardowang.filter;

import cn.ricardowang.bean.User;
import cn.ricardowang.service.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/2/12 0012 - 02 -12 -10:18
 * @Description: cn.ricardowang.filter
 * @version: 1.0
 */
public class SignInCheckFilter implements Filter {
    private AbstractApplicationContext ioc;
    private FilterConfig config;
    private UserService userService;
    private LinkedHashMap<String,String> safeUrl;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config=filterConfig;
        ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        userService=ioc.getBean(UserService.class);
        safeUrl=new LinkedHashMap<String, String>();
        safeUrl.put("/signin","1");
        safeUrl.put("/signIn","1");
        safeUrl.put("/signup","1");
        safeUrl.put("/signUp","1");
        safeUrl.put("/index.jsp","1");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        boolean b = "1".equals(safeUrl.get(servletPath));

        if (!b){
            User user= (User) request.getSession().getAttribute("user");
            if (servletPath.endsWith(".css")||servletPath.endsWith(".js")){

            }else {
                boolean result = userService.checkUserInfo(user);
                if (!result){
//                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/signin");
                    response.sendRedirect("/signin");
                }
            }

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        ioc.close();
    }
}
