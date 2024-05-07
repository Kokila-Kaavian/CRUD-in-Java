package com.dbconnection.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CheckField {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void alterTable(){
        System.out.println("is enter?");
        String tableName = "EMPLOYEE_TBL";
        String fieldName = "Salary";
        String fieldType = "INTEGER";
        String alterQuery = String.format("ALTER TABLE "+ tableName +" ADD "+ "("+fieldName +" "+ fieldType+")");

        entityManager.createNativeQuery(alterQuery).executeUpdate();
    }

}
