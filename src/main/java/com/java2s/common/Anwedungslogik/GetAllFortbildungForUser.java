package com.java2s.common.Anwedungslogik;

import Entitätsklassen.FortbildungensachbearbeiterEK;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GetAllFortbildungForUser {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public FortbildungensachbearbeiterEK getAllFortbildungenFortUser(String user)
    {
        System.out.println("USer ist hier : " + user);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM FortbildungensachbearbeiterEK  e WHERE e.username = :employeeName ");
        query.setParameter("employeeName" , user);
        List<FortbildungensachbearbeiterEK> result = query.getResultList();
        FortbildungensachbearbeiterEK fortbildungensachbearbeiterEK = new FortbildungensachbearbeiterEK();

        System.out.println("Result size " + result.size());
        if(result.size() == 1) {
            fortbildungensachbearbeiterEK.setFortbildung1(result.get(0).getFortbildung1());
            fortbildungensachbearbeiterEK.setFortbildung2(result.get(0).getFortbildung2());
            fortbildungensachbearbeiterEK.setFortbildung3(result.get(0).getFortbildung3());
            fortbildungensachbearbeiterEK.setFortbildung4(result.get(0).getFortbildung4());
            fortbildungensachbearbeiterEK.setStatus1(result.get(0).getStatus1());
            fortbildungensachbearbeiterEK.setStatus2(result.get(0).getStatus2());
            fortbildungensachbearbeiterEK.setStatus3(result.get(0).getStatus3());
            fortbildungensachbearbeiterEK.setStatus4(result.get(0).getStatus4());
        }


        return fortbildungensachbearbeiterEK;
    }



}
