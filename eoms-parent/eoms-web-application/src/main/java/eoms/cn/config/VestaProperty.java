package eoms.cn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "vesta")
@PropertySource(value= {"classpath:vesta-rest.properties"})
public class VestaProperty {
    private long machine;
    private long genMethod;
    private long type;

    public void setMachine(long machine) {
        this.machine = machine;
    }

    public void setGenMethod(long genMethod) {
        this.genMethod = genMethod;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getMachine() {
        return machine;
    }

    public long getGenMethod() {
        return genMethod;
    }

    public long getType() {
        return type;
    }
    
}
