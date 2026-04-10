package com.bytedance.sdk.component.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.z.kb;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    gz f866a;
    boolean e;
    i fo;
    z g;
    Context gc;
    boolean gz;
    kb.g ls;
    boolean m;
    boolean pf;
    v uy;
    boolean v;
    com.bytedance.sdk.component.i.dl z;
    String dl = "IESJSBridge";
    String kb = "host";
    final Set<String> wp = new LinkedHashSet();
    final Set<String> i = new LinkedHashSet();

    uy(com.bytedance.sdk.component.i.dl dlVar) {
        this.z = dlVar;
    }

    uy() {
    }

    public uy z(z zVar) {
        this.g = zVar;
        return this;
    }

    public uy z(String str) {
        this.dl = str;
        return this;
    }

    public uy z(wp wpVar) {
        this.f866a = gz.z(wpVar);
        return this;
    }

    public uy z(boolean z) {
        this.m = z;
        return this;
    }

    public uy g(boolean z) {
        this.e = z;
        return this;
    }

    public uy z() {
        this.pf = true;
        return this;
    }

    public p g() {
        dl();
        return new p(this);
    }

    public Context getContext() {
        return this.gc;
    }

    private void dl() {
        if ((this.z == null && !this.v && this.g == null) || ((TextUtils.isEmpty(this.dl) && this.z != null) || this.f866a == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
