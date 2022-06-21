package com.sijanstu.networkquestions;

public class QN8 {
    public static void main(String[] args) {
        //8.wap to display the socket information
        try {
            java.net.Socket socket = new java.net.Socket("www.google.com", 80);
            System.out.println("Socket: " + socket);
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
            System.out.println("Remote port: " + socket.getPort());
            socket.close();
        } catch (java.io.IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
