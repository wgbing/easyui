package com.jykj.easyui.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao {

    @PersistenceContext(name = "entityManager")
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}