package com.dbailey.sp_spacespacego;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ObstacleSprite {

    private Bitmap image;
    private int x, y;
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

            /* WHEN OBSTACLES REACHES BOTTOM OF SCREEN */
            if (y > screenHeight - image.getHeight()) {
                /*yVelocity = yVelocity*-1;*/

                /* CASE STATEMENT FOR MORE VARIABLE SPEED INCREASE??? */

                y = 0;
                cnt++;
                if (cnt >= 2) {
                    yVelocity += .4;
                    x = 575;
                    cnt = 0;
                }
            }

    }

    public void update1() {

        /*x += xVelocity;*/
        y += yVelocity;
            /*if ((x > screenWidth - image.getWidth()) || (x < 0)) {
                xVelocity = xVelocity*-1;
            }*/

        /* WHEN OBSTACLES REACHES BOTTOM OF SCREEN */
        if (y > screenHeight - image.getHeight()) {
            /*yVelocity = yVelocity*-1;*/

            y = 0;
            cnt1++;
            if (cnt1 >= 2) {
                x = 100;
                yVelocity += .5;
                cnt1 = 0;
            }
        }

    }

    public void update2() {

        /*x += xVelocity;*/
        y += yVelocity;
            /*if ((x > screenWidth - image.getWidth()) || (x < 0)) {
                xVelocity = xVelocity*-1;
            }*/

        /* WHEN OBSTACLES REACHES BOTTOM OF SCREEN */
        if (y > screenHeight - image.getHeight()) {
            /*yVelocity = yVelocity*-1;*/

            y = 0;
            cnt2++;
            if (cnt2 >= 2) {
                x = 425;
                yVelocity += .45;
                cnt2 = 0;
            }
        }

    }


}


