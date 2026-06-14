package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WyborController {

    @GetMapping("/wybory")
    public String pokazFormularz(Model model) {
        model.addAttribute("osobaFormularz", new OsobaFormularz());
        return "formularzWybory";
    }

    @PostMapping("/wybory")
    public String obsluzFormularz(@ModelAttribute OsobaFormularz osobaFormularz, Model model) {
        int wiek = osobaFormularz.getWiek() == null ? 0 : osobaFormularz.getWiek();

        String komunikat;
        if (wiek < 18) {
            komunikat = "Nie możesz wziąć udziału w wyborach (poniżej 18).";
        } else if (wiek < 35) {
            komunikat = "Możesz wziąć udział w wyborach, ale nie możesz zostać prezydentem (od 18, ale mniej niż 35).";
        } else {
            komunikat = "Możesz już kandydować na prezydenta. (od 35)";
        }

        model.addAttribute("osobaFormularz", osobaFormularz);
        model.addAttribute("komunikat", komunikat);
        return "wynik";
    }
}
