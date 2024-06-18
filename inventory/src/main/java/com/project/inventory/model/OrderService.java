package com.project.inventory.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public void saveOrder(Order order) {
        repository.save(order);
    }


    public Optional<Order> getByID(int orderID) {
        return repository.findById(orderID);
    }

    public List<Order> findAll(){
        return repository.findAll();
    }


    public Order findByitemid(int id) {
        return repository.findByItemId(id);
    }


}
