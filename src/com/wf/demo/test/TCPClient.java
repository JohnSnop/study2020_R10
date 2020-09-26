package com.wf.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author wf
 * @create 2020-09-26 21:03
 * @desc
 **/
public class TCPClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.200.10", 8888);
        InputStream inputStream = socket.getInputStream();

        byte[] data = new byte[1024];
        int read = inputStream.read(data);
        System.out.println(new String(data, 0, read));
        inputStream.close();
        socket.close();
    }
}
