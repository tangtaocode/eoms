package eoms.cn.commons.response;

import java.util.Map;

import org.springframework.http.HttpStatus;

import eoms.cn.commons.consts.EomsResponseStatus;

/**
 * 公共数据返回对象
 * 
 * @author TTCODE
 * @date 2019/04/22
 */
public class EomsResponse<T> {

    private String status = EomsResponseStatus.SUCCESS;

    private int code;

    private String msg;

    private Map<String, Object> extData;

    private int total = 0;

    private T data;

    public EomsResponse(String status, int code) {
        this.code = code;
        this.status = status;
    }

    public static EomsResponse<?> createOkEomsResponse() {
        return new EomsResponse<Object>(EomsResponseStatus.SUCCESS, HttpStatus.OK.value());
    }

    public static EomsResponse<?> createdErrorEomsResponse() {
        return new EomsResponse<Object>(EomsResponseStatus.FAIL, HttpStatus.BAD_REQUEST.value());
    }

    public EomsResponse<?> buildExtData(T data) {
        this.data = data;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtData() {
        return extData;
    }

    public void setExtData(Map<String, Object> extData) {
        this.extData = extData;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
