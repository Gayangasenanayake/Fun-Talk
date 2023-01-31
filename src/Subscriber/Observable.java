package Subscriber;

public interface Observable {
    public void subscribeStudent(String chatId, String stuId);
   
    public void unsubscribeStudent(int cid);
    
    public void notifyStudent();
}
