package com.shopping.services.Impl;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Manufacturer;
import com.shopping.repository.ManufacturerRepository;
import com.shopping.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer getManufacturerById(Long mId) {
        return this.manufacturerRepository.findById(mId).get();
    }

    @Override
    public Set<Manufacturer> getManufacturers() {
        return new HashSet<>(this.manufacturerRepository.findAll());
    }

    @Override
    public void deleteManufacturerById(Long mId) {
        this.manufacturerRepository.deleteById(mId);
    }

    @Override
    public List<Manufacturer> getManufacturerOfCategory(Category category) {
        return this.manufacturerRepository.findByCategory(category);
    }
}
