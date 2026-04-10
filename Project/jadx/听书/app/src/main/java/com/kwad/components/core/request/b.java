package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final List<a> WW;

    public interface a {
        void sl();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    static class C0350b {
        private static final b WX = new b(0);
    }

    public static b sj() {
        return C0350b.WX;
    }

    private b() {
        this.WW = new CopyOnWriteArrayList();
    }

    public final void a(a aVar) {
        this.WW.add(aVar);
    }

    public final void b(a aVar) {
        this.WW.remove(aVar);
    }

    public final void sk() {
        for (a aVar : this.WW) {
            if (aVar != null) {
                try {
                    aVar.sl();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }
}
