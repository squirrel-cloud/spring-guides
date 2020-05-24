package org.squirrel.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.squirrel.world.db.mapper.CountryMapper;
import org.squirrel.world.db.model.Country;
import org.squirrel.world.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> listCountries() {
        return countryMapper.listCountries();
    }

    @Override
    public int getCountryCount() {
        return countryMapper.getCountryCount();
    }
}
