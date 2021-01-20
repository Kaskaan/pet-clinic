package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.model.Pet;
import pl.konradlesiak.petclinic.model.Visit;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    Visit visit1;
    Visit visit2;
    Pet pet1;
    Pet pet2;
    Owner owner1;
    Owner owner2;

    VisitMapService visitMapService;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();

        owner1 = Owner.builder().id(1L).build();
        owner2 = Owner.builder().id(2L).build();

        pet1 = Pet.builder()
                .id(1L)
                .owner(owner1)
                .build();

        pet2 = Pet.builder()
                .id(2L)
                .owner(owner2)
                .build();

        visit1 = Visit.builder()
                .id(1L)
                .date(LocalDate.now().plusDays(3))
                .description("test description for visit1")
                .pet(pet1)
                .build();

        visitMapService.save(visit1);

        visit2 = Visit.builder()
                .id(2L)
                .date(LocalDate.now().plusDays(5))
                .description("test description for visit2")
                .pet(pet2)
                .build();
    }

    @Test
    void findAll() {
        final Set<Visit> visitSet = visitMapService.findAll();
        assertEquals(1L, visitSet.size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visit1.getId());
        assertNull(visitMapService.findById(visit1.getId()));
        assertFalse(visitMapService.findAll().contains(visit1));
    }

    @Test
    void delete() {
        visitMapService.delete(visit1);
        assertFalse(visitMapService.findAll().contains(visit1));
    }

    @Test
    void save() {
        visitMapService.save(visit2);
    }

    @Test
    void findById() {
        final Visit visitFromService = visitMapService.findById(visit1.getId());
        assertEquals(visit1, visitFromService);
    }
}