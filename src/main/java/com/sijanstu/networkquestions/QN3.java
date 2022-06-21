package com.sijanstu.networkquestions;

public class QN3 {
    public static void main(String[] args) {
        //3.Wap to create URI object from a string
        String uriString = "http://www.google.com/search?q=java";
        java.net.URI uri = null;
        try {
            uri = new java.net.URI(uriString);
        } catch (java.net.URISyntaxException e) {
            System.out.println("Invalid URI");
        }
        System.out.println("URI: " + uri);
    }
}
