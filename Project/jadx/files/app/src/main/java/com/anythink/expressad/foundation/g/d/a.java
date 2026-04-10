package com.anythink.expressad.foundation.g.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.anythink.expressad.foundation.h.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @SuppressLint({"NewApi"})
    private static Drawable a(Resources resources, Bitmap bitmap) {
        return new BitmapDrawable(resources, bitmap);
    }

    private static Bitmap b(Bitmap bitmap) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f5 = width / 2;
            f4 = width;
            f2 = 0.0f;
            f3 = f4;
        } else {
            f2 = (width - height) / 2;
            f3 = height;
            f4 = width - f2;
            width = height;
            f5 = height / 2;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            int i2 = (int) f3;
            Rect rect = new Rect((int) f2, 0, (int) f4, i2);
            Rect rect2 = new Rect(0, 0, i2, i2);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f5, f5, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap a(String str) {
        Bitmap bitmapDecodeFile = null;
        if (!m.a(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inDither = true;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            System.gc();
            b.a();
            try {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return bitmapDecodeFile;
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
                return bitmapDecodeFile;
            }
        }
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int iCeil;
        int iMin;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        if (i3 == -1) {
            iCeil = 1;
        } else {
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i3;
            Double.isNaN(d4);
            iCeil = (int) Math.ceil(Math.sqrt((d2 * d3) / d4));
        }
        if (i2 == -1) {
            iMin = 128;
        } else {
            double d5 = i2;
            Double.isNaN(d2);
            Double.isNaN(d5);
            double dFloor = Math.floor(d2 / d5);
            Double.isNaN(d3);
            Double.isNaN(d5);
            iMin = (int) Math.min(dFloor, Math.floor(d3 / d5));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? iCeil : iMin;
    }

    private static Bitmap a(Context context, int i2) {
        Bitmap bitmapDecodeResource;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
        } catch (Exception unused) {
            bitmapDecodeResource = null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            bitmapDecodeResource = null;
        }
        return bitmapDecodeResource == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8) : bitmapDecodeResource;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream a(android.graphics.Bitmap r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L41
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L41
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L41
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L41
            r4.<init>(r2)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L41
            r1.close()     // Catch: java.lang.Exception -> L1a
            goto L40
        L1a:
            r0 = move-exception
            boolean r1 = com.anythink.expressad.a.a
            if (r1 == 0) goto L40
            r0.printStackTrace()
            goto L40
        L23:
            r4 = move-exception
            goto L2a
        L25:
            r4 = move-exception
            r1 = r0
            goto L42
        L28:
            r4 = move-exception
            r1 = r0
        L2a:
            boolean r2 = com.anythink.expressad.a.a     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L31
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L41
        L31:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Exception -> L37
            goto L3f
        L37:
            r4 = move-exception
            boolean r1 = com.anythink.expressad.a.a
            if (r1 == 0) goto L3f
            r4.printStackTrace()
        L3f:
            r4 = r0
        L40:
            return r4
        L41:
            r4 = move-exception
        L42:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.lang.Exception -> L48
            goto L50
        L48:
            r0 = move-exception
            boolean r1 = com.anythink.expressad.a.a
            if (r1 == 0) goto L50
            r0.printStackTrace()
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.d.a.a(android.graphics.Bitmap):java.io.InputStream");
    }
}
