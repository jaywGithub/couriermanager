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
import android.widget.Toast;

import com.example.jayson.assignment6.R;
import com.example.jayson.assignment6.repository.employeerepository.employee.Impl.EmployeeRepositoryImpl;

public class PreviewActivity extends AppCompatActivity {

    EmployeeRepositoryImpl emp;
    TextView textView;
    TextView textView2;
    TextView textView3;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
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

        /*emp = new EmployeeRepositoryImpl(this);

        textView3 = (TextView) findViewById(R.id.txtLicense);
        textView = (TextView) findViewById(R.id.txtName);
        textView2 = (TextView) findViewById(R.id.txtSurname);


        Intent intent = getIntent();
        String lastName = intent.getStringExtra("lastName");
        String firstName = intent.getStringExtra("firstName");
        String license = intent.getStringExtra("license");

        textView.setText("Name: " + firstName);
        textView2.setText("Surname: " + lastName);
        textView3.setText("License: " + license);*/

        //UploadData();

    }

    /*public void UploadData()
    {
        Button btn = (Button) findViewById(R.id.btnPreview);
        btn.setOnClickListener(
                new Button.OnClickListener()

        {
            public void onClick (View view)
            {
                assert btnSubmit != null;
                btnSubmit.setOnClickListener(
                        new View.OnClickListener()
                        {
                            Intent intent = new Intent (getApplicationContext(), DisplayActivity.class);
                            @Override
                            public void onClick(View v) {
                                boolean isInserted = emp.save(
                                        textView3.getText().toString(),
                                        textView2.getText().toString(),
                                        textView.getText().toString());
                                if(isInserted == true)
                                {
                                    Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_LONG).show();
                            }
                        }
                );
    }*/

}
