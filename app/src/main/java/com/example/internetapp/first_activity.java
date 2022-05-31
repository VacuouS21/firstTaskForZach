package com.example.internetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class first_activity extends AppCompatActivity {
    EditText URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        URL=findViewById(R.id.name);
    }
    public void myButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
// передача объекта с ключом "hello" и значением "Hello World"
        intent.putExtra("hello",URL.getText().toString());
// запуск SecondActivity
        startActivity(intent);
    }
}