package com.farmer.app.controller;

import com.farmer.app.entity.Investment;
import com.farmer.app.service.InvestmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/investments")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping("/crop/{cropId}")
    public Investment save(@PathVariable Long cropId, @Valid @RequestBody Investment investment) {
        return investmentService.save(cropId, investment);
    }

    @GetMapping
    public List<Investment> getAll() {
        return investmentService.getAll();
    }
}
