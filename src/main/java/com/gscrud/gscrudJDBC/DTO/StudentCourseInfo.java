package com.gscrud.gscrudJDBC.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseInfo {
    private int id;
    private int isapproved;
    private String username;
    private String email;
    private Long regYear;
    private Long phonenum;
    private String gender;
    private String[] courses;
}
