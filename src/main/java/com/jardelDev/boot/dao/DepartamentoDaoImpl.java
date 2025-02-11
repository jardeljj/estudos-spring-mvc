package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {


    @Override
    public void delete(Departamento departamento) {

    }


}
