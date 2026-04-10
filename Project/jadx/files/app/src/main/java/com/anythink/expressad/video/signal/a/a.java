package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.anythink.expressad.video.signal.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final String f11913f = "DefaultJSActivity";

    @Override // com.anythink.expressad.video.signal.a
    public void a() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onPause");
    }

    @Override // com.anythink.expressad.video.signal.a
    public void b() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onResume");
    }

    @Override // com.anythink.expressad.video.signal.a
    public void c() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onDestory");
    }

    @Override // com.anythink.expressad.video.signal.a
    public final void d() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onStop");
    }

    @Override // com.anythink.expressad.video.signal.a
    public final void e() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onStart");
    }

    @Override // com.anythink.expressad.video.signal.a
    public final void f() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onRestart");
    }

    @Override // com.anythink.expressad.video.signal.a
    public void g() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onBackPressed");
    }

    @Override // com.anythink.expressad.video.signal.a
    public int h() {
        com.anythink.expressad.foundation.h.o.a(f11913f, "isSystemResume");
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.a
    public void a(Configuration configuration) {
        com.anythink.expressad.foundation.h.o.a(f11913f, "DefaultJSActivity-onConfigurationChanged:" + configuration.orientation);
    }

    @Override // com.anythink.expressad.video.signal.a
    public void a(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11913f, "setSystemResume,isResume:".concat(String.valueOf(i2)));
    }
}
