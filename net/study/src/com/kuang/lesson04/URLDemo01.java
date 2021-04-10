package com.kuang.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=kuangsheng&password=123");
    }
}
