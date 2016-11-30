package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE, maxInactiveIntervalInSeconds = 7200)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
