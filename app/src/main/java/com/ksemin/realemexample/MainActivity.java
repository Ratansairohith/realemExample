package com.ksemin.realemexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isfirstrun = getSharedPreferences("preferences",MODE_PRIVATE).getBoolean("isfirstrun",true);
        if (isfirstrun){
            Toast.makeText(MainActivity.this,"First run",Toast.LENGTH_LONG).show();
            getSharedPreferences("preferences",MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
        }

        add = (Button)findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddData.class);
                startActivity(i);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ShowData.class);
                startActivity(i);
            }
        });
    }
}
