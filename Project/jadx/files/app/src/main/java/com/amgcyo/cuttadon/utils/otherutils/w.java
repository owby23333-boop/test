package com.amgcyo.cuttadon.utils.otherutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Base64;
import com.amgcyo.cuttadon.app.MkApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: MkBitmapUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class w {
    public static Bitmap a(String str) {
        Bitmap bitmap = null;
        try {
            if (str.startsWith("https") || str.startsWith("http")) {
                ResponseBody responseBodyBody = g.Y().newCall(new Request.Builder().url(str).build()).execute().body();
                if (responseBodyBody != null) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(responseBodyBody.byteStream());
                    if (bitmapDecodeStream == null) {
                        return null;
                    }
                    try {
                        return c(bitmapDecodeStream);
                    } catch (Exception e2) {
                        bitmap = bitmapDecodeStream;
                        e = e2;
                        e.printStackTrace();
                        return bitmap;
                    }
                }
            } else if (str.startsWith("data:image/")) {
                return b(str);
            }
        } catch (Exception e3) {
            e = e3;
        }
        return bitmap;
    }

    private static Bitmap b(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str.split(",")[1], 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap c(Bitmap bitmap) {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        options.inJustDecodeBounds = false;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i4 && i3 > 512.0f) {
            i2 = (int) (i3 / 512.0f);
        } else if (i3 >= i4 || i4 <= 512.0f) {
            i2 = 1;
        } else {
            i3 = options.outHeight;
            i2 = (int) (i3 / 512.0f);
        }
        if (i2 <= 0) {
            i2 = 1;
        }
        options.inSampleSize = i2;
        return b(BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options));
    }

    public static Bitmap b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i2 = 90;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 40) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            i2 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[Catch: IOException -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0035, blocks: (B:16:0x0031, B:27:0x0047), top: B:30:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.graphics.Bitmap r4) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            r1 = 0
            if (r4 == 0) goto L45
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r2.<init>()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r3 = 90
            r4.compress(r1, r3, r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r2.flush()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r2.close()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            byte[] r4 = r2.toByteArray()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r1 = 0
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r0 = r4
            r1 = r2
            goto L45
        L23:
            r4 = move-exception
            goto L3a
        L25:
            r4 = move-exception
            r1 = r2
            goto L2c
        L28:
            r4 = move-exception
            r2 = r1
            goto L3a
        L2b:
            r4 = move-exception
        L2c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L35
            goto L4a
        L35:
            r4 = move-exception
            r4.printStackTrace()
            goto L4a
        L3a:
            if (r2 == 0) goto L44
            r2.close()     // Catch: java.io.IOException -> L40
            goto L44
        L40:
            r0 = move-exception
            r0.printStackTrace()
        L44:
            throw r4
        L45:
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L35
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.utils.otherutils.w.a(android.graphics.Bitmap):java.lang.String");
    }

    public static final Bitmap a(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static Drawable a(Bitmap bitmap, int i2) {
        RenderScript renderScriptCreate = RenderScript.create(MkApplication.getAppContext());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapDecodeStream);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setRadius(20.0f);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapDecodeStream);
        return new BitmapDrawable(MkApplication.getAppContext().getResources(), bitmapDecodeStream);
    }
}
