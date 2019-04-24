 package eoms.cn.commons.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import eoms.cn.commons.response.EomsResponse;
import eoms.cn.commons.tools.FastJsonUtils;
/**
 * 
 * @author TTCODE
 * @date 2019/04/23
 */
public class LoginTokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
         
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        // TODO 实现token登陆验证，token可存放redis中
         
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
         
    }
    
    private boolean showTip(HttpServletResponse response, EomsResponse resp) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(FastJsonUtils.toJSONString(response));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.close();
        }
        return false;
    }
}
