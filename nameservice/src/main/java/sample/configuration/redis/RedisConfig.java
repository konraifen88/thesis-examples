package sample.configuration.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * If everything works right this class was
 * created by konraifen88 on 30.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class RedisConfig {
    @Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
