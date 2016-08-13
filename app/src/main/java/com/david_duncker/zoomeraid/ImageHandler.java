package com.david_duncker.zoomeraid;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.widget.ImageView;
import android.util.Log;


/**
 * Created by david on 5/3/16.
 */
public class ImageHandler {
    public ImageHandler(Context context, int resID, ImageView imgView, int reqWidth, int reqHeight) {
        String TAG = "Z_log";
        Log.i(TAG, "Started ImageHandler");
        Resources res=context.getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resID, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        Log.i(TAG, "BimapFactory options set, about to set inSampleSize");

        int inSampleSize = 1;
        if (imageHeight > reqHeight || imageWidth > reqWidth) {
            final int halfHeight = imageHeight / 2;
            final int halfWidth = imageWidth / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        Log.i(TAG, "inSampleSize calculated to be " + Integer.toString(inSampleSize));
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        Log.i(TAG, "About to create Bitmap from BitmapFactory.decodeResource");
        Bitmap q = BitmapFactory.decodeResource(res, resID, options);
        Log.i(TAG, "about to set imageView to Bitmap");
        imgView.setImageBitmap(q);
    }
}