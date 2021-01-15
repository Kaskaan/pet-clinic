package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.konradlesiak.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
