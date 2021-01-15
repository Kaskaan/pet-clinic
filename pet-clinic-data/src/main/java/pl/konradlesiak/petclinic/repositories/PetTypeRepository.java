package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konradlesiak.petclinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
