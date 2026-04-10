package com.bytedance.adsdk.lottie.bf;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.d.zk;
import com.bytedance.adsdk.lottie.vn.tg;
import com.yuewen.yh4;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private d ga;
    private final AssetManager tg;
    private final zk<String> e = new zk<>();
    private final Map<zk<String>, Typeface> bf = new HashMap();
    private final Map<String, Typeface> d = new HashMap();
    private String vn = yh4.Q;

    public e(Drawable.Callback callback, d dVar) {
        this.ga = dVar;
        if (callback instanceof View) {
            this.tg = ((View) callback).getContext().getAssets();
        } else {
            tg.bf("LottieDrawable must be inside of a view for images to work.");
            this.tg = null;
        }
    }

    private Typeface bf(com.bytedance.adsdk.lottie.d.d dVar) {
        Typeface typefaceCreateFromAsset;
        String strE = dVar.e();
        Typeface typeface = this.d.get(strE);
        if (typeface != null) {
            return typeface;
        }
        String strD = dVar.d();
        String strBf = dVar.bf();
        d dVar2 = this.ga;
        if (dVar2 != null) {
            typefaceCreateFromAsset = dVar2.e(strE, strD, strBf);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.ga.e(strE);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        d dVar3 = this.ga;
        if (dVar3 != null && typefaceCreateFromAsset == null) {
            String strBf2 = dVar3.bf(strE, strD, strBf);
            if (strBf2 == null) {
                strBf2 = this.ga.bf(strE);
            }
            if (strBf2 != null) {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.tg, strBf2);
            }
        }
        if (dVar.tg() != null) {
            return dVar.tg();
        }
        if (typefaceCreateFromAsset == null) {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.tg, "fonts/" + strE + this.vn);
        }
        this.d.put(strE, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public void e(d dVar) {
        this.ga = dVar;
    }

    public void e(String str) {
        this.vn = str;
    }

    public Typeface e(com.bytedance.adsdk.lottie.d.d dVar) {
        this.e.e(dVar.e(), dVar.d());
        Typeface typeface = this.bf.get(this.e);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(bf(dVar), dVar.d());
        this.bf.put(this.e, typefaceE);
        return typefaceE;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
