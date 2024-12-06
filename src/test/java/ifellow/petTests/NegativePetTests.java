package ifellow.petTests;

import ifellow.steps.PetSteps;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NegativePetTests {

    private static final PetSteps petSteps = new PetSteps();

    @Test
    public void checkErrorPetWithIdNotFound() {
        JsonPath body = petSteps.getNoExistencePetById(0);
        Assertions.assertEquals("error", body.get("type"));
        Assertions.assertEquals("Pet not found", body.get("message"));
    }
}
