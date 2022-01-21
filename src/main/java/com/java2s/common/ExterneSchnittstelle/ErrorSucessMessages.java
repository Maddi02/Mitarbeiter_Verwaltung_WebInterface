package com.java2s.common.ExterneSchnittstelle;

import javax.faces.application.FacesMessage;

public class ErrorSucessMessages {


    FacesMessage msgSuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aktion erflogreich ausgeführt ", null);
    FacesMessage msgError = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diese Aktion konnte nicht durchgeführt werden ", null);
    FacesMessage msgFortbildung = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diese Aktion konnte nicht durchgeführt werden da diese Fortbildung \n nicht belegt ist oder sie Vorrausetzung für eine andere ist ", null);

    public FacesMessage getMsgFortbildung() {
        return msgFortbildung;
    }

    public FacesMessage getSuccessMessage()
    {
       return  msgSuccess;
    }

    public FacesMessage getErrorMessage()
    {
        return msgError;
    }
}
