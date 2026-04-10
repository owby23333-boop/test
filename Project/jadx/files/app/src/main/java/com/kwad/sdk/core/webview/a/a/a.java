package com.kwad.sdk.core.webview.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bo;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0447a {
        void c(com.kwad.sdk.e.kwai.b bVar);

        void d(com.kwad.sdk.e.kwai.b bVar);

        void e(com.kwad.sdk.e.kwai.b bVar);
    }

    public static void a(Context context, final com.kwad.sdk.e.kwai.b bVar, @NonNull final InterfaceC0447a interfaceC0447a) {
        com.kwad.sdk.core.d.b.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0447a.c(bVar);
        bVar.aa(System.currentTimeMillis());
        com.kwad.sdk.core.webview.a.b.b.a(bVar, 1);
        r.dx(bo.dt(context));
        r.Hd();
        r.eV(bVar.packageUrl).j(bVar).eS(bVar.asJ).bK(true).a(new m() { // from class: com.kwad.sdk.core.webview.a.a.a.1
            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, th.getMessage());
                interfaceC0447a.e((com.kwad.sdk.e.kwai.b) aVar.getTag());
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.Ge() == -3) {
                    interfaceC0447a.d(bVar);
                    return;
                }
                interfaceC0447a.e(bVar);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.Ge()));
            }
        }).start();
    }
}
