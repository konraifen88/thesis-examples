package sample.configuration.redis;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class ForwardSessionIdAsHeaderFilter extends ZuulFilter {
    private final String headerName;

    public ForwardSessionIdAsHeaderFilter() {
        this("x-auth-token");
    }

    public ForwardSessionIdAsHeaderFilter(String headerName) {
        this.headerName = headerName;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        final RequestContext context = RequestContext.getCurrentContext();
        return context.getRequest().getSession(false) != null;
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();
        final HttpSession session = request.getSession(false);
        if (session != null) {
            context.addZuulRequestHeader(headerName, session.getId());
        }
        return null;
    }
}
