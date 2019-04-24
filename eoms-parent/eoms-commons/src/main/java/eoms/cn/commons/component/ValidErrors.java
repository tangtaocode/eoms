package eoms.cn.commons.component;
/**
   * 校验入参信息提示数据
 * @author TTCODE
 * @date 2019/04/24
 */
public class ValidErrors {
    private String objectName;
    private String field;
    private String message;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
