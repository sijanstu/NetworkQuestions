package com.sijanstu.networkquestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QN16 {
    //16.wap to create a simple udp client and server which provide factorial of a number
}

class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(2000);
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println(str);
        int a = Integer.parseInt(str);
        int f = 1, i;
        String s = "";
        for (i = 1; i <= a; i++) {
            f = f * i;
        }
        s = Integer.toString(f);
        String str1 = "The Factorial of " + str + " is : " + f;
        byte b1[];
        b1 = str1.getBytes();
        DatagramPacket dp1 = new
                DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1000);
        ds.send(dp1);
    }
}

class udpClientFact {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1000);
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        System.out.println("Enter a number : ");
        String num = br.readLine();
        byte[] b;
        b = num.getBytes();
        DatagramPacket dp = new
                DatagramPacket(b, b.length, InetAddress.getLocalHost(), 2000);
        ds.send(dp);
        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);
        String str = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println(str);
    }

}