package sample.service;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.model.ReverseMessage;

/**
 * If everything works right this class was
 * created by konraifen88 on 27.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Service
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitMessageSender {
    private static final Logger log = Logger.getLogger(RabbitMessageSender.class);

    @NonNull
    private final RabbitTemplate template;

    public String sendMessage(String queue, String message) {
        ReverseMessage result = null;
        try {
            Object o = template.convertSendAndReceive(queue, new ReverseMessage(message));
            System.out.println(o);
            result = (ReverseMessage) o;
        } catch (AmqpException | ClassCastException | NullPointerException e) {
            log.error("SendAndReceived failed", e);
        }
        return result != null ? result.getMessage() : "";
    }
}
