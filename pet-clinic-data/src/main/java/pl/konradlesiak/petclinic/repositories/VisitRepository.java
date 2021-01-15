package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.konradlesiak.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
