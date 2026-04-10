package com.bytedance.sdk.openadsdk.core.ugeno.component.dl;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<UpieImageView> {
    protected boolean wo;
    protected ImageView.ScaleType z;

    public z(Context context) {
        super(context);
        this.z = ImageView.ScaleType.FIT_XY;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UpieImageView z() {
        return new UpieImageView(this.g, null, null);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.z = kb(str2);
                break;
            case "isBgGaussianBlur":
                this.wo = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
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

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(this.f239a);
        if (naVarZ != null) {
            ((UpieImageView) this.gc).z(com.bytedance.sdk.openadsdk.gc.z.z(naVarZ, this.f239a), com.bytedance.sdk.openadsdk.gc.z.uy(naVarZ));
            ((UpieImageView) this.gc).setScaleType(this.z);
        }
    }
}
