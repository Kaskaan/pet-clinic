package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.konradlesiak.petclinic.model.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SpecialityMapService.class)
class VetMapServiceTest {

    Vet vet1;
    Vet vet2;
    VetMapService vetMapService;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vet1 = Vet.builder().id(1L).firstName("Paul").lastName("Walker").specialities(new HashSet<>()).build();
        vet2 = Vet.builder().id(2L).firstName("Richard").lastName("Hays").specialities(new HashSet<>()).build();
        vetMapService.save(vet1);
    }

    @Test
    void findAll() {
        final Set<Vet> vetsFromService = vetMapService.findAll();
        assertEquals(1L, vetsFromService.size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vet1.getId());
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void delete() {
        vetMapService.delete(vet1);
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void save() {
        vetMapService.save(vet2);
        assertEquals(2L, vetMapService.findAll().size());
    }

    @Test
    void findByIdNotNull() {
        final Vet vetFromService = vetMapService.findById(vet1.getId());
        assertNotNull(vetFromService);
    }

    @Test
    void findById() {
        final Vet vetFromService = vetMapService.findById(vet1.getId());
        assertEquals(vet1.getId(), vetFromService.getId());
        assertEquals(vet1.getFirstName(), vetFromService.getFirstName());
        assertEquals(vet1.getLastName(), vetFromService.getLastName());
    }
}