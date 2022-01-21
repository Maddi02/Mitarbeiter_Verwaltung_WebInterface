package com.java2s.common.Anwedungslogik;
import Entitätsklassen.FortbildungensachbearbeiterEK;
import Entitätsklassen.SacharbeiterverwaltungEK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ErstellungSacharbeiterK {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    Hilfsfunktionen hilfsfunktionen = new Hilfsfunktionen();

    public boolean createUser(String username, String password, String role) {
        try {
            int primaryKey =  hilfsfunktionen.getMaxPublicKey();
            transaction.begin();
            SacharbeiterverwaltungEK sacharbeiterverwaltungEK = new SacharbeiterverwaltungEK();
            FortbildungensachbearbeiterEK fortbildungensachbearbeiterEK = new FortbildungensachbearbeiterEK();
            fortbildungensachbearbeiterEK.setUsername(username);
            fortbildungensachbearbeiterEK.setPk( primaryKey + 1);
            sacharbeiterverwaltungEK.setUsername(username);
            sacharbeiterverwaltungEK.setPasswort(password);
            sacharbeiterverwaltungEK.setRole(role);
            sacharbeiterverwaltungEK.setPk(primaryKey +1 );
            entityManager.persist(sacharbeiterverwaltungEK);
            entityManager.persist(fortbildungensachbearbeiterEK);
            transaction.commit();

        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return true;
    }

}
