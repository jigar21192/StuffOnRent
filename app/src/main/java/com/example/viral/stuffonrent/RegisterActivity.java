package com.example.viral.stuffonrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText et_fname;
    EditText et_lname;
    EditText et_adrs;
    EditText et_cont;
    EditText et_emailid;
    EditText et_password;
    EditText et_conpassword;

    Button register;

    String fname;
    String lname;
    String adrs;
    String cont;
    String emailid;
    String password;
    String con_password;

    Matcher first_name;
    Matcher last_name;

    boolean f_name;
    boolean l_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");

        register=findViewById(R.id.register);
        et_fname=findViewById(R.id.et_fname);
        et_lname=findViewById(R.id.et_lname);
        et_adrs= findViewById(R.id.et_adrs);
        et_cont=findViewById(R.id.et_cont);
        et_emailid=findViewById(R.id.et_emailid);
        et_password=findViewById(R.id.et_password);
        et_conpassword=findViewById(R.id.et_conpassword);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = et_fname.getText().toString();
                lname = et_lname.getText().toString();
                emailid = et_emailid.getText().toString();
                adrs = et_adrs.getText().toString();
                cont = et_cont.getText().toString();
                password=et_password.getText().toString();
                con_password=et_conpassword.getText().toString();

                Pattern ps1 = Pattern.compile("^[a-zA-Z ]+$");

                first_name = ps1.matcher(et_fname.getText().toString());
                f_name = first_name.matches();

                Pattern ps2 = Pattern.compile("^[a-zA-Z ]+$");

                last_name = ps2.matcher(et_lname.getText().toString());
                l_name = last_name.matches();


                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter First Name.", Toast.LENGTH_LONG).show();
                }
                else if (f_name == false) {
                    Toast.makeText(RegisterActivity.this, "Only Text allowed In First Name.", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(lname)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Last Name.", Toast.LENGTH_LONG).show();
                }
                else if (l_name == false) {
                    Toast.makeText(RegisterActivity.this, "Only Text allowed In Last Name.", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(adrs)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Address.", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(cont)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Mobile Number.", Toast.LENGTH_LONG).show();
                }
                else if (cont.length() != 10) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Correct Mobile Number.", Toast.LENGTH_LONG).show();
                }
                else if (!emailid.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Password.", Toast.LENGTH_LONG).show();
                }
                else if (password.length() < 5) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Minimum 5 Digits password.", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(con_password)) {
                    Toast.makeText(RegisterActivity.this, "Please Confirm Password.", Toast.LENGTH_LONG).show();
                }
                else if (!password.equals(con_password)) {
                    Toast.makeText(RegisterActivity.this, "Please Confirm Password.", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent l = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(l);
                    Toast.makeText(RegisterActivity.this, "Register Successfully." + fname, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
