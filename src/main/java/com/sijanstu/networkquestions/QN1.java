package com.sijanstu.networkquestions;

/**
 * @author Sijan
 */
public class QN1 {

    public static void main(String[] args) {
        //1.wap to test the nature of an IP address

        //check IP address nature
        String ipAddress = "192.168.1.1";
        if (ipAddress.matches("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$")) {
            System.out.println("IPv4");
        } else if (ipAddress.matches("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})$")) {
            System.out.println("IPv4");
        } else if (ipAddress.matches("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$")) {
            System.out.println("IPv6");
        } else if (ipAddress.matches("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$")) {
            System.out.println("IPv6");
        } else {
            System.out.println("Invalid IP address");
        }

    }
}
