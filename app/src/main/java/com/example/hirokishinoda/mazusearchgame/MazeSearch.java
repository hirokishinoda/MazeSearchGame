package com.example.hirokishinoda.mazusearchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MazeSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameSurfaceView(this));
    }
}
