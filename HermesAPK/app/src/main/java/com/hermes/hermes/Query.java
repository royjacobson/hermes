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
    private Context context;

    public Query(String json, Context context) {
        this.json = json;
        this.context = context;
    }

    public void sendQuery(Socket socket) {

        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {

            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
            printWriter.print(json);
            printWriter.flush();
            printWriter.close();

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,"Something went wrong during the socket opening", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
