package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.konradlesiak.petclinic.services.PetService;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping({"/pets", "/pets.html"})
    public String getPets(Model model) {
        model.addAttribute("pets", petService.findAll());
        return "pets/pets";
    }
}
