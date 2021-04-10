package com.kuang.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    DatagramSocket socket;
    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;

        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);

                System.out.println(msgFrom + ": " + receiveData);
                if ("bye".equals(receiveData)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        socket.close();
    }
}
