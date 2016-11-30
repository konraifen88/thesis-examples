package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Test
    public void contextLoads() {

    }

    @EnableRedisHttpSession
    @Configuration
    static class Config {
        @Bean
        @SuppressWarnings("unchecked")
        public RedisSerializer<Object> defaultRedisSerializer() {
            return Mockito.mock(RedisSerializer.class);
        }


        @Bean
        public RedisConnectionFactory connectionFactory() {
            RedisConnectionFactory factory = Mockito.mock(RedisConnectionFactory.class);
            RedisConnection connection = Mockito.mock(RedisConnection.class);
            Mockito.when(factory.getConnection()).thenReturn(connection);

            return factory;
        }
    }
}