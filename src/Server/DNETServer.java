package Server;

import Services.Talk;
import Services.TalkService;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DNETServer {

    public DNETServer() {
      //  this.StartServer();
    }
    
    

    public void StartServer(){
        try {
            Talk chat = new TalkService();
            Registry reg = LocateRegistry.createRegistry(1997);
            reg.bind("DNETAdmin", chat);//bind:
            System.out.println("Chat server is running...");
            
            
            
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Exception ocured : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DNETServer dnetServer = new DNETServer();
                dnetServer.StartServer();
            }
        });
    }
    
}
