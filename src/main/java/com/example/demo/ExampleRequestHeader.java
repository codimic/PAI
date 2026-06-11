package com.example.demo;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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