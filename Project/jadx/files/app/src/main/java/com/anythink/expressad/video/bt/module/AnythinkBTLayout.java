package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.video.bt.a.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBTLayout extends BTBaseView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11499p = "portrait";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11500q = "landscape";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private WebView f11501r;

    public AnythinkBTLayout(Context context) {
        super(context);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f11501r != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.f11546n);
                jSONObject2.put("id", getInstanceId());
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                j.a();
                j.a(this.f11501r, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                c.a();
                c.a(this.f11501r, "broadcast", getInstanceId());
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
    }

    public void notifyEvent(String str) {
        WebView webView = this.f11501r;
        if (webView != null) {
            BTBaseView.a(webView, str, this.f11550d);
        }
    }

    public void onBackPressed() {
        if (this.f11501r != null) {
            c.a();
            c.a(this.f11501r, "onSystemBackPressed", this.f11550d);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f11501r != null) {
            try {
                if (this.b == null || !this.b.j()) {
                    JSONObject jSONObject = new JSONObject();
                    if (configuration.orientation == 2) {
                        jSONObject.put("orientation", f11500q);
                    } else {
                        jSONObject.put("orientation", f11499p);
                    }
                    jSONObject.put("instanceId", this.f11550d);
                    String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                    j.a();
                    j.a(this.f11501r, "orientation", strEncodeToString);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
    }

    public void setWebView(WebView webView) {
        this.f11501r = webView;
    }

    public AnythinkBTLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
