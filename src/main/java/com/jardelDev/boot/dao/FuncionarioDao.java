package com.jardelDev.boot.dao;



import com.jardelDev.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();


    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargo(Long id);
}
