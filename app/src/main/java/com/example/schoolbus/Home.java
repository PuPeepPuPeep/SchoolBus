package com.example.schoolbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

//    private Button btnTransport;
//    private Button btnDriver;
//    private Button btnStudent;
//    private Button btnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        btnTransport = (Button) findViewById(R.id.btnTransport);
//        btnDriver = (Button) findViewById(R.id.btnDriver);
//        btnStudent = (Button) findViewById(R.id.btnStudent);
//        btnPayment = (Button) findViewById(R.id.btnPayment);
//
//        btnTransport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openTransport();
//            }
//        });
//
//        btnDriver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDriver();
//            }
//        });
//
//        btnStudent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openstudent();
//            }
//        });
//
//        btnPayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPayment();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                openHome();
                break;
            case R.id.menu_transport:
                openTransport();
                break;
            case R.id.menu_student:
                openstudent();
                break;
            case R.id.menu_payment:
                openPayment();
                break;
            case R.id.menu_driver:
                openDriver();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void openHome(){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
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

    public void openPayment(){
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);
    }
}