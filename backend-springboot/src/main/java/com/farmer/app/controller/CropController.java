package com.farmer.app.controller;

import com.farmer.app.entity.Crop;
import com.farmer.app.service.CropService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping("/farmer/{farmerId}")
    public Crop save(@PathVariable Long farmerId, @Valid @RequestBody Crop crop) {
        return cropService.save(farmerId, crop);
    }

    @GetMapping
    public List<Crop> getAll() {
        return cropService.getAll();
    }

    @GetMapping("/{id}")
    public Crop getById(@PathVariable Long id) {
        return cropService.getById(id);
    }

    @PutMapping("/{id}")
    public Crop update(@PathVariable Long id, @Valid @RequestBody Crop crop) {
        return cropService.update(id, crop);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        cropService.delete(id);
        return "Crop deleted successfully";
    }
}
