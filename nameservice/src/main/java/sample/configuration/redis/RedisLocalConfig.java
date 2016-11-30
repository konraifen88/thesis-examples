package sample.configuration.redis;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@EnableRedisHttpSession
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "redis")
@Data
@NoArgsConstructor
public class RedisLocalConfig {
    private String hostname;
    private int port;
    private String password;


    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName(hostname);
        jedisFactory.setPort(port);
        jedisFactory.setPassword(password);
        return jedisFactory;
    }
}
