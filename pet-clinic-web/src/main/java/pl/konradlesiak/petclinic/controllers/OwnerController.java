package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.konradlesiak.petclinic.services.OwnerService;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"/owners", "/owners.html"})
    public String getOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/owners";
    }

    @GetMapping({"/owners/{id}", "/owners/{id}.html"})
    public String getOwners(Model model, @PathVariable Long id) {
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/owner";
    }
}
