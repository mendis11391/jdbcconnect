package com.gscrud.gscrudJDBC.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private Integer id;
    private String isapproved;
    private String username;
    private String email;
    private String regyear;
    private Long phonenum;
    private String gender;
}
