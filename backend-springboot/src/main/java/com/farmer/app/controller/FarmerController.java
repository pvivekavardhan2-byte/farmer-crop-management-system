package com.farmer.app.controller;

import com.farmer.app.entity.Farmer;
import com.farmer.app.service.FarmerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public Farmer save(@Valid @RequestBody Farmer farmer) {
        return farmerService.save(farmer);
    }

    @GetMapping
    public List<Farmer> getAll() {
        return farmerService.getAll();
    }

    @GetMapping("/{id}")
    public Farmer getById(@PathVariable Long id) {
        return farmerService.getById(id);
    }

    @PutMapping("/{id}")
    public Farmer update(@PathVariable Long id, @Valid @RequestBody Farmer farmer) {
        return farmerService.update(id, farmer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        farmerService.delete(id);
        return "Farmer deleted successfully";
    }
}
