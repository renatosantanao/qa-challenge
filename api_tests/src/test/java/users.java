import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class users {
    String propFileName = "config.properties";
    String host = "";

    private static final String ENDPOINT = "/users";

//    private final String TESTDATAFILEPATH = "v2/user/user.json";
//    private JSONObject jsonData = null;
//    private static final String ENDPOINT_CONTRACT = "user-schema.json";

    @Before
    public void setUp() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        properties.load(inputStream);
        host = properties.getProperty("host");
    }

    @Test
    public void getValidateUsers(){
        given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
                .and()
                .body("name",notNullValue())
                .body("username",notNullValue())
                .body("email",notNullValue())
        ;
    }

    @Test
    public void getValidateEmail(){
        given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
        ;

    }

    @Test
    public  void getValidateCompanyCatchphrase(){
        given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
        ;

    }
}
