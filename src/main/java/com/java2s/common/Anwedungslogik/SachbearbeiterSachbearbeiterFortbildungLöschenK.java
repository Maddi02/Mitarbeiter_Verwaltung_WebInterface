package com.java2s.common.Anwedungslogik;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SachbearbeiterSachbearbeiterFortbildungLöschenK {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public boolean deleteFortbildung(String user)
    {
        try {
            Query queryFortbildung1 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.fortbildung3 = :Fortbildung , e.status3 = :Status WHERE e.username = :username");
            entityManager.getTransaction().begin();
            queryFortbildung1.setParameter("Fortbildung", null);
            queryFortbildung1.setParameter("Status", null);
            queryFortbildung1.setParameter("username", user);
            queryFortbildung1.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
}
