package eoms.cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import eoms.cn.commons.component.RedisClient;

@Configuration
public class RedisConfig {
	@Bean
	RedisClient redisClient(RedisTemplate<String,Object> redisTemplate) {
		return new RedisClient(redisTemplate);
	}
}
