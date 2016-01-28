package com.hermes.hermes;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Query {

    String json;
    static final String serverIP = "172.29.104.189";
    static final int serverPort = 4356;
    private Context context;

    public Query(String json, Context context) {
        this.json = json;
        this.context = context;
    }

    public void sendQuery() {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(serverIP, serverPort);
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            socket = new Socket(serverIP, serverPort);
            socket.connect(socketAddress);
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.print("Lev Petrov");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,"Something went wrong during the socket opening", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
