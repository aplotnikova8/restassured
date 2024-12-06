package ifellow.simpleTests;

import ifellow.api.Specifications;
import ifellow.constants.EnvConstants;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpecificationTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.POSTMAN_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    @Test
    public void checkSimpleGetRequest() {
        given()
               //.spec(Specifications.baseRequestSpec())
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                //.spec(Specifications.baseResponseSpecSuccess())
                .assertThat()
                .and().body("args.foo2", Matchers.is("bar2"));
    }
}
