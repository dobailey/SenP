package com.dbailey.sp_spacespacego;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {

    private static Bitmap image;
    private static int x, y;
    private final float TOUCH_SCALE_FACTOR = 180.0f / 80;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public static int GetCurX(){
        return x;
    }

    public static int GetCurY(){
        return y;
    }

    public CharacterSprite (Bitmap bmp) {
        image = bmp;
        x = screenWidth/2 - image.getWidth()/2;
        y = screenHeight - (image.getHeight()*3);
    }

    public void Move(float dx, float dy){
        x += dx * TOUCH_SCALE_FACTOR;
        /*y += dy;*/
    }

    public void draw(Canvas canvas) {
       canvas.drawBitmap(image, x, y, null);

    }

    public void update() {
       if (x > screenWidth - image.getWidth()) {
           x = screenWidth - image.getWidth();
       }
       if (x < 0) {
           x = 0;
       }
    }

    public static Bitmap GetImg(){
        return image;
    }
}