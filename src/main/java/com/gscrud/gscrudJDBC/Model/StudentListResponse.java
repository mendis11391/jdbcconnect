package com.gscrud.gscrudJDBC.Model;

import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentListResponse {
    private Integer count;
    private Long studentsHavingAccessCount;
    private Long studentsNotHavingAccessCount;
    private List<StudentDTO> students;
}
