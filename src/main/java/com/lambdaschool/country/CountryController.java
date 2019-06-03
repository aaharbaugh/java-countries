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
    @RequestMapping(value = "names/allcountries",
                    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost/data/countries/s
    @GetMapping(value = "names/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountries(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> returnCountries = CountryApplication.ourCountryList.
                findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    //localhost/data/countries/n
    @GetMapping(value = "names/size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesLongerThan(
            @PathVariable
                    int number)
    {
        ArrayList<Country> returnCountries = CountryApplication.ourCountryList.
                findCountries(c -> c.getName().length() >= number);
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    //localhost/data/countries/n
    @GetMapping(value = "population/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesLargerThan(
            @PathVariable
                    int people)
    {
        ArrayList<Country> returnCountries = CountryApplication.ourCountryList.
                findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    //localhost:2019/data/allEmployees
    @GetMapping(value = "population/min",
            produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/data/allEmployees
    @GetMapping(value = "population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }


}