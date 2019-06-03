package com.lambdaschool.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    //localhost:2019/data/allEmployees
    @RequestMapping(value = "/allcountries",
                    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost/data/countries/s
    @GetMapping(value = "countries/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountries(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> returnCountries = CountryApplication.ourCountryList.
                findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }
}
