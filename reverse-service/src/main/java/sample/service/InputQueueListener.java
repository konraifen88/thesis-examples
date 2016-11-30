package sample.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import sample.model.ReverseMessage;

/**
 * If everything works right this class was
 * created by konraifen88 on 27.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Service
public class InputQueueListener {
    private final Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    public ReverseMessage handleMessage(final ReverseMessage message) {
        log.info("received message with content: " + message.getMessage());
        String result = "";
        result = new StringBuilder(message.getMessage()).reverse().toString();
        return new ReverseMessage(result);
    }
}
