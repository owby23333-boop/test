package com.anythink.core.basead.ui.web;

import android.webkit.WebView;
import com.anythink.core.common.e.i;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    i a;
    JSONObject b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    HashMap<String, Boolean> f6610c = new HashMap<>(3);

    public b(i iVar) {
        JSONObject jSONObject;
        this.a = iVar;
        if (iVar != null) {
            try {
                jSONObject = new JSONObject(iVar.M());
            } catch (Throwable unused) {
                return;
            }
        } else {
            jSONObject = null;
        }
        this.b = jSONObject;
    }

    private void a(WebView webView, String str) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && str != null && str.contains(next) && this.f6610c.get(next) == null) {
                    this.f6610c.put(next, Boolean.TRUE);
                    webView.loadUrl(this.b.optString(next));
                }
            }
        } catch (Throwable unused) {
        }
    }
}
