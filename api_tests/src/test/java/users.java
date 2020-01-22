import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class users {
    String propFileName = "config.properties";
    String host = "";

    private static final String ENDPOINT = "/users";

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
                .body("email[0]",containsString("@"))
                .body("email[1]",containsString("@"))
                .body("email[2]",containsString("@"))
                .body("email[3]",containsString("@"))
                .body("email[4]",containsString("@"))
                .body("email[5]",containsString("@"))
                .body("email[6]",containsString("@"))
                .body("email[7]",containsString("@"))
                .body("email[8]",containsString("@"))
                .body("email[9]",containsString("@"))
        ;

    }

    @Test
    public  void getValidateCompanyCatchphrase(){
        given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
                .body("[0]['company]['catchPhrase']", hasSize(50))
                .body("[1]['company]['catchPhrase']", hasSize(50))
                .body("[2]['company]['catchPhrase']", hasSize(50))
                .body("[3]['company]['catchPhrase']", hasSize(50))
                .body("[4]['company]['catchPhrase']", hasSize(50))
                .body("[5]['company]['catchPhrase']", hasSize(50))
                .body("[6]['company]['catchPhrase']", hasSize(50))
                .body("[7]['company]['catchPhrase']", hasSize(50))
                .body("[8]['company]['catchPhrase']", hasSize(50))
                .body("[9]['company]['catchPhrase']", hasSize(50))
        ;

    }
}
