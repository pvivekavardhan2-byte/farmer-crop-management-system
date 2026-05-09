package com.farmer.app.service;

import com.farmer.app.entity.Crop;
import com.farmer.app.entity.Investment;
import com.farmer.app.exception.ResourceNotFoundException;
import com.farmer.app.repository.CropRepository;
import com.farmer.app.repository.InvestmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final CropRepository cropRepository;

    public InvestmentService(InvestmentRepository investmentRepository, CropRepository cropRepository) {
        this.investmentRepository = investmentRepository;
        this.cropRepository = cropRepository;
    }

    public Investment save(Long cropId, Investment investment) {
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found with id: " + cropId));

        double total = value(investment.getSeedCost())
                + value(investment.getFertilizerCost())
                + value(investment.getPesticideCost())
                + value(investment.getLabourCost())
                + value(investment.getWaterCost())
                + value(investment.getTransportCost())
                + value(investment.getMachineryCost())
                + value(investment.getOtherCost());

        investment.setTotalInvestment(total);
        investment.setCrop(crop);
        return investmentRepository.save(investment);
    }

    public List<Investment> getAll() {
        return investmentRepository.findAll();
    }

    private double value(Double amount) {
        return amount == null ? 0.0 : amount;
    }
}
