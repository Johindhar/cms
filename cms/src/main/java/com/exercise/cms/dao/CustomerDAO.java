package com.exercise.cms.dao;

import com.exercise.cms.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();


}
