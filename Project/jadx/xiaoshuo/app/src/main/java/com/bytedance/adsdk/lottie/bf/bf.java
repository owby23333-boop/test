package com.bytedance.adsdk.lottie.bf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.tg;
import com.bytedance.adsdk.lottie.vn.v;
import com.bytedance.adsdk.lottie.zk;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static final Object e = new Object();
    private final Context bf;
    private final String d;
    private final Map<String, zk> ga;
    private tg tg;

    public bf(Drawable.Callback callback, String str, tg tgVar, Map<String, zk> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.d = str;
        } else {
            this.d = str + JsonPointer.SEPARATOR;
        }
        this.ga = map;
        e(tgVar);
        if (callback instanceof View) {
            this.bf = ((View) callback).getContext().getApplicationContext();
        } else {
            this.bf = null;
        }
    }

    public void e(tg tgVar) {
        this.tg = tgVar;
    }

    public Bitmap e(String str) {
        zk zkVar = this.ga.get(str);
        if (zkVar == null) {
            return null;
        }
        Bitmap bitmapGa = zkVar.ga();
        if (bitmapGa != null) {
            return bitmapGa;
        }
        tg tgVar = this.tg;
        if (tgVar != null) {
            return tgVar.e(zkVar);
        }
        Context context = this.bf;
        if (context == null) {
            return null;
        }
        String strTg = zkVar.tg();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strTg.startsWith("data:") && strTg.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strTg.substring(strTg.indexOf(44) + 1), 0);
                return e(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e2) {
                com.bytedance.adsdk.lottie.vn.tg.e("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.d)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.d + strTg), null, options);
                if (bitmapDecodeStream != null) {
                    return e(str, v.e(bitmapDecodeStream, zkVar.e(), zkVar.bf()));
                }
                com.bytedance.adsdk.lottie.vn.tg.bf("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e3) {
                com.bytedance.adsdk.lottie.vn.tg.e("Unable to decode image `" + str + "`.", e3);
                return null;
            }
        } catch (IOException e4) {
            com.bytedance.adsdk.lottie.vn.tg.e("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean e(Context context) {
        return (context == null && this.bf == null) || this.bf.equals(context);
    }

    private Bitmap e(String str, Bitmap bitmap) {
        synchronized (e) {
            this.ga.get(str).e(bitmap);
        }
        return bitmap;
    }
}
