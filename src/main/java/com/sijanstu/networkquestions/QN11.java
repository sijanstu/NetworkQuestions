package com.sijanstu.networkquestions;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// 11.wap to create client server to implement the remote method invocation(rmi)
interface RMIInterface extends Remote {

    public String helloTo(String name) throws RemoteException;

}

class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;

    protected ServerOperation() throws RemoteException {

        super();

    }

    public static void main(String[] args) {

        try {

            Naming.rebind("//localhost/MyServer", new ServerOperation());
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

    @Override
    public String helloTo(String name) throws RemoteException {

        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;

    }

}

class ClientOperation {

    private static RMIInterface look_up;

    public static void main(String[] args)
            throws MalformedURLException, RemoteException, NotBoundException {

        look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
        //get name from user
        System.out.println("Enter your name: ");
        String name = System.console().readLine();
        //call remote method
        System.out.println(look_up.helloTo(name));
    }

}

public class QN11 {

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        ClientOperation.main(args);
    }
}
