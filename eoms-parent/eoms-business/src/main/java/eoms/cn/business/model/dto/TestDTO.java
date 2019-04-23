package eoms.cn.business.model.dto;

import eoms.cn.commons.component.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="测试对象")
public class TestDTO extends Page{
    @ApiModelProperty(value="对象")
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
