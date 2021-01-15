package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konradlesiak.petclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
