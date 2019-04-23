package com.dbailey.sp_spacespacego;

import android.graphics.Bitmap;

public class CollisionDetect {

    private static Bitmap image1, image2;
    private static float x1, y1, x2, y2;

    public static boolean CollisionDetected (Bitmap bmp1, Bitmap ship, float X1, float Y1, float X2, float Y2) {
        image1 = bmp1;
        image2 = ship;

        x1 = X1;
        y1 = Y1;
        x2 = X2;
        y2 = Y2;
        // initialization
        double width1 = x1 + image1.getWidth() -1,
                height1 = y1 + image1.getHeight() -1,
                width2 = x2 + image2.getWidth() -1,
                height2 = y2 + image2.getHeight() -1;

        int xstart = (int) Math.max(x1, x2),
                ystart = (int) Math.max(y1, y2),
                xend   = (int) Math.min(width1, width2),
                yend   = (int) Math.min(height1, height2);

        // intersection rectangle
        int toty = Math.abs(yend - ystart);
        int totx = Math.abs(xend - xstart);

        for (int y = 0; y < toty; y++){
            int ny = Math.abs(ystart - (int) y1) + y;
            int ny1 = Math.abs(ystart - (int) y2) + y;

            for (int x = 0; x < totx; x++) {
                int nx = Math.abs(xstart - (int) x1) + x;
                int nx1 = Math.abs(xstart - (int) x2) + x;
                try {
                    if (((image1.getPixel(nx,ny) & 0xFF000000) != 0x00) &&
                            ((image2.getPixel(nx1,ny1) & 0xFF000000) != 0x00)) {
                        // Collission!
                        return true;
                    }
                } catch (Exception e) {
                    System.err.println("Failed to check pixels!");
                }
            }
        }
        return false;
    }
}