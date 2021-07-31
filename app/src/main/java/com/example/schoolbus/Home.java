package com.example.schoolbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private RecyclerView studentRecView;

    ArrayAdapter studentArrayAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        studentRecView = findViewById(R.id.studentRecView);

        database = new Database(Home.this);

//        ShowStudentOnRecView(database);


    }

//    private void ShowStudentOnRecView(Database database) {
//        studentArrayAdapter = new ArrayAdapter<StudentModel>(Home.this, R.layout.student_list_item, database.getStudent());
//        studentRecView.setAdapter(studentArrayAdapter);
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