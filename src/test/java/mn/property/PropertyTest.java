package mn.property;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyTest {

    @Test
    void getProperty_should_read_list_from_yaml_file() {
        ApplicationContext applicationContext = startApp();

       Map test =  applicationContext.getProperty("whitelist", Map.class).get();

        assertEquals(test, Map.of("scope", asList("aUserName", "aUserName2")));
    }

    private ApplicationContext startApp() {
        return ApplicationContext.build().build().start();
    }
}
