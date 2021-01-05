package pl.konradlesiak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.model.Pet;
import pl.konradlesiak.petclinic.model.PetType;
import pl.konradlesiak.petclinic.model.Vet;
import pl.konradlesiak.petclinic.services.OwnerService;
import pl.konradlesiak.petclinic.services.PetService;
import pl.konradlesiak.petclinic.services.PetTypeService;
import pl.konradlesiak.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");
        final PetType savedPetTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        final PetType savedPetTypeCat = petTypeService.save(cat);

        System.out.println("PetTypes has been loaded...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Boglarka");
        owner1.setSecondName("Palko");
        final Owner savedOwnerBoglarka = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setSecondName("Glenanne");
        final Owner savedOwnerFiona = ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Andrzej");
        owner3.setSecondName("Piaseczny");
        final Owner savedOwnerAndrzej = ownerService.save(owner3);

        System.out.println("Owners has been loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setSecondName("Axe");
        final Vet savedVetSam = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setSecondName("Moore");
        final Vet savedVetRoger = vetService.save(vet2);

        System.out.println("Vets has been loaded...");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetTypeDog);
        pet1.setPetName("Rex");
        pet1.setBirthDate(LocalDate.now().minusYears(2));
        pet1.setOwner(savedOwnerAndrzej);
        final Pet savedPetRex = petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetTypeDog);
        pet2.setPetName("Kutyus");
        pet2.setBirthDate(LocalDate.now().minusYears(1));
        pet2.setOwner(savedOwnerBoglarka);
        final Pet savedPetKutyus = petService.save(pet2);

        System.out.println("Pets has been loaded...");
    }
}
