package com.anythink.expressad.video.signal.a;

import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.module.AnythinkVideoView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11951n = "onVideoStatusNotify";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f11952o = "onJSClick";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11953p = "onVideoProgressNotify";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11954q = "webviewshow";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f11955r = "showDataInfo";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f11956s = "portrait";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f11957t = "landscape";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private WebView f11958u;

    public l(WebView webView) {
        this.f11958u = webView;
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a() {
        super.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u);
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i2) {
        super.a(i2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", i2);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u, f11951n, strEncodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i2, String str) {
        super.a(i2, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i2);
            jSONObject.put("pt", str);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u, f11952o, strEncodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(AnythinkVideoView.a aVar) {
        super.a(aVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(aVar.a, aVar.b));
            jSONObject.put("time", String.valueOf(aVar.a));
            jSONObject.put("duration", String.valueOf(aVar.b));
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u, f11953p, strEncodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String a(int i2, int i3) {
        if (i3 != 0) {
            double d2 = i2 / i3;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(t.a(Double.valueOf(d2)));
                return sb.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return String.valueOf(i3);
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(Object obj) {
        super.a(obj);
        String strEncodeToString = (obj == null || !(obj instanceof String)) ? "" : Base64.encodeToString(obj.toString().getBytes(), 2);
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u, f11954q, strEncodeToString);
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = f11957t;
            if (i2 != 2 ? i3 != 2 : i3 == 1) {
                str = f11956s;
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i4);
            jSONObject2.put("screen_height", i5);
            jSONObject.put("data", jSONObject2);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.f11958u, f11955r, strEncodeToString);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }
}
