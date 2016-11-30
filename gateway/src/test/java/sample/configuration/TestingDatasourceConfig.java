package sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Configuration
@Profile("test")
public class TestingDatasourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        System.out.println("datasource created");
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("user_data.sql", "country_data.sql")
                .build();
    }

    @Bean
    @Primary
    public JdbcTemplate testTemplate() {
        System.out.println("template created");
        return new JdbcTemplate(dataSource());
    }
}
