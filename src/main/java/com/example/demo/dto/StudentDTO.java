package com.example.demo.dto;

import com.example.demo.modal.StudentModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    public Long id;
    public String name;
    public String address;
    List<Long> sbId;

    public static   StudentDTO toDto(StudentModal modal){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(modal.getId());
        studentDTO.setName(modal.getName());
        studentDTO.setAddress(modal.getAddress());
//        return StudentDTO.builder().id(modal.getId()).name(modal.getName())
//                                    .address(modal.getAddress()).build();
        return studentDTO;
    }

}
