package com.s22617.jazs22617nbp.model;

import java.util.ArrayList;

public class FetchedNbpResponse {
    ArrayList<CenaZlota> cenaZlotaList;

    public FetchedNbpResponse() {
    }

    public FetchedNbpResponse(ArrayList<CenaZlota> cenaZlotaList) {
        this.cenaZlotaList = cenaZlotaList;
    }

    public ArrayList<CenaZlota> getCenaZlotaList() {
        return cenaZlotaList;
    }

    public void setCenaZlotaList(ArrayList<CenaZlota> cenaZlotaList) {
        this.cenaZlotaList = cenaZlotaList;
    }
}
