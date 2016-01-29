package com.hermes.hermes;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        final Button musicBtn, sportBtn, artBtn, filmBtn, festiBtn, danceBtn, otherBtn;
        musicBtn = (Button) findViewById(R.id.music_btn);
        sportBtn = (Button) findViewById(R.id.sports_btn);
        artBtn = (Button) findViewById(R.id.art_btn);
        filmBtn = (Button) findViewById(R.id.films_btn);
        festiBtn = (Button) findViewById(R.id.festi_btn);
        danceBtn = (Button) findViewById(R.id.dance_btn);
        otherBtn = (Button) findViewById(R.id.other_btn);
        Button btn = new Button(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch(v.getId()){
                    case R.id.art_btn:
                        intent = new Intent(MainActivity.this,oneOption.class);
                        intent.putExtra("type","festi");
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.other_btn:
                        intent = new Intent(MainActivity.this,oneOption.class);
                        intent.putExtra("type","festi");
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.dance_btn:
                        intent = new Intent(MainActivity.this,oneOption.class);
                        intent.putExtra("type","festi");
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.festi_btn:
                        intent = new Intent(MainActivity.this,oneOption.class);
                        intent.putExtra("type", "festi");
                        MainActivity.this.startActivity(intent);
                        break;
                }
            }
        });
        //Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        //MainActivity.this.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
