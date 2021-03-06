package com.patelndipen.sanityscout.location.config;

import com.patelndipen.sanityscout.location.domain.LocationDetail;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Configuration
@ComponentScan("com.patelndipen.sanityscout.location")
public class RedisConf {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisTemplate<String, LocationDetail> redisTemplate() {
    final RedisTemplate<String, LocationDetail> template = new RedisTemplate<String, LocationDetail>();
    final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    template.setConnectionFactory(jedisConnectionFactory());
    template.setHashKeySerializer(stringRedisSerializer);
    template.setKeySerializer(stringRedisSerializer);
    template.setValueSerializer(new JdkSerializationRedisSerializer());
    return template;
  }

}
