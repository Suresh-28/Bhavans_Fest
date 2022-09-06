package com.example.bhavans_fest;

public class Store_Data{
    String firstname,lastname,email,printing,password,ednumber,address,nation;

    public Store_Data(String firstname, String lastname, String email, String printing, String password, String ednumber, String address, String nation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.printing = printing;
        this.password = password;
        this.ednumber = ednumber;
        this.address = address;
        this.nation = nation;
    }

    public String getFirstname() {

        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrinting() {
        return printing;
    }

    public void setPrinting(String printing) {
        this.printing = printing;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEdnumber() {
        return ednumber;
    }

    public void setEdnumber(String ednumber) {
        this.ednumber = ednumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}

