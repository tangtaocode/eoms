/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package eoms.cn.commons.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 解析HttpServletRequest参数
 * 
 * @author taixu.zqq
 * @version $Id: RequestUtil.java, v 0.1 2014年7月23日 上午10:48:10 taixu.zqq Exp $
 */
public class RequestUtil {
	
    /**
     * 获取所有request请求参数key-value
     * 
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request){
        
        Map<String, String> params = new HashMap<String, String>();
        if(null != request){
            Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
    /**
     * 
     * @Title: getRequestPostStr   
     * @Description: TODO(获取post请求字符)   
     * @param: @param request
     * @param: @return
     * @param: @throws IOException      
     * @return: String      
     * @throws
     */
    public static String getRequestPostStr(HttpServletRequest request)throws IOException {  
      byte buffer[] = getRequestPostBytes(request);  
      String charEncoding = request.getCharacterEncoding();  
      if (charEncoding == null) {  
          charEncoding = "UTF-8";  
      }  
      return new String(buffer, charEncoding);  
    }
    /**
     * 
     * @Title: getRequestPostBytes   
     * @Description: TODO(获取请求体字节)   
     * @param: @param request
     * @param: @return
     * @param: @throws IOException      
     * @return: byte[]      
     * @throws
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)throws IOException {  
        int contentLength = request.getContentLength();  
        if(contentLength<0){  
            return null;  
        }  
        byte buffer[] = new byte[contentLength];  
        for (int i = 0; i < contentLength;) {  
  
            int readlen = request.getInputStream().read(buffer, i,  
                    contentLength - i);  
            if (readlen == -1) {  
                break;  
            }  
            i += readlen;  
        }  
        return buffer;  
    }
   
    /**   
     * @Title: getRequestBodyByReader   
     * @Description: TODO(获取微信回调函数参数,返回xml)   
     * @param: @param request
     * @param: @return
     * @param: @throws IOException      
     * @return: String      
     * @throws   
     */ 
    public static String getRequestBodyByReader(HttpServletRequest request) throws IOException {
    	String tempLine;
    	String result = "";
    	try {
			if(request != null) {
				while ((tempLine = request.getReader().readLine()) != null) {
					result += tempLine;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if(request.getReader() != null) {
					request.getReader().close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return result;
    }
}
