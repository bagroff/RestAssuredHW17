package reqres.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.pojo.CreatePostUserRequest;
import reqres.pojo.CreatePostUserResponse;
import reqres.spec.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static reqres.spec.Specifications.URL;

public class PostCreateApiTest {
    @Test
    @DisplayName("POST - Create: Response 201")
    public void createUserPost() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecCustom(201));

        CreatePostUserRequest userRequest = new CreatePostUserRequest();
        userRequest.setName("morpheus");
        userRequest.setJob("leader");

        CreatePostUserResponse expectedResponse = new CreatePostUserResponse();
        expectedResponse.setName("morpheus");
        expectedResponse.setJob("leader");

        CreatePostUserResponse response = given()
                .body(userRequest)
                .when()
                .post("api/users")
                .then()
                .log()
                .all()
                .extract()
                .as(CreatePostUserResponse.class);

        assertThat(response.getName(), equalTo(expectedResponse.getName()));
        assertThat(response.getJob(), equalTo(expectedResponse.getJob()));
        assertThat(response.getId(), notNullValue());
        assertThat(response.getCreatedAt(), notNullValue());
    }
}
