package com.kuang.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {

    DatagramSocket socket;
    BufferedReader reader;

    private int fromPort;
    private String toIp;
    private int port;

    public TalkSend(int fromPort, String toIp, int port) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.port = port;

        try {
            this.socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();

                DatagramPacket packet =
                        new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.port));

                socket.send(packet);
                if ("bye".equals(data)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
