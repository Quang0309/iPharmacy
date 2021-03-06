package com.example.quang.ipharmacy.model;

import java.util.List;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Medicine {
    private String id;
    private String shortName;
    private String name;
    private List<MedicineType> types;
    private List<Chemical> chemicals;
    private String productionBatch;
    private String MFGDate;
    private String EXPDate;
    private int quantity;
    private List<Unit> units;
    private Country country;
    private Location location;
    private String note;

    public Medicine() {
    }

    public Medicine(String shortName,
                    String name,
                    List<MedicineType> types,
                    List<Chemical> chemicals,
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
        this.types = types;
        this.chemicals = chemicals;
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

    public Medicine setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Medicine setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Medicine setName(String name) {
        this.name = name;
        return this;
    }

    public List<MedicineType> getTypes() {
        return types;
    }

    public Medicine setTypes(List<MedicineType> types) {
        this.types = types;
        return this;
    }

    public List<Chemical> getChemicals() {
        return chemicals;
    }

    public Medicine setChemicals(List<Chemical> chemicals) {
        this.chemicals = chemicals;
        return this;
    }

    public String getProductionBatch() {
        return productionBatch;
    }

    public Medicine setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
        return this;
    }

    public String getMFGDate() {
        return MFGDate;
    }

    public Medicine setMFGDate(String MFGDate) {
        this.MFGDate = MFGDate;
        return this;
    }

    public String getEXPDate() {
        return EXPDate;
    }

    public Medicine setEXPDate(String EXPDate) {
        this.EXPDate = EXPDate;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Medicine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public Medicine setUnits(List<Unit> units) {
        this.units = units;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Medicine setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Medicine setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Medicine setNote(String note) {
        this.note = note;
        return this;
    }
}
