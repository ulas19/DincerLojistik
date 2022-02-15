package com.ulas.dincerlojistik.Model;

public class ModelVerify {
    String name,surname,job,companyAdress,companyName;
    int phoneNumber,userId;

    public ModelVerify(String name, String surname, String job, String companyAdress, String companyName, int phoneNumber,int userId) {
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.companyAdress = companyAdress;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.userId= userId;
    }

    public ModelVerify() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
