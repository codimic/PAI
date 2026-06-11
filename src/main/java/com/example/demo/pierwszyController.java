package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class pierwszyController {

    @RequestMapping("/")
    public String index() {
        return "Nasz pierwszy projekt i już działający serwer :-)";
    }

    @GetMapping(value = "/{tekst1}/{liczba1}/{liczba2}")
    public String PrzykladZPath(@PathVariable String tekst1, @PathVariable Long liczba1, @PathVariable Long liczba2
    ) {
        return switch (tekst1) {
            case "dodawanie" -> "Wynik: " + (liczba1 + liczba2);
            case "odejmowanie" -> "Wynik: " + (liczba1 - liczba2);
            case "iloczyn" -> "Wynik: " + (liczba1 * liczba2);
            default -> "Wpisz [dodawanie, odejmowanie lub iloczyn]/liczba1/liczba2";
        };
    }
}
