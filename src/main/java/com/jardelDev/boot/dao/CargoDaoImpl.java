package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Cargo;
import com.jardelDev.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {


    public PaginacaoUtil<Cargo> buscaPaginada(int pagina){
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        Long totalRegistros = count();
        Long totalDePaginas = (totalRegistros + (tamanho - 1 )) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, cargos);
    }

    public Long count(){

        return getEntityManager()
                .createQuery("select count(*) from Cargo", Long.class)
                .getSingleResult();
    }

}
