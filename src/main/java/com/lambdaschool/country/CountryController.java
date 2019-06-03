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
}
