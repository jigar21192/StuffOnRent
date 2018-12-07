package com.example.viral.stuffonrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_emailid;
    EditText et_password;

    TextView txt_crtacc;

    String emailid;
    String password;

    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        et_emailid = findViewById(R.id.et_emailid);
        et_password = findViewById(R.id.et_password);
        txt_crtacc = findViewById(R.id.txt_crtacc);
        login = findViewById(R.id.login);

        txt_crtacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent l = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(l);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailid = et_emailid.getText().toString();
                password=et_password.getText().toString();

                if (!emailid.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                    Toast.makeText(LoginActivity.this, "Please Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Password.", Toast.LENGTH_LONG).show();
                }

                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);

            }
        });
    }
}
