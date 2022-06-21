package com.sijanstu.networkquestions;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class QN9 {
    public static void main(String[] args) throws IOException {
        // 9.wap to server side program for daytime service using socket
        ServerSocketChannel server = ServerSocketChannel.open();
        int port = 13;
        server.bind(new java.net.InetSocketAddress(port));
        CharsetEncoder encoder = StandardCharsets.US_ASCII.newEncoder();
        for (; ; ) {
            SocketChannel client = server.accept();
            String date = new java.util.Date().toString() + "\r\n";
            ByteBuffer response = encoder.encode(CharBuffer.wrap(date));
            client.write(response);
            client.close();
        }
    }
}
