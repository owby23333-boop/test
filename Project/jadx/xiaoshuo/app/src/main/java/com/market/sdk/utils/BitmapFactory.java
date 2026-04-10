package com.market.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.renderscript.RenderScript;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class BitmapFactory extends android.graphics.BitmapFactory {
    static Object sLockForRsContext = new Object();
    static RenderScript sRsContext;
    private static final Paint sSrcInPaint;

    static {
        Paint paint = new Paint(1);
        sSrcInPaint = paint;
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public BitmapFactory() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static Bitmap copyToEmpty(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        return Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
    }

    public static Bitmap fastBlur(Bitmap bitmap, int i) {
        Bitmap bitmapCopyToEmpty = copyToEmpty(bitmap);
        fastBlur(bitmap, bitmapCopyToEmpty, i);
        return bitmapCopyToEmpty;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        r2 = transferF16ToARGB(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap fastblur_v17(android.graphics.Bitmap r10, android.graphics.Bitmap r11, int r12) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.market.sdk.utils.BitmapFactory.fastblur_v17(android.graphics.Bitmap, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static boolean saveToFile(Bitmap bitmap, String str) throws IOException {
        return saveToFile(bitmap, str, false);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        scaleBitmap(bitmap, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private static Bitmap transferF16ToARGB(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setFlags(3);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static boolean saveToFile(Bitmap bitmap, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static Bitmap fastBlur(Bitmap bitmap, Bitmap bitmap2, int i) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null || bitmap.getWidth() != bitmap2.getWidth() || bitmap.getHeight() != bitmap2.getHeight()) {
            bitmap2 = copyToEmpty(bitmap);
        }
        fastblur_v17(bitmap, bitmap2, i);
        return bitmap2;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        if (bitmap.getWidth() == bitmap2.getWidth() && bitmap.getHeight() == bitmap2.getHeight()) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), paint);
        return bitmap2;
    }
}
