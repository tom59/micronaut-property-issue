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

        // It does work in micronaut 1.3.6
        // This fails in micronaut 2.0, this returns
        // Map.of(
        //   "scope[0]", "aUserName",
        //  "scope[1]", "aUserName2",
        //  "scope", asList("aUserName", "aUserName2")))
        assertEquals(test, Map.of("scope", asList("aUserName", "aUserName2")));
    }

    private ApplicationContext startApp() {
        return ApplicationContext.build().build().start();
    }
}
