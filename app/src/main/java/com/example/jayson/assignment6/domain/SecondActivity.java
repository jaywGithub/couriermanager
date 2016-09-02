package com.example.jayson.assignment6.domain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jayson.assignment6.R;

public class SecondActivity extends AppCompatActivity {

    private  EditText name;
    private  EditText surname;
    private EditText license;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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

        name = (EditText) findViewById(R.id.txtName);
        surname = (EditText) findViewById(R.id.txtSurname);
        license = (EditText) findViewById(R.id.txtLicense);

        Button btn = (Button) findViewById(R.id.btnPreview);
        btn.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), PreviewActivity.class);
                        i.putExtra("name", name.getText().toString());
                        i.putExtra("surname", surname.getText().toString());
                        i.putExtra("license", license.getText().toString());
                        SecondActivity.this.startActivity(i);
                    }
                }
        );

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent i = new Intent(view.getContext(), ManageEmployeesActivity.class);

                        SecondActivity.this.startActivity(i);
                    }
                }
        );

    }

}
