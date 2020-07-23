package com.example.threadpractices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toThreadBtn = findViewById(R.id.btn_to_thread);
        toThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toThreadPage();
            }
        });
    }

    private void toThreadPage() {
        Intent intent = new Intent(this, ThreadActivity.class);
        startActivity(intent);
    }
}