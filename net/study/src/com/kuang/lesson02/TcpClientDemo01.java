package com.kuang.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo01 {
    public static void main(String[] args) {

        try {
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            Socket socket = new Socket(serverIp, port);

            OutputStream os = socket.getOutputStream();

            os.write("你好123123123".getBytes());
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
