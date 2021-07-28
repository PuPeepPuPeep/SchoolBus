package com.example.schoolbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button btnTransport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTransport = (Button) findViewById(R.id.btnTransport);

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransport();
            }
        });
    }

    public void openTransport(){
        Intent intent = new Intent(this, Transport.class);
        startActivity(intent);
    }
}