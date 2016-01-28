package com.hermes.hermes;

import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Lev Petrov on 28-Jan-16.
 */
public class Query {

    String json;

    public Query(String json){
        this.json = json;
    }

    public void sendQuery(){
        SocketAddress socketAddress =
        Socket socket = new Socket();
        socket.connect();
    }
}
