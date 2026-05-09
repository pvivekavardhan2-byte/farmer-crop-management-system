package com.farmer.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfitLossReportDTO {
    private String farmerName;
    private String cropName;
    private Double investment;
    private Double expectedRevenue;
    private Double profitOrLoss;
    private String status;
}
