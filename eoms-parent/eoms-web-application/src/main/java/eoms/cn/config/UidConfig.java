package eoms.cn.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robert.vesta.service.factory.IdServiceFactoryBean;
import com.robert.vesta.service.factory.IdServiceFactoryBean.Type;
import com.robert.vesta.service.intf.IdService;

import eoms.cn.commons.component.UidService;

@Configuration
@EnableConfigurationProperties(VestaProperty.class)
public class UidConfig {

    @Bean(initMethod = "init", name = "idService")
    public IdServiceFactoryBean idServiceFactoryBean(VestaProperty vestaProperty) {
        IdServiceFactoryBean re = new IdServiceFactoryBean();
        re.setGenMethod(vestaProperty.getGenMethod());
        re.setMachineId(vestaProperty.getMachine());
        re.setType(vestaProperty.getType());
        re.setProviderType(Type.PROPERTY);
        return re;
    }

    @Bean
    @ConditionalOnClass({IdService.class})
    public UidService uidService(IdService idService) {
        return new UidService(idService);
    }
}
