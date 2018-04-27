package com.example.quang.ipharmacy.model;

/**
 * Created by VVLv on 04/27/2018.
 */

public class Location {
    private String id;
    private String shelfId;
    private String rackId;
    private String serialId;

    public Location() {
    }

    public Location(String shelfId, String rackId, String serialId) {
        this.shelfId = shelfId;
        this.rackId = rackId;
        this.serialId = serialId;
    }

    public String getId() {
        return id;
    }

    public Location setId(String id) {
        this.id = id;
        return this;
    }

    public String getShelfId() {
        return shelfId;
    }

    public Location setShelfId(String shelfId) {
        this.shelfId = shelfId;
        return this;
    }

    public String getRackId() {
        return rackId;
    }

    public Location setRackId(String rackId) {
        this.rackId = rackId;
        return this;
    }

    public String getSerialId() {
        return serialId;
    }

    public Location setSerialId(String serialId) {
        this.serialId = serialId;
        return this;
    }
}
