package com.jardelDev.boot.dao;

import com.jardelDev.boot.domain.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.List;

// T representa a entidade (cargo, funcionario etc...) - PK tipo referente ao tipo de chave primaria como um Long ou Interger
public abstract class AbstractDao<T, PK extends Serializable> {

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass =
            (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {

        entityManager.persist(entity);
    }

    public void update(T entity) {

        entityManager.merge(entity);
    }

    public void delete(PK id) {

        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id) {

        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {

        return entityManager
                .createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params) {
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        return query.getResultList();
    }


}
