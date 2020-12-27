package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.konradlesiak.petclinic.services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"/vets", "vets.html"})
    public String getVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vets";
    }
}
