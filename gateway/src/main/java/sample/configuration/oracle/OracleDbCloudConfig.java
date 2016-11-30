package sample.configuration.oracle;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@Profile("cloud")
public class OracleDbCloudConfig extends AbstractCloudConfig {

    @Bean
    public DataSource dataSource() {
        return connectionFactory().dataSource();
    }

}
