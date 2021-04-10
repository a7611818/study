package com.kuang.lesson03;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData()));

        socket.close();
    }
}
