package com.boardsound.boardsound;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileDescriptor;

import static com.boardsound.boardsound.R.raw.ffviivictory;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnTest = findViewById(R.id.btnTest);
        Button btnStop = findViewById(R.id.btnStop);




        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mPlayer = MediaPlayer.create(MainActivity.this, R.raw.ffviivictory);
                    mPlayer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPlayer.stop();
                mPlayer.release();
            }
        });


    }
}
