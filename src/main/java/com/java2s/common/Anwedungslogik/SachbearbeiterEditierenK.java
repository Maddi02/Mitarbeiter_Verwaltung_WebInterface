package com.java2s.common.Anwedungslogik;


import Entitätsklassen.SacharbeiterverwaltungEK;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class SachbearbeiterEditierenK {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public SachbearbeiterEditierenK() {

    }

    public boolean UpdateSacharbeiter(String newUsername, String newPasswort, String newRole, String oldUsername) {
        Hilfsfunktionen hilfsfunktionen = new Hilfsfunktionen();
        if (!hilfsfunktionen.checkIfUserExists(oldUsername)) {
            entityManager.getTransaction().begin();
            //   getSachbearbeiter(oldUsername);
            Query query = entityManager.createQuery("UPDATE SacharbeiterverwaltungEK e SET e.username = :employeeName, e.passwort = :password , e.role = :role WHERE e.username = :employeeOldName");
            Query query1 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.username = :employeeName WHERE e.username = :employeeOldName");


            query.setParameter("employeeOldName", oldUsername);
            query.setParameter("employeeName", newUsername);
            query.setParameter("password", newPasswort);
            query.setParameter("role", newRole);
            query1.setParameter("employeeOldName", oldUsername);
            query1.setParameter("employeeName", newUsername);
            int a = query.executeUpdate();
            int b = query1.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    private List<SacharbeiterverwaltungEK> getSachbearbeiter(String  user)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM SacharbeiterverwaltungEK  e WHERE e.username = :employeeName ");
        query.setParameter("employeeName" , user);
        List<SacharbeiterverwaltungEK> result = query.getResultList();
        return result;
    }



    public String getRoleBeforeChange(String user)
    {
        return getSachbearbeiter(user).get(0).getRole();

    }
}