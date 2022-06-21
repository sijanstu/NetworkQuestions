package com.sijanstu.networkquestions;

public class QN14 {
    // QN14: display the cookie value of the given url
    public static void main(String[] args) {
        String url = "http://www.google.com";
        System.out.println(url + " cookie value: " + getCookieValue(url));
    }

    public static String getCookieValue(String url) {
        String cookie = null;
        try {
            java.net.CookieManager manager = new java.net.CookieManager();
            java.net.CookieHandler.setDefault(manager);
            java.net.URL u = new java.net.URL(url);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", "CookieName=CookieValue");
            conn.connect();
            java.util.Map<String, java.util.List<String>> map = conn.getHeaderFields();
            java.util.List<String> list = map.get("Set-Cookie");
            cookie = list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookie;
    }
}
