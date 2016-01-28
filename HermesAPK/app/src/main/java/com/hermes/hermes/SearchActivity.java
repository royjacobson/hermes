package com.hermes.hermes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


                final EditText country= (EditText) findViewById(R.id.editText);
                final EditText num= (EditText) findViewById(R.id.editText2);
                final EditText age= (EditText) findViewById(R.id.editText3);
                final EditText budget= (EditText) findViewById(R.id.editText4);
                final EditText dates= (EditText) findViewById(R.id.editText5);
                final EditText email= (EditText) findViewById(R.id.editText6);

                final Button button = (Button) findViewById(R.id.buttonContinue);
                button.setOnClickListener(new View.OnClickListener()

                {
                    public void onClick(View v)
                    {
                        String strCountry = country.getText().toString();
                        String strNum= num.getText().toString();
                        String strAge= age.getText().toString();
                        String strBudget= budget.getText().toString();
                        String strDates= dates.getText().toString();
                        String strEmail= email.getText().toString();

                    }

                    })



        ;}
}


