package ifellow.simpleTests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleApiTest {

    @Test
    public void checkSimpleGetRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("args.foo2", Matchers.is("bar2"));
    }
}
