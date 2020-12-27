package pl.konradlesiak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.konradlesiak.petclinic.model.Owner;
import pl.konradlesiak.petclinic.model.Vet;
import pl.konradlesiak.petclinic.services.OwnerService;
import pl.konradlesiak.petclinic.services.VetService;
import pl.konradlesiak.petclinic.services.map.OwnerServiceMap;
import pl.konradlesiak.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setFirstName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setFirstName("Glenanne");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Andrzej");
        owner3.setFirstName("Piaseczny");

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
    }
}
