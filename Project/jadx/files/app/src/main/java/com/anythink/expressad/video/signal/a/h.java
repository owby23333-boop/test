package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11933g = "orientation";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11934h = "onSystemPause";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f11935i = "onSystemResume";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f11936j = "onSystemDestory";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f11937k = "onSystemBackPressed";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f11938l = "portrait";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f11939m = "landscape";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WebView f11940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f11941o = 0;

    public h(WebView webView) {
        this.f11940n = webView;
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a() {
        super.a();
        this.f11941o = 1;
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11940n, "onSystemPause", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void b() {
        super.b();
        this.f11941o = 0;
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11940n, "onSystemResume", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void c() {
        super.c();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11940n, "onSystemDestory", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void g() {
        super.g();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11940n, f11937k, "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final int h() {
        return this.f11941o;
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a(Configuration configuration) {
        super.a(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", f11939m);
            } else {
                jSONObject.put("orientation", f11938l);
            }
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11940n, "orientation", strEncodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a(int i2) {
        super.a(i2);
        this.f11941o = i2;
    }
}
