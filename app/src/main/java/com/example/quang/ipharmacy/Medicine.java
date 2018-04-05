package com.example.quang.ipharmacy;

import android.net.Uri;

import java.util.Date;

/**
 * Created by cpu10475-local on 04/04/2018.
 */

public class Medicine {
    private String name;
    private String image;
    private int quantity;
    private String lastModify;
    //private String ID;
    public Medicine(String name, String image, int quantity, String lastModify/*,String ID*/) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.lastModify = lastModify;
        //this.ID = ID;
    }

    public Medicine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLastModify() {
        return lastModify;
    }

    public void setLastModify(String lastModify) {
        this.lastModify = lastModify;
    }
/*
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }*/
}
