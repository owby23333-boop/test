package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.splash.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
abstract class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected gz.z f998a;
    protected na dl;
    protected ViewGroup g;
    protected Context z;

    public abstract String z();

    public abstract void z(com.bytedance.sdk.openadsdk.core.g.z zVar);

    public void z(boolean z) {
    }

    dl() {
    }

    public void z(Context context, ViewGroup viewGroup, na naVar) {
        this.z = context;
        this.g = viewGroup;
        this.dl = naVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, gz.z zVar) {
        com.bytedance.sdk.openadsdk.core.i.a.dl(this.dl, "splash_ad", z());
        this.g.setVisibility(0);
        this.f998a = zVar;
    }

    public void g() {
        gz.z zVar = this.f998a;
        if (zVar != null) {
            zVar.g();
        }
    }
}
