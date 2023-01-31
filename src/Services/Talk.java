
package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import DnetMessage.Message;


public interface Talk extends Remote{
    public void send_message(Message msg) throws RemoteException;
    
    public Message broadcast() throws RemoteException;
}
