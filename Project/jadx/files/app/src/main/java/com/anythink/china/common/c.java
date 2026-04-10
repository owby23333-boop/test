package com.anythink.china.common;

import android.os.SystemClock;
import com.anythink.china.api.ATAppDownloadListener;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.f;
import com.anythink.core.common.r;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements CustomAdapterDownloadListener {
    ATBaseAdAdapter a;
    BaseAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ATAdInfo f6456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WeakReference<ATAppDownloadListener> f6457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f6458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f6459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f6460g;

    public c(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        this.a = aTBaseAdAdapter;
        this.b = baseAd;
        if (aTEventInterface == null || !(aTEventInterface instanceof ATAppDownloadListener)) {
            return;
        }
        this.f6457d = new WeakReference<>((ATAppDownloadListener) aTEventInterface);
    }

    private void a() {
        BaseAd baseAd = this.b;
        if (baseAd != null) {
            this.f6456c = j.a(baseAd);
        } else {
            this.f6456c = j.a(this.a);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFail(long j2, long j3, String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFail(this.f6456c, j2, j3, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFinish(long j2, String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        if (this.f6458e != 0 && !this.f6460g) {
            this.f6460g = true;
            a(19, SystemClock.elapsedRealtime() - this.f6458e, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFinish(this.f6456c, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadPause(long j2, long j3, String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadPause(this.f6456c, j2, j3, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadStart(long j2, long j3, String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        this.f6458e = SystemClock.elapsedRealtime();
        a(18, 0L, str2);
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadStart(this.f6456c, j2, j3, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadUpdate(long j2, long j3, String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadUpdate(this.f6456c, j2, j3, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onInstalled(String str, String str2) {
        if (this.f6456c == null) {
            a();
        }
        if (!this.f6459f) {
            this.f6459f = true;
            a(20, 0L, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.f6457d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onInstalled(this.f6456c, str, str2);
        }
    }

    private void a(final int i2, final long j2, final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.common.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    f fVar = new f();
                    fVar.b = c.this.b != null ? c.this.b.getDetail() : c.this.a.getTrackingInfo();
                    fVar.a = i2;
                    fVar.f7253c = System.currentTimeMillis();
                    if (fVar.b instanceof e) {
                        ((e) fVar.b).b(str);
                        ((e) fVar.b).b(j2);
                    }
                    r.a(n.a().g()).a(i2, fVar, com.anythink.core.c.b.a(n.a().g()).b(n.a().p()));
                } catch (Throwable unused) {
                }
            }
        });
    }
}
