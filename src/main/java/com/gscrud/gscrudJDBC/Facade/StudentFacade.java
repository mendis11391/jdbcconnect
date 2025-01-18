package com.gscrud.gscrudJDBC.Facade;

import com.gscrud.gscrudJDBC.DAO.StudentDAO;
import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFacade {
    @Autowired
    private StudentDAO studentDAO;

    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Object getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
