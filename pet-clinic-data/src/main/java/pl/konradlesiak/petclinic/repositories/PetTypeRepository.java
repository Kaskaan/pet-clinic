package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetRepository, Long> {
}
