package com.kwad.components.offline.d;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends com.kwad.components.core.o.b.a<ITkOfflineCompo> {
    private static long akg;
    private final List<com.kwad.components.core.o.a.e.a> akf;
    private final AtomicBoolean akh;

    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "4.5.20.1";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-4.4.20.2-634ee5d43a-104.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "91ef97cd6a396acd3eaffce69d31b5c5";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_tk_45201";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return ITkOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "TK";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static final class a {
        private static final c akr = new c(0);
    }

    public static c wx() {
        return a.akr;
    }

    private c() {
        this.akf = new CopyOnWriteArrayList();
        this.akh = new AtomicBoolean(false);
    }

    public static void aF(Context context) {
        akg = SystemClock.elapsedRealtime();
        wx().init(context);
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return com.kwad.sdk.core.h.a.JO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.o.b.a
    public void a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - akg, context));
    }

    /* JADX INFO: renamed from: com.kwad.components.offline.d.c$1, reason: invalid class name */
    final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo aki;
        final /* synthetic */ boolean akj;
        final /* synthetic */ long akk;
        final /* synthetic */ long akl;
        final /* synthetic */ Context dq;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.aki = iTkOfflineCompo;
            this.akj = z;
            this.akk = j;
            this.akl = j2;
            this.dq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            try {
                final b bVar = new b(this.aki);
                com.kwad.sdk.components.d.a(com.kwad.components.core.o.a.e.c.class, bVar);
                c.this.akh.set(true);
                int i = z ? 2 : 1;
                int i2 = this.akj ? 2 : 1;
                c.this.b(i, i2, SystemClock.elapsedRealtime() - this.akk, this.akl);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.akl).setSoLoadTime(SystemClock.elapsedRealtime() - this.akk).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - l.Cf().CH()).setThreadPoolCoreSize(i.zS().zM().An()).setOfflineSource(i2).setSoSource(i).toJson());
                c.this.qx();
                h.b(new com.kwad.components.core.request.i() { // from class: com.kwad.components.offline.d.c.1.1
                    @Override // com.kwad.components.core.request.i, com.kwad.components.core.request.h.a
                    public final void d(final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.offline.d.c.1.1.1
                            @Override // com.kwad.sdk.utils.bg
                            public final void doTask() {
                                bVar.onConfigRefresh(AnonymousClass1.this.dq, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i) {
            c.this.aJ(i);
        }
    }

    public final void a(com.kwad.components.core.o.a.e.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.akh.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.akf.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void b(com.kwad.components.core.o.a.e.a aVar) {
        if (aVar == null) {
            return;
        }
        this.akf.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, long j, long j2) {
        Iterator<com.kwad.components.core.o.a.e.a> it = this.akf.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i, i2, j, j2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
