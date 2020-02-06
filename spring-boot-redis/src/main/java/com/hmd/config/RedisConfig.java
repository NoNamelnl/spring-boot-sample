package com.hmd.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/21
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder builder = new StringBuilder();
                builder.append(o.getClass().getName())
                        .append(method.getName());
                for (Object obj : objects) {
                    builder.append(obj.toString());
                }
                return builder.toString();
            }
        };
    }
}
