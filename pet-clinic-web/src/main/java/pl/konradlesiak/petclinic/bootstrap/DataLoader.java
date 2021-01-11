package pl.konradlesiak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.konradlesiak.petclinic.model.*;
import pl.konradlesiak.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        final int size = petTypeService.findAll().size();

        System.out.println("PetTypeService = " + size);

        if (size == 0) {
            loadData();
        }

        System.out.println("PetTypeService = " + size);

    }

    private void loadData() {
        Speciality speciality1 = new Speciality();
        speciality1.setDescription("radiology");
        Speciality savedSpecialityRadiology = specialityService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("surgery");
        Speciality savedSpecialitySurgery = specialityService.save(speciality2);


        Speciality speciality3 = new Speciality();
        speciality3.setDescription("dentistry");
        Speciality savedSpecialityDentistry = specialityService.save(speciality3);

        System.out.println("Specialities has been loaded...");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedPetTypeCat = petTypeService.save(cat);

        System.out.println("PetTypes has been loaded...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Boglarka");
        owner1.setSecondName("Palko");
        Owner savedOwnerBoglarka = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setSecondName("Glenanne");
        Owner savedOwnerFiona = ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Andrzej");
        owner3.setSecondName("Piaseczny");
        Owner savedOwnerAndrzej = ownerService.save(owner3);

        System.out.println("Owners has been loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setSecondName("Axe");
        vet1.getSpecialities().add(savedSpecialityDentistry);
        Vet savedVetSam = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setSecondName("Moore");
        vet2.getSpecialities().add(savedSpecialitySurgery);
        Vet savedVetRoger = vetService.save(vet2);

        System.out.println("Vets has been loaded...");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetTypeDog);
        pet1.setPetName("Rex");
        pet1.setBirthDate(LocalDate.now().minusYears(2));
        pet1.setOwner(savedOwnerAndrzej);
        Pet savedPetRex = petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetTypeDog);
        pet2.setPetName("Kutyus");
        pet2.setBirthDate(LocalDate.now().minusYears(1));
        pet2.setOwner(savedOwnerBoglarka);
        Pet savedPetKutyus = petService.save(pet2);

        System.out.println("Pets has been loaded...");
    }
}
