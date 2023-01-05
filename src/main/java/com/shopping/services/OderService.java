package com.shopping.services;

import com.shopping.entity.User;
import com.shopping.entity.shopping.Oder;
import com.shopping.entity.shopping.Product;

import java.util.List;
import java.util.Set;

public interface OderService {

    public Oder addOder(Oder oder);

    public Oder updateOder(Oder oder);

    public Oder getOderById(Long oId);

    public Set<Oder> getOder();

    public void deleteOder(Long oId);

    public List<Oder> getOderOfProduct(Product product);

    public List<Oder> getOderOfUser(User user);
}
