package sample.configuration.oracle;

import org.junit.Test;
import org.meanbean.test.BeanTester;

/**
 * If everything works right this class was
 * created by konraifen88 on 29.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class OracleDbLocalConfigTest {

    @Test
    public void automatedGetterAndSetterTest() {
        BeanTester tester = new BeanTester();
        tester.testBean(OracleDbLocalConfig.class);
    }
}