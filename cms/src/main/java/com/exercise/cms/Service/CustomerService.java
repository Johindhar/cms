package com.exercise.cms.Service;

import com.exercise.cms.Model.Customer;
import com.exercise.cms.dao.CustomerDAO;
import com.exercise.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){

     /*   customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer; */

        return customerDAO.save(customer);

    }

    public List<Customer> getCustomers(){

        return customerDAO.findAll();
        //return customerList;
    }

    public  Customer getCustomer(int customerId){

//        return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record not available...");

        return optionalCustomer.get();

    }

    public Customer updateCustomer(int customerId, Customer customer){

//        customerList.stream().forEach(c -> {
//            if(c.getCustomerId() == customerId){
//                c.setCustomerFirstname(customer.getCustomerFirstname());
//                c.setCustomerLastname(customer.getCustomerLastname());
//                c.setCustomerEmail(customer.getCustomerEmail());
//            }
//        });
//
//        return getCustomer(customerId);

        customer.setCustomerId(customerId);
        return customerDAO.save(customer);

    }

    public void deleteCustomer(int customerId){

//        customerList.stream().forEach(c -> {
//                if(c.getCustomerId() == customerId)
//                {
//                    customerList.remove(c);
//                }
//        });

        customerDAO.deleteById(customerId);

    }


}
