package com.gscrud.gscrudJDBC.Facade;

import com.gscrud.gscrudJDBC.DAO.StudentDAO;
import com.gscrud.gscrudJDBC.DTO.StudentCourseInfo;
import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import com.gscrud.gscrudJDBC.Model.StudentListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentFacade {
    @Autowired
    private StudentDAO studentDAO;

    public Object Init() {
        return "";
    }

    public StudentListResponse getAllStudents() {
        var students = studentDAO.getAllStudents();

        var studentsHavingPermission = students.stream().filter(res -> res.getIsapproved().equals("1")).count();

        var studentsNotHavingPermission = students.stream().filter(res -> res.getIsapproved().equals("0")).count();

        var groupByYear = students.stream().collect(Collectors.groupingBy(StudentDTO::getRegyear));

        var yearData = groupByYear.entrySet().stream().sorted(Map.Entry.<String, List<StudentDTO>>comparingByKey().reversed()).map(entry -> {
            Map<String, Object> yearCount = new HashMap<>();
            yearCount.put("Year", entry.getKey());
            yearCount.put("Count", entry.getValue().size());
            return yearCount;
        }).collect(Collectors.toList());

        StudentListResponse response = new StudentListResponse();

        response.setStudents(students);
        response.setCount(students.size());
        response.setStudentsHavingAccessCount(studentsHavingPermission);
        response.setStudentsNotHavingAccessCount(studentsNotHavingPermission);
        response.setJoinedByYearData(yearData);
        return response;
    };

    public List<StudentCourseInfo> getStudentsWithCourseInfo() {
        var students =  studentDAO.getStudentWithCourseInfo();

        return students;
    }

    public Object getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
