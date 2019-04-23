package eoms.cn.commons.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebInterceptorConfiguration extends WebMvcConfigurerAdapter {
	private List<String> inpathPatterns = new ArrayList<String>();
	private List<String>  expathPatterns = new ArrayList<String>();
	private List<HandlerInterceptor> interceptorlist = new ArrayList<HandlerInterceptor>();
	public WebInterceptorConfiguration(){
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
        //自定义拦截器
        for(HandlerInterceptor intercept:interceptorlist){
        	registry.addInterceptor(intercept).addPathPatterns(inpathPatterns.toArray(new String[inpathPatterns.size()])).excludePathPatterns(expathPatterns.toArray(new String[expathPatterns.size()]));
        }
	}
	public WebInterceptorConfiguration setInpathPatterns(List<String> inpathPatterns) {
		this.inpathPatterns = inpathPatterns;
		return this;
	}
	public WebInterceptorConfiguration setExpathPatterns(List<String> expathPatterns) {
		this.expathPatterns = expathPatterns;
		return this;
	}
    public WebInterceptorConfiguration addHandlerInterceptor (HandlerInterceptor interceptor){
    	interceptorlist.add(interceptor);
    	return this;
    }
}
