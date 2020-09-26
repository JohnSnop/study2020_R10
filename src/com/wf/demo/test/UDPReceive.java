package com.wf.demo.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wf
 * @create 2020-09-26 21:06
 * @desc
 **/
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12306);
        byte[] data = new byte[1024];

        DatagramPacket packet = new DatagramPacket(data, 1024);
        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress());

        byte[] data1 = packet.getData();
        System.out.println("数据：" + new String(data1));

        socket.close();
    }
}
