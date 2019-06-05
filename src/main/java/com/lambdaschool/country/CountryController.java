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

    //localhost/names/s
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

    //localhost/names/size/10
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

    //localhost/population/size/50000
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

    //localhost:2019/population/min
    @GetMapping(value = "population/min",
            produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/population/median   stretch
    @GetMapping(value = "population/median",
            produces = {"application/json"})
    public ResponseEntity<?> getMedianCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(CountryApplication.ourCountryList.countryList.size()/2), HttpStatus.OK);
    }


    //localhost:2019/population/max
    @GetMapping(value = "population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost/age/age/medianagevalue
    @GetMapping(value = "age/age/{age}",
            produces = {"application/json"})
    public ResponseEntity<?> getAllMedianAge(
            @PathVariable
                    int age)
    {
        ArrayList<Country> returnCountries = CountryApplication.ourCountryList.
                findCountries(c -> c.getMedianage() >= age);
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    //localhost:2019/age/min
    @GetMapping(value = "age/min",
            produces = {"application/json"})
    public ResponseEntity<?> getYoungestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getMedianage() - c2.getMedianage());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/age/max
    @GetMapping(value = "age/max",
            produces = {"application/json"})
    public ResponseEntity<?> getOldestCountry()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c2.getMedianage() - c1.getMedianage());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/age/median   stretch
    @GetMapping(value = "age/median",
            produces = {"application/json"})
    public ResponseEntity<?> getMedianCountryByAge()
    {
        CountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getMedianage() - c2.getMedianage());
        return new ResponseEntity<>(CountryApplication.ourCountryList.countryList.get(CountryApplication.ourCountryList.countryList.size()/2), HttpStatus.OK);
    }
}