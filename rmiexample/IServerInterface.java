package itanalyst.rmiexample;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerInterface extends Remote {
    /**
     * Beschreibung
     *
     * @param name Alex
     * @return Begruessungsformel
     * @throws RemoteException wenn Fehler
     */

    String sayHello(String name) throws RemoteException;

}
