package org.squirrel.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squirrel.world.db.mapper.CountryMapper;

import java.util.List;

@RestController
public class WorldController {
    @Autowired
    CountryMapper countryMapper;

    @RequestMapping(path = "/listCountries")
    public Object listCountries() {
        List<Object> countries = countryMapper.listCountries();
        return countries.size();
    }
}
