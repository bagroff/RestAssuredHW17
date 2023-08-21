package reqres.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.pojo.Resources;
import reqres.spec.Specifications;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static reqres.spec.Specifications.URL;

public class GetListApiTest {
    @Test
    @DisplayName("GET - List Resources: Response 200")
    public void getListResourcesTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecCustom(200));
        List<Resources> resources = given()
                .when()
                .get("api/unknown")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", Resources.class);

        List<String> namesOfResources = Arrays.asList(
                "cerulean",
                "fuchsia rose",
                "true red",
                "aqua sky",
                "tigerlily",
                "blue turquoise");

        IntStream.range(0, resources.size())
                .forEach(i -> Assertions.assertEquals(true, resources.get(i).getName().equals(namesOfResources.get(i)),
                        String.format("Expected %s , actual %s",
                                resources.get(i).getName(),
                                namesOfResources.get(i))));
    }
}
