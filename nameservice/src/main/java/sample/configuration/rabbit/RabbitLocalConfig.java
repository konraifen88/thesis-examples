package sample.configuration.rabbit;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * If everything works right this class was
 * created by konraifen88 on 27.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "rabbit")
@EnableRabbit
@Profile("!cloud")
@Data
@NoArgsConstructor
public class RabbitLocalConfig {
    private String hostname;
    private int port;
    private String username;
    private String password;


    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }

}
