package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.model.Pet;
import pl.konradlesiak.petclinic.model.PetType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OwnerMapService.class)
class PetMapServiceTest {

    Pet pet1;
    Pet pet2;

    PetMapService petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();

        pet1 = Pet.builder()
                .name("Rex")
                .birthDate(LocalDate.now().minusYears(1))
                .petType(new PetType())
                .owner(new Owner())
                .visits(new HashSet<>())
                .build();

        petMapService.save(pet1);

        pet2 = Pet.builder()
                .name("Rambo")
                .birthDate(LocalDate.now().minusYears(2))
                .petType(new PetType())
                .owner(new Owner())
                .visits(new HashSet<>())
                .build();
    }

    @Test
    void findAll() {
        final Set<Pet> petSet = petMapService.findAll();
        assertEquals(1L, petSet.size());
    }

    @Test
    void findById() {
        final Pet petFromService = petMapService.findById(pet1.getId());
        assertEquals(pet1, petFromService);
    }

    @Test
    void save() {
        petMapService.save(pet2);
        assertEquals(2L, petMapService.findAll().size());
        assertTrue(petMapService.findAll().contains(pet2));
    }

    @Test
    void deleteById() {
        petMapService.deleteById(pet1.getId());
        assertFalse(petMapService.findAll().contains(pet1));
    }

    @Test
    void delete() {
        petMapService.delete(pet1);
        assertFalse(petMapService.findAll().contains(pet1));
    }
}