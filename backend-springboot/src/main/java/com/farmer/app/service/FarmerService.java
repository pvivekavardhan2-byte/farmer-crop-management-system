package com.farmer.app.service;

import com.farmer.app.entity.Farmer;
import com.farmer.app.exception.ResourceNotFoundException;
import com.farmer.app.repository.FarmerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer save(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAll() {
        return farmerRepository.findAll();
    }

    public Farmer getById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + id));
    }

    public Farmer update(Long id, Farmer farmer) {
        Farmer existing = getById(id);
        existing.setFarmerName(farmer.getFarmerName());
        existing.setMobileNumber(farmer.getMobileNumber());
        existing.setVillage(farmer.getVillage());
        existing.setDistrict(farmer.getDistrict());
        existing.setState(farmer.getState());
        existing.setLandSize(farmer.getLandSize());
        return farmerRepository.save(existing);
    }

    public void delete(Long id) {
        Farmer farmer = getById(id);
        farmerRepository.delete(farmer);
    }
}
