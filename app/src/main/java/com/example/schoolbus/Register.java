package com.example.schoolbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.sql.Timestamp;

public class Register extends AppCompatActivity {

    private Button btnRegister;
    private EditText edtFirstName, edtLastName,edtTel, edtUsername, edtPassword;

    ArrayAdapter userArrayAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtTel = findViewById(R.id.edtTel);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        database = new Database(Register.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //openLogin();

                UserModel userModel;

                try {
                    userModel = new UserModel(-1, edtFirstName.getText().toString(), edtLastName.getText().toString(), edtTel.getText().toString(), edtUsername.getText().toString(), edtPassword.getText().toString(), "0000");
                    Toast.makeText(Register.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Register.this, "error", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", "error", "error", "error", "error", "error");
                }

                Database database = new Database(Register.this);

                boolean success = database.addOne(userModel);
            }
        });
    }

//    public void openLogin(){
//        Intent intent = new Intent(this, Home.class);
//        startActivity(intent);
//    }
}