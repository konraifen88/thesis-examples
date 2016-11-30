package sample.configuration.redis;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import sample.configuration.rabbit.RabbitLocalConfig;

/**
 * If everything works right this class was
 * created by konraifen88 on 30.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class RedisLocalConfigTest {

    @Test
    public void automatedGetterAndSetterTest() {
        BeanTester tester = new BeanTester();
        tester.testBean(RabbitLocalConfig.class);
    }
}