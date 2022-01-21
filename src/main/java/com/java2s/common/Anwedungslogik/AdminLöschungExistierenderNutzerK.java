package com.java2s.common.Anwedungslogik;

import javax.persistence.*;

public class AdminLöschungExistierenderNutzerK {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public boolean deleteUser(String username) {
        Hilfsfunktionen hilfsfunktionen = new Hilfsfunktionen();

        if(!hilfsfunktionen.checkIfUserExists(username)) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM SacharbeiterverwaltungEK e WHERE e.username = :employeeName ");
            Query query1 = entityManager.createQuery("DELETE FROM FortbildungensachbearbeiterEK e WHERE e.username = :employeeName ");
            query.setParameter("employeeName", username);
            query1.setParameter("employeeName", username);
            query.executeUpdate();
            query1.executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }
}

