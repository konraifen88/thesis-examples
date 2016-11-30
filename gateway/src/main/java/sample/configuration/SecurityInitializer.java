package sample.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import sample.configuration.redis.RedisLocalConfig;

/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(WebSecurityConfig.class, RedisLocalConfig.class);
    }
}
