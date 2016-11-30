package sample.configuration.rabbit;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.model.ReverseMessage;

/**
 * If everything works right this class was
 * created by konraifen88 on 30.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitConfig {

    @NonNull
    private ConnectionFactory connection;

    @Bean
    public MessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setClassMapper(classMapper());
        return converter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper typeMapper = new DefaultClassMapper();
        typeMapper.setDefaultType(ReverseMessage.class);
        return typeMapper;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(jsonMessageConverter());
        template.setMandatory(true);
        return template;
    }
}
