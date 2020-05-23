package org.squirrel.world.db.mapper;

import java.util.List;

public interface CountryMapper {
//    @Select("SELECT * FROM country")
    List<String> listCountries();

//    @Select("SELECT count(*) FROM country")
    int getCountryCount();
}
