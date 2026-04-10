package com.bytedance.sdk.openadsdk.core.nativeexpress.g;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.g.z$z, reason: collision with other inner class name */
    public interface InterfaceC0191z {
        com.bytedance.sdk.component.adexpress.z.g.z z(String str, uy.z zVar, String str2);

        boolean z();
    }

    public static com.bytedance.sdk.component.adexpress.z.g.z z(WebView webView, na naVar, String str, InterfaceC0191z interfaceC0191z) {
        gk next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        uy.z zVarZ = uy.z(str);
        boolean z = interfaceC0191z != null && interfaceC0191z.z();
        if (zVarZ == uy.z.IMAGE || !z || naVar == null) {
            next = null;
        } else {
            Iterator<gk> it = naVar.jz().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (!TextUtils.isEmpty(next.z()) && !TextUtils.isEmpty(str)) {
                    String strZ = next.z();
                    if (strZ.startsWith("https")) {
                        strZ = strZ.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strZ)) {
                        break;
                    }
                }
            }
            next = null;
        }
        if (zVarZ == uy.z.IMAGE) {
            com.bytedance.sdk.component.adexpress.z.g.z zVar = new com.bytedance.sdk.component.adexpress.z.g.z();
            zVar.z(5);
            zVar.z(z(str, g.g(naVar, str)));
            return zVar;
        }
        if (next == null) {
            if (interfaceC0191z == null) {
                return null;
            }
            return interfaceC0191z.z(str, zVarZ, "");
        }
        com.bytedance.sdk.component.adexpress.z.g.z zVar2 = new com.bytedance.sdk.component.adexpress.z.g.z();
        zVar2.z(z(str, next.e()));
        zVar2.z(5);
        return zVar2;
    }

    private static WebResourceResponse z(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamZ = com.bytedance.sdk.openadsdk.gz.g.z(str, str2);
            if (inputStreamZ == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(uy.z.IMAGE.getType(), "utf-8", inputStreamZ);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        wp.dl("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
