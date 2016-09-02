package com.example.jayson.assignment6.domain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jayson.assignment6.R;
import com.example.jayson.assignment6.repository.employeerepository.employee.Impl.EmployeeRepositoryImpl;

public class DisplayActivity extends AppCompatActivity {

    EmployeeRepositoryImpl employeeRepository;
    private EditText editText;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        editText = (EditText) findViewById(R.id.txtName);
        editText1 = (EditText) findViewById(R.id.txtSurname);
        editText2 = (EditText) findViewById(R.id.txtLicense);

        Button btn = (Button) findViewById(R.id.btnContinue);
        btn.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), MainActivity.class);
                        DisplayActivity.this.startActivity(i);
                    }
                }
        );
    }

}
