package com.java2s.common.ExterneSchnittstelle;
import com.java2s.common.Anwedungslogik.ErstellungSacharbeiterK;
import com.java2s.common.Anwedungslogik.LoginK;
import com.java2s.common.Anwedungslogik.Hilfsfunktionen;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String Username;
    private String Password;
    private String Role;
    int loginCounter = 0 ;
    private boolean login = true;
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        System.out.println(password);
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        System.out.println(role);
        Role = role;
    }


    public void checkValidCredantials() {

         login = true;
        LoginK loginK = new LoginK();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diese Daten sind nicht Valide ", null);
        FacesMessage msgRole = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sie müssen eine Rolle auswählen ", null);
        FacesMessage msgWrongRole = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sie als Sacharbeiter können Sich nicht als Admin anmelden", null);
        System.out.println(Username);
        System.out.println(Password);

        if (!loginK.isValidConnection(Username, Password)) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("loginError", msg);
        } else {
            if (LoginK.getRole().equals("Sachbearbeiter") && Role.equals("Admin")) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("loginError", msgWrongRole);
                login = true;
            } else if (Role.equals("Admin") && LoginK.getRole().equals("Admin")) {
                System.out.println("Passt");
                login = false;
                redirectAdminAS();

            } else if (Role.equals("Sachbearbeiter") && LoginK.getRole().equals("Admin")) {
                login = false;
                redirectSacharbeiterASS();

            } else {
                login = false;
                redirectSacharbeiterASS();
            }

        }
        if (Role.contentEquals("")) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("loginError", msgRole);
        }


    }

    public void createUser() {
        ErrorSucessMessages errorSucessMessages = new ErrorSucessMessages();
        Hilfsfunktionen hilfsfunktionen = new Hilfsfunktionen();
        ErstellungSacharbeiterK erstellungSacharbeiterK = new ErstellungSacharbeiterK();
        if (hilfsfunktionen.checkIfUserExists(Username)) {


            if (erstellungSacharbeiterK.createUser(Username, Password, Role)) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());

            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("loginError", errorSucessMessages.getErrorMessage());
            }
        }
        resetButton();
    }

    private void redirectSacharbeiterASS() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("SachbearbeiterAS.xhtml");
        } catch (Exception e) {
            System.out.println("Got an exeption");
        }
    }

    private void redirectAdminAS()
    {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdminAS.xhtml");
        } catch (Exception e) {
            System.out.println("Got an exeption");
        }
    }
    public boolean LoginTrue()
    {
        System.out.println("Login Status " + login);
      return login;
    }

    public void resetButton()
    {
        login = true;
    }
}
