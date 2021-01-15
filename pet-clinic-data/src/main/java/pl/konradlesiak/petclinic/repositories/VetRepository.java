package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konradlesiak.petclinic.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
