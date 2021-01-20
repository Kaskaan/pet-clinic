package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.konradlesiak.petclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PetTypeMapService.class)
class PetTypeMapServiceTest {

    PetType petType1;
    PetType petType2;

    PetTypeMapService petTypeMapService;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();

        petType1 = PetType.builder().name("Dog").build();
        petTypeMapService.save(petType1);

        petType2 = PetType.builder().name("Cat").build();
    }

    @Test
    void findAll() {
        final Set<PetType> petTypeSet = petTypeMapService.findAll();
        assertNotNull(petTypeSet);
        assertEquals(1L, petTypeSet.size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(petType1.getId());
        assertFalse(petTypeMapService.findAll().contains(petType1));
    }

    @Test
    void delete() {
        petTypeMapService.delete(petType1);
        assertFalse(petTypeMapService.findAll().contains(petType1));
    }

    @Test
    void save() {
        petTypeMapService.save(petType2);
        assertTrue(petTypeMapService.findAll().contains(petType2));
    }

    @Test
    void findById() {
        final PetType petTypeFromService = petTypeMapService.findById(petType1.getId());
        assertEquals(petType1, petTypeFromService);
    }
}