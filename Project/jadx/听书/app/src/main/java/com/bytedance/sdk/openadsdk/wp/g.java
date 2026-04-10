package com.bytedance.sdk.openadsdk.wp;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private Map<String, String> dl;
    private String g;
    private Uri z;

    public g(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.z = webResourceRequest.getUrl();
            this.g = webResourceRequest.getMethod();
            this.dl = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.z = Uri.parse(str);
        this.g = "GET";
    }

    public Uri z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public Map<String, String> dl() {
        return this.dl;
    }
}
