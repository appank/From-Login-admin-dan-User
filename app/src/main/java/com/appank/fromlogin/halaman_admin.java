package com.appank.fromlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class halaman_admin extends AppCompatActivity {
    TextView username;
    Button add,delet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_admin);
        Bundle extras1 = getIntent().getExtras();
        String intent = extras1.getString("yourkey1");
        username = (TextView) findViewById(R.id.username);
        username.setText(intent);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(halaman_admin. this, Register_user .class);
                startActivity(intent);
            }
        });
        delet = (Button) findViewById(R.id.delet);
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(halaman_admin. this, delet_akun .class);
                startActivity(intent);
            }
        });
    }

}