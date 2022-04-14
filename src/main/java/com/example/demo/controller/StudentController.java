package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.modal.StudentModal;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.Response;
import com.example.demo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @PostMapping
    public Response<StudentDTO> save(@RequestBody StudentDTO dto){
        boolean result = this.iStudentService.save(StudentModal.builder()
                                                                .name(dto.getName())
                                                                .address(dto.getAddress()).build());
        return Response.ofSucceeded(dto);
    }
    @GetMapping
    public Response<List<StudentDTO>> findAllStudent(){
        try {
            List<StudentModal> listModal=this.iStudentService.findAll();
            List<StudentDTO> studentDTOS = new ArrayList<>();
            for (StudentModal studentModal:listModal) {
                StudentDTO studentDTO = new StudentDTO().toDto(studentModal);
                studentDTOS.add(studentDTO);
            }
// List<StudentDTO> studentPage = (List<StudentDTO>) this.iStudentService.findAll()
////                    .stream().map(c->StudentDTO.toDto(c));
            return Response.ofSucceeded(studentDTOS);
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return null;
        }



    }

//    @PostMapping()
//    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
//
//
//     studentRepository.save(student);
//
//        return ResponseEntity.status(200).body(student);
//    }
//    @GetMapping(value = "/getAll",produces = "application/json")
//    @ResponseBody
//    public Iterable<Student> getAll(){
//        return  studentRepository.findAll();
//    }



}
