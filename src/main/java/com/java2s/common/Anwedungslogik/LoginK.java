package com.java2s.common.Anwedungslogik;

import Entitätsklassen.SacharbeiterverwaltungEK;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class LoginK {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    private static String Role;
    public boolean isValidConnection(String Benutzername, String password) {

       EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM SacharbeiterverwaltungEK  e WHERE e.username = :employeeName ");
        query.setParameter("employeeName" , Benutzername);
        List<SacharbeiterverwaltungEK> result = query.getResultList();


        if(result.size() == 0)
        {
            System.out.println("User not found");
            return false;
        }

        if(result.get(0).getPasswort().equals(password) && result.get(0).getUsername().equals(Benutzername))
        {
            Role = result.get(0).getRole();
            return true;
        }
        else {
            return false;
        }

    }

    public static String getRole()
    {
        return Role;
    }

}

