package com.example.hirokishinoda.mazusearchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;

public class MazeSearch extends AppCompatActivity {
    private GameSurfaceView gsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mazu_search);

        SurfaceView sv = (SurfaceView)findViewById(R.id.SV);
        gsv = new GameSurfaceView(this,sv);

        Button right_button = (Button)findViewById(R.id.button_right);

        Button left_button = (Button)findViewById(R.id.button_left);
        Button up_button = (Button)findViewById(R.id.button_up);
        Button down_button = (Button)findViewById(R.id.button_down);
    }
}
