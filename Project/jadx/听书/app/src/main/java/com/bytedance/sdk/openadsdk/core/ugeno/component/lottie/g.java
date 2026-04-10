package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.z;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl<UgenLottieView> {
    private float bw;
    private String cb;
    private int dt;
    protected ImageView.ScaleType k;
    private boolean o;
    protected HashMap<String, Bitmap> wo;
    protected ImageView.ScaleType wx;
    private float xf;
    private boolean xo;

    @Deprecated
    private boolean yt;
    protected String z;

    public g(Context context) {
        super(context);
        this.cb = "images";
        this.bw = 1.0f;
        this.k = ImageView.ScaleType.FIT_CENTER;
        this.wx = ImageView.ScaleType.FIT_XY;
        this.wo = new HashMap<>();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UgenLottieView z() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.g);
        ugenLottieView.z(this);
        return ugenLottieView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((UgenLottieView) this.gc).setProgress(this.xf);
        if (this.bw <= 0.0f) {
            this.bw = 1.0f;
        }
        ((UgenLottieView) this.gc).setSpeed(this.bw);
        if (this.z.startsWith("local")) {
            ((UgenLottieView) this.gc).setAnimation(kb(this.z));
            ((UgenLottieView) this.gc).setImageAssetsFolder(this.cb);
        } else {
            ((UgenLottieView) this.gc).setAnimationFromUrl(this.z);
        }
        ((UgenLottieView) this.gc).setImageAssetDelegate(new AnonymousClass1());
        if (h()) {
            ((UgenLottieView) this.gc).setScaleType(this.wx);
        } else {
            ((UgenLottieView) this.gc).setScaleType(this.k);
        }
        if (h()) {
            ((UgenLottieView) this.gc).setRepeatCount(this.dt);
        } else {
            ((UgenLottieView) this.gc).z(this.yt);
        }
        gz();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g$1, reason: invalid class name */
    class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.lottie.a
        public Bitmap z(final fo foVar) {
            final String strZ;
            if (foVar == null) {
                return null;
            }
            String strI = foVar.i();
            String strWp = foVar.wp();
            if (!TextUtils.isEmpty(strI) && TextUtils.isEmpty(strWp)) {
                strZ = com.bytedance.adsdk.ugeno.a.g.z(strI, g.this.f239a);
            } else {
                strZ = (TextUtils.isEmpty(strWp) || !TextUtils.isEmpty(strI)) ? (TextUtils.isEmpty(strWp) || TextUtils.isEmpty(strI)) ? null : com.bytedance.adsdk.ugeno.a.g.z(strI, g.this.f239a) + com.bytedance.adsdk.ugeno.a.g.z(strWp, g.this.f239a) : com.bytedance.adsdk.ugeno.a.g.z(strWp, g.this.f239a);
            }
            if (TextUtils.isEmpty(strZ)) {
                return null;
            }
            Bitmap bitmap = g.this.wo.get(strZ);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.a.z().g().z(g.this.fo, strZ, new z.InterfaceC0053z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g.1.1
                @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                public void z(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, foVar.z(), foVar.g(), false);
                        g.this.wo.put(strZ, bitmapCreateScaledBitmap);
                        gz.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) g.this.gc).z(foVar.kb(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return g.this.wo.get(strZ);
        }
    }

    protected void gz() {
        ((UgenLottieView) this.gc).z();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.wx = i(str2);
                break;
            case "scaleType":
                this.k = wp(str2);
                break;
            case "progress":
                this.xf = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case "imagePath":
                this.cb = str2;
                break;
            case "autoReverse":
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
                break;
            case "src":
                this.z = str2;
                break;
            case "loop":
                if (h()) {
                    this.dt = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0);
                    break;
                } else {
                    this.yt = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
                    break;
                }
                break;
            case "speed":
                this.bw = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1.0f);
                break;
            case "autoPlay":
                this.xo = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
                break;
            case "autoplay":
                this.xo = com.bytedance.adsdk.ugeno.m.dl.z(str2, true);
                break;
        }
    }

    private String kb(String str) {
        return (!TextUtils.isEmpty(str) && str.contains("local")) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    private ImageView.ScaleType wp(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType i(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }
}
