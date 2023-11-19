/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHpackage;

/**
 *
 * @author HP
 */
public class MedicalCard {
    private String email;
    private String illness;
    private String firstOccurrence;
    private String medicine;
    private String fee;
    private String transactionId;
    private String RegisteredOn;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setFirstOccurrence(String firstOccurrence) {
        this.firstOccurrence = firstOccurrence;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setRegisteredOn(String RegisteredOn) {
        this.RegisteredOn = RegisteredOn;
    }

    public String getEmail() {
        return email;
    }

    public String getIllness() {
        return illness;
    }

    public String getFirstOccurrence() {
        return firstOccurrence;
    }

    public String getMedicine() {
        return medicine;
    }

    public String getFee() {
        return fee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getRegisteredOn() {
        return RegisteredOn;
    }
    
    
}
