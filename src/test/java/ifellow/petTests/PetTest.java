package ifellow.petTests;



import ifellow.constants.PetStatus;
import ifellow.pet.Pet;
import ifellow.steps.PetSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PetTest {

    private static final PetSteps petSteps = new PetSteps();

    @Test
    @DisplayName("Проверка статуса 'available'")
    public void checkPetId() {
        Pet createdPetId = petSteps.createNewPetFromFile();
        long expectedId = createdPetId.getId();
        Pet pet = petSteps.getPetById(expectedId);
        Assertions.assertEquals(pet.getStatus(), "available");
    }

    @Test
    public void checkPetStatuses() {
        List<Pet> list = petSteps.getListPetByStatus(PetStatus.AVAILABLE);
        Assertions.assertTrue(list.size() > 1);
    }
}
