package test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.service.ZuulService;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    @Autowired
    private ZuulService zuulService;
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    //过滤类型  四种 pre：路由之前 routing：路由之时 post： 路由之后 error：发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //用来判断是否要过滤
//    这里可以写逻辑判断，是否要过滤，为true,则过滤。
    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String id = request.getParameter("id");
        return zuulService.checkAothority(id);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
