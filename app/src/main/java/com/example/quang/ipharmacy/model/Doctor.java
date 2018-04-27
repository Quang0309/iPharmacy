package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Doctor {
    private String id;
    private String name;
    private String address;
    private String specialisation;
    private String tel;
    private String note;

    public Doctor() {
    }

    public Doctor(String name, String address, String specialisation, String tel, String note) {
        this.name = name;
        this.address = address;
        this.specialisation = specialisation;
        this.tel = tel;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public Doctor setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Doctor setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public Doctor setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Doctor setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Doctor setNote(String note) {
        this.note = note;
        return this;
    }
}
