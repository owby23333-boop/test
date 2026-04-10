package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bytedance.component.sdk.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class e {
    @RequiresApi(api = 17)
    public static Bitmap e(Context context, Bitmap bitmap, int i) {
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
            th.printStackTrace();
            return null;
        }
    }
}
