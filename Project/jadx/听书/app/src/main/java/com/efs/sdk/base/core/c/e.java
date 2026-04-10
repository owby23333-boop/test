package com.efs.sdk.base.core.c;

import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.d.b f1541a;
    private c b;
    private String c;

    public e(com.efs.sdk.base.core.d.b bVar, c cVar, String str) {
        this.f1541a = bVar;
        this.b = cVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpResponse httpResponse;
        c cVar;
        com.efs.sdk.base.core.d.b bVar = this.f1541a;
        if (bVar != null && (cVar = this.b) != null) {
            httpResponse = cVar.a(bVar, true);
        } else {
            httpResponse = new HttpResponse();
        }
        d.a().a(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
