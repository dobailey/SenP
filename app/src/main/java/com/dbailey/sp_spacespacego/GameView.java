package com.dbailey.sp_spacespacego;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private CharacterSprite characterSprite;
    private ObstacleSprite obstacle1, obstacle2, obstacle3;
    private float previousX;
    private float previousY;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - previousX;
                float dy = y - previousY;
/*
                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }
*/
                characterSprite.Move(dx, dy);
        }

        previousX = x;
        previousY = y;
        return true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.ship));
        obstacle1 = new ObstacleSprite(BitmapFactory.decodeResource(getResources(),R.drawable.obs1), 100, 0);
        obstacle2 = new ObstacleSprite(BitmapFactory.decodeResource(getResources(),R.drawable.obs2), 425, 200);
        obstacle3 = new ObstacleSprite(BitmapFactory.decodeResource(getResources(),R.drawable.obs3), 575, 100);


        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
        retry = false;
        }
    }

    public void update() {
        characterSprite.update();
        obstacle1.update();
        obstacle2.update1();
        obstacle3.update2();
    }

    @Override
    public void draw(Canvas canvas)
    {

        super.draw(canvas);
        if(canvas!=null) {
            characterSprite.draw(canvas);
            obstacle1.draw(canvas);
            obstacle2.draw(canvas);
            obstacle3.draw(canvas);
        }
    }


}






