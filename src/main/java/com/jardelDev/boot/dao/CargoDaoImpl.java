package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {


    @Override
    public void delete(Cargo cargo) {

    }
}
