package com.farmer.app.controller;

import com.farmer.app.dto.ProfitLossReportDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class ReportController {

    @GetMapping("/profit-loss")
    public List<ProfitLossReportDTO> getProfitLossReport() {
        return List.of(
                new ProfitLossReportDTO("Ramesh", "Paddy", 50000.0, 75000.0, 25000.0, "Profit"),
                new ProfitLossReportDTO("Suresh", "Cotton", 40000.0, 30000.0, -10000.0, "Loss"),
                new ProfitLossReportDTO("Mahesh", "Maize", 30000.0, 45000.0, 15000.0, "Profit")
        );
    }
}
