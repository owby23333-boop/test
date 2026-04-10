package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.dl.e;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.a;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.z;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl<RoundImageView> {
    private int cb;
    protected boolean k;
    private float o;
    protected ImageView.ScaleType wo;
    protected String wx;
    private float yt;
    protected String z;

    public g(Context context) {
        super(context);
        this.wo = ImageView.ScaleType.FIT_XY;
        this.cb = -1;
        this.o = -1.0f;
        this.yt = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        jq();
        ((RoundImageView) this.gc).setScaleType(this.wo);
        ((RoundImageView) this.gc).setBorderColor(this.yx);
        ((RoundImageView) this.gc).setCornerRadius(this.gp);
        ((RoundImageView) this.gc).setBorderWidth(this.f);
        if (this.cb != -1) {
            ((RoundImageView) this.gc).setColorFilter(this.cb);
        }
    }

    public void wp(String str) {
        this.z = str;
    }

    private void jq() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        ((RoundImageView) this.gc).setImageDrawable(null);
        if (this.z.startsWith("local://")) {
            try {
                String strReplace = this.z.replace("local://", "");
                if (TextUtils.equals(e(), "raw")) {
                    ((RoundImageView) this.gc).setImageResource(a.z(this.g, strReplace));
                    return;
                } else {
                    ((RoundImageView) this.gc).setImageResource(a.g(this.g, strReplace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.z.startsWith("@")) {
            try {
                ((RoundImageView) this.gc).setImageResource(Integer.parseInt(this.z.substring(1)));
                return;
            } catch (Exception e) {
                wp.z(e);
                return;
            }
        }
        sv();
    }

    private void sv() {
        if (this.o > 0.0f) {
            if (this.yw != null) {
                this.yw.z();
            }
            com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.z, new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.1
                @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                public void z(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (g.this.yw != null) {
                            e eVar = g.this.yw;
                            g gVar = g.this;
                            eVar.g(gVar, gVar.z);
                            return;
                        }
                        return;
                    }
                    if (g.this.yw != null) {
                        e eVar2 = g.this.yw;
                        g gVar2 = g.this;
                        eVar2.z(gVar2, gVar2.z);
                    }
                    final Bitmap bitmapZ = gz.z(g.this.g, bitmap, (int) g.this.o);
                    if (bitmapZ != null) {
                        gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) g.this.gc).setImageBitmap(bitmapZ);
                            }
                        });
                    }
                    if (g.this.k || g.this.yt > 0.0f) {
                        Bitmap bitmapZ2 = gz.z(g.this.g, bitmap, g.this.yt > 0.0f ? (int) g.this.yt : 10);
                        if (bitmapZ2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(g.this.g.getResources(), bitmapZ2);
                            gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) g.this.gc).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        if (this.yw != null) {
            this.yw.z();
        }
        com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.z, (ImageView) this.gc, ((RoundImageView) this.gc).getWidth(), ((RoundImageView) this.gc).getHeight(), new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.2
            @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
            public void z(Bitmap bitmap) {
                if (bitmap == null) {
                    if (g.this.yw != null) {
                        e eVar = g.this.yw;
                        g gVar = g.this;
                        eVar.g(gVar, gVar.z);
                        return;
                    }
                    return;
                }
                if (g.this.yw != null) {
                    e eVar2 = g.this.yw;
                    g gVar2 = g.this;
                    eVar2.z(gVar2, gVar2.z);
                }
            }
        });
        if (this.k || this.yt > 0.0f) {
            com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.z, new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.3
                @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                public void z(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapZ = gz.z(g.this.g, bitmap, g.this.yt > 0.0f ? (int) g.this.yt : 10);
                    gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapZ != null) {
                                ((RoundImageView) g.this.gc).setBackground(new BitmapDrawable(g.this.g.getResources(), bitmapZ));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: gz, reason: merged with bridge method [inline-methods] */
    public RoundImageView z() {
        RoundImageView roundImageView = new RoundImageView(this.g);
        roundImageView.z(this);
        return roundImageView;
    }

    public void g(Drawable drawable) {
        ((RoundImageView) this.gc).setImageDrawable(drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.wo = kb(str2);
                break;
            case "imageBlur":
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.k = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
                break;
            case "src":
                this.z = str2;
                break;
            case "tintColor":
                this.cb = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "imageBgBlur":
                this.yt = com.bytedance.adsdk.ugeno.m.dl.z(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType kb(String str) {
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl, com.bytedance.adsdk.ugeno.dl
    public void gc() {
        super.gc();
        ((RoundImageView) this.gc).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.g.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) g.this.gc).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl, com.bytedance.adsdk.ugeno.dl
    public void m() {
        super.m();
        Drawable drawable = ((RoundImageView) this.gc).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    protected String e() {
        return this.wx;
    }
}
