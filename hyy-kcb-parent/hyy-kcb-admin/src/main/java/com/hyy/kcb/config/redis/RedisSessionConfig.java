package com.hyy.kcb.config.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 30, redisNamespace = "hyy-kcb-work") //30分钟失效
public class RedisSessionConfig {

}