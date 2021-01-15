package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konradlesiak.petclinic.model.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
