package com.gscrud.gscrudJDBC.Facade;

import com.gscrud.gscrudJDBC.DAO.StudentDAO;
import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import com.gscrud.gscrudJDBC.Model.StudentListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFacade {
    @Autowired
    private StudentDAO studentDAO;

    public StudentListResponse getAllStudents() {
        var students = studentDAO.getAllStudents();
        var studentsHavingPermission = students.stream().filter(res -> res.getIsapproved().equals("1")).count();
        var studentsNotHavingPermission = students.stream().filter(res -> res.getIsapproved().equals("0")).count();
        StudentListResponse response = new StudentListResponse();
        response.setStudents(students);
        response.setCount(students.size());
        response.setStudentsHavingAccessCount(studentsHavingPermission);
        response.setStudentsNotHavingAccessCount(studentsNotHavingPermission);
        return response;
    };

    public Object getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
