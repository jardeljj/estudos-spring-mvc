package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    public List<Funcionario> findByNome(String nome) {

        return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
    }

    @Override
    public List<Funcionario> findByCargo(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }
}
