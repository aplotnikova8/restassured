package ifellow.steps;


import ifellow.api.petstore.PetApi;
import ifellow.constants.PetStatus;
import ifellow.pet.Pet;
import ifellow.utils.MapperUtils;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class PetSteps {

    private static final PetApi petApi = new PetApi();

    public Pet createNewPetFromFile() {
        return petApi.postPet(MapperUtils.readFromFile("src/test/resources/fifthLesson/pet.json", Pet.class))
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Pet.class);
    }

    public Pet getPetById(long id) {
        Pet pet = petApi.getPetId(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Pet.class);
        return pet;
    }

    public JsonPath getNoExistencePetById(long id) {
        return petApi.getPetId(id)
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .body()
                .jsonPath();
    }

    public List<Pet> getListPetByStatus(PetStatus status) {
        return petApi.getFindByStatus(status)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(new TypeRef<>() {
                });
    }
}
