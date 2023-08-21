package reqres.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.pojo.UserData;
import reqres.spec.Specifications;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static reqres.spec.Specifications.URL;

public class PutUpdateApiTest {
    @Test
    @DisplayName("PUT - Update: Response 200")
    public void updateUserTime(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecCustom(200));
        LocalDateTime dateTime = LocalDateTime.now();
        UserData user = new UserData("morpheus", "zion resident");

        given()
                .body(user)
                .when()
                .put("api/users/2")
                .then()
                .log()
                .all()
                .body("updatedAt", Matchers.startsWith(String.valueOf(dateTime.getYear())));
    }
}
