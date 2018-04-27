package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Disease {
    private String id;
    private String shortName;
    private String name;
    private String symptom;

    public Disease() {
    }

    public Disease(String shortName, String name, String symptom) {
        this.shortName = shortName;
        this.name = name;
        this.symptom = symptom;
    }

    public String getId() {
        return id;
    }

    public Disease setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Disease setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Disease setName(String name) {
        this.name = name;
        return this;
    }

    public String getSymptom() {
        return symptom;
    }

    public Disease setSymptom(String symptom) {
        this.symptom = symptom;
        return this;
    }
}
