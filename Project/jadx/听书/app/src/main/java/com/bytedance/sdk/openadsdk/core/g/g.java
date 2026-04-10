package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1069a;
    protected final int dl;
    protected final String g;
    protected com.bytedance.sdk.openadsdk.core.g.z.dl gc;
    protected final na z;

    protected boolean z() {
        return false;
    }

    public g(Context context, na naVar, String str, int i) {
        super(context);
        this.f1069a = 1;
        this.z = naVar;
        this.g = str;
        this.dl = i;
        gc();
    }

    private void gc() {
        com.bytedance.sdk.openadsdk.core.g.z.dl dlVarZ = this.gz.z(this.z, this.m, this, z());
        this.gc = dlVarZ;
        dlVarZ.z(this.e);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.g);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.g);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
        if (z()) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).a(true);
        }
    }

    public void z(int i) {
        this.f1069a = i;
        if (this.e != null) {
            this.e.z(i);
        }
    }

    public void z(uy uyVar) {
        this.e = uyVar;
    }

    public uy g() {
        return this.e;
    }

    public void z(View view) {
        this.e.g(view);
    }

    public void g(View view) {
        this.e.z(view);
    }

    public void g(int i) {
        this.e.a(i);
    }

    public void dl(int i) {
        this.e.dl(i);
    }

    public void a(int i) {
        this.e.g(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void z(View view, uy uyVar) {
        if (na.gc(this.z)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(((com.bytedance.sdk.openadsdk.core.g.z.dl.z) z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).gc());
        this.gc.z(view);
        if (uyVar == null) {
            uyVar = new uy();
        }
        this.gc.z(uyVar);
        this.gc.z();
        na.m(this.z);
    }
}
