package eoms.cn.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import eoms.cn.commons.annotation.DataSourceAnnotation;

@Aspect
@Component
public class DynamicDataSourceAspect {
    
    @Before("@annotation(dataSourceAnnotation)")
    public void beforeSwitch(JoinPoint point,DataSourceAnnotation dataSourceAnnotation) {
        // 获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        // 获得访问的方法名
        String methodName = point.getSignature().getName();
        // 得到方法的参数的类型
        @SuppressWarnings("rawtypes")
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceAnnotation.DEFAULT_DATASOURCE;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DataSourceAnnotation注解
            if (method.isAnnotationPresent(DataSourceAnnotation.class)) {
                DataSourceAnnotation annotation = method.getAnnotation(DataSourceAnnotation.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(dataSourceAnnotation)")
    public void afterSwitch(JoinPoint point,DataSourceAnnotation dataSourceAnnotation) {
        DataSourceContextHolder.clearDB();
    }
}
