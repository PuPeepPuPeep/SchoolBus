package com.example.schoolbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button btnTransport;
    private Button btnDriver;
    private Button btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTransport = (Button) findViewById(R.id.btnTransport);
        btnDriver = (Button) findViewById(R.id.btnDriver);
        btnStudent = (Button) findViewById(R.id.btnStudent);

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransport();
            }
        });

        btnDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDriver();
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstudent();
            }
        });
    }

    public void openTransport(){
        Intent intent = new Intent(this, Transport.class);
        startActivity(intent);
    }

    public void openDriver(){
        Intent intent = new Intent(this, Driver.class);
        startActivity(intent);
    }

    public void openstudent(){
        Intent intent = new Intent(this, student.class);
        startActivity(intent);
    }
}