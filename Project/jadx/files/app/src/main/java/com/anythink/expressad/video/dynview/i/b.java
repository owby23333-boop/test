package com.anythink.expressad.video.dynview.i;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.anythink.core.common.b.n;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                RenderScript renderScriptCreate = RenderScript.create(n.a().g());
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                scriptIntrinsicBlurCreate.setRadius(18.0f);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                renderScriptCreate.destroy();
                return bitmapCreateBitmap;
            }
            return a(i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Bitmap a(int i2) {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_4444);
            if (i2 == 1) {
                bitmapCreateBitmap.eraseColor(Color.parseColor("#FF0000"));
            } else {
                bitmapCreateBitmap.eraseColor(Color.parseColor("#FFFFFF"));
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
        return bitmapCreateBitmap;
    }
}
