/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esp32cp;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    private static ServerSocket server;
    private static Socket trunggian;
    private static DataInputStream din;
    private static DataOutputStream dout;
    private static Thread WIFI_CONNECT_THREAD;
    private static Socket WIFI_SOCKET;

    private BufferedWriter WIFI_BUFFERED_WRITER;

    private void SendData(String x) throws Exception {
        if (x == null || x.isEmpty()) {
            return;
        }
        if (WIFI_SOCKET == null) {
            // jLabel2.setText("not connected !");
            System.out.println("not connected !");
            return;
        }
        try {
            WIFI_BUFFERED_WRITER = new BufferedWriter(new OutputStreamWriter(WIFI_SOCKET.getOutputStream()));
            WIFI_BUFFERED_WRITER.write(x + "\n");
            WIFI_BUFFERED_WRITER.flush();
            // jLabel2.setText("sent :" + x);
            System.out.println("esp32cp.Ui.SendData()");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void WIFI_closeConnecition() {
        if (WIFI_SOCKET != null) {
            if (WIFI_SOCKET.isConnected()) {
                try {
                    WIFI_SOCKET.close();
                    WIFI_SOCKET = null;

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    private boolean WIFI_isConnected() {
        if (WIFI_SOCKET != null) {
            if (WIFI_SOCKET.isConnected()) {
                return true;
            }
        }
        return false;
    }

    private void Connect(String WIFI_IP, String WIFI_PORT) {
        if (WIFI_isConnected()) {
            // System.out.println("closing connection ...");
            WIFI_closeConnecition();
            //  System.out.println("connection closed");

            return;
        }
        if(WIFI_SOCKET ==null){
            WIFI_CONNECT_THREAD = new Thread(() -> {
            if (WIFI_isConnected()) {
                System.out.println("closing connection ...");
                WIFI_closeConnecition();
                System.out.println("connection closed");
                WIFI_SOCKET = null;

                return;
            }

            try {
                System.out.println("connecting...");
                WIFI_SOCKET = new Socket(WIFI_IP, Integer.valueOf(WIFI_PORT));
                System.out.println("connected to :" + WIFI_IP + "  " + 80);
                System.out.println(WIFI_SOCKET);

            } catch (UnknownHostException e1) {
                System.out.println("Error !");

            } catch (IOException e1) {

                System.out.println("Network is unreachable !");

            }
        });
        WIFI_CONNECT_THREAD.start();
        }
        

    }

    private void running() throws IOException, Exception {

        server = new ServerSocket(8888);

        while (true) {
            trunggian = server.accept();
            din = new DataInputStream(trunggian.getInputStream());
            dout = new DataOutputStream(trunggian.getOutputStream());
            if (WIFI_SOCKET == null) {
                int length = din.readInt();
                byte[] data = new byte[length];
                din.readFully(data);
                String str = new String(data, "UTF-8");

                String[] parts = str.split("-");
                String wifi = parts[0];
                String port = parts[1];
                Connect(wifi, port);
                System.out.println(wifi + " " + port);
            } else {
                System.out.println("1");
                int length = din.readInt();
                byte[] data = new byte[length];
                din.readFully(data);

                String str = new String(data, "UTF-8");
                System.out.println(str);
                SendData(str);

                System.out.println(WIFI_SOCKET + "");

            }

        }
    }

    public static void main(String[] args) {

        Server s = new Server();
        try {
            s.running();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
