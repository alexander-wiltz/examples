package itanalyst.rmicallback;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMessageSender extends Remote {
    void register(IMessageReceiver clientCallback) throws RemoteException;
    void remove(IMessageReceiver clientCallback) throws RemoteException;
}
