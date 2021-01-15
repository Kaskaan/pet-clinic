package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konradlesiak.petclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
