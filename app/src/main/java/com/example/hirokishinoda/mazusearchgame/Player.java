package com.example.hirokishinoda.mazusearchgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player extends Character{
    MazeMap map;

    public Player(){
        super();
        character_x = 0;
        character_y = 0 ;
    }

    @Override
    public void move(int x,int y) {
                character_x += x;
                character_y += y;
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);

        paint.setAntiAlias(true);
        c.drawCircle((float)(character_x * RECTSIZE + RADIUS + OFFSETX), (float)(character_y * RECTSIZE + RADIUS + OFFSETY), (float)RADIUS, paint);
    }

    public void setCharacterPoint(int x,int y){
        character_x = x;
        character_y = y;
    }
}
