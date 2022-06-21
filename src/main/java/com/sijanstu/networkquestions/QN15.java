package com.sijanstu.networkquestions;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class QN15 {
    //illustrate creation and implementation of buffer and channel

    public static void main(String[] args) {
        File inputFile = new File("hello.txt");
        if (!inputFile.exists()) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(inputFile));
                writer.write("Hello World");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        if (!inputFile.exists()) {
            System.out.println("The input file doesn't exit.");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(inputFile);
            FileChannel fileChannel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
            }

            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}