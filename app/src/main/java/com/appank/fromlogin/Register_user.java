package com.appank.fromlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_user extends AppCompatActivity {
    EditText mTextUsername,mTextPassword,mTextCnfPassword, txt_namalengkap;
    Button add,close;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
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
                if ( pwd.equals(cnf_pwd)) {
                    long val = db.tambahUser(user, pwd);
                    if (val > 0) {
                        Toast.makeText(Register_user.this, "Anda Berhasil menambahkan user "+nama, Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Register_user.this, "Anda gagal Registrasi user" + nama, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Register_user.this,"Password tidak sama",Toast.LENGTH_SHORT).show();
                }
                if (nama.equals("") || user.equals("") || pwd.equals("")) {
                    Toast.makeText(Register_user.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}