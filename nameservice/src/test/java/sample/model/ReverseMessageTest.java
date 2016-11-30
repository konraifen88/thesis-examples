package sample.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import static org.junit.Assert.assertEquals;

/**
 * If everything works right this class was
 * created by konraifen88 on 30.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
public class ReverseMessageTest {

    private static final String TEST_MESSAGE = "test123";

    @Test
    public void automatedGetterAndSetterTest() {
        BeanTester tester = new BeanTester();
        tester.testBean(ReverseMessage.class);
    }

    @Test
    public void hashCodeAndEqualsTest() {
        EqualsVerifier.forClass(ReverseMessage.class).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void getCorrectMessageWhenInitializedWithIt() throws Exception {
        ReverseMessage message = new ReverseMessage(TEST_MESSAGE);
        assertEquals(TEST_MESSAGE, message.getMessage());
    }

}