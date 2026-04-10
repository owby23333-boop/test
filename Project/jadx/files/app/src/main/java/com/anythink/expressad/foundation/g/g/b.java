package com.anythink.expressad.foundation.g.g;

import android.content.Context;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private static WeakHashMap<Context, c> b = new WeakHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f10611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f10612d;

    private b(Context context) {
        this.f10612d = context;
        if (b.get(this.f10612d) != null) {
            this.f10611c = b.get(this.f10612d);
        } else {
            this.f10611c = new c(this.f10612d, 5);
            b.put(this.f10612d, this.f10611c);
        }
    }

    private void a(a aVar) {
        this.f10611c.a(aVar);
    }
}
