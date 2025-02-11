package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
    @Override
    public void delete(Funcionario funcionario) {

    }
}
