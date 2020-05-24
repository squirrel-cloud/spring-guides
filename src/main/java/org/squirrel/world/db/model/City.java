package org.squirrel.world.db.model;

import lombok.Data;

@Data
public class City {
    private Long id;

    private String name;

    private CountryCode code;

    private String district;

    private Long population;
}
