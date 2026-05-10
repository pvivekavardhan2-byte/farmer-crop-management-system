package com.farmer.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Table(name = "investments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero private Double seedCost;
    @PositiveOrZero private Double fertilizerCost;
    @PositiveOrZero private Double pesticideCost;
    @PositiveOrZero private Double labourCost;
    @PositiveOrZero private Double waterCost;
    @PositiveOrZero private Double transportCost;
    @PositiveOrZero private Double machineryCost;
    @PositiveOrZero private Double otherCost;

    private Double totalInvestment;

    @OneToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;
}
