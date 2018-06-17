package com.example.hirokishinoda.mazusearchgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    Thread thread;

    public GameSurfaceView(Context context){
        super(context);
        getHolder().addCallback(this);
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
            draw(getHolder());
        }
    }

    private void draw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();
        if(c == null) return;

        holder.unlockCanvasAndPost(c);
    }
}
