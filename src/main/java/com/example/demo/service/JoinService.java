package com.example.demo.service;

import com.example.demo.dto.JoinDTO;
import com.example.demo.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {
    @Autowired
    private JoinRepository joinRepository;

    public List<JoinDTO> leftJoinData() {
        return joinRepository.fetchDataLeftJoin();
    }

    public List<JoinDTO> rightJoinData() {
        return joinRepository.fetchDataRightJoin();
    }

    public List<JoinDTO> innerJoinData() {
        return joinRepository.fetchDataInnerJoin();
    }

    public List<JoinDTO> crossJoinData() {
        return joinRepository.fetchDataCrossJoin();
    }
}
