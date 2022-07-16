package com.appank.fromlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class halaman_user extends AppCompatActivity {
    TextView username;
    Button add,delet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_user);
        Bundle extras1 = getIntent().getExtras();
        String intent = extras1.getString("userkey1");
        username = (TextView) findViewById(R.id.username);
        username.setText(intent);

    }
    /*
    Terimakasi Telah  Mampir di www.appank.com
    tetap belajar salam coding teman-teman
     */
}