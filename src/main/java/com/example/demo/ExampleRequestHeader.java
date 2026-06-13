package com.example.demo;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class ExampleRequestHeader {

    @GetMapping("/RequestHeader")
    public String exampleRequestHeader(
            @RequestHeader("User-Agent") String wersjaPrzegladarki,
            @RequestHeader(value = "Accept-Language", required = false) String acceptLanguage,
            @RequestHeader(value = "Host", required = false) String host
    ) {
        Locale lang = null;

        if (acceptLanguage != null && !acceptLanguage.isBlank()) {
            List<Locale.LanguageRange> ranges = Locale.LanguageRange.parse(acceptLanguage);
            lang = Locale.lookup(ranges, List.of(Locale.getAvailableLocales()));
        }

        if (lang == null) {
            lang = LocaleContextHolder.getLocale();
        }

        String nationalLang = (lang != null) ? lang.toLanguageTag() : "unknown";

        return "wersja przegladarki:" + wersjaPrzegladarki + "\n" +
                "jezyk narodowy: " + nationalLang + "\n" +
                "adres hosta: " + host;
    }
}

@Controller
class HelloController {
    @RequestMapping("/szablon")
    public String hello() {
        return "StronaWidok";
    }
}

@Controller
class KolejnyController2 {
    @RequestMapping("/parametr")
    public String hello(Model model) {
        model.addAttribute("danzeZKontrolera", "Tekst jest parametrem (atrybutem), nie ma go w widoku");
        return "PrzekazywanieParametrow";
    }
}

@Controller
class KolejnyController3 {
    @RequestMapping("/obiekt")
    public Object hello3(Model model) {
        Osoba osoba1 = new Osoba(1, "Jan", "Kowalski", "600-123-456", "przykladowy@mail.com");
        model.addAttribute("osoba1", osoba1);
        Osoba osoba2 = new Osoba(2, "Anna", "Nowak", "600-987-654", "anna@mail.com");

        model.addAttribute("osoba2", osoba2);
        return "obiektOsoba";
    }
}

@Controller
class Formularz {
    @RequestMapping("/formularz")
    public Object hello3(Model model) {
        Osoba osoba3 = new Osoba(2, "Henryk", "Sienkiewicz", "123-456-789", "henryk@mail.pl");
        model.addAttribute("osoba3", osoba3);
        return "formularz";
    }
}






