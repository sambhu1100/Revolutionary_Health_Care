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
public class Patient_and_MedicalCard {
    //patient data
    private int pid;
    private String email;
    private String password;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String f_or_hubName;
    private String occupation;
    private String i_mark;
    private String bloodgroup;
    private String aadhar;
    //medical card data
    private String illness;
    private String firstOccurrence;
    private String medicine;
    private String fee;
    private String transactionId;
    private String RegisteredOn;

    //setter
    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setF_or_hubName(String f_or_hubName) {
        this.f_or_hubName = f_or_hubName;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setI_mark(String i_mark) {
        this.i_mark = i_mark;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
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
    
    //Getter

    public int getPid() {
        return pid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getF_or_hubName() {
        return f_or_hubName;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getI_mark() {
        return i_mark;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getAadhar() {
        return aadhar;
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
