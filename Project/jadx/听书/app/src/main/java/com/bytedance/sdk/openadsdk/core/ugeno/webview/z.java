package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.g.dl;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<PageWebView> {
    private String z;

    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public PageWebView z() {
        return new PageWebView(this.g);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((PageWebView) this.gc).setMeta(com.bytedance.sdk.openadsdk.core.z.z(uy()));
        ((PageWebView) this.gc).g(uy());
        ((PageWebView) this.gc).setUGenContext(this.fo);
        ((PageWebView) this.gc).z();
        ((PageWebView) this.gc).z(this.z);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        if (str.equals(QMUISkinValueBuilder.SRC)) {
            this.z = str2;
        }
    }
}
