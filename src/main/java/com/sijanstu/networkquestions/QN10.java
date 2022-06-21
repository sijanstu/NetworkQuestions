package com.sijanstu.networkquestions;

import java.net.MalformedURLException;
import java.net.URL;

public class QN10 {
    public static void main(String[] args) throws MalformedURLException {
        // 10.test given two url are same or not
        URL url1 = new URL("http://www.google.com/search?q=java");
        URL url2 = new URL("http://www.google.com/search?q=java");
        boolean isSame = url1.equals(url2);
        System.out.println("Are same: " + isSame);
    }
}
