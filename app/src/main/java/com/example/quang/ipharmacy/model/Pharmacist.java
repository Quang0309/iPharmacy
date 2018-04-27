package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Pharmacist {
    private String id;
    private String name;
    private String address;
    private String tel;
    private String note;

    public Pharmacist() {
    }

    public Pharmacist(String name, String address, String tel, String note) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public Pharmacist setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pharmacist setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Pharmacist setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Pharmacist setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Pharmacist setNote(String note) {
        this.note = note;
        return this;
    }
}
