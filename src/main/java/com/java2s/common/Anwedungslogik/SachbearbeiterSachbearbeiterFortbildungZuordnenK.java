package com.java2s.common.Anwedungslogik;

import Entitätsklassen.FortbildungensachbearbeiterEK;

import javax.persistence.*;

public class SachbearbeiterSachbearbeiterFortbildungZuordnenK {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Hilfsfunktionen hilfsfunktionen = new Hilfsfunktionen();
    GetAllFortbildungForUser getAllFortbildungForUser = new GetAllFortbildungForUser();

    public boolean setFortbildung(String user , String Fortbildung , String Status)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String Mathe1 = "Mathematik 1";
        String Mathe2 = "Mathematik 2";
        String Kostenrechnung = "Kostenrechnung";
        String AllgemeineBetriebswirtschaft = "Allgemeine Betriebswirtschaft";

        Query queryFortbildung1 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.fortbildung1 = :Fortbildung , e.status1 = :Status WHERE e.username = :username");
        Query queryFortbildung2 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.fortbildung2 = :Fortbildung , e.status2 = :Status WHERE e.username = :username");
        Query queryFortbildung3 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.fortbildung3 = :Fortbildung , e.status3 = :Status WHERE e.username = :username");
        Query queryFortbildung4 = entityManager.createQuery("UPDATE FortbildungensachbearbeiterEK e SET e.fortbildung4 = :Fortbildung , e.status4 = :Status WHERE e.username = :username");


        FortbildungensachbearbeiterEK fortbildungensachbearbeiterEK = getAllFortbildungForUser.getAllFortbildungenFortUser(user);
        String allFortbildungenForUser =  fortbildungensachbearbeiterEK.getFortbildung1()+ " " + fortbildungensachbearbeiterEK.getFortbildung2() + " " +  fortbildungensachbearbeiterEK.getFortbildung3() +  " " + fortbildungensachbearbeiterEK.getFortbildung4();
        System.out.println(allFortbildungenForUser);
        System.out.println(Fortbildung);

        if(Fortbildung.equals(Mathe1))
        {
            entityManager.getTransaction().begin();
            queryFortbildung1.setParameter("Fortbildung" , Fortbildung);
            queryFortbildung1.setParameter("Status" , Status);
            queryFortbildung1.setParameter("username" , user);
            int a =  queryFortbildung1.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }

        if(Fortbildung.equals(Mathe2) && hilfsfunktionen.isContainExactWord(allFortbildungenForUser,Mathe1))
        {
            entityManager.getTransaction().begin();
            queryFortbildung2.setParameter("Fortbildung" , Fortbildung);
            queryFortbildung2.setParameter("Status" , Status);
            queryFortbildung2.setParameter("username" , user);
            int a =  queryFortbildung2.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }

        if(Fortbildung.equals(Kostenrechnung) && hilfsfunktionen.isContainExactWord(allFortbildungenForUser,Mathe2) && hilfsfunktionen.isContainExactWord(allFortbildungenForUser,AllgemeineBetriebswirtschaft)) {
            entityManager.getTransaction().begin();
            queryFortbildung3.setParameter("Fortbildung" , Fortbildung);
            queryFortbildung3.setParameter("Status" , Status);
            queryFortbildung3.setParameter("username" , user);
            int a =  queryFortbildung3.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }

        if(Fortbildung.equals(AllgemeineBetriebswirtschaft))
        {
            entityManager.getTransaction().begin();
            queryFortbildung4.setParameter("Fortbildung" , Fortbildung);
            queryFortbildung4.setParameter("Status" , Status);
            queryFortbildung4.setParameter("username" , user);
            int a =  queryFortbildung4.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }

        return false;
    }
}
