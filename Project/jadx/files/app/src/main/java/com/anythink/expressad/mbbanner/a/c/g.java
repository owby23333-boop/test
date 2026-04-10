package com.anythink.expressad.mbbanner.a.c;

import android.graphics.Bitmap;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.anythink.expressad.foundation.g.d.c {
    private static final String a = "g";
    private com.anythink.expressad.mbbanner.a.d.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10809c;

    public g(com.anythink.expressad.mbbanner.a.d.b bVar, String str) {
        this.b = bVar;
        this.f10809c = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        o.b(a, "DownloadImageListener campaign image success");
        this.b.a(this.f10809c, 1, str, true);
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(String str, String str2) {
        o.b(a, "DownloadImageListener campaign image fail");
        this.b.a(this.f10809c, 1, str2, false);
    }
}
