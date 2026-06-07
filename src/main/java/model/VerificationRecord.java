
package model;


public class VerificationRecord {
  
    private int userId;
    private String phoneNumber;
    private String code;
    private java.sql.Timestamp createdAt;

    public VerificationRecord(
            int userId,
            String phoneNumber,
            String code,
            java.sql.Timestamp createdAt) {

        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.code = code;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }  
}
