package com.example.schoolbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private RecyclerView studentRecView;
    private ListView studentListView;

    ArrayAdapter studentArrayAdapter;
    Database database;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        studentRecView = findViewById(R.id.studentRecView);
//        studentListView = findViewById(R.id.studentListView);

        database = new Database(Home.this);

        ArrayList<StudentRecModel> studentRecModels = new ArrayList<StudentRecModel>(database.getStudentRec());
//        studentRecModels.add(new StudentRecModel("JJ","JJ", "https://images.pexels.com/photos/1804035/pexels-photo-1804035.jpeg"));

        StudentRecViewAdapter adapter = new StudentRecViewAdapter(this);
        adapter.setStudentRecModels(studentRecModels);

        studentRecView.setAdapter(adapter);
        studentRecView.setLayoutManager(new LinearLayoutManager(this));
//        ShowStudentOnListView(database);

        sessionManager = new SessionManager(getApplicationContext());

    }

//    private void ShowStudentOnListView(Database database) {
//        studentArrayAdapter = new ArrayAdapter<StudentModel>(Home.this, android.R.layout.simple_list_item_1, database.getStudent());
//        studentRecView.setAdapter(studentArrayAdapter);
//        studentListView.setAdapter(studentArrayAdapter);
//    }

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
        sessionManager.setLogin(false);
        sessionManager.setUsername("");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}