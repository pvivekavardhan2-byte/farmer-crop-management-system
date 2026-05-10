package com.farmer.app.config;

import com.farmer.app.entity.Crop;
import com.farmer.app.entity.Farmer;
import com.farmer.app.entity.Investment;
import com.farmer.app.repository.CropRepository;
import com.farmer.app.repository.FarmerRepository;
import com.farmer.app.repository.InvestmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final FarmerRepository farmerRepository;
    private final CropRepository cropRepository;
    private final InvestmentRepository investmentRepository;

    public DataLoader(FarmerRepository farmerRepository,
                      CropRepository cropRepository,
                      InvestmentRepository investmentRepository) {
        this.farmerRepository = farmerRepository;
        this.cropRepository = cropRepository;
        this.investmentRepository = investmentRepository;
    }

    @Override
    public void run(String... args) {

        List<Farmer> farmers = List.of(

                new Farmer(null, "Ramesh", "9876543210", "Bellary", "Bellary", "Karnataka", 5.5),
                new Farmer(null, "Suresh", "9876543211", "Hospet", "Vijayanagara", "Karnataka", 3.0),
                new Farmer(null, "Mahesh", "9876543212", "Raichur", "Raichur", "Karnataka", 7.0),
                new Farmer(null, "Rajesh", "9876543213", "Anantapur", "Anantapur", "Andhra Pradesh", 4.5),
                new Farmer(null, "Naresh", "9876543214", "Kurnool", "Kurnool", "Andhra Pradesh", 6.0),
                new Farmer(null, "Ganesh", "9876543215", "Tumkur", "Tumkur", "Karnataka", 2.5),
                new Farmer(null, "Lokesh", "9876543216", "Mysore", "Mysore", "Karnataka", 8.0),
                new Farmer(null, "Harish", "9876543217", "Chitradurga", "Chitradurga", "Karnataka", 5.0),
                new Farmer(null, "Kiran", "9876543218", "Davangere", "Davangere", "Karnataka", 4.0),
                new Farmer(null, "Manoj", "9876543219", "Guntur", "Guntur", "Andhra Pradesh", 6.5)

        );

        List<Farmer> savedFarmers = farmerRepository.saveAll(farmers);

        int count = 1;

        for (Farmer farmer : savedFarmers) {

            Crop crop = new Crop(
                    null,
                    "Paddy-" + count,
                    "Kharif",
                    "Hybrid",
                    farmer.getLandSize(),
                    LocalDate.of(2026, 6, 1),
                    LocalDate.of(2026, 10, 1),
                    20.0 + count,
                    farmer
            );

            Crop savedCrop = cropRepository.save(crop);

            double seedCost = 5000 + (count * 500);
            double fertilizerCost = 10000 + (count * 700);
            double pesticideCost = 3000 + (count * 200);
            double labourCost = 12000 + (count * 500);
            double waterCost = 2000 + (count * 100);
            double transportCost = 1500 + (count * 100);
            double machineryCost = 5000 + (count * 300);
            double otherCost = 1000 + (count * 50);

            double totalInvestment =
                    seedCost +
                            fertilizerCost +
                            pesticideCost +
                            labourCost +
                            waterCost +
                            transportCost +
                            machineryCost +
                            otherCost;

            Investment investment = new Investment(
                    null,
                    seedCost,
                    fertilizerCost,
                    pesticideCost,
                    labourCost,
                    waterCost,
                    transportCost,
                    machineryCost,
                    otherCost,
                    totalInvestment,
                    savedCrop
            );

            investmentRepository.save(investment);

            count++;
        }

        System.out.println("10 Farmers, Crops and Investments inserted successfully...");
    }
}