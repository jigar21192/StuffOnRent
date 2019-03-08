package com.example.viral.stuffonrent;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText et_emailid;
    EditText et_password;

    ProgressDialog pd;

    TextView txt_crtacc;

    String emailid;
    String password;
    String url="https://chauhanviral36.000webhostapp.com/login.php";

    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        pd=new ProgressDialog(LoginActivity.this);
        pd.setMessage("Loading");
        pd.setCancelable(false);

        et_emailid = findViewById(R.id.et_emailid);
        et_password = findViewById(R.id.et_password);
        txt_crtacc = findViewById(R.id.txt_crtacc);
        login = findViewById(R.id.login);

        txt_crtacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent l = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(l);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd.show();

                emailid = et_emailid.getText().toString();
                password = et_password.getText().toString();

                if (!emailid.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {

                    pd.dismiss();
                    Toast.makeText(LoginActivity.this, "Please Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password)) {

                    pd.dismiss();
                    Toast.makeText(LoginActivity.this, "Please Enter Password.", Toast.LENGTH_LONG).show();
                }
                else {

                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.trim().equals("success")) {

                                pd.dismiss();
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else {

                                pd.dismiss();
                                Toast.makeText(LoginActivity.this, "Please Enter Correct E-mail Id or Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Connection Problem", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<>();
                            param.put("email", emailid);
                            param.put("password", password);
                            return param;
                        }
                    };

                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(request);

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        LoginActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
