package pl.konradlesiak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.konradlesiak.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
