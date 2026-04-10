package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.a;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.gz.g;
import com.bytedance.sdk.openadsdk.hh.e;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<RoundImageView> {
    protected int wo;
    protected String z;

    public z(Context context) {
        super(context);
        this.wo = 25;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        gz();
        ((RoundImageView) this.gc).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.gc).setBorderColor(this.yx);
        ((RoundImageView) this.gc).setCornerRadius(this.gp);
        ((RoundImageView) this.gc).setBorderWidth(this.f);
    }

    private void gz() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        ((RoundImageView) this.gc).setImageDrawable(null);
        if (this.z.startsWith("local://")) {
            e.z(new fo("UG_decode_img") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.z.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(z.this.g.getResources(), a.dl(z.this.g, z.this.z.replace("local://", "")));
                    if (bitmapDecodeResource != null) {
                        z.this.z(bitmapDecodeResource);
                    }
                }
            });
        } else {
            g.z(this.z).type(2).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.z.2
                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls lsVar) {
                    Object result = lsVar.getResult();
                    if (result == null || !(result instanceof Bitmap)) {
                        return;
                    }
                    z.this.z((Bitmap) result);
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                    wp.g("UGBlurWidget", str, th);
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bitmap bitmap) {
        final Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(this.g, bitmap, 25);
        if (bitmapZ != null) {
            e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.z.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.gc != null) {
                        ((RoundImageView) z.this.gc).setImageBitmap(bitmapZ);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public RoundImageView z() {
        RoundImageView roundImageView = new RoundImageView(this.g);
        roundImageView.z(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.z(str, str2);
        str.hashCode();
        if (!str.equals("blurRate")) {
            if (str.equals(QMUISkinValueBuilder.SRC)) {
                this.z = str2;
            }
        } else {
            try {
                this.wo = Integer.parseInt(str2);
            } catch (Exception e) {
                wp.g("UGBlurWidget", e);
            }
        }
    }
}
