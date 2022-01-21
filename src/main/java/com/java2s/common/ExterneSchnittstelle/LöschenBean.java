package com.java2s.common.ExterneSchnittstelle;

import com.java2s.common.Anwedungslogik.AdminLöschungExistierenderNutzerK;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "LöschenBean")
@ApplicationScoped
public class LöschenBean {
    private String userToDelete;

    public String getUserToDelete() {
        return userToDelete;
    }

    public void setUserToDelete(String userToDelete) {
        this.userToDelete = userToDelete;
    }

    public void deleteUser()
    {
        ErrorSucessMessages errorSucessMessages = new ErrorSucessMessages();
        AdminLöschungExistierenderNutzerK adminLöschungExistierenderNutzerK = new AdminLöschungExistierenderNutzerK();
        if(adminLöschungExistierenderNutzerK.deleteUser(userToDelete))
        {
            System.out.println("Hallo");
            FacesContext fc = FacesContext.getCurrentInstance();
            try {
                fc.getExternalContext().redirect("http://localhost:8080/AdminAS.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            fc.addMessage("loginError", errorSucessMessages.getSuccessMessage());
        }

        else{
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("loginError", errorSucessMessages.getErrorMessage());
        }
    }
}
