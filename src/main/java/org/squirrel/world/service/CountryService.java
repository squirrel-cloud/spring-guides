package org.squirrel.world.service;

import org.squirrel.world.db.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> listCountries();

    int getCountryCount();
}
