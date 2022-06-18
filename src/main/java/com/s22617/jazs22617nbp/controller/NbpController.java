package com.s22617.jazs22617nbp.controller;

import com.s22617.jazs22617nbp.service.NbpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nbp")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/average-zloty/{startDate}/{endDate}")
    public ResponseEntity<Double> getAverageZloty(@PathVariable String startDate, @PathVariable String endDate) {
        return ResponseEntity.ok(nbpService.getAverageExchangeRate(startDate, endDate));
    }
}
