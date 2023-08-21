package reqres.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.pojo.LoginData;
import reqres.pojo.SuccessLogin;
import reqres.spec.Specifications;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static reqres.spec.Specifications.URL;


public class PostLoginSuccessApiTest {
    @Test
    @DisplayName("POST - Login successful: Response 200")
    public void loginUserSuccessful() throws IOException {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecCustom(200));

        File loginUserData = new File("src/test/resources/loginUserData.json");
        LoginData loginData = new ObjectMapper().readValue(loginUserData, LoginData.class);

        String token = "QpwL5tke4Pnpja7X4";

        SuccessLogin successLogin = given()
                .body(loginData)
                .when()
                .post("api/login")
                .then()
                .log()
                .all()
                .extract()
                .as(SuccessLogin.class);
        Assert.assertNotNull(successLogin.getToken());
        Assert.assertEquals(token, successLogin.getToken());
    }
}
