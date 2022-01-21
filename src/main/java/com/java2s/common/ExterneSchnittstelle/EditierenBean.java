package com.java2s.common.ExterneSchnittstelle;
import com.java2s.common.Anwedungslogik.InitializiseJComboBox;
import com.java2s.common.Anwedungslogik.LoginK;
import com.java2s.common.Anwedungslogik.SachbearbeiterEditierenK;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "EditierenBean")
@ApplicationScoped
public class EditierenBean {
    private String oldUsername;
    private String newUsername;
    private String newPassword;
    private String newRole; // nur admin

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
        System.out.println(oldUsername);
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
        System.out.println(newUsername);
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        System.out.println(newPassword);
        this.newPassword = newPassword;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        System.out.println(newRole);
        this.newRole = newRole;
    }

    public boolean isShowOption() {
        if(LoginK.getRole().equals("Admin")) {
            return true;
        }
        return false;
    }

    public void EditUser()
    {
        ErrorSucessMessages errorSucessMessages = new ErrorSucessMessages();
        SachbearbeiterEditierenK sachbearbeiterEditierenK = new SachbearbeiterEditierenK();
        if(LoginK.getRole().equals("Sachbearbeiter"))
        {
            newRole = sachbearbeiterEditierenK.getRoleBeforeChange(oldUsername);
        }
        if(sachbearbeiterEditierenK.UpdateSacharbeiter(newUsername,newPassword,newRole,oldUsername))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            try {
                fc.getExternalContext().redirect("http://localhost:8080/AdminAS.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            FacesContext fc = FacesContext.getCurrentInstance();

            fc.addMessage("loginError", errorSucessMessages.getErrorMessage());
        }
    }

    public String getDoneFortbildung() {

        InitializiseJComboBox initializiseJComboBox = new InitializiseJComboBox();
        return initializiseJComboBox.getAllFortbildungenForUserAsString(oldUsername);
    }
}
