package com.example.schoolbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminHome extends AppCompatActivity {

    private RecyclerView studentRecView2;

    ArrayAdapter studentArrayAdapter;
    Database database;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        studentRecView2 = findViewById(R.id.studentRecView2);

        database = new Database(AdminHome.this);

        ArrayList<StudentRecModel> studentRecModels = new ArrayList<StudentRecModel>(database.getAllStudentRec());

        StudentRecViewAdapter adapter = new StudentRecViewAdapter(this);
        adapter.setStudentRecModels(studentRecModels);

        studentRecView2.setAdapter(adapter);
        studentRecView2.setLayoutManager(new LinearLayoutManager(this));

        sessionManager = new SessionManager(getApplicationContext());


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
            case R.id.menu_logout:
                logout();
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

    public void logout(){
        sessionManager.setLogin(0);
        sessionManager.setUsername("");
        sessionManager.setUserId(0);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}