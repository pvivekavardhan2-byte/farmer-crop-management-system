package com.farmer.app.service;

import com.farmer.app.entity.Crop;
import com.farmer.app.entity.Farmer;
import com.farmer.app.exception.ResourceNotFoundException;
import com.farmer.app.repository.CropRepository;
import com.farmer.app.repository.FarmerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CropService {

    private final CropRepository cropRepository;
    private final FarmerRepository farmerRepository;

    public CropService(CropRepository cropRepository, FarmerRepository farmerRepository) {
        this.cropRepository = cropRepository;
        this.farmerRepository = farmerRepository;
    }

    public Crop save(Long farmerId, Crop crop) {
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + farmerId));
        crop.setFarmer(farmer);
        return cropRepository.save(crop);
    }

    public List<Crop> getAll() {
        return cropRepository.findAll();
    }

    public Crop getById(Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found with id: " + id));
    }

    public Crop update(Long id, Crop crop) {
        Crop existing = getById(id);
        existing.setCropName(crop.getCropName());
        existing.setSeason(crop.getSeason());
        existing.setSeedType(crop.getSeedType());
        existing.setLandArea(crop.getLandArea());
        existing.setSowingDate(crop.getSowingDate());
        existing.setExpectedHarvestDate(crop.getExpectedHarvestDate());
        existing.setExpectedYield(crop.getExpectedYield());
        return cropRepository.save(existing);
    }

    public void delete(Long id) {
        cropRepository.delete(getById(id));
    }
}
