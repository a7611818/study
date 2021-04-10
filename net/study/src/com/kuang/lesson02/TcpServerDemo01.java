package com.kuang.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(9999);

           while(true){
               socket = serverSocket.accept();

               is = socket.getInputStream();

               bos = new ByteArrayOutputStream();
               byte[] buffer = new byte[1024];
               int len;
               while ((len = is.read(buffer)) != -1) {
                   bos.write(buffer, 0, len);
               }
               System.out.println(bos.toString());
           }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bos.flush();
            is.close();
            socket.close();
            serverSocket.close();
        }
    }
}
