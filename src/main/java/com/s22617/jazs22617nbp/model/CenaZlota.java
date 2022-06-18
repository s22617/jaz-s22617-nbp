package com.s22617.jazs22617nbp.model;

public class CenaZlota {
    String data;
    Double cena;

    public CenaZlota() {
    }

    public CenaZlota(String data, Double cena) {
        this.data = data;
        this.cena = cena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
