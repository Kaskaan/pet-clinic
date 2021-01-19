package pl.konradlesiak.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.konradlesiak.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    Owner owner1 = Owner.builder().id(1L).firstName("John").lastName("Wood").build();
    Owner owner2 = Owner.builder().id(2L).firstName("Owen").lastName("Wilson").build();

    @Autowired
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(owner1);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        final Owner owner = ownerMapService.findById(owner1.getId());
        assertEquals(owner1.getId(), owner.getId());
    }

    @Test
    void saveWithID() {
        assertEquals(1L, ownerMapService.findAll().size());
        ownerMapService.save(owner2);
        assertEquals(2L, ownerMapService.findAll().size());
    }

    @Test
    void saveWithNoId() {
        final Owner owner = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void delete() {
        assertEquals(1, ownerMapService.findAll().size());
        ownerMapService.delete(owner1);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(owner1.getId());
        assertEquals(null, ownerMapService.findById(owner1.getId()));
    }

    @Test
    void findByLastName() {
        Owner ownerFromService = ownerMapService.findByLastName(owner1.getLastName());
        assertNotNull(ownerFromService);
        assertEquals(owner1.getLastName(), ownerFromService.getLastName());
    }

    @Test
    void findByLastNameNull() {
        Owner ownerFromService = ownerMapService.findByLastName("foo");
        assertNull(ownerFromService);
    }
}