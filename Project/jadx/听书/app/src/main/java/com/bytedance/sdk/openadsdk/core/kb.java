package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.gc f1210a;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl dl;
    private String e;
    private final na g;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.a gc;
    private View m;
    private final Context z;

    public kb(Context context, na naVar, View view, String str) {
        this.e = "rewarded_video";
        this.g = naVar;
        this.z = context;
        this.m = view;
        if (TextUtils.isEmpty(str)) {
            this.e = com.bytedance.sdk.openadsdk.core.un.eo.g(com.bytedance.sdk.openadsdk.core.un.eo.gz(naVar));
        } else {
            this.e = str;
        }
        if (naVar.lt() == 4) {
            this.dl = com.bytedance.sdk.openadsdk.core.kb.gz.z(context, naVar, this.e, false);
        }
        String str2 = this.e;
        com.bytedance.sdk.openadsdk.core.nativeexpress.gc gcVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.gc(context, naVar, str2, com.bytedance.sdk.openadsdk.core.un.eo.g(str2));
        this.f1210a = gcVar;
        gcVar.z(this.m);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.f1210a.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
        String str3 = this.e;
        com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a(context, naVar, str3, com.bytedance.sdk.openadsdk.core.un.eo.g(str3));
        this.gc = aVar;
        aVar.z(this.m);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
    }

    public void z(int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar;
        if (i == -1 || zwVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.iq.uy uyVar = new com.bytedance.sdk.openadsdk.core.iq.uy();
        uyVar.z(zwVar.z);
        uyVar.g(zwVar.g);
        uyVar.dl(zwVar.dl);
        uyVar.a(zwVar.f1208a);
        uyVar.z(zwVar.pf);
        uyVar.z(zwVar.ls);
        if (i != 1) {
            if (i == 2 && (aVar = this.gc) != null) {
                aVar.z(zwVar);
                this.gc.z(uyVar);
                this.gc.z(this.m, uyVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.gc gcVar = this.f1210a;
        if (gcVar != null) {
            gcVar.z(zwVar);
            this.f1210a.z(uyVar);
            this.f1210a.z(this.m, uyVar);
        }
    }
}
