package com.gscrud.gscrudJDBC.Facade;

import com.gscrud.gscrudJDBC.DAO.CustomerDAO;
import com.gscrud.gscrudJDBC.DTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerFacade {
    @Autowired
    private CustomerDAO customerDAO;

    public List<CustomerDTO> getCustomers() {
        return customerDAO.getCustomerDetails();
    }

    public Object getCustomerById(Long id) {
        return customerDAO.getCustomerById(id);
    }
}
