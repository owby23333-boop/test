package me.jessyan.art.http.imageloader.glide.transform;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableProvider {
    private DrawableProvider() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getReSizeBitmap(Bitmap bitmap, float f2, float f3) {
        Bitmap bitmapCreateBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f2 / width, f3 / height);
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmap;
        }
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Drawable getScaleDrawable(float f2, Drawable drawable) {
        drawable.setBounds(0, 0, (int) ((drawable.getIntrinsicWidth() * f2) + 0.5f), (int) ((drawable.getIntrinsicHeight() * f2) + 0.5f));
        return drawable;
    }

    public static Drawable getScaleDrawable2(float f2, Drawable drawable) {
        return getScaleDrawable((f2 * 1.0f) / drawable.getIntrinsicWidth(), drawable);
    }

    public static Drawable getScaleDrawableForRadioButton(float f2, TextView textView) {
        Drawable drawable = null;
        for (Drawable drawable2 : textView.getCompoundDrawables()) {
            if (drawable2 != null) {
                drawable = drawable2;
            }
        }
        return getScaleDrawable(f2, drawable);
    }

    public static Drawable getScaleDrawableForRadioButton2(float f2, TextView textView) {
        Drawable drawable = null;
        for (Drawable drawable2 : textView.getCompoundDrawables()) {
            if (drawable2 != null) {
                drawable = drawable2;
            }
        }
        return getScaleDrawable2(f2, drawable);
    }

    public static Drawable getStateListDrawable(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i2) {
        Bitmap bitmapCreateBitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmap;
        }
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static void setLeftDrawable(TextView textView, Drawable drawable) {
        textView.setCompoundDrawables(drawable, null, null, null);
    }
}
