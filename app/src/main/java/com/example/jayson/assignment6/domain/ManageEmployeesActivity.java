package com.example.jayson.assignment6.domain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.jayson.assignment6.R;

public class ManageEmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employees);
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

        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), MenuActivity.class);
                        ManageEmployeesActivity.this.startActivity(i);
                    }
                }
        );

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), SecondActivity.class);
                        ManageEmployeesActivity.this.startActivity(i);
                    }
                }
        );

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), SecondActivity.class);
                        ManageEmployeesActivity.this.startActivity(i);
                    }
                }
        );
    }

}
