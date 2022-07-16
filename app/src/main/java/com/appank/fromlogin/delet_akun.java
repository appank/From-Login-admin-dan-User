package com.appank.fromlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delet_akun extends AppCompatActivity {
    EditText mTextUsername,mTextPassword,mTextCnfPassword, txt_namalengkap;
    Button add,close;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delet_akun);
        db= new DatabaseHelper(this);
        txt_namalengkap= findViewById(R.id.edittext_nama);
        mTextUsername= findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = findViewById(R.id.edittext_cinfir_pasword);
        add = (Button)findViewById(R.id.add);
        close=(Button)findViewById(R.id.exit);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =mTextUsername.getText().toString().trim();
                String pwd =mTextPassword.getText().toString().trim();
                String cnf_pwd =mTextCnfPassword.getText().toString().trim();
                String nama = txt_namalengkap.getText().toString().trim();
                Boolean res = db.delet(user,pwd);
                if(res == false)
                {
                    Toast.makeText(delet_akun.this, "Berhasil Menghapus User  "+nama, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(delet_akun.this, "Gagal Menghapus User  "+nama, Toast.LENGTH_SHORT).show();
                }
                if (nama.equals("") || user.equals("") || pwd.equals("")|| cnf_pwd.equals("")) {
                    Toast.makeText(delet_akun.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}