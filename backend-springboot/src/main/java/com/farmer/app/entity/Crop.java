package com.farmer.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "crops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Crop name is required")
    private String cropName;

    private String season;
    private String seedType;

    @Positive(message = "Land area must be positive")
    private Double landArea;

    private LocalDate sowingDate;
    private LocalDate expectedHarvestDate;

    @PositiveOrZero(message = "Expected yield cannot be negative")
    private Double expectedYield;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
}
