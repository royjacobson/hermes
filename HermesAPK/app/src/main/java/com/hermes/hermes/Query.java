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

    public void sendQuery(OutputStream outputStream) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(outputStream, true);
            printWriter.print(json + '\n');
            printWriter.flush();
            //printWriter.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,"Something went wrong during the socket opening", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
