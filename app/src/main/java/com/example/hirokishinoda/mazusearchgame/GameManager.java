package com.example.hirokishinoda.mazusearchgame;

import android.graphics.Canvas;
import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameManager {
        Player player;
        Stage stage;
        //private int stage_level;

        GameManager(){
            player = new Player();
            stage = new Stage(player,0);
        }

        public boolean onUpdate(int x,int y) {
            stage.onUpdate();
            return true;
        }

        public void onDraw(Canvas c) {
            c.drawColor(Color.WHITE);       //白で塗りつぶす
            stage.onDraw(c);
        }
}
