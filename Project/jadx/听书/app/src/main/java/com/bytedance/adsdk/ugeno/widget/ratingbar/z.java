package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.g.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<UGRatingBar> {
    private static final int o = Color.parseColor("#FFC642");
    private static final int yt = Color.parseColor("#e3e3e4");
    private float cb;
    private float k;
    private int wo;
    private float wx;
    private int z;

    public z(Context context) {
        super(context);
        this.z = o;
        this.wo = yt;
        this.k = 4.0f;
        this.wx = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UGRatingBar z() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.g);
        uGRatingBar.z(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        if (h()) {
            ((UGRatingBar) this.gc).z(this.k, this.z, this.wo, this.wx, (int) this.cb);
        } else {
            ((UGRatingBar) this.gc).z(this.k, this.z, this.wo, this.wx, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.z = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.wo = com.bytedance.adsdk.ugeno.m.z.z(str2, yt);
                break;
            case "gap":
                this.cb = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case "size":
                this.wx = com.bytedance.adsdk.ugeno.m.dl.z(str2, 20.0f);
                break;
            case "score":
                this.k = com.bytedance.adsdk.ugeno.m.dl.z(str2, 4.0f);
                break;
        }
    }
}
