package com.bytedance.sdk.openadsdk.core.e;

import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static a gc = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.sdk.component.z f1038a;
    private int dl;
    private int g;
    private na z;

    public static a z() {
        return gc;
    }

    private boolean g() {
        this.f1038a = LogAdapter.z;
        return this.f1038a != null;
    }

    public a z(na naVar) {
        if (g()) {
            this.z = naVar;
        }
        return this;
    }

    public a z(int i) {
        if (g()) {
            this.g = i;
        }
        return this;
    }

    public a g(int i) {
        if (g()) {
            this.dl = i;
        }
        return this;
    }

    public void z(Thread thread, Throwable th) {
        if (g()) {
            String str = thread != null ? thread.getName() + "-" + thread.getId() : "";
            this.f1038a.z(str, "-------fatal----------");
            this.f1038a.z(str, "last show rit:" + this.dl);
            this.f1038a.z(str, "last show adtype:" + this.g);
            this.f1038a.z(str, dl());
            this.f1038a.z(str, th);
            this.f1038a.z(str, "-------finish----------");
            LogAdapter.z.z().z();
        }
    }

    private String dl() {
        na naVar = this.z;
        return naVar != null ? com.bytedance.sdk.component.utils.z.z(naVar.kv()).toString() : "";
    }
}
