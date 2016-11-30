package sample.configuration.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
public class RedisCommonConfig {

    @Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean
    public ForwardSessionIdAsHeaderFilter forwardSessionIdAsHeaderFilter() {
        return new ForwardSessionIdAsHeaderFilter();
    }
}
