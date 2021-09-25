package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editId;
    EditText editPwd;

    AppCompatButton btnLogin;
    AppCompatButton btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = findViewById(R.id.edit_id);
        editPwd = findViewById(R.id.edit_pwd);

        btnLogin = findViewById(R.id.btn_login);
        btnJoin = findViewById(R.id.btn_join);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "회원가입 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void goLogin() {

        String id = "BF";
        String pwd = "18";


        if (editId.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (editPwd.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (editId.getText().toString().equals(id) && editPwd.getText().toString().equals(pwd)) {


            Intent intent;
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
        }
    }
}