package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.dl;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.tb;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.uy;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLottieView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f595a;
    private boolean dl;
    private int e;
    private String g;
    private int gc;
    private Map<String, String> gz;
    private int m;
    private Map<String, Bitmap> z;

    public void setLottieAppNameMaxLength(int i) {
        this.gc = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.m = i;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.e = i;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.z = new HashMap();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fo();
    }

    public void setImageLottieTosPath(String str) {
        this.g = str;
    }

    public void setAnimationsLoop(boolean z) {
        this.dl = z;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.f595a = z;
    }

    public void setData(Map<String, String> map) {
        this.gz = map;
    }

    public void fo() {
        if (TextUtils.isEmpty(this.g)) {
            return;
        }
        setProgress(0.0f);
        z(this.dl);
        if (this.f595a) {
            kb();
        } else {
            uy();
        }
    }

    private void uy() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.g + ".json");
        setImageAssetDelegate(new a() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.a
            public Bitmap z(final fo foVar) {
                final String strWp;
                strWp = foVar.wp();
                strWp.hashCode();
                switch (strWp) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.gz != null) {
                            strWp = (String) DynamicLottieView.this.gz.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.gz != null) {
                            strWp = (String) DynamicLottieView.this.gz.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.z.get(strWp);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.z.z.z.z().gc().from(strWp).type(2).converter(new uy() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.m.uy
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, foVar.z(), foVar.g(), false);
                        DynamicLottieView.this.z.put(strWp, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new io<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.m.io
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.io
                    public void onSuccess(ls<Bitmap> lsVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(lsVar.getResult(), foVar.z(), foVar.g(), false);
                        DynamicLottieView.this.z.put(strWp, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.z(foVar.kb(), bitmapCreateScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.z.get(strWp);
            }
        });
        if (this.gz != null) {
            tb tbVar = new tb(this);
            String str = this.gz.get(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            String str2 = this.gz.get("description");
            String str3 = this.gz.get("title");
            if (this.gc > 0 && str.length() > this.gc) {
                str = str.substring(0, this.gc - 1) + "...";
            } else if (this.gc <= 0) {
                str = "";
            }
            if (this.m > 0 && str3.length() > this.m) {
                str3 = str3.substring(0, this.m - 1) + "...";
            } else if (this.gc <= 0) {
                str3 = "";
            }
            if (this.e > 0 && str2.length() > this.e) {
                str2 = str2.substring(0, this.e - 1) + "...";
            } else if (this.gc <= 0) {
                str2 = "";
            }
            tbVar.g("{appName}", str);
            tbVar.g("{adTitle}", str3);
            tbVar.g("{adDesc}", str2);
            setTextDelegate(tbVar);
            setFontAssetDelegate(new dl() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.dl
                public String g(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.dl
                public Typeface z(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        z();
    }

    private void kb() {
        setAnimationFromUrl(this.g);
        setImageAssetDelegate(new a() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.a
            public Bitmap z(final fo foVar) {
                if (foVar == null) {
                    return null;
                }
                final String strI = foVar.i();
                String strWp = foVar.wp();
                if (TextUtils.isEmpty(strI) || !TextUtils.isEmpty(strWp)) {
                    if (TextUtils.isEmpty(strWp) || !TextUtils.isEmpty(strI)) {
                        strI = (TextUtils.isEmpty(strWp) || TextUtils.isEmpty(strI)) ? "" : strI + strWp;
                    } else {
                        strI = strWp;
                    }
                }
                if (TextUtils.isEmpty(strI)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.z == null ? null : (Bitmap) DynamicLottieView.this.z.get(strI);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.z.z.z.z().gc().from(strI).converter(new uy() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.m.uy
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, foVar.z(), foVar.g(), false);
                        if (DynamicLottieView.this.z != null) {
                            DynamicLottieView.this.z.put(strI, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new io<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.m.io
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.io
                    public void onSuccess(ls<Bitmap> lsVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(lsVar.getResult(), foVar.z(), foVar.g(), false);
                        if (DynamicLottieView.this.z != null) {
                            DynamicLottieView.this.z.put(strI, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.z(foVar.kb(), bitmapCreateScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.z == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.z.get(strI);
            }
        });
        z();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }
}
