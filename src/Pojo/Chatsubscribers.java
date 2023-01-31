package Pojo;



public class Chatsubscribers  implements java.io.Serializable {


     private Integer id;
     private String chatId;
     private String studentId;
     private String status;

    public Chatsubscribers() {
    }
    public Chatsubscribers(String chatId, String studentId, String status) {
       this.chatId = chatId;
       this.studentId = studentId;
       this.status = status;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getChatId() {
        return this.chatId;
    }
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
    public String getStudentId() {
        return this.studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}


