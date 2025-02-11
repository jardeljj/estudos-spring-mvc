package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoDao {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Departamento departamento);

    Departamento findById(Long id);

    List<Departamento> findAll();


}
