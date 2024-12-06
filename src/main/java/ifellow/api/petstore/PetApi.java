package ifellow.api.petstore;

import ifellow.constants.PetStatus;
import ifellow.pet.Pet;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PetApi extends BasePetApi {

    private static final String PET_URN = "/pet";

    public ValidatableResponse postPet(Pet pet) {
        return given()
                .when().body(pet)
                .post(PET_URN)
                .then();
    }

    public ValidatableResponse getPetId(long id) {
        return given()
                .when()
                .get(PET_URN + "/" + id)
                .then();
    }

    public ValidatableResponse getFindByStatus(PetStatus petStatus) {
        return given()
                .when().queryParam("status", petStatus.getStatus())
                .get(PET_URN + "/findByStatus")
                .then();
    }
}
