package com.user;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class User {
    private InputStream is = null;
    private OutputStream os = null;

    private Socket client;

    public void clientStop() {
        try {
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    public void sendFile(File f, String flag) {

        try {
            PrintWriter printWriter = new PrintWriter(os, true);
            printWriter.println(f.getName());
            printWriter.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] arr_b = new byte[1];
       
        try {
            OutputStream dout = new DataOutputStream(new BufferedOutputStream(os)); // Поток чтения файла
            InputStream ins = new FileInputStream(f);
            int index = ins.read(arr_b);
            while (index != -1) {
                dout.write (arr_b); 
                dout.flush (); 
                index = ins.read(arr_b);
            } 
            ins.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile() {
        byte[] arr_b=new byte[1024];
        try {
            InputStream in = is;
            DataInputStream din = new DataInputStream (new BufferedInputStream(in)); // Создать файл для сохранения
            String filename = din.readLine();
            File f = new File(filename);
            RandomAccessFile fw = new RandomAccessFile(f, "rw");

            int num = din.read(arr_b);
            while (num != -1) {
                fw.write(arr_b, 0, num);
                fw.skipBytes(num);
                num = din.read(arr_b);
            } 
            din.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
  public void connectSocketServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            client = server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            is = client.getInputStream();
            os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
