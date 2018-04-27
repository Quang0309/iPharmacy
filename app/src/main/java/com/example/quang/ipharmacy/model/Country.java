package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Country {
    private String id;
    private String shortName;
    private String name;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Country setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }
}
