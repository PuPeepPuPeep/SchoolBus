package com.example.schoolbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class student extends AppCompatActivity {

    private TextView txtUserId;
    private Button btnAddStu;
    private EditText edtStuFirstname, edtStuLastname, edtStuSchool, edtStuAddress;

    SessionManager sessionManager;

    ArrayAdapter studentArrayAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        txtUserId = findViewById(R.id.txtUserId);

        sessionManager = new SessionManager(getApplicationContext());

        int userId = sessionManager.getUserId();
        txtUserId.setText(Integer.toString(userId));

        btnAddStu = (Button) findViewById(R.id.btnAddStu);
        edtStuFirstname = findViewById(R.id.edtStuFirstname);
        edtStuLastname = findViewById(R.id.edtStuLastname);
        edtStuSchool = findViewById(R.id.edtStuSchool);
        edtStuAddress = findViewById(R.id.edtStuAddress);

        database = new Database(student.this);

        btnAddStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentModel studentModel;

                try{
                    studentModel = new StudentModel(-1, edtStuFirstname.getText().toString(), edtStuLastname.getText().toString(), "0000", edtStuAddress.getText().toString(), edtStuSchool.getText().toString(), userId, "0000");
                    Toast.makeText(student.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(student.this, "Error", Toast.LENGTH_SHORT).show();
                    studentModel = new StudentModel(-1,"error", "error", "error", "error", "error", 0, "error");
                }

                Database database = new Database(student.this);

                boolean success = database.addOne(studentModel);
            }
        });
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