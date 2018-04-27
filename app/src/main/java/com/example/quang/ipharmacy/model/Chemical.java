package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Chemical {
    private String id;
    private String shortName;
    private String name;

    public Chemical() {
    }

    public Chemical(String name) {
        this.name = name;
    }

    public Chemical(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Chemical setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Chemical setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Chemical setName(String name) {
        this.name = name;
        return this;
    }
}
