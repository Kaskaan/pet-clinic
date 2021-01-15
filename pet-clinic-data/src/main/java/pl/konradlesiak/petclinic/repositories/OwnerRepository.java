package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.konradlesiak.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
