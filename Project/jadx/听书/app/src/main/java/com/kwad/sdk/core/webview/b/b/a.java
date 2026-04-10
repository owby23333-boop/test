package com.kwad.sdk.core.webview.b.b;

import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.b.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0410a {
        void c(com.kwad.sdk.h.a.b bVar);

        void d(com.kwad.sdk.h.a.b bVar);

        void e(com.kwad.sdk.h.a.b bVar);
    }

    public static void a(final com.kwad.sdk.h.a.b bVar, final InterfaceC0410a interfaceC0410a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0410a.c(bVar);
        bVar.aQ(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.aH(m.Ta());
        r.xI();
        r.bm(bVar.packageUrl).f(bVar).bk(bVar.aRr).be(true).a(new com.kwad.framework.filedownloader.m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.wJ() == -3) {
                    interfaceC0410a.d(bVar);
                } else {
                    interfaceC0410a.e(bVar);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.wJ()));
                }
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                interfaceC0410a.e((com.kwad.sdk.h.a.b) aVar.getTag());
            }
        }).start();
    }
}
