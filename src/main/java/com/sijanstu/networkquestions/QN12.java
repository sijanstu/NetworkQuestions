package com.sijanstu.networkquestions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class QN12 {
    // 12.wap to perform a basic two-way communication between client and server
    static class Server2 {

        public static void main(String[] args)
                throws Exception {
            ServerSocket ss = new ServerSocket(888);
            Socket s = ss.accept();
            System.out.println("Connection established");
            PrintStream ps
                    = new PrintStream(s.getOutputStream());
            BufferedReader br
                    = new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()));
            BufferedReader kb
                    = new BufferedReader(
                    new InputStreamReader(System.in));
            while (true) {
                String str, str1;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                    str1 = kb.readLine();
                    ps.println(str1);
                }
                ps.close();
                br.close();
                kb.close();
                ss.close();
                s.close();
                System.exit(0);
            }
        }
    }

    static class Client {

        public static void main(String[] args)
                throws Exception {
            Socket s = new Socket("localhost", 888);
            DataOutputStream dos
                    = new DataOutputStream(
                    s.getOutputStream());
            BufferedReader br
                    = new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()));
            BufferedReader kb
                    = new BufferedReader(
                    new InputStreamReader(System.in));
            String str, str1;
            while (!(str = kb.readLine()).equals("exit")) {
                dos.writeBytes(str + "\n");
                str1 = br.readLine();
                System.out.println(str1);
            }
            dos.close();
            br.close();
            kb.close();
            s.close();
        }
    }
}
