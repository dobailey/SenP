package com.dbailey.sp_spacespacego;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ObstacleSprite {

    private Bitmap image;
    public int x, y;
    private int cnt, cnt1, cnt2 = 0;
    private int xVelocity = 10;
    private double yVelocity = 9;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public ObstacleSprite (Bitmap bmp, int lr, int ud) {
        image = bmp;
        x = lr;
        y = ud;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);

    }

    public void update() {

       /*x += xVelocity;*/
       y += yVelocity;
       /*if ((x > screenWidth - image.getWidth()) || (x < 0)) {
           xVelocity = xVelocity*-1;
       }*/
       if (CharacterSprite.GetCurY() > 0) { // if obs will be in the same area as ship (to increase efficiency)
           if ((y >= screenHeight - (CharacterSprite.GetImg().getHeight() * 3) - (image.getHeight()))) {
               if (y <= screenHeight - (CharacterSprite.GetImg().getHeight() * 2)) {
                   HitDet();
               }
           }
       }

       /* WHEN OBSTACLES REACHES BOTTOM OF SCREEN */
       if (y > screenHeight - image.getHeight()) {
           /*yVelocity = yVelocity*-1;*/

           /* CASE STATEMENT FOR MORE VARIABLE SPEED INCREASE??? */

           y = 0;
           cnt++;
           if (cnt >= 6) {
               yVelocity += .4;
               cnt = 0;
           }
       }

    }


    public void HitDet() {
        /* TEST HIT DETECTION */
        if (CollisionDetect.CollisionDetected(image, CharacterSprite.GetImg(), x, y, CharacterSprite.GetCurX(), CharacterSprite.GetCurY())){
            yVelocity = 0;
        }
    }

}


