package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.a;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<UgenGif> {
    protected ImageView.ScaleType wo;
    protected String z;

    public z(Context context) {
        super(context);
        this.wo = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UgenGif z() {
        this.gc = new UgenGif(this.g);
        ((UgenGif) this.gc).z(this);
        return (UgenGif) this.gc;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        gz();
        ((UgenGif) this.gc).setScaleType(this.wo);
    }

    private void gz() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        if (this.z.startsWith("local://")) {
            ((UgenGif) this.gc).z(a.g(this.g, this.z.replace("local://", "")), false);
        } else {
            com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.z, (ImageView) this.gc, null);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.wo = kb(str2);
        } else if (str.equals(QMUISkinValueBuilder.SRC)) {
            this.z = str2;
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

    @Override // com.bytedance.adsdk.ugeno.g.dl, com.bytedance.adsdk.ugeno.dl
    public void gc() {
        super.gc();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl, com.bytedance.adsdk.ugeno.dl
    public void z(boolean z) {
        super.z(z);
        if (z) {
            g();
        }
    }
}
