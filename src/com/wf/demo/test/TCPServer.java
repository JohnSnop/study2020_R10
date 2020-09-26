package com.wf.demo.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wf
 * @create 2020-09-26 21:00
 * @desc
 **/
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("您已连接服务器".getBytes());

        outputStream.close();
        accept.close();
    }
}
