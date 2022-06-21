package com.sijanstu.networkquestions;

public class QN2 {
    public static void main(String[] args) {
        //2.find the hostname of a given IP address
        String ipAddress = "1.1.1.1";
        String hostName = "";
        try {
            hostName = java.net.InetAddress.getByName(ipAddress).getHostName();
        } catch (java.net.UnknownHostException e) {
            System.out.println("Invalid IP address");
        }
        System.out.println("Host name: " + hostName);
    }
}
