package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @Table(name = "admin")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;

    
    
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", email =" + email + ", password =" + password + ", fullName ="+ fullName +", address ="+ address +", phoneNumber =" + phoneNumber +" ]";
    }
}
