package sample.configuration.redis;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@Profile("cloud")
public class RedisCloudConfig extends AbstractCloudConfig {

    @Bean
    public RedisConnectionFactory rediscloudConfig() {
        return connectionFactory().redisConnectionFactory();
    }
}
