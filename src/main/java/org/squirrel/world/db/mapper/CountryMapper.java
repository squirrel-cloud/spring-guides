package org.squirrel.world.db.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryMapper {
    @Select("SELECT * FROM country")
    List<Object> listCountries();
}
