package com.java2s.common.Anwedungslogik;

import Entitätsklassen.FortbildungensachbearbeiterEK;
import Entitätsklassen.FortbildungvorraussetzungEK;
import Entitätsklassen.SacharbeiterverwaltungEK;

import javax.persistence.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InitializiseJComboBox {
     LinkedList<String> allUser = new LinkedList<String>();
     LinkedList<String> allFortbildungen = new LinkedList<String>();
     LinkedList<String> allFortbildungenByUser = new LinkedList<String>();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public InitializiseJComboBox() {
    }
    public List setComboBoxUser()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM SacharbeiterverwaltungEK e");
        List<SacharbeiterverwaltungEK> result = query.getResultList();
        List<String> allUser = new ArrayList<>();
        for(int i = 0 ; i < result.size(); i++)
        {
            allUser.add(result.get(i).getUsername());
            System.out.println(result.get(i).getUsername());
        }
        return allUser;
    }
    public  List setComboBoxVorbildungen() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM FortbildungvorraussetzungEK e");
        List<FortbildungvorraussetzungEK> result = query.getResultList();
        List<String> allFortbildungen = new ArrayList<>();
        for(int i = 0 ; i < result.size(); i++)
        {
            allFortbildungen.add(result.get(i).getFortbildung());
            System.out.println(result.get(i).getFortbildung());
        }
        return allFortbildungen;
    }
    public String getAllFortbildungenForUserAsString(String user)
    {
        GetAllFortbildungForUser getAllFortbildungForUser = new GetAllFortbildungForUser();
        FortbildungensachbearbeiterEK fortbildungensachbearbeiterEK = getAllFortbildungForUser.getAllFortbildungenFortUser(user);
        String allFortbildungenForUser =  fortbildungensachbearbeiterEK.getFortbildung1()+ " " + fortbildungensachbearbeiterEK.getFortbildung2() + " " +  fortbildungensachbearbeiterEK.getFortbildung3() +  " " + fortbildungensachbearbeiterEK.getFortbildung4();
        return allFortbildungenForUser;
    }


}
