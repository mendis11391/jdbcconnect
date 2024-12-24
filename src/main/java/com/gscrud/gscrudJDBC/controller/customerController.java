package com.gscrud.gscrudJDBC.controller;

import com.gscrud.gscrudJDBC.DTO.CustomerDTO;
import com.gscrud.gscrudJDBC.Facade.CustomerFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {
    private final CustomerFacade customerFacade;

    public customerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllUsers() {
        return ResponseEntity.ok(customerFacade.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerFacade.getCustomerById(id));
    }
}
