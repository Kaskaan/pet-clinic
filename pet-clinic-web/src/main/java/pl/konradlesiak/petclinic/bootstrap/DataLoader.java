package pl.konradlesiak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.model.Pet;
import pl.konradlesiak.petclinic.model.PetType;
import pl.konradlesiak.petclinic.model.Vet;
import pl.konradlesiak.petclinic.services.OwnerService;
import pl.konradlesiak.petclinic.services.PetService;
import pl.konradlesiak.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setSecondName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setSecondName("Glenanne");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Andrzej");
        owner3.setSecondName("Piaseczny");

        ownerService.save(owner3);

        System.out.println("Owners has been loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setSecondName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Roger");
        vet2.setSecondName("Moore");

        vetService.save(vet2);

        System.out.println("Vets has been loaded...");

        PetType dog = new PetType();
        dog.setName("Dog");

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.now().minusYears(2));
        pet1.setOwner(owner3);

        petService.save(pet1);

        System.out.println("Pets has been loaded...");
    }
}
