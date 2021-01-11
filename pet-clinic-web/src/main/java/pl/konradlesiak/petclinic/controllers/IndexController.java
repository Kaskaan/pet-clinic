package pl.konradlesiak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"", "/", "index", "index.html"})
    public String getIndex() {
        return "index";
    }

    @GetMapping({"oups", "oups.html", "/oups.html"})
    public String getError() {
        return "oups";
    }
}
