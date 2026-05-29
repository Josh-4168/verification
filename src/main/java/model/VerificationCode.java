package model; 
public class VerificationCode { 
    private int id;
    private int userId;
    private String code; 
    private String status;
    public VerificationCode() { }
    public VerificationCode(int userId, String code) {
        this.userId = userId; 
        this.code = code; }
    public int getId() {
        return id; } 
    public void setId(int id) {
        this.id = id; }
    public int getUserId() {
        return userId; } 
    public void setUserId(int userId) { 
        this.userId = userId; } 
    public String getCode() { 
        return code; }
    public void setCode(String code) {
        this.code = code; }
    public String getStatus() { 
        return status; } 
    public void setStatus(String status) { 
        this.status = status; } }
