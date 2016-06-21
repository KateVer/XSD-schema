package com.company.business.model;

/**
 * Created by kateverbitskaya on 20.06.16.
 */
public class User {

    private int UserId;
    private String name;
    private long hashPass;
    private String adminYN;
    private String email;
    private String phone;
    private String bannedYN;
    private String orderHistory;
    private String discount;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHashPass() {
        return hashPass;
    }

    public void setHashPass(long hashPass) {
        this.hashPass = hashPass;
    }

    public String getAdminYN() {
        return adminYN;
    }

    public void setAdminYN(String adminYN) {
        this.adminYN = adminYN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBannedYN() {
        return bannedYN;
    }

    public void setBannedYN(String bannedYN) {
        this.bannedYN = bannedYN;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", hashPass=" + hashPass +
                ", adminYN='" + adminYN + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", bannedYN='" + bannedYN + '\'' +
                ", orderHistory='" + orderHistory + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
