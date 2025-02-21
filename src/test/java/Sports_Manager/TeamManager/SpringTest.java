package Sports_Manager.TeamManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTest {
    @Autowired
    private TestRestTemplate trt;
    @Test
    @DisplayName(value = "Context loading test")
    void contextLoads(){

    }

    @Test
    @DisplayName(value = "Player Controller test")
    void controllerTest(){

    }

}
