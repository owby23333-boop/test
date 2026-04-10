package com.anythink.expressad.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;
import com.anythink.expressad.video.signal.a.h;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.video.signal.a.k;
import com.anythink.expressad.video.signal.a.l;
import com.anythink.expressad.video.signal.a.m;
import com.anythink.expressad.video.signal.a.n;
import com.anythink.expressad.video.signal.c;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Activity f12098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WebView f12099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AnythinkVideoView f12100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AnythinkContainerView f12101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f12102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AnythinkBTContainer f12103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<c> f12104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private c.a f12105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f12106p;

    public b(Activity activity) {
        this.f12098h = activity;
    }

    public final void a(j jVar) {
        this.b = jVar;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        WebView webView = this.f12099i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.a == null) {
            this.a = new h(webView);
        }
        return this.a;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        Activity activity;
        AnythinkContainerView anythinkContainerView = this.f12101k;
        if (anythinkContainerView == null || (activity = this.f12098h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f12096f == null) {
            this.f12096f = new m(activity, anythinkContainerView);
        }
        return this.f12096f;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        AnythinkBTContainer anythinkBTContainer;
        Activity activity = this.f12098h;
        if (activity == null || (anythinkBTContainer = this.f12103m) == null) {
            return super.getJSBTModule();
        }
        if (this.f12097g == null) {
            this.f12097g = new com.anythink.expressad.video.signal.a.i(activity, anythinkBTContainer);
        }
        return this.f12097g;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        com.anythink.expressad.foundation.d.c cVar;
        List<com.anythink.expressad.foundation.d.c> list;
        Activity activity = this.f12098h;
        if (activity == null || (cVar = this.f12102l) == null) {
            return super.getJSCommon();
        }
        if (this.b == null) {
            this.b = new j(activity, cVar);
        }
        if (this.f12102l.k() == 5 && (list = this.f12104n) != null) {
            com.anythink.expressad.video.signal.c cVar2 = this.b;
            if (cVar2 instanceof j) {
                ((j) cVar2).a(list);
            }
        }
        this.b.a(this.f12098h);
        this.b.a(this.f12106p);
        this.b.a(this.f12105o);
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        AnythinkContainerView anythinkContainerView = this.f12101k;
        if (anythinkContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.f12095e == null) {
            this.f12095e = new k(anythinkContainerView);
        }
        return this.f12095e;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        WebView webView = this.f12099i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f12094d == null) {
            this.f12094d = new l(webView);
        }
        return this.f12094d;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        AnythinkVideoView anythinkVideoView = this.f12100j;
        if (anythinkVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f12093c == null) {
            this.f12093c = new n(anythinkVideoView);
        }
        return this.f12093c;
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.f12104n = list;
    }

    public b(Activity activity, AnythinkBTContainer anythinkBTContainer, WebView webView) {
        this.f12098h = activity;
        this.f12103m = anythinkBTContainer;
        this.f12099i = webView;
    }

    private b(Activity activity, WebView webView, AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar) {
        this.f12098h = activity;
        this.f12099i = webView;
        this.f12100j = anythinkVideoView;
        this.f12101k = anythinkContainerView;
        this.f12102l = cVar;
    }

    public b(Activity activity, WebView webView, AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, c.a aVar) {
        this.f12098h = activity;
        this.f12099i = webView;
        this.f12100j = anythinkVideoView;
        this.f12101k = anythinkContainerView;
        this.f12102l = cVar;
        this.f12105o = aVar;
        this.f12106p = anythinkVideoView.getUnitId();
    }
}
