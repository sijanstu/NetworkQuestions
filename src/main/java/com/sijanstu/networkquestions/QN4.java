package com.sijanstu.networkquestions;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class QN4 {
    public static void main(String[] args) {
        //4.Wap to receive a data using multicast socket
        //multicast receiver
        try {
            MulticastSocket socket = new MulticastSocket(9876);
            InetAddress group = InetAddress.getByName("224.0.2.0");
            socket.joinGroup(group);
            byte[] buffer = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println("Received packet from: " + packet.getAddress().getHostAddress());
            System.out.println("Packet contents: " + new String(packet.getData()));
            socket.leaveGroup(group);
            socket.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);

        }
    }
}
