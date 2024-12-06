package ifellow.api.petstore;

import ifellow.api.Specifications;
import ifellow.constants.EnvConstants;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public abstract class BasePetApi {
    public BasePetApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.PETSTORE_URL);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
