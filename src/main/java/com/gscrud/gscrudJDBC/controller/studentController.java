package com.gscrud.gscrudJDBC.controller;

import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import com.gscrud.gscrudJDBC.Facade.StudentFacade;
import com.gscrud.gscrudJDBC.Model.StudentListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private StudentFacade studentFacade;

    @GetMapping
    public ResponseEntity<StudentListResponse> getAllStudents() {
        return ResponseEntity.ok(studentFacade.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentFacade.getStudentById(id));
    }
}
