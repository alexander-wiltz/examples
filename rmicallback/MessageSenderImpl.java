package itanalyst.rmicallback;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageSenderImpl extends UnicastRemoteObject implements IMessageSender {

    private List<IMessageReceiver> receiverList = new ArrayList<>(2);

    protected MessageSenderImpl() throws RemoteException {
    }

    @Override
    public void register(IMessageReceiver clientCallback) throws RemoteException {
        if(!receiverList.contains(clientCallback)) {
            receiverList.add(clientCallback);
        }
    }

    @Override
    public void remove(IMessageReceiver clientCallback) throws RemoteException {
        receiverList.remove(clientCallback);
    }

    public void sendMessage(String message) throws RemoteException {
        Iterator<IMessageReceiver> iterator = receiverList.iterator();

        while(iterator.hasNext()) {
            IMessageReceiver receiver = iterator.next();
            receiver.sendToClient(message);
        }
    }

}
