package pl.konradlesiak.petclinic.services;

import pl.konradlesiak.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
