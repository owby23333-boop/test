package com.bytedance.adsdk.lottie.g;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.dl;
import com.bytedance.adsdk.lottie.gc.gc;
import com.bytedance.adsdk.lottie.model.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f147a;
    private dl gc;
    private final e<String> z = new e<>();
    private final Map<e<String>, Typeface> g = new HashMap();
    private final Map<String, Typeface> dl = new HashMap();
    private String m = ".ttf";

    public z(Drawable.Callback callback, dl dlVar) {
        this.gc = dlVar;
        if (!(callback instanceof View)) {
            gc.g("LottieDrawable must be inside of a view for images to work.");
            this.f147a = null;
        } else {
            this.f147a = ((View) callback).getContext().getAssets();
        }
    }

    public void z(dl dlVar) {
        this.gc = dlVar;
    }

    public void z(String str) {
        this.m = str;
    }

    public Typeface z(com.bytedance.adsdk.lottie.model.dl dlVar) {
        this.z.z(dlVar.z(), dlVar.dl());
        Typeface typeface = this.g.get(this.z);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceZ = z(g(dlVar), dlVar.dl());
        this.g.put(this.z, typefaceZ);
        return typefaceZ;
    }

    private Typeface g(com.bytedance.adsdk.lottie.model.dl dlVar) {
        Typeface typefaceCreateFromAsset;
        String strZ = dlVar.z();
        Typeface typeface = this.dl.get(strZ);
        if (typeface != null) {
            return typeface;
        }
        String strDl = dlVar.dl();
        String strG = dlVar.g();
        dl dlVar2 = this.gc;
        if (dlVar2 != null) {
            typefaceCreateFromAsset = dlVar2.z(strZ, strDl, strG);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.gc.z(strZ);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        dl dlVar3 = this.gc;
        if (dlVar3 != null && typefaceCreateFromAsset == null) {
            String strG2 = dlVar3.g(strZ, strDl, strG);
            if (strG2 == null) {
                strG2 = this.gc.g(strZ);
            }
            if (strG2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.f147a, strG2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (dlVar.a() != null) {
            return dlVar.a();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.f147a, "fonts/" + strZ + this.m);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.dl.put(strZ, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface z(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
