package reqres.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.spec.Specifications;

import static io.restassured.RestAssured.given;
import static reqres.spec.Specifications.URL;

public class DeleteUserApiTest {
    @Test
    @DisplayName("DELETE - Delete user: Response 204")
    public void deleteUserTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecCustom(204));
        given()
                .when()
                .delete("api/users/2")
                .then()
                .log()
                .all();
    }

}
