package com.anythink.expressad.video.signal.factory;

import com.anythink.expressad.video.signal.a.d;
import com.anythink.expressad.video.signal.a.f;
import com.anythink.expressad.video.signal.c;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import com.anythink.expressad.video.signal.j;

/* JADX INFO: loaded from: classes2.dex */
public class a implements IJSFactory {
    protected com.anythink.expressad.video.signal.a a;
    protected c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f12093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected g f12094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f12095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected i f12096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.anythink.expressad.video.signal.b f12097g;

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        if (this.a == null) {
            this.a = new com.anythink.expressad.video.signal.a.a();
        }
        return this.a;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f12096f == null) {
            this.f12096f = new f();
        }
        return this.f12096f;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        if (this.f12097g == null) {
            this.f12097g = new com.anythink.expressad.video.signal.a.b();
        }
        return this.f12097g;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public c getJSCommon() {
        if (this.b == null) {
            this.b = new com.anythink.expressad.video.signal.a.c();
        }
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        if (this.f12095e == null) {
            this.f12095e = new d();
        }
        return this.f12095e;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.f12094d == null) {
            this.f12094d = new com.anythink.expressad.video.signal.a.e();
        }
        return this.f12094d;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.f12093c == null) {
            this.f12093c = new com.anythink.expressad.video.signal.a.g();
        }
        return this.f12093c;
    }
}
