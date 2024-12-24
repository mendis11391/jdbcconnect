package com.gscrud.gscrudJDBC.DAO;

import com.gscrud.gscrudJDBC.DTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CustomerDTO> getCustomerDetails() {
        String sql = "select USER_ID, FIRST_NAME, LAST_NAME, MOBILE, EMAIL from NRM_CUSTOMER_DETAILS";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setUSER_ID(rs.getLong("USER_ID"));
                customer.setFIRST_NAME(rs.getString("FIRST_NAME"));
                customer.setLAST_NAME(rs.getString("LAST_NAME"));
                customer.setMobile(rs.getLong("Mobile"));
                customer.setEMAIL(rs.getString("EMAIL"));
                return customer;
            });
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public Object getCustomerById(Long id) {
        String sql = "select USER_ID, FIRST_NAME, LAST_NAME, MOBILE, EMAIL from NRM_CUSTOMER_DETAILS where user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id},(rs, rowNum) -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setUSER_ID(rs.getLong("USER_ID"));
                customer.setFIRST_NAME(rs.getString("FIRST_NAME"));
                customer.setLAST_NAME(rs.getString("LAST_NAME"));
                customer.setMobile(rs.getLong("Mobile"));
                customer.setEMAIL(rs.getString("EMAIL"));
                return customer;
            });
        } catch (EmptyResultDataAccessException e) {
            return "No results found";
        }
    }
}
