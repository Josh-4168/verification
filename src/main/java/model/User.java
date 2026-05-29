package model; 
public class User {
    private int id;
    private String phoneNumber; 
    private boolean verified; 
    public User() { } 
    public User(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    } 
    public int getId() { 
        return id; } 
    public void setId(int id) { 
        this.id = id; } 
    public String getPhoneNumber() {
        return phoneNumber; } 
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; } 
    public boolean isVerified() { 
        return verified; }
    public void setVerified(boolean verified) { 
        this.verified = verified; } }

