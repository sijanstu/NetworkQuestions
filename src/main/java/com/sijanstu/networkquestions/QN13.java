package com.sijanstu.networkquestions;

public class QN13 {
    public static void main(String[] args) {
        //create a simple udp client
        try {
            java.net.DatagramSocket udpSocket = new java.net.DatagramSocket(8080);
            java.net.DatagramPacket udpPacket = new java.net.DatagramPacket("Hello".getBytes(), "Hello".getBytes().length);
            udpPacket.setAddress(java.net.InetAddress.getByName("localhost"));
            udpPacket.setPort(8080);
            udpSocket.send(udpPacket);
            byte[] buffer = new byte[1000];
            udpPacket = new java.net.DatagramPacket(buffer, buffer.length);
            udpSocket.receive(udpPacket);
            System.out.println("Received packet from: " + udpPacket.getAddress().getHostAddress());
            System.out.println("Packet contents: " + new String(udpPacket.getData()));
            udpSocket.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
