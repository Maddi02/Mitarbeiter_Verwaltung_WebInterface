package com.java2s.common.ExterneSchnittstelle;
import com.java2s.common.Anwedungslogik.GetAllFortbildungForUser;
import com.java2s.common.Anwedungslogik.InitializiseJComboBox;
import com.java2s.common.Anwedungslogik.LoginK;
import com.java2s.common.Anwedungslogik.SachbearbeiterSachbearbeiterFortbildungZuordnenK;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "FortbilungZuordnenBean")
@ApplicationScoped
public class FortbilungZuordnenBean implements Serializable {
    private String ausgewählterUser;
    private String ausgewählteFortbildung;
    private String Status;


    public String getAusgewählterUser() {
        return ausgewählterUser;
    }

    public void setAusgewählterUser(String ausgewählterUser) {
        this.ausgewählterUser = ausgewählterUser;
        System.out.println(ausgewählterUser);
    }

    public String getAusgewählteFortbildung() {
        return ausgewählteFortbildung;
    }

    public void setAusgewählteFortbildung(String ausgewählteFortbildung) {
        this.ausgewählteFortbildung = ausgewählteFortbildung;
        System.out.println(ausgewählteFortbildung);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List getNutzer() {
        InitializiseJComboBox initializiseJComboBox = new InitializiseJComboBox();
        return initializiseJComboBox.setComboBoxUser();
    }

    public List getFortbildungen() {
        InitializiseJComboBox initializiseJComboBox = new InitializiseJComboBox();
        return initializiseJComboBox.setComboBoxVorbildungen();
    }

    public String getDoneFortbildung() {

        InitializiseJComboBox initializiseJComboBox = new InitializiseJComboBox();
        return initializiseJComboBox.getAllFortbildungenForUserAsString(ausgewählterUser);
    }

    public void setFortbildung() {
        String ausgewählterUserSave = ausgewählterUser;
        String ausgewählteFortbildungSave = ausgewählteFortbildung;
        String ausgewählertStatus = Status;
        SachbearbeiterSachbearbeiterFortbildungZuordnenK sachbearbeiterSachbearbeiterFortbildungZuordnenK = new SachbearbeiterSachbearbeiterFortbildungZuordnenK();
        ErrorSucessMessages errorSucessMessages = new ErrorSucessMessages();
        if (sachbearbeiterSachbearbeiterFortbildungZuordnenK.setFortbildung(ausgewählterUserSave, ausgewählteFortbildungSave, ausgewählertStatus)) {
            FacesContext fc = FacesContext.getCurrentInstance();
          //  fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());
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
                    fc.getExternalContext().redirect("http://localhost:8080/SachbearbeiterAS.xhtml");
                } catch (IOException e) {
                    System.out.println("Fuck");
                    e.printStackTrace();
                }
                fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());
            }
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("loginError", errorSucessMessages.getErrorMessage());
        }
    }
}
