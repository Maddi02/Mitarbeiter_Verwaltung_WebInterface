package com.java2s.common.ExterneSchnittstelle;

import com.java2s.common.Anwedungslogik.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "FortbilungZuordnungLöschenBean")
@ApplicationScoped
public class FortbilungZuordnungLöschenBean {
    private String ausgewählteFortbildung;
    private String ausgewählterNutzer;

    public String getAusgewählteFortbildung() {
        return ausgewählteFortbildung;
    }

    public void setAusgewählteFortbildung(String ausgewählteFortbildung) {
        this.ausgewählteFortbildung = ausgewählteFortbildung;
    }

    public String getAusgewählterNutzer() {
        return ausgewählterNutzer;
    }

    public void setAusgewählterNutzer(String ausgewählterNutzer) {
        this.ausgewählterNutzer = ausgewählterNutzer;
    }

    public void deleteFortbildungReletedToUser()
    {
        System.out.println(ausgewählteFortbildung);
        ErrorSucessMessages errorSucessMessages = new ErrorSucessMessages();

        SachbearbeiterSachbearbeiterFortbildungLöschenK sachbearbeiterSachbearbeiterFortbildungLöschenK = new SachbearbeiterSachbearbeiterFortbildungLöschenK();
        if(sachbearbeiterSachbearbeiterFortbildungLöschenK.deleteFortbildung(ausgewählterNutzer)) {
            FacesContext fc = FacesContext.getCurrentInstance();
            System.out.println((!(ausgewählteFortbildung.equals("Kostenrechnung"))));
            if (!(ausgewählteFortbildung.equals("Kostenrechnung"))) {
                fc.addMessage("loginError", errorSucessMessages.getMsgFortbildung());
            }

            if (ausgewählteFortbildung.equals("Kostenrechnung")) {
                if (LoginK.getRole().equals("Admin")) {
                    try {
                        fc.getExternalContext().redirect("http://localhost:8080/AdminAS.xhtml");
                    } catch (IOException e) {
                        System.out.println("Fuck");
                        e.printStackTrace();
                    }
                    fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());
                }

                if (LoginK.getRole().equals("Sachbearbeiter")) {
                    try {
                        fc.getExternalContext().redirect("http://localhost:8080/Sachbearbeiter.xhtml");
                    } catch (IOException e) {
                        System.out.println("Fuck");
                        e.printStackTrace();
                    }
                    fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());
                }
            }
        }
        else{
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("loginError", errorSucessMessages.getErrorMessage());
    }
    }


    public  String getDoneFortbildung() {
        InitializiseJComboBox initializiseJComboBox = new InitializiseJComboBox();
        return  initializiseJComboBox.getAllFortbildungenForUserAsString(ausgewählterNutzer);
    }

}
