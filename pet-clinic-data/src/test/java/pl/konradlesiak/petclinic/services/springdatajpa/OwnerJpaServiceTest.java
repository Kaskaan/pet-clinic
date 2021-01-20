package pl.konradlesiak.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.repositories.OwnerRepository;
import pl.konradlesiak.petclinic.repositories.PetRepository;
import pl.konradlesiak.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    Owner owner1;
    Owner owner2;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerService;

    @BeforeEach
    void setUp() {
        owner1 = Owner.builder()
                .id(1L)
                .firstName("Stuart")
                .lastName("Smith")
                .build();

        owner2 = Owner.builder()
                .id(2L)
                .firstName("John")
                .lastName("Kowalsky")
                .build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner1);

        final Owner ownerFromService = ownerService.findByLastName(owner1.getLastName());

        assertNotNull(ownerFromService);
        assertEquals(owner1.getLastName(), ownerFromService.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(owner1);
        returnOwnerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> ownerSet = ownerService.findAll();

        assertNotNull(ownerSet);
        assertEquals(2L, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner1));

        final Owner ownerFromService = ownerService.findById(owner1.getId());

        assertNotNull(ownerFromService);
        assertEquals(owner1.getId(), ownerFromService.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        final Owner ownerFromService = ownerService.findById(owner1.getId());

        assertNull(ownerFromService);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().firstName("Rick").lastName("Pickle").build();

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        final Owner savedOwner = ownerService.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepository, Mockito.times(1)).save(any());
        verify(ownerRepository, Mockito.times(1)).save(ownerToSave);
    }

    @Test
    void delete() {
        ownerService.delete(owner1);

        verify(ownerRepository).delete(any());
        verify(ownerRepository, Mockito.times(1)).delete(owner1);
    }

    @Test
    void deleteById() {
        final Long ID = 1L;

        ownerService.deleteById(ID);

        verify(ownerRepository).deleteById(any());
        verify(ownerRepository, Mockito.times(1)).deleteById(ID);
    }
}