package com.spring.task.Country.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CountryEntity {


    @Id
    private int id;
    private String isoCode;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
