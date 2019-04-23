package eoms.cn.commons.component;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import eoms.cn.commons.exception.BusinessException;
import eoms.cn.commons.response.EomsResponse;

/**
 * 全局异常拦截器
 * @author TTCODE
 * @date 2019/04/23
 */
@CrossOrigin
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public EomsResponse<?> runtimeExceptionHandler(RuntimeException ex) {
        return exceptionFormat(1, ex,"非业务运行时异常");
    }

    //空指针异常    
    @ExceptionHandler(NullPointerException.class)  
    public EomsResponse<?> nullPointerExceptionHandler(NullPointerException ex) {  
        return exceptionFormat(2, ex,"空指针异常   ");  
    }  

    //类型转换异常    
    @ExceptionHandler(ClassCastException.class)  
    public EomsResponse<?> classCastExceptionHandler(ClassCastException ex) {  
        return exceptionFormat(3, ex,"类型转换异常");  
    }  

    //IO异常    
    @ExceptionHandler(IOException.class)  
    public EomsResponse<?> iOExceptionHandler(IOException ex) {  
        return exceptionFormat(4, ex,"IO异常");  
    }  

    //未知方法异常    
    @ExceptionHandler(NoSuchMethodException.class)  
    public EomsResponse<?> noSuchMethodExceptionHandler(NoSuchMethodException ex) {  
        return exceptionFormat(5, ex,"未知方法异常");  
    }  

    //数组越界异常    
    @ExceptionHandler(IndexOutOfBoundsException.class)  
    public EomsResponse<?> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {  
        return exceptionFormat(6, ex,"数组越界异常");  
    }  

    //请求信息不可读
    @ExceptionHandler({HttpMessageNotReadableException.class})  
    public EomsResponse<?> requestNotReadable(HttpMessageNotReadableException ex) {  
        return exceptionFormat(7, ex,"请求信息不可读 ");  
    }  

    //类型匹配错误    
    @ExceptionHandler({TypeMismatchException.class})  
    public EomsResponse<?> requestTypeMismatch(TypeMismatchException ex) {  
        return exceptionFormat(8, ex,"类型匹配错误");  
    }  

    //丢失请求参数错误 
    @ExceptionHandler({MissingServletRequestParameterException.class})  
    public EomsResponse<?> requestMissingServletRequest(MissingServletRequestParameterException ex) {  
        return exceptionFormat(9, ex,"丢失请求参数错误");  
    }  

    //请求方法不支持
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})  
    public EomsResponse<?> request405(HttpRequestMethodNotSupportedException ex) {  
        return exceptionFormat(10, ex,"请求方法不支持");  
    }  

    //不接受此媒体类型  
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})  
    public EomsResponse<?> request406(HttpMediaTypeNotAcceptableException ex) {  
        return exceptionFormat(11, ex,"不接受此媒体类型");  
    }  

    //转化异常   
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})  
    public EomsResponse<?> server500(RuntimeException ex) {  
        return exceptionFormat(12, ex,"转化异常");  
    }  

    //栈溢出  
    @ExceptionHandler({StackOverflowError.class})  
    public EomsResponse<?> requestStackOverflow(StackOverflowError ex) {  
        return exceptionFormat(13, ex,"栈溢出");  
    }  

    //系统异常 
    @ExceptionHandler({Exception.class})  
    public EomsResponse<?> exception(Exception ex) {  
        return exceptionFormat(14, ex,"系统异常");  
    }

    //自定义异常捕获
    @ExceptionHandler({BusinessException.class})
    public EomsResponse<?> businessException(BusinessException ex) {
        return exceptionFormat(999, ex,ex.getMsg());
    }

    private <T extends Throwable> EomsResponse<?> exceptionFormat(Integer code, T ex,String msg) {  
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));
        ex.printStackTrace();
        return EomsResponse.createdErrorEomsResponse().buildMsg(msg);  
    }
}
