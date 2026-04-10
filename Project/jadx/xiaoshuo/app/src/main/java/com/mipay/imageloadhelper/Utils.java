package com.mipay.imageloadhelper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes17.dex */
public class Utils {
    private static final String TAG = "image_Utils";

    public static String calculateMD5key(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            for (byte b2 : messageDigest.digest()) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                    sb.append(Integer.toHexString(i));
                } else {
                    sb.append(Integer.toHexString(i));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Bundle createErrorTaskArguments(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", i);
        bundle.putString("desc", str);
        return bundle;
    }

    public static Bundle createSuccessTaskArguments(int i, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", i);
        bundle.putParcelable("key_bitmap", bitmap);
        return bundle;
    }

    public static boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static Bitmap resizeBitmap(ImageView imageView, Bitmap bitmap) {
        int measuredWidth = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (measuredWidth > 0 && measuredHeight > 0 && measuredWidth < width && measuredHeight < height) {
            Matrix matrix = new Matrix();
            matrix.setScale(measuredWidth / width, measuredHeight / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Log.d(TAG, "imageView,x=" + measuredWidth + ",y=" + measuredHeight + ";before,bitmap,x=" + width + ",y=" + height + ";after,bitmap,x=" + bitmap.getWidth() + ",y=" + bitmap.getHeight());
        return bitmap;
    }
}
