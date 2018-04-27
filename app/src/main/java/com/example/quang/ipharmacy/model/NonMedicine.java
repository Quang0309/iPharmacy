package com.example.quang.ipharmacy.model;

import java.util.List;

/**
 * Created by VVLv on 04/27/2018.
 */

public class NonMedicine {
    private String id;
    private String shortName;
    private String name;
    private String productionBatch;
    private String MFGDate;
    private String EXPDate;
    private int quantity;
    private List<Unit> units;
    private Country country;
    private Location location;
    private String note;

    public NonMedicine() {
    }

    public NonMedicine(String shortName,
                       String name,
                       String productionBatch,
                       String MFGDate,
                       String EXPDate,
                       int quantity,
                       List<Unit> units,
                       Country country,
                       Location location,
                       String note) {
        this.shortName = shortName;
        this.name = name;
        this.productionBatch = productionBatch;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.quantity = quantity;
        this.units = units;
        this.country = country;
        this.location = location;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public NonMedicine setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public NonMedicine setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public NonMedicine setName(String name) {
        this.name = name;
        return this;
    }

    public String getProductionBatch() {
        return productionBatch;
    }

    public NonMedicine setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
        return this;
    }

    public String getMFGDate() {
        return MFGDate;
    }

    public NonMedicine setMFGDate(String MFGDate) {
        this.MFGDate = MFGDate;
        return this;
    }

    public String getEXPDate() {
        return EXPDate;
    }

    public NonMedicine setEXPDate(String EXPDate) {
        this.EXPDate = EXPDate;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public NonMedicine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public NonMedicine setUnits(List<Unit> units) {
        this.units = units;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public NonMedicine setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public NonMedicine setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getNote() {
        return note;
    }

    public NonMedicine setNote(String note) {
        this.note = note;
        return this;
    }
}
