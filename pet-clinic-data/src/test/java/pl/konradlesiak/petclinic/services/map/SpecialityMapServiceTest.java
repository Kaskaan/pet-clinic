package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.konradlesiak.petclinic.model.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    Speciality speciality1;
    Speciality speciality2;

    SpecialityMapService specialityMapService;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();

        speciality1 = Speciality.builder().description("GP").build();
        specialityMapService.save(speciality1);

        speciality2 = Speciality.builder().description("Laryngologist").build();
    }

    @Test
    void findAll() {
        final Set<Speciality> specialitySet = specialityMapService.findAll();
        assertEquals(1L, specialitySet.size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(speciality1.getId());
        assertFalse(specialityMapService.findAll().contains(speciality1));
    }

    @Test
    void save() {
        specialityMapService.save(speciality2);
        assertEquals(2L, specialityMapService.findAll().size());
        assertTrue(specialityMapService.findAll().contains(speciality2));
    }

    @Test
    void delete() {
        specialityMapService.delete(speciality1);
        assertFalse(specialityMapService.findAll().contains(speciality1));
    }

    @Test
    void findById() {
        final Speciality specialityFromService = specialityMapService.findById(speciality1.getId());
        assertEquals(speciality1, specialityFromService);
    }
}