package com.bytedance.adsdk.lottie.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.gc.gc;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final Object z = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f146a;
    private final String dl;
    private final Context g;
    private final Map<String, fo> gc;

    public g(Drawable.Callback callback, String str, a aVar, Map<String, fo> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.dl = str + '/';
        } else {
            this.dl = str;
        }
        this.gc = map;
        z(aVar);
        if (!(callback instanceof View)) {
            this.g = null;
        } else {
            this.g = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void z(a aVar) {
        this.f146a = aVar;
    }

    public Bitmap z(String str, Bitmap bitmap) {
        if (bitmap == null) {
            fo foVar = this.gc.get(str);
            Bitmap bitmapV = foVar.v();
            foVar.z(null);
            return bitmapV;
        }
        return this.gc.get(str).v();
    }

    public Bitmap z(String str) {
        fo foVar = this.gc.get(str);
        if (foVar == null) {
            return null;
        }
        Bitmap bitmapV = foVar.v();
        if (bitmapV != null) {
            return bitmapV;
        }
        a aVar = this.f146a;
        if (aVar != null) {
            return aVar.z(foVar);
        }
        Context context = this.g;
        if (context == null) {
            return null;
        }
        String strWp = foVar.wp();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strWp.startsWith("data:") && strWp.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strWp.substring(strWp.indexOf(44) + 1), 0);
                return g(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                gc.z("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.dl)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.dl + strWp), null, options);
                if (bitmapDecodeStream == null) {
                    gc.g("Decoded image `" + str + "` is null.");
                    return null;
                }
                return g(str, com.bytedance.adsdk.lottie.gc.fo.z(bitmapDecodeStream, foVar.z(), foVar.g()));
            } catch (IllegalArgumentException e2) {
                gc.z("Unable to decode image `" + str + "`.", e2);
                return null;
            }
        } catch (IOException e3) {
            gc.z("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean z(Context context) {
        return (context == null && this.g == null) || this.g.equals(context);
    }

    private Bitmap g(String str, Bitmap bitmap) {
        synchronized (z) {
        }
        return bitmap;
    }
}
