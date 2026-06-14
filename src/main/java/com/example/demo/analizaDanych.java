package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class analizaDanych {

    @RequestMapping("/dane")
    public String dane(
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko,
            @RequestParam("pesel") String pesel,
            @RequestParam(value = "e-mail", required = false) String email,   // opcjonalne
            @RequestParam(value = "telefon", required = false) String telefon // opcjonalne
    ) {

        StringBuilder sb = new StringBuilder();
        sb.append("Witaj ").append(imie).append(" ").append(nazwisko).append(".");
        sb.append(" Twój PESEL to: ").append(pesel).append(".");

        if (email != null && !email.isBlank()) {
            sb.append(" Twój adres e-mail to: ").append(email).append(".");
        } else {
            sb.append(" Nie znamy Twojego adresu e-mail.");
        }

        if (telefon != null && !telefon.isBlank()) {
            sb.append(" Twój numer telefonu to: ").append(telefon).append(".");
        } else {
            sb.append(" Nie znamy Twojego numeru telefonu.");
        }

        return sb.toString();
    }
}
