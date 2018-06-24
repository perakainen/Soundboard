package com.boardsound.boardsound;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.FileDescriptor;

import static com.boardsound.boardsound.R.raw.ffviivictory;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnTest = findViewById(R.id.btnTest);
        final Button btnTest2 = findViewById(R.id.btnTest2);
        Button btnStop = findViewById(R.id.btnStop);
        final ViewGroup layout = (ViewGroup)btnTest.getParent();




        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    mPlayer = MediaPlayer.create(MainActivity.this, R.raw.ffviivictory);
                    mPlayer.start();

            }
        });

        btnTest.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnTest);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.remove:
                                if(layout != null){
                                    layout.removeView(btnTest);
                                }
                                return true;

                            case R.id.toast:
                                Toast.makeText(MainActivity.this, "Test Toast", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return true;
                    }
                });

                popupMenu.show();
                return true;
            }
        });

        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.moi);
                mPlayer.start();
            }
        });

        btnTest2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnTest2);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.remove:
                                if(layout != null){
                                    layout.removeView(btnTest2);
                                }
                                return true;

                            case R.id.toast:
                                Toast.makeText(MainActivity.this, "Test Toast", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return true;
                    }
                });

                popupMenu.show();
                return true;
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {

                    mPlayer.stop();

                    mPlayer.release();

                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "No sound found", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) mPlayer.release();
    }
}


