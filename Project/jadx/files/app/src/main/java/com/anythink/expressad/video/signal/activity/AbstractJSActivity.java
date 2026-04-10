package com.anythink.expressad.video.signal.activity;

import android.content.res.Configuration;
import com.anythink.expressad.activity.ATBaseActivity;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.signal.b;
import com.anythink.expressad.video.signal.c;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import com.anythink.expressad.video.signal.factory.a;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import com.anythink.expressad.video.signal.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractJSActivity extends ATBaseActivity implements IJSFactory {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final String f11963n = "AbstractJSActivity";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected IJSFactory f11964o = new a();

    private static boolean b() {
        return false;
    }

    public final void a(IJSFactory iJSFactory) {
        this.f11964o = iJSFactory;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        return this.f11964o.getActivityProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.f11964o.getIJSRewardVideoV1();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public b getJSBTModule() {
        return this.f11964o.getJSBTModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public c getJSCommon() {
        return this.f11964o.getJSCommon();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        return this.f11964o.getJSContainerModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.f11964o.getJSNotifyProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.f11964o.getJSVideoModule();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!getJSCommon().g()) {
            o.a(f11963n, "onBackPressed can't excute");
        } else if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
            getActivityProxy().g();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getJSCommon().g()) {
            getActivityProxy().a(configuration);
        }
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (getJSCommon().g()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        if (getJSCommon().g()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }
}
