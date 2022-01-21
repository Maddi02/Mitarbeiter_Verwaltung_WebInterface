package com.java2s.common.Anwedungslogik;




import Entitätsklassen.SacharbeiterverwaltungEK;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hilfsfunktionen {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public boolean checkIfUserExists(String user)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM SacharbeiterverwaltungEK  e WHERE e.username = :employeeName ");
        query.setParameter("employeeName" , user);
        List<SacharbeiterverwaltungEK> result = query.getResultList();
        System.out.println(result.size());
        if(result.size() == 1)
        {
            System.out.println("User found");
            return false;
        }
        else{
            System.out.println("User not found");
            return true;
        }
    }

    public int countRows()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM SacharbeiterverwaltungEK e ");
        List<SacharbeiterverwaltungEK> result = query.getResultList();
        System.out.println(result.size());
        entityManager.close();
        return result.size();
    }

    public boolean isContainExactWord(String fullString, String partWord)
    {
        String pattern = "\\b"+partWord+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(fullString);
        return m.find();
    }

    public int getMaxPublicKey()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT MAX(e.pk) FROM SacharbeiterverwaltungEK e ");
        List<Integer> result = query.getResultList();
        int max = result.get(0);
        return max;
    }

    }

