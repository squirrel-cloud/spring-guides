package org.squirrel.world.db.mapper;

import org.squirrel.world.db.model.Country;

import java.util.List;

public interface CountryMapper {
//    @Select("SELECT * FROM country")
    List<Country> listCountries();

//    @Select("SELECT count(*) FROM country")
    int getCountryCount();
}
