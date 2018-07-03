package com.example.hirokishinoda.mazusearchgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView  implements SurfaceHolder.Callback,Runnable,BottonTypesDefine{
    private GameManager gm = new GameManager();
    private Thread thread;
    private SurfaceView sv;

    public GameSurfaceView(Context context,SurfaceView sv) {
        this.sv = sv;
        sv.getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        thread = null;
    }

    @Override
    public void run() {
        while(thread != null){
            gm.onUpdate();
            draw(sv.getHolder());
        }
    }

    public void touchButton(int botton_type){
        switch (botton_type){
            case RIGHT_B:
                gm.stage.move(1,0);
                break;
            case LEFT_B:
                gm.stage.move(-1,0);
                break;
            case UP_B:
                gm.stage.move(0,-1);
                break;
            case DOWN_B:
                gm.stage.move(0,1);
                break;
        }

    }

    private void draw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();
        if(c == null) return;
        gm.onDraw(c);
        holder.unlockCanvasAndPost(c);
    }
}
