package com.scanink.home.lab.hl_redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.*;

@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    JedisClientConfig jedisClientConfig() {
        return DefaultJedisClientConfig.builder().resp3().build();
    }

    @Bean
    public UnifiedJedis unifiedJedis(@Value("${spring.redis.uri}") String uri,
                                     JedisClientConfig jedisClientConfig) {
        HostAndPort node = HostAndPort.from(uri);
        return new UnifiedJedis(node, jedisClientConfig);
    }
}
