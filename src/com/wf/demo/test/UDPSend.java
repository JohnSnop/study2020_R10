package com.wf.demo.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author wf
 * @create 2020-09-26 21:11
 * @desc
 **/
public class UDPSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();


        DatagramPacket packet = new DatagramPacket("Hello".getBytes(), 5, InetAddress.getByName("192.168.200.10"),
                12306);
        socket.send(packet);
        socket.close();
    }
}
