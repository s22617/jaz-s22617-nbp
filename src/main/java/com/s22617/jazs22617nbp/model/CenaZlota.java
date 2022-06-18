package com.s22617.jazs22617nbp.model;

import java.sql.Date;

public class CenaZlota {
    String date;
    Double price;

    public CenaZlota() {
    }

    public CenaZlota(String date, Double price) {
        this.date = date;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
