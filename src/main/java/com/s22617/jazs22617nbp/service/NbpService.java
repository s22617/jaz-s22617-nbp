package com.s22617.jazs22617nbp.service;

import com.s22617.jazs22617nbp.model.CenaZlota;
import com.s22617.jazs22617nbp.model.NbpRequest;
import com.s22617.jazs22617nbp.repository.NbpRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class NbpService {

    private final NbpRepository nbpRepository;

    private final RestTemplate restTemplate;

    public NbpService(NbpRepository nbpRepository, RestTemplate restTemplate) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    private final static String url = "http://api.nbp.pl/api/cenyzlota/";

    private Double getAverage(CenaZlota[] response) {
        double summedRates = 0d;
        List<CenaZlota> cenaZlotaList = Arrays.asList(response);
        for (CenaZlota cenaZlota : response) {
            summedRates += cenaZlota.getCena();
        }
        return summedRates / response.length;
    }

    public Double getAverageExchangeRate(String startDate, String endDate) {
        Date dateStart = Date.valueOf(startDate);
        Date dateEnd = Date.valueOf(endDate);

        String finalUrl = url + startDate.toString() + "/" + endDate.toString();

        ResponseEntity<CenaZlota[]> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, CenaZlota[].class);
        CenaZlota[] nbpResponse = response.getBody();
        double averageExchangeRate = getAverage(nbpResponse);
        nbpRepository.save(new NbpRequest(null, "ZLOTY", Date.valueOf(startDate), Date.valueOf(endDate), averageExchangeRate, LocalDateTime.now()));

        return averageExchangeRate;
    }
}
