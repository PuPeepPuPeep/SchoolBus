package com.example.schoolbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnToRegister;
    private Database database;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnToRegister = (Button) findViewById(R.id.btnToRegister);
        database = new Database(this);

        sessionManager = new SessionManager(getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = edtUsername.getText().toString();
                String Password = edtPassword.getText().toString();


                if (Password.equals("")){
                    edtUsername.setError("Please enter Username and Password");
                    edtPassword.setError("Please enter Username and Password");
                }
                else {
                    Boolean checkUsernamePassword = database.checkUsernamePassword(Username, Password);
                    if (checkUsernamePassword==true){

                        sessionManager.setLogin(true);
                        sessionManager.setUsername(Username);

                        int UserId = database.checkUserId(Username);

                        sessionManager.setUserId(UserId);

                        Toast.makeText(MainActivity.this, Integer.toString(sessionManager.getUserId()), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }

//                openLogin();
            }
        });

        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        if (sessionManager.getLogin()){
            startActivity(new Intent(getApplicationContext(),
                    Home.class));
        }
    }

//    public void openLogin(){
//        Intent intent = new Intent(this, Home.class);
//        startActivity(intent);
//    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}