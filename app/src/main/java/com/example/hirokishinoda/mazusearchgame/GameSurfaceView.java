package com.example.hirokishinoda.mazusearchgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView  implements SurfaceHolder.Callback,Runnable{
    private GameManager gm = new GameManager();
    private SurfaceView surfaceView;
    private Thread thread;

    public GameSurfaceView(Context context,SurfaceView sv){
        surfaceView = sv;
        surfaceView.getHolder().addCallback(this);
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
            draw(surfaceView.getHolder());
        }
    }

    private void draw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();
        if(c == null) return;
        gm.onDraw(c);
        holder.unlockCanvasAndPost(c);
    }
}
