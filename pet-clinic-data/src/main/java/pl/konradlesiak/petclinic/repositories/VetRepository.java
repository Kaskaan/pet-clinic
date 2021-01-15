package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.konradlesiak.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
