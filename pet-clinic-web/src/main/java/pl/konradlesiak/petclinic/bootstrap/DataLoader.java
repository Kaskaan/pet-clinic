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
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService,
                      PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        owner1.setLastName("Palko");
        owner1.setAddress("17 Best St.");
        owner1.setCity("Katowice");
        owner1.setTelephone("7363466433");
        Owner savedOwnerBoglarka = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("125 Oxford Rd.");
        owner2.setCity("Reading");
        owner2.setTelephone("7672645409");
        Owner savedOwnerFiona = ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Andrzej");
        owner3.setLastName("Piaseczny");
        owner3.setAddress("65 Island Rd.");
        owner3.setCity("Reading");
        owner3.setTelephone("7345167345");
        Owner savedOwnerAndrzej = ownerService.save(owner3);

        Owner owner4 = Owner.builder()
                .firstName("Konrad")
                .lastName("Lesiak")
                .address("99 Island Road")
                .city("Slough")
                .telephone("6665554443")
                .build();
        Owner savedOwnerKonrad = ownerService.save(owner4);

        System.out.println("Owners has been loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSpecialityDentistry);
        Vet savedVetSam = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setLastName("Moore");
        vet2.getSpecialities().add(savedSpecialitySurgery);
        Vet savedVetRoger = vetService.save(vet2);

        System.out.println("Vets has been loaded...");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetTypeDog);
        pet1.setName("Rex");
        pet1.setBirthDate(LocalDate.now().minusYears(2));
        pet1.setOwner(savedOwnerAndrzej);
        Pet savedPetRex = petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetTypeDog);
        pet2.setName("Kutyus");
        pet2.setBirthDate(LocalDate.now().minusYears(1));
        pet2.setOwner(savedOwnerBoglarka);
        Pet savedPetKutyus = petService.save(pet2);

        Pet pet3 = Pet.builder()
                .petType(savedPetTypeDog)
                .name("Rambo")
                .birthDate(LocalDate.now().minusYears(3))
                .owner(savedOwnerKonrad)
                .build();
        Pet savedPetRambo = petService.save(pet3);

        System.out.println("Pets has been loaded...");

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setDate(LocalDate.now().plusWeeks(1));
        visit1.setDescription(pet1.getName() + " has to be injected.");

        visitService.save(visit1);

        System.out.println("Visits has been loaded...");
    }
}
