package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Cargo;
import com.jardelDev.boot.util.PaginacaoUtil;

import java.util.List;

public interface CargoDao {

    void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

    PaginacaoUtil<Cargo> buscaPaginada(int pagina);

}
