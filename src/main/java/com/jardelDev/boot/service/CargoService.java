package com.jardelDev.boot.service;

import com.jardelDev.boot.domain.Cargo;
import com.jardelDev.boot.util.PaginacaoUtil;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);

    void editar(Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemfuncionarios(Long id);

    PaginacaoUtil<Cargo> buscaPorPagina(int pagina, String direcao);
}
