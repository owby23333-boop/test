package com.bytedance.adsdk.ugeno.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static TypedValue dl;
    private static final Object g = new Object();
    public static Handler z = new Handler(Looper.getMainLooper());

    public static float z(Context context, String str) {
        float f;
        float f2 = context.getResources().getDisplayMetrics().density;
        try {
            f = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            f = 0.0f;
        }
        return (f * f2) + 0.5f;
    }

    public static float z(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int g(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static int z(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Bitmap z(Context context, Bitmap bitmap, int i) {
        try {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                return null;
            }
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(i);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    public static Drawable z(Context context, int i) {
        return context.getDrawable(i);
    }

    public static boolean z() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void z(Runnable runnable) {
        if (z()) {
            runnable.run();
        } else {
            z.post(runnable);
        }
    }
}
