package com.example.demo.service.student;

import com.example.demo.entity.Student;
import com.example.demo.modal.StudentModal;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean save(StudentModal model) {
        try {
            this.studentRepository.save(
                    Student.builder()
                            .id(model.getId())
                            .name(model.getName())
                            .address(model.getAddress()).build());
            return true;
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return  false;
        }

    }

    @Override
    public void delete(Long modelId) {
    this.studentRepository.deleteById(modelId);
    }

    @Override
    public List<StudentModal> findAll() {
//        try {
//            List<Student> studentList= this.studentRepository.findAll();
//            List<StudentModal> studentModalList = new ArrayList<>();
//            for (Student student:studentList) {
//                StudentModal studentModal = new StudentModal();
//                studentModal.setId(student.getId());
//                studentModal.setName(student.getName());
//                studentModal.setAddress(student.getAddress());
//                studentModalList.add(studentModal);
//            }
//            return studentModalList;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }


        return this.studentRepository.findAll().stream().map(model->{
            return StudentModal.builder().id(model.getId())
                                .name(model.getName())
                                .address(model.getAddress()).build();
        }).collect(Collectors.toList());

    }

    @Override
    public Optional<StudentModal> findById(Long id) {
        return this.studentRepository.findById(id).map(model->{
            return StudentModal.builder().id(model.getId()
            )                   .name(model.getName())
                                .address(model.getAddress()).build();
        });
    }

    @Override
    public Page<StudentModal> findAllByCondition(String filter, Pageable pageable) {
        return null;
    }
}
