package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g implements com.bytedance.adsdk.ugeno.z.g {
    private String kb;

    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        com.bytedance.adsdk.ugeno.g.dl dlVarG;
        com.bytedance.adsdk.ugeno.z.z zVarUy;
        if (this.gc != null && this.gc.size() > 0) {
            String str = this.gc.get("name");
            this.kb = this.gc.get("state");
            if (!TextUtils.isEmpty(str) && (dlVarG = this.g.g(this.g)) != null && (zVarUy = dlVarG.m(str).uy(str)) != null) {
                zVarUy.z(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.z.g
    public void z() {
        if ((TextUtils.equals(this.kb, TtmlNode.START) || TextUtils.isEmpty(this.kb)) && this.z != null) {
            this.z.z(this.g, this.m, this.dl.g());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g
    public void g() {
        if ((TextUtils.equals(this.kb, "complete") || TextUtils.isEmpty(this.kb)) && this.z != null) {
            this.z.z(this.g, this.m, this.dl.g());
        }
    }
}
