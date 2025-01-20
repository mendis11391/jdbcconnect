package com.gscrud.gscrudJDBC.DAO;

import com.gscrud.gscrudJDBC.DTO.CustomerDTO;
import com.gscrud.gscrudJDBC.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<StudentDTO> getAllStudents() {
        String sql = "select id, isapproved, username, email, regyear, phonenum, gender from users";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                StudentDTO student = new StudentDTO();
                student.setId(rs.getInt("id"));
                student.setIsapproved(rs.getString("isapproved"));
                student.setUsername(rs.getString("username"));
                student.setEmail(rs.getString("email"));
                student.setRegyear(rs.getString("regyear"));
                student.setPhonenum(rs.getLong("phonenum"));
                student.setGender(rs.getString("gender"));
                return student;
            });
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public Object getStudentById(int id) {
        String sql = "select id, isapproved, username, email, regyear, phonenum, gender from users where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                StudentDTO student = new StudentDTO();
                student.setId(rs.getInt("id"));
                student.setIsapproved(rs.getString("isapproved"));
                student.setUsername(rs.getString("username"));
                student.setEmail(rs.getString("email"));
                student.setRegyear(rs.getString("regyear"));
                student.setPhonenum(rs.getLong("phonenum"));
                student.setGender(rs.getString("gender"));
                return student;
            });
        } catch (EmptyResultDataAccessException e) {
            return "No results found";
        }
    }

}
