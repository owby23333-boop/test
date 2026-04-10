package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.gz;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<DislikeView> {
    private int k;
    private int wo;
    private int z;

    public z(Context context) {
        super(context);
        this.z = 0;
        this.k = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public DislikeView z() {
        DislikeView dislikeView = new DislikeView(this.g);
        dislikeView.z(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((DislikeView) this.gc).setRadius(this.gp);
        ((DislikeView) this.gc).setStrokeWidth((int) this.f);
        ((DislikeView) this.gc).setDislikeColor(this.z);
        ((DislikeView) this.gc).setStrokeColor(this.yx);
        ((DislikeView) this.gc).setDislikeWidth(this.wo);
        ((DislikeView) this.gc).setBgColor(this.k);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.z = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "dislikeWidth":
                this.wo = (int) gz.z(this.g, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.k = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
        }
    }
}
