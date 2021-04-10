package com.kuang.lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/qinjiang/SecurityFile.txt");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("Security.txt");
        byte[] buffer = new byte[1024];
        int len;

        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
