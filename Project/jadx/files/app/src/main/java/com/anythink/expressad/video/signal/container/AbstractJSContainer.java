package com.anythink.expressad.video.signal.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.signal.b;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import com.anythink.expressad.video.signal.factory.a;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.c.c;
import com.anythink.expressad.videocommon.e.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final String f12076k = "AbstractJSContainer";
    private int a;
    private int b;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Activity f12077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected String f12078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected String f12079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected d f12080o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected String f12081p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected c f12082q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f12083r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f12084s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f12085t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f12086u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f12087v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f12088w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f12089x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected boolean f12090y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected IJSFactory f12091z;

    public AbstractJSContainer(Context context) {
        super(context);
        this.a = 0;
        this.b = 1;
        this.f12084s = 2;
        this.f12085t = false;
        this.f12086u = false;
        this.f12090y = false;
        this.f12091z = new a();
    }

    private static void b(Object obj, String str) {
        j.a().a(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    protected final void a(Object obj) {
        j.a().a(obj, a(this.a));
    }

    protected final int c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.video.signal.a.j jVarB = b(cVar);
        if (jVarB != null) {
            return jVarB.d();
        }
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        return this.f12091z.getActivityProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.f12091z.getIJSRewardVideoV1();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public b getJSBTModule() {
        return this.f12091z.getJSBTModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        return this.f12091z.getJSCommon();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        return this.f12091z.getJSContainerModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.f12091z.getJSNotifyProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        return this.f12091z.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.f12079n;
    }

    public String getUnitId() {
        return this.f12078m;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().g()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().g()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().g()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().g()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        if (getJSCommon().g()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().g()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().g()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.f12091z = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.f12077l = activity;
    }

    public void setBidCampaign(boolean z2) {
        this.f12086u = z2;
    }

    public void setBigOffer(boolean z2) {
        this.f12090y = z2;
    }

    public void setIV(boolean z2) {
        this.f12085t = z2;
    }

    public void setIVRewardEnable(int i2, int i3, int i4) {
        this.f12087v = i2;
        this.f12088w = i3;
        this.f12089x = i4;
    }

    public void setMute(int i2) {
        this.f12084s = i2;
    }

    public void setPlacementId(String str) {
        this.f12079n = str;
    }

    public void setReward(c cVar) {
        this.f12082q = cVar;
    }

    public void setRewardId(String str) {
        this.f12083r = str;
    }

    public void setRewardUnitSetting(d dVar) {
        this.f12080o = dVar;
    }

    public void setUnitId(String str) {
        this.f12078m = str;
    }

    public void setUserId(String str) {
        this.f12081p = str;
    }

    protected static void a(Object obj, String str) {
        j.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private void b(Object obj) {
        j.a().b(obj, a(this.b));
    }

    private static void a(WindVaneWebView windVaneWebView, String str, String str2) {
        j.a();
        j.a((WebView) windVaneWebView, str, Base64.encodeToString(str2.getBytes(), 2));
    }

    protected final com.anythink.expressad.video.signal.a.j b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        a.C0226a c0226aA = com.anythink.expressad.videocommon.a.a(this.f12085t ? com.anythink.expressad.foundation.g.a.aU : 94, cVar);
        if (c0226aA != null && c0226aA.c()) {
            WindVaneWebView windVaneWebViewA = c0226aA.a();
            if (windVaneWebViewA.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                o.d(f12076k, "JSCommon 进来");
                return (com.anythink.expressad.video.signal.a.j) windVaneWebViewA.getObject();
            }
        }
        return null;
    }

    private static String a(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(f12076k, "code to string is error");
            return "";
        }
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 1;
        this.f12084s = 2;
        this.f12085t = false;
        this.f12086u = false;
        this.f12090y = false;
        this.f12091z = new com.anythink.expressad.video.signal.factory.a();
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private boolean b(int i2) {
        boolean z2 = false;
        try {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f12077l.setRequestedOrientation(11);
                } else {
                    this.f12077l.setRequestedOrientation(0);
                }
            } else if (Build.VERSION.SDK_INT >= 18) {
                this.f12077l.setRequestedOrientation(12);
            } else {
                this.f12077l.setRequestedOrientation(1);
            }
            z2 = true;
            return true;
        } catch (Throwable th) {
            o.b(f12076k, th.getMessage(), th);
            return z2;
        }
    }

    protected void a(String str) {
        o.d(f12076k, str);
        Activity activity = this.f12077l;
        if (activity != null) {
            activity.finish();
        }
    }

    protected final void a(d dVar, com.anythink.expressad.foundation.d.c cVar) {
        c.C0205c c0205cM;
        if (c(cVar) == 1) {
            return;
        }
        boolean zB = false;
        if (cVar != null && (c0205cM = cVar.M()) != null) {
            zB = b(c0205cM.c());
        }
        if (zB || dVar == null) {
            return;
        }
        b(this.f12080o.b());
    }

    protected final String b() {
        d dVar;
        if (TextUtils.isEmpty(this.f12079n) && (dVar = this.f12080o) != null && !TextUtils.isEmpty(dVar.O())) {
            return this.f12080o.O();
        }
        return this.f12079n;
    }
}
