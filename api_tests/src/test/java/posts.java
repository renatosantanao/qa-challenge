import Utils.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class posts extends Utils {

    private static final String ENDPOINT = "/posts";
    private JSONObject jsonData = null;
    private final String DATAFILEPATH = "posts.json";
    private String postId;
    private JSONObject bodyRequest;

    @Before
    public void setUp() throws IOException {
        jsonData = this.getJSONData(DATAFILEPATH);
    }

    @Test
    public void postNew(){

        ValidatableResponse response = given()
                .when()
                .get(host + ENDPOINT)
                .then()
                .statusCode(200)
        ;

        JsonPath body = response.extract().jsonPath();
        postId = body.getString("[0]['userId']");

        bodyRequest = jsonData.getJSONObject("fluxo1");
        bodyRequest.put("userId", postId);

        given()
                .body(jsonData.getJSONObject("fluxo1").toString())
                .when()
                .post(host + ENDPOINT)
                .then()
                .statusCode(201)
        ;

    }

    @Test
    public void postNewWithouttitle(){

        given()
                .body(jsonData.getJSONObject("fluxo2").toString())
                .when()
                .post(host + ENDPOINT)
                .then()
                .statusCode(400)
        ;
    }
}
