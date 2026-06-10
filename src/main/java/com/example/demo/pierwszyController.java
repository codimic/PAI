package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class pierwszyController {

    @RequestMapping("/")
    public String index() {
        return "Nasz pierwszy projekt i już działający serwer :-)";
    }

    @GetMapping(value = "/{tekst1}/{liczba1}/{tekst2}/{liczba2}")
    public String PrzykladZPath(@PathVariable String tekst1, @PathVariable Long liczba1,
                                @PathVariable String tekst2, @PathVariable Long liczba2
    ) throws Exception {
        return "Z adresu pozyskałem następujące dane: tekst1="+tekst1+", liczba1:"+liczba1+", " +
                "tekst2="+tekst2+", liczba2 to:"+liczba2
                ;
    }
}
