package web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstInterceptor implements HandlerInterceptor {
    @Override
    //在处理器方法执行之前调用
    //返回值：布尔类型【true：放行 false：不放行】 如果不放行就执行不了处理器方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle在业务处理器处理请求之前被调用1");
        return true;
    }

    @Override
    //当处理器方法执行之后会自动调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle在业务处理器处理完请求后调用1");
    }

    @Override
    //请求处理完毕之后调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion在 DispatcherServlet 完全处理完请求后被调用1");
    }
}
