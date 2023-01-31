
package Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import DnetMessage.Message;


public class TalkService extends UnicastRemoteObject implements Talk{

    Message newmsg = null;
    
    public TalkService() throws RemoteException {
        super();
    }   

    @Override
    public void send_message(Message msg) {
        
        this.newmsg = msg;
        System.out.println("ID:"+newmsg.getMsgid());
        System.out.println("NAME:"+newmsg.getName());
        System.out.println("MESSAGE:ame"+newmsg.getMessage());
        System.out.println("TIME:"+newmsg.getDate_time());
        this.save_msg();
        
    }
    
     public void save_msg() {
    
        try {
            FileOutputStream fileOut = new FileOutputStream("messagedb.ser", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            out.writeObject(this.newmsg);
            out.flush();
            out.close();
            fileOut.close();
            
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
         
    }

    @Override
    public Message broadcast() throws RemoteException {
        return this.newmsg;
    }
    

 
    
    
}
