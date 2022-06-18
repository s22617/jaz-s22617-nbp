package com.s22617.jazs22617nbp.service;

import com.s22617.jazs22617nbp.model.CenaZlota;
import com.s22617.jazs22617nbp.model.FetchedNbpResponse;
import com.s22617.jazs22617nbp.repository.NbpRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

@Service
public class NbpService {

    private final NbpRepository nbpRepository;

    private final RestTemplate restTemplate;

    public NbpService(NbpRepository nbpRepository, RestTemplate restTemplate) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    private final static String url = "http://api.nbp.pl/api/cenyzlota/";

    private Double getAverage(FetchedNbpResponse response) {
        double summedRates = 0d;
        for (CenaZlota cenaZlota : response.getCenaZlotaList()) {
            summedRates += cenaZlota.getPrice();
        }
        return summedRates / response.getCenaZlotaList().size();
    }

    public Double getAverageExchangeRate(String startDate, String endDate) {
        Date dateStart = Date.valueOf(startDate);
        Date dateEnd = Date.valueOf(endDate);

        String finalUrl = url + startDate.toString() + "/" + endDate.toString();

//        ResponseEntity<FetchedNbpResponse> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, FetchedNbpResponse.class);
//        FetchedNbpResponse nbpResponse = response.getBody();

        double averageExchangeRate = getAverage(nbpResponse);
        System.out.println(averageExchangeRate);

        return null;
    }
}
