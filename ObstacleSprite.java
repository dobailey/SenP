package com.dbailey.sp_spacespacego;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import static com.dbailey.sp_spacespacego.GameView.contextX;


public class ObstacleSprite {

    private Bitmap image;
    private int x, y;
    private int cnt = 0;
    private double xVelocity = 0;
    private double yVelocity;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public ObstacleSprite (Bitmap bmp, int lr, int ud, double spd) {
        image = bmp;
        x = lr;
        y = ud;
        yVelocity = spd;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {

       y += yVelocity;

       // if obs will be in same x zone
       if ((x >= CharacterSprite.GetCurX() - image.getWidth() && (x <= (CharacterSprite.GetCurX() + CharacterSprite.GetImg().getWidth())))) {
           // if obs will be in same y zone
           if ((y >= screenHeight - (CharacterSprite.GetImg().getHeight() * 3) - (image.getHeight())) && (y <= screenHeight - (CharacterSprite.GetImg().getHeight() * 2))) {
                   HitDet();
           }
       } // greatly increased efficiency and eliminated lag

       /* WHEN OBSTACLES REACHES BOTTOM OF SCREEN */
       if (y > screenHeight - image.getHeight()) {
           /*yVelocity = yVelocity*-1;*/

           /* CASE STATEMENT FOR MORE VARIABLE SPEED INCREASE???
           *  DELETE OBS AND CREATE NEW??? */

           switch (cnt){
               case 6 : // cnt reaches 6
                   // do something
                   cnt++;
                   break;

               default :
                   // do something
                   break;
           }


           y = 0;  // moves obstacle to top of screen to begin falling again
           cnt++;
           if (cnt >= 6) {
               yVelocity += .4;
               cnt = 0;
           }
       }
    }

    private void HitDet() {
        /* TEST HIT DETECTION */
        if (CollisionDetect.CollisionDetected(image, CharacterSprite.GetImg(), x, y, CharacterSprite.GetCurX(), CharacterSprite.GetCurY())){
            yVelocity = 0;
            // DO SOMETHING WHEN USER HITS OBSTACLE

            // BRING UP DEATH SCREEN
        }
    }

    private void increaseSpeed() {
        yVelocity += 1;
    }


}