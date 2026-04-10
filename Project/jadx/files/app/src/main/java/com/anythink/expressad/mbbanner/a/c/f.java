package com.anythink.expressad.mbbanner.a.c;

import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.videocommon.b.i;

/* JADX INFO: loaded from: classes2.dex */
public class f implements i.b {
    private static final String a = "f";
    private com.anythink.expressad.mbbanner.a.d.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10808c;

    public f(com.anythink.expressad.mbbanner.a.d.b bVar, String str) {
        this.b = bVar;
        this.f10808c = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(String str) {
        o.b(a, "DownloadBannerUrlListener HTML SUCCESS:".concat(String.valueOf(str)));
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f10808c, 3, str, true);
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(String str, String str2) {
        o.b(a, "DownloadBannerUrlListener HTML FAIL:".concat(String.valueOf(str)));
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f10808c, 3, str, false);
        }
    }
}
