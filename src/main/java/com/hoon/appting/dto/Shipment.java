package com.hoon.appting.dto;

/**
 * Created by hoon on 2014-09-11.
 */
public class Shipment {
    Long id;
    String name;
    String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
