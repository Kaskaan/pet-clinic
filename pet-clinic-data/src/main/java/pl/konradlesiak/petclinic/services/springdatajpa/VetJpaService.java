package pl.konradlesiak.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.konradlesiak.petclinic.model.Vet;
import pl.konradlesiak.petclinic.repositories.VetRepository;
import pl.konradlesiak.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
