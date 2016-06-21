package com.company.business.model;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class Maker {
    private int makerId;
    private String country;
    private String company;
    private String contacts;

    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Maker{" +
                "makerId=" + makerId +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", contacts='" + contacts + '\'' +
                '}';
    }
}
