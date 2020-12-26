package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping({"/owners", "/owners.html"})
    public String getOwners() {
        return "owners/owners";
    }
}
