package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Unit {
    private String id;
    private String shortName;
    private String name;
    private float price;

    public Unit() {
    }

    public Unit(String shortName, String name, float price) {
        this.shortName = shortName;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public Unit setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Unit setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Unit setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Unit setPrice(float price) {
        this.price = price;
        return this;
    }
}
