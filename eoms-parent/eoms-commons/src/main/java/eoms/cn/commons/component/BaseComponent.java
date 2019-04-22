package eoms.cn.commons.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

@Component
public class BaseComponent {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    public Locale locale() {
        return RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
    }

    public HttpServletRequest req() {
        return this.request;
    }

    public HttpServletResponse resp() {
        return this.response;
    }
}
