package com.gscrud.gscrudJDBC.DTO;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long USER_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private Long Mobile;
    private String EMAIL;
}
