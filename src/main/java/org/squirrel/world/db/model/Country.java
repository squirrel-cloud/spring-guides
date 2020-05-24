package org.squirrel.world.db.model;

import lombok.Data;

@Data
public class Country {
    private String code;

    private String name;

    private Continent continent;

    private String region;

    private Double surfaceArea;

    private Long population;
}
