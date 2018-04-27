package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class MedicineType {
    private String id;
    private String shortName;
    private String name;

    public MedicineType() {
    }

    public MedicineType(String name) {
        this.name = name;
    }

    public MedicineType(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public MedicineType setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public MedicineType setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public MedicineType setName(String name) {
        this.name = name;
        return this;
    }
}
