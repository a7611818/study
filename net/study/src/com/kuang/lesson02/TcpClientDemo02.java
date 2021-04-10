package com.kuang.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("u5.png"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

//        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
