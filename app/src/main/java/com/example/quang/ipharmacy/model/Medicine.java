package com.example.quang.ipharmacy.model;

/**
 * Created by Quang on 04/04/2018.
 */

public class Medicine {

    //private String id;
    private String name;
    private String image;
    private int quantity;
    private String lastModify;

    public Medicine() {
    }

    public Medicine(String name, String image, int quantity, String lastModify) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.lastModify = lastModify;
    }

    public String getName() {
        return name;
    }

    public Medicine setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Medicine setImage(String image) {
        this.image = image;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Medicine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getLastModify() {
        return lastModify;
    }

    public Medicine setLastModify(String lastModify) {
        this.lastModify = lastModify;
        return this;
    }
}