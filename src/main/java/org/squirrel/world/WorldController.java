package org.squirrel.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squirrel.world.db.model.Country;
import org.squirrel.world.service.CountryService;

import java.util.List;

@RestController
public class WorldController {
    @Autowired
    private CountryService countryService;

    @RequestMapping(path = "/listCountries")
    public Object listCountries() {
        List<Country> countries = countryService.listCountries();
        System.out.println(countries);
        return countryService.getCountryCount();
    }
}
