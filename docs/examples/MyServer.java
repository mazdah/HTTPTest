package com.innotree.study.httptest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    // port 80은 root 계정에서만 허용
    // sudo su로 루트 계정으로 바꾸고 실행해야함.
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(80);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    System.out.printf("IP from : %s, Port : %d\n",
                            socket.getInetAddress(), socket.getPort());

                    OutputStream o = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(o);

                    File accessFile = new File("/Users/mazdah/Sites/localhost/index.php");
                    int accessFileLength = (int)accessFile.length();

                    if(accessFile.exists()){
                        FileInputStream in = new FileInputStream(accessFile);
                        byte[] fBytes = new byte[accessFileLength];
                        in.read(fBytes);
                        in.close();

                        dos.writeBytes("HTTP/1.1 200 OK \r\n");
                        dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
                        dos.writeBytes("Content-Length: " + accessFileLength + "\r\n");
                        dos.writeBytes("\r\n");

                        dos.write(fBytes, 0, accessFileLength);
                        dos.writeBytes("\r\n");
                        dos.flush();
                    }
                    else{
                        dos.writeBytes("HTTP/1.0 404 Not Found \r\n");
                        dos.writeBytes("Connection: close\r\n");
                        dos.writeBytes("\r\n");
                        dos.writeBytes("요청한 페이지를 찾을 수 없습니다!!!");
                        dos.flush();
                    }



                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}
