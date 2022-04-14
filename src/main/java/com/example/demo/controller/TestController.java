package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.modal.StudentModal;
import com.example.demo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class TestController {
    @Autowired
    IStudentService iStudentService;
    @GetMapping("/{id}")
    public @ResponseBody
    StudentDTO studentDTO(@PathVariable Long id){
        Optional<StudentModal> studentModal = iStudentService.findById(id);
        StudentDTO studentDTO = new StudentDTO();
           studentDTO.setId(studentModal.get().getId());
           studentDTO.setName(studentModal.get().getName());
           studentDTO.setAddress(studentModal.get().getAddress());
        return studentDTO ;
    }
}
