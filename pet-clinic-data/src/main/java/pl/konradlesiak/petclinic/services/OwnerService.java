package pl.konradlesiak.petclinic.services;

import pl.konradlesiak.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
