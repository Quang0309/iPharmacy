package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Provider {
    private String id;
    private String shortName;
    private String name;
    private String address;
    private String tel;
    private String license;
    private String note;

    public Provider() {
    }

    public Provider(String shortName,
                    String name,
                    String address,
                    String tel,
                    String license,
                    String note) {
        this.shortName = shortName;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.license = license;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public Provider setId(String id) {
        this.id = id;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Provider setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Provider setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Provider setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Provider setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getLicense() {
        return license;
    }

    public Provider setLicense(String license) {
        this.license = license;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Provider setNote(String note) {
        this.note = note;
        return this;
    }
}
