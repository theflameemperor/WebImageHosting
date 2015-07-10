/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DatoSession;

/**
 *
 * @author mrmomo
 */
public class ErrorDePagina {
    private String error;
    private String reason;
    public ErrorDePagina(String error,String reason){
        this.error=error;
        this.reason =reason;
    }
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}
