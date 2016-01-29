package com.hermes.hermes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SearchActivity extends AppCompatActivity {

    static final String serverIP = "172.29.104.189";
    static final int serverPort = 4356;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText country, num, age, budget, dates, email;
        country = (EditText) findViewById(R.id.editText);
        num = (EditText) findViewById(R.id.editText2);
        age = (EditText) findViewById(R.id.editText3);
        budget = (EditText) findViewById(R.id.editText4);
        dates = (EditText) findViewById(R.id.editText5);
        email = (EditText) findViewById(R.id.editText6);

        final Button button = (Button) findViewById(R.id.buttonContinue);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String strCountry, strNum, strAge, strBudget, strDates, strEmail;
                strCountry = country.getText().toString();
                strNum = num.getText().toString();
                strAge = age.getText().toString();
                strBudget = budget.getText().toString();
                strDates = dates.getText().toString();
                strEmail = email.getText().toString();

                Socket socket = null;
                SocketAddress socketAddress = new InetSocketAddress(serverIP, serverPort);

                JSONObject jsonObject = new JSONObject();
                try {
                    socket = new Socket();
                    socket.connect(socketAddress, 50);
                    jsonObject.accumulate("country", strCountry)
                            .accumulate("numberOfPeople", strNum)
                            .accumulate("age", strAge)
                            .accumulate("budget", strBudget)
                            .accumulate("dates", strDates)
                            .accumulate("email", strEmail);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
                Query query = new Query(jsonObject.toString(), getApplicationContext());
                query.sendQuery(socket);
                InputStream inputStream;
                try {
                    inputStream = socket.getInputStream();
                    int i = inputStream.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        })


        ;
    }
}


