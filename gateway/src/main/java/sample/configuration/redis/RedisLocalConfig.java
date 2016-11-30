package sample.configuration.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@Profile("!cloud")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "redis")
@Data
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
