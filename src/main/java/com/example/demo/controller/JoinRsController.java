package com.example.demo.controller;

import com.example.demo.dto.JoinDTO;
import com.example.demo.repository.JoinRepository;
import com.example.demo.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoinRsController {
    @Autowired
    private JoinService joinService;
    @Autowired
    private JoinRepository joinRepository;


    @GetMapping("/join/left")
    public ResponseEntity<List<JoinDTO>> getLeftJoinData() {
        return new ResponseEntity<List<JoinDTO>>(joinService.leftJoinData(), HttpStatus.OK);
    }

    @GetMapping("/join/right")
    public ResponseEntity<List<JoinDTO>> getRightJoinData() {
        return new ResponseEntity<List<JoinDTO>>(joinService.rightJoinData(), HttpStatus.OK);
    }

    @GetMapping("/join/inner")
    public ResponseEntity<List<JoinDTO>> getLeftInnerData() {
        return new ResponseEntity<List<JoinDTO>>(joinService.innerJoinData(), HttpStatus.OK);
    }

    @GetMapping("/join/cross")
    public ResponseEntity<List<JoinDTO>> getLeftCrossData() {
        return new ResponseEntity<List<JoinDTO>>(joinService.crossJoinData(), HttpStatus.OK);
    }
    @DeleteMapping("join/delele/{id}")
    public String  deleteCompany(@PathVariable("id")Long id){
        joinRepository.deleteById(id);
        return "";
    }


}
