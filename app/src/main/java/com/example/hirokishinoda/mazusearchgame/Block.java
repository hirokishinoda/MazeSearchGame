package com.example.hirokishinoda.mazusearchgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Block {
    private static final int RECTSIZE = 25;
    private static final int OFFSETX = 25;
    private static final int OFFSETY = 110;
    private Paint paint = new Paint();
    private blockType type;

    public enum blockType{
        START,
        GOAL,
        EMPTY,
        WALL
    }

    public Block(){
        type = blockType.EMPTY;
    }

    public void onDraw(Canvas c,int x,int y){
        switch(type){
            case START:
                paint.setColor(Color.YELLOW);
                break;
            case GOAL:
                paint.setColor(Color.BLUE);
                break;
            case EMPTY:
                paint.setColor(Color.GRAY);
                break;
            case WALL:
                paint.setColor(Color.BLACK);
                break;
        }
        paint.setStyle(Paint.Style.FILL);
        c.drawRect(x * RECTSIZE + OFFSETX,y * RECTSIZE + OFFSETY,x * RECTSIZE + RECTSIZE + OFFSETX,y * RECTSIZE + RECTSIZE + OFFSETY,paint);
    }

    public void setType(blockType type){
        this.type = type;
    }

    public blockType getType(){
        return this.type;
    }
}
