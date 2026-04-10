package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.js.a;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.hh.e;

/* JADX INFO: loaded from: classes3.dex */
public class EcMallWebView extends SSWebView {
    private a e;
    mc gc;
    private final na m;

    public EcMallWebView(final Context context, na naVar, final int i) {
        super(context);
        this.m = naVar;
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.z(context, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, int i) {
        this.gc = new mc(context);
        final String strZ = eo.z(i);
        this.e = new a() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.2
            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void z(int i2) {
                if (EcMallWebView.this.m != null) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.g gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) io.z(EcMallWebView.this.m.dc(), com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
                    if (gVar != null) {
                        gVar.z(2, null);
                    }
                } else {
                    wp.z("EcMallWebView", "onSendReward failed meta null");
                }
                com.bytedance.sdk.openadsdk.core.i.a.z(strZ, EcMallWebView.this.m);
            }
        };
        this.gc.g(this).z(this.m).g(this.m.mj()).a(this.m.vk()).dl(i).gc(eo.ls(this.m)).z((SSWebView) this).z(strZ).z(this.e).z(true);
        setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(context, this.gc, this.m.mj(), new gc(this.m, this).g(true)));
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.gc));
        String strM = js.m(this.m);
        if (TextUtils.isEmpty(strM)) {
            strM = this.m.fp();
        }
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        loadUrl(strM);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, android.view.View, com.bytedance.sdk.component.i.dl
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        mc mcVar = this.gc;
        if (mcVar != null) {
            mcVar.kb(z);
        }
    }
}
