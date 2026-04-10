package com.kwad.components.offline.tk;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.e;
import com.kwad.components.core.n.f;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKInitCallBack;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.offline.init.a {
    private static long Xn;
    private final List<com.kwad.components.core.offline.api.a.a> Xm;
    private final AtomicBoolean Xo;

    /* JADX INFO: renamed from: com.kwad.components.offline.tk.b$1, reason: invalid class name */
    final class AnonymousClass1 implements TKInitCallBack {
        final /* synthetic */ boolean Kl;
        final /* synthetic */ ITkOfflineCompo Xp;
        final /* synthetic */ long Xq;
        final /* synthetic */ long Xr;
        final /* synthetic */ Context jL;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, long j2, long j3, boolean z2, Context context) {
            this.Xp = iTkOfflineCompo;
            this.Xq = j2;
            this.Xr = j3;
            this.Kl = z2;
            this.jL = context;
        }

        @Override // com.kwad.components.offline.api.tk.TKInitCallBack
        public final void onSuccess(boolean z2) {
            final TkCompoImpl tkCompoImpl = new TkCompoImpl(this.Xp);
            com.kwad.sdk.components.c.a(com.kwad.components.core.offline.api.a.c.class, tkCompoImpl);
            b.this.Xo.set(true);
            TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.Xq).setSoLoadTime(SystemClock.elapsedRealtime() - this.Xr).setOfflineSource(this.Kl ? 1 : 2).setSoSource(z2 ? 2 : 1).toJson());
            com.kwad.sdk.core.d.b.d(b.this.getTag(), "offlineComponent load success");
            b.this.si();
            e.a(new f() { // from class: com.kwad.components.offline.tk.b.1.1
                @Override // com.kwad.components.core.n.f, com.kwad.components.core.n.e.a
                public final void a(@NonNull final SdkConfigData sdkConfigData) {
                    super.a(sdkConfigData);
                    g.execute(new Runnable() { // from class: com.kwad.components.offline.tk.b.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C04251 c04251 = C04251.this;
                            tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jL, sdkConfigData.toJson());
                        }
                    });
                }
            });
        }
    }

    static final class a {
        private static final b Xw = new b(0);
    }

    private b() {
        this.Xm = new CopyOnWriteArrayList();
        this.Xo = new AtomicBoolean(false);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void au(Context context) {
        Xn = SystemClock.elapsedRealtime();
        sh().init(context);
    }

    public static b sh() {
        return a.Xw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si() {
        Iterator<com.kwad.components.core.offline.api.a.a> it = this.Xm.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
    }

    public final void a(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.Xo.get()) {
            aVar.onSuccess();
        }
        this.Xm.add(aVar);
    }

    public final void b(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.Xm.remove(aVar);
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
        if (iTkOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("TkInitModule", "onPluginLoaded components is null");
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - Xn;
        boolean zI = x.i(context, od(), oe());
        com.kwad.sdk.core.d.b.d(getTag(), "offlineComponent load " + zI + " components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
        iTkOfflineCompo.initReal(context, ServiceProvider.CF(), new c(), new AnonymousClass1(iTkOfflineCompo, jElapsedRealtime2, jElapsedRealtime, zI, context));
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return d.isCanUseTk();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean ob() {
        return false;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String od() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oe() {
        return "3.3.38.1";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String of() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.38.1-a469423ad-256.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String og() {
        return "88d6d5051436fd5a35066ce6113d498f";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oh() {
        return "ks_tk_134ad9665";
    }
}
