package eoms.cn.business.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import eoms.cn.commons.component.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="测试对象")
public class TestDTO extends Page{
    @ApiModelProperty(value="对象")
    @Range(min=1,max=2,message = "范围错误")
    private BigDecimal bigDecimal;
    @NotBlank(message = "校验不能为空。")
    private String validata;

    public String getValidata() {
        return validata;
    }

    public void setValidata(String validata) {
        this.validata = validata;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }
    
    
}
