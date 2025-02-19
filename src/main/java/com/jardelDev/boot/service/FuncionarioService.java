package com.jardelDev.boot.service;

import com.jardelDev.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();


    List<Funcionario> buscarPorNome(String nome);
}
