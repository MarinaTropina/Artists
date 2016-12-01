package com.company.model;

public class Director {
    private String name;

    private String phone;
    private String email;

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Director: " + name + ", " + phone + ", " + email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
