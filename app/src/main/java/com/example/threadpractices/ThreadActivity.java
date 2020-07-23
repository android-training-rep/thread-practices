package com.example.threadpractices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class ThreadActivity extends AppCompatActivity {

    Button startThreadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        startThreadBtn = findViewById(R.id.btn_start_thread);
        startThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startThread();
            }
        });
    }

    private void startThread() {
        new Thread(new Runnable() {
            public void run() {
                // a potentially time consuming task
                int count = 0;

                while(count < 10) {
                    SystemClock.sleep(1000);
                    count++;
                    final int finalCount = count;
                    startThreadBtn.post(new Runnable() {
                        public void run() {
                            startThreadBtn.setEnabled(false);
                            startThreadBtn.setText(""+finalCount);
                            if(finalCount == 10 ){
                                startThreadBtn.setEnabled(true);
                            }
                        }
                    });
                }
            }
        }).start();
    }
}
