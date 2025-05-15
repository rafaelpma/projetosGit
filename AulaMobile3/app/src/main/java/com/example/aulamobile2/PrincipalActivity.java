package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    private Button btAllocation = null;
    private Button btProfessor = null;
    private Button btCourse = null;
    private Button btDepartment = null;

    private Intent telaAllocation;
    private Intent telaProfessor;
    private Intent telaCourse;
    private Intent telaDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btAllocation = findViewById(R.id.btAllocation);
        btProfessor = findViewById(R.id.btProfessor);
        btCourse = findViewById(R.id.btCourse);
        btDepartment = findViewById(R.id.btDepartment);


        btAllocation.setOnClickListener(b -> {
            telaAllocation = new Intent(this, AllocationActivity.class);
            startActivity(telaAllocation);
        });

        btProfessor.setOnClickListener(b -> {
            telaProfessor = new Intent(this, ProfessorActivity.class);
            startActivity(telaProfessor);
        });

        btCourse.setOnClickListener(b -> {
            telaCourse = new Intent(this, CourseActivity.class);
            startActivity(telaCourse);
        });

        btDepartment.setOnClickListener(b -> {
            telaDepartment = new Intent(this, DepartmentActivity.class);
            startActivity(telaDepartment);
        });


    }
}