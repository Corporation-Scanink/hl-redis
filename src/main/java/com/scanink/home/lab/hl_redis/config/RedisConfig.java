package com.scanink.home.lab.hl_redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.*;

@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    JedisClientConfig jedisClientConfig() {
        return DefaultJedisClientConfig.builder().resp3().build();
    }

    @Bean JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory (JedisPoolConfig jedisPoolConfig) {
        return new JedisConnectionFactory(jedisPoolConfig);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    public UnifiedJedis unifiedJedis(@Value("${spring.redis.host}") String hostname, @Value("${spring.redis.port}") String port,
                                    JedisClientConfig jedisClientConfig, JedisPoolConfig jedisPoolConfig) {
        HostAndPort node = HostAndPort.from(hostname+":"+port);
        return new UnifiedJedis(node, jedisClientConfig);
    }
}
