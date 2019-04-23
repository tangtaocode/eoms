package eoms.cn.commons.filter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "XssFilter",urlPatterns = {"/*"})
public class XssFilter implements Filter {

	/**无需进行xss过滤的uri地址*/
	private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("")));
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
		
		boolean allowedPath = ALLOWED_PATHS.contains(path);
		
		if(allowedPath) {
			chain.doFilter(request, response);
		}else {
			chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
