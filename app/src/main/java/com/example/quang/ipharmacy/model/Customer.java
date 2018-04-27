package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/26/2018.
 */

public class Customer {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String tel;

    public Customer() {
    }

    public Customer(String name, String gender, int age, String address, String tel) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Customer setTel(String tel) {
        this.tel = tel;
        return this;
    }
}
