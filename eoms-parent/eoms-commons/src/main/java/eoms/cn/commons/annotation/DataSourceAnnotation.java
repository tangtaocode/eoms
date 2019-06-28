package eoms.cn.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 动态数据源注解
 * @author TTCODE
 * @date 2019/05/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface DataSourceAnnotation {
    
    public static final String DEFAULT_DATASOURCE="defaultDataSource";
    
    public static final String CHR_DATASOURCE="chrDataSource";
    
    String value() default DEFAULT_DATASOURCE;
}
