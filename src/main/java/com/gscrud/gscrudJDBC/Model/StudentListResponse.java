package com.gscrud.gscrudJDBC.Model;

import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StudentListResponse {
    private Integer count;
    private Long studentsHavingAccessCount;
    private Long studentsNotHavingAccessCount;
    private List<StudentDTO> students;
    private List <Map<String, Object>> joinedByYearData;
}
