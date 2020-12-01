package pl.atom.spring.cqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CqsSpringTest {

    @Autowired
    BusProvider busProvider;

    @Test
    void testCommandHandling() {
        TestCommand testCommand = new TestCommand();
        Assertions.assertDoesNotThrow(() -> busProvider.getCommandBus().execute(testCommand));
    }

    @Test
    void testQueryHandling() {
        TestQuery testQuery = new TestQuery();
        Assertions.assertEquals("TestMessage", busProvider.getQueryBus().execute(testQuery));
    }
}
