package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g.z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.openadsdk.core.widget.z.a {
    private final com.bytedance.sdk.openadsdk.v.gz fo;
    private boolean kb;
    private na uy;
    private com.bytedance.sdk.component.adexpress.g.i wp;
    public ArrayList<Integer> z;

    public m(Context context, mc mcVar, na naVar, com.bytedance.sdk.openadsdk.core.i.gc gcVar, boolean z, com.bytedance.sdk.openadsdk.v.gz gzVar, com.bytedance.sdk.component.adexpress.g.i iVar) {
        super(context, mcVar, naVar.mj(), gcVar);
        this.z = new ArrayList<>();
        this.uy = naVar;
        this.kb = z;
        this.fo = gzVar;
        this.wp = iVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int z() {
        for (Integer num : this.z) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(a()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.bytedance.sdk.openadsdk.v.gz gzVar = this.fo;
            if (gzVar != null) {
                gzVar.gz(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.z.g.z zVarZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.z(webView, this.uy, str, new z.InterfaceC0191z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.m.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.InterfaceC0191z
                public boolean z() {
                    return true;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.InterfaceC0191z
                public com.bytedance.sdk.component.adexpress.z.g.z z(String str2, uy.z zVar, String str3) {
                    return com.bytedance.sdk.component.adexpress.z.g.g.z(str2, zVar, str3, m.this.a());
                }
            });
            z(jCurrentTimeMillis, System.currentTimeMillis(), str, (zVarZ == null || zVarZ.z() == null) ? 2 : 1);
            if (zVarZ != null && zVarZ.getType() != 5) {
                this.z.add(Integer.valueOf(zVarZ.getType()));
            }
            if (zVarZ != null && zVarZ.z() != null) {
                com.bytedance.sdk.openadsdk.v.gz gzVar2 = this.fo;
                if (gzVar2 != null) {
                    gzVar2.fo(str);
                }
                return zVarZ.z();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        if (vm.m(this.uy) != null) {
            return vm.m(this.uy).kb();
        }
        if (vm.e(this.uy) != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.m = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.g.i iVar = this.wp;
        if (iVar == null || !iVar.sy()) {
            return;
        }
        com.bytedance.sdk.component.utils.kb.z(webView, "javascript:window.SDK_INJECT_DATA=" + this.wp.gc());
    }

    private void z(long j, long j2, String str, int i) {
        if (this.gc == null || this.gc.dl() == null) {
            return;
        }
        uy.z zVarZ = com.bytedance.sdk.component.adexpress.a.uy.z(str);
        if (zVarZ == uy.z.HTML) {
            this.gc.dl().z(str, j, j2, i);
        } else if (zVarZ == uy.z.JS) {
            this.gc.dl().g(str, j, j2, i);
        }
    }
}
