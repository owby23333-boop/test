package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.ti;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class uf implements SSWebView.g {
    private mc dl;
    private na g;
    private SSWebView z;

    public uf(SSWebView sSWebView, mc mcVar, na naVar) {
        this.z = sSWebView;
        this.g = naVar;
        this.dl = mcVar;
    }

    private boolean z() {
        SSWebView sSWebView = this.z;
        if (sSWebView == null) {
            return false;
        }
        return ti.g(sSWebView, 50, eo.gz(this.g));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.g
    public void z(final int i) {
        boolean z = z();
        com.bytedance.sdk.component.utils.wp.g("xeasy", "wv:".concat(String.valueOf(z)));
        if (z) {
            if (com.bytedance.sdk.openadsdk.core.zw.g().fo()) {
                SSWebView sSWebView = this.z;
                if (sSWebView != null) {
                    com.bytedance.sdk.openadsdk.core.un.mc.z((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.bytedance.sdk.openadsdk.core.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.uf.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.dl
                        public void z() {
                            if (uf.this.dl != null) {
                                uf.this.dl.z(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            mc mcVar = this.dl;
            if (mcVar != null) {
                mcVar.z(i);
            }
        }
    }
}
