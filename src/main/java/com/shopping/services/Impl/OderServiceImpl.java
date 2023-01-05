package com.shopping.services.Impl;

import com.shopping.entity.User;
import com.shopping.entity.shopping.Oder;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.OderRepository;
import com.shopping.services.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OderServiceImpl implements OderService {
    @Autowired
    private OderRepository oderRepository;

    @Override
    public Oder addOder(Oder oder) {
        return this.oderRepository.save(oder);
    }

    @Override
    public Oder updateOder(Oder oder) {
        return this.oderRepository.save(oder);
    }

    @Override
    public Oder getOderById(Long oId) {
        return this.oderRepository.findById(oId).get();
    }

    @Override
    public Set<Oder> getOder() {
        return new HashSet<>(this.oderRepository.findAll());
    }

    @Override
    public void deleteOder(Long oId) {
        this.oderRepository.deleteById(oId);
    }

    @Override
    public List<Oder> getOderOfProduct(Product product) {
        return this.oderRepository.findByProduct(product);
    }

    @Override
    public List<Oder> getOderOfUser(User user) {
        return this.oderRepository.findByUser(user);
    }
}
