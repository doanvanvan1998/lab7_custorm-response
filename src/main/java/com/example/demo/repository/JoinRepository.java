package com.example.demo.repository;

import com.example.demo.dto.JoinDTO;
import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinRepository extends JpaRepository<Company, Long> {
    @Query("SELECT new com.example.demo.dto.JoinDTO(s.id, f.name, c.name, s.amount) "
            + "FROM Sale s LEFT JOIN s.food f LEFT JOIN f.company c")
    List<JoinDTO> fetchDataLeftJoin();

    @Query("SELECT new com.example.demo.dto.JoinDTO(s.id, f.name, c.name, s.amount) "
            + "FROM Sale s RIGHT JOIN s.food f RIGHT JOIN f.company c")
    List<JoinDTO> fetchDataRightJoin();

    @Query("SELECT new com.example.demo.dto.JoinDTO(s.id, f.name, c.name, s.amount) "
            + "FROM Sale s INNER JOIN s.food f INNER JOIN f.company c")
    List<JoinDTO> fetchDataInnerJoin();

    @Query("SELECT new com.example.demo.dto.JoinDTO(s.id, f.name, c.name, s.amount) "
            + "FROM Sale s, Food f, Company c WHERE s.food.id = f.id AND f.company.id = c.id")
    List<JoinDTO> fetchDataCrossJoin();
}
