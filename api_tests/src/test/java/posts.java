import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class posts {
    String propFileName = "config.properties";
    String host = "";

    private static final String ENDPOINT = "/posts";

    @Before
    public void setUp() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        properties.load(inputStream);
        host = properties.getProperty("host");
    }

    @Test
    public void postNew(){
        ValidatableResponse response = given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
        ;


    }
}
