package com.example.hirokishinoda.mazusearchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MazeSearch extends AppCompatActivity implements BottonTypesDefine{
    GameSurfaceView gsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mazu_search);

        SurfaceView sv = findViewById(R.id.SV);
        gsv = new GameSurfaceView(this,sv);

        buttonEvents();
    }

    private void buttonEvents(){
        Button right_b = findViewById(R.id.button_right);
        Button left_b = findViewById(R.id.button_left);
        Button up_b = findViewById(R.id.button_up);
        Button down_b = findViewById(R.id.button_down);

        right_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsv.touchButton(RIGHT_B);
            }
        });

        left_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsv.touchButton(LEFT_B);
            }
        });

        up_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsv.touchButton(UP_B);
            }
        });

        down_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsv.touchButton(DOWN_B);
            }
        });
    }
}

