package sopra.formation.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sopra.formation.model.Civilite;

@RestController
@CrossOrigin("*")
public class CommonRestController {

    @GetMapping("/civilites")
    public Civilite[] getCivilites() {
        return Civilite.values();
    }

}