package com.sijanstu.networkquestions;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

//5.wap a client side to read from server using socket
public class QN5 {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("www.google.com", 80);
        InputStream is = clientSocket.getInputStream();
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
        pw.println("GET / HTTP/1.0");
        pw.println();
        pw.flush();
        byte[] buffer = new byte[1024];
        int read;
        while((read = is.read(buffer)) != -1) {
            String output = new String(buffer, 0, read);
            System.out.print(output);
            System.out.flush();
        };
        clientSocket.close();

    }
}
