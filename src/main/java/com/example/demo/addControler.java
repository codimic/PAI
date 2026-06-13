package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class addControler {
    @PostMapping("/add")
    public String addOsoba(@ModelAttribute Osoba osobaFormularz, Model model) {

        model.addAttribute("osobaFormularz", osobaFormularz);
        if(checkNotEmpty(osobaFormularz)) {

            return "poprawnaWalidacja";
        } else
            return "error";
    }

    private boolean checkNotEmpty(Osoba osoba) {
        return 	(osoba.getImie()!=null
                && osoba.getImie().length()>2)
                &&(osoba.getNazwisko()!=null
                && osoba.getNazwisko().length()>0)
                &&(osoba.getMail()!=null
                && osoba.getMail().length()>2);
    }
}
