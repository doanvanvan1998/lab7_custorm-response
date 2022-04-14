package com.example.demo.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService <T>{
    public boolean save(T model);
    public void delete(Long modelId);
    public List<T> findAll();
    public Optional<T>findById(Long id);
    public Page<T>findAllByCondition(String filter, Pageable pageable);

}
