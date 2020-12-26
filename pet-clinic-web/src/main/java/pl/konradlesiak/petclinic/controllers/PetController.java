package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {

    @GetMapping({"/pets", "/pets.html"})
    public String getPets() {
        return "pets/pets";
    }
}
