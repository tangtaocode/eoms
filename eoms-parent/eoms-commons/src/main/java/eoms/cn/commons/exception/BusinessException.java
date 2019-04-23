package eoms.cn.commons.exception;

import org.springframework.http.HttpStatus;
/**
 * 业务异常通用
 * @author TTCODE
 * @date 2019/04/23
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
    
    private int code = HttpStatus.OK.value();
    
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException buildCode(int code) {
        this.code = code;
        return this;
    }

    public BusinessException buildMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
}
