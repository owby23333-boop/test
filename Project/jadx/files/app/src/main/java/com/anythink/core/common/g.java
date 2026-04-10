package com.anythink.core.common;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends CountDownTimer {
    protected ai a;
    protected com.anythink.core.common.e.e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.anythink.core.c.d f7431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f7432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f7433e;

    private class a implements ATCustomLoadListener {
        ATBaseAdAdapter a;
        long b;

        /* synthetic */ a(g gVar, long j2, ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(j2, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(BaseAd... baseAdArr) {
            g.this.a(this.b, this.a, baseAdArr != null ? Arrays.asList(baseAdArr) : null);
            ATBaseAdAdapter aTBaseAdAdapter = this.a;
            if (aTBaseAdAdapter != null) {
                aTBaseAdAdapter.releaseLoadResource();
            }
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            g.a(this.b, this.a);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(String str, String str2) {
            g gVar = g.this;
            long j2 = this.b;
            ATBaseAdAdapter aTBaseAdAdapter = this.a;
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, str, str2);
            com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            if (!gVar.f7432d) {
                gVar.f7432d = true;
                com.anythink.core.common.j.c.a(trackingInfo, 0, errorCode, SystemClock.elapsedRealtime() - j2);
                com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.f6861g, errorCode.printStackTrace());
            }
            ATBaseAdAdapter aTBaseAdAdapter2 = this.a;
            if (aTBaseAdAdapter2 != null) {
                aTBaseAdAdapter2.releaseLoadResource();
            }
        }

        private a(long j2, ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = j2;
            this.a = aTBaseAdAdapter;
        }
    }

    public g(long j2, long j3, ai aiVar, com.anythink.core.common.e.e eVar) {
        super(j2, j3);
        this.f7433e = g.class.getSimpleName();
        this.f7432d = false;
        this.a = aiVar;
        this.b = eVar;
    }

    private void a(Context context) {
        ATBaseAdAdapter aTBaseAdAdapterA = com.anythink.core.common.k.i.a(this.a);
        if (aTBaseAdAdapterA == null) {
            return;
        }
        com.anythink.core.common.e.e eVar = this.b;
        eVar.f7243q = 1;
        eVar.f7244r = 0;
        eVar.f7245s = 0;
        aTBaseAdAdapterA.setTrackingInfo(eVar);
        aTBaseAdAdapterA.setUnitGroupInfo(this.a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.j.a.a(context).a(1, this.b);
        com.anythink.core.common.k.g.a(this.b, g.i.a, g.i.f6862h, "");
        this.f7431c = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.b.W());
        com.anythink.core.common.a.a().a(this.b.W(), this.b.x());
        this.f7432d = false;
        aTBaseAdAdapterA.internalLoad(context, this.f7431c.a(this.b.W(), this.b.X(), aTBaseAdAdapterA.getUnitGroupInfo()), v.a().c(this.b.W()), new a(this, jElapsedRealtime, aTBaseAdAdapterA, (byte) 0));
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Context contextG;
        ATBaseAdAdapter aTBaseAdAdapterA;
        if (this.a == null || this.b == null || (contextG = com.anythink.core.common.b.n.a().g()) == null || (aTBaseAdAdapterA = com.anythink.core.common.k.i.a(this.a)) == null) {
            return;
        }
        com.anythink.core.common.e.e eVar = this.b;
        eVar.f7243q = 1;
        eVar.f7244r = 0;
        eVar.f7245s = 0;
        aTBaseAdAdapterA.setTrackingInfo(eVar);
        aTBaseAdAdapterA.setUnitGroupInfo(this.a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.j.a.a(contextG).a(1, this.b);
        com.anythink.core.common.k.g.a(this.b, g.i.a, g.i.f6862h, "");
        this.f7431c = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.b.W());
        com.anythink.core.common.a.a().a(this.b.W(), this.b.x());
        this.f7432d = false;
        aTBaseAdAdapterA.internalLoad(contextG, this.f7431c.a(this.b.W(), this.b.X(), aTBaseAdAdapterA.getUnitGroupInfo()), v.a().c(this.b.W()), new a(this, jElapsedRealtime, aTBaseAdAdapterA, (byte) 0));
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j2) {
    }

    protected static void a(long j2, com.anythink.core.common.b.d dVar) {
        dVar.getTrackingInfo().c(SystemClock.elapsedRealtime() - j2);
    }

    protected final void a(long j2, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list) {
        com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        if (!this.f7432d) {
            this.f7432d = true;
            trackingInfo.d(SystemClock.elapsedRealtime() - j2);
            com.anythink.core.common.j.a.a(com.anythink.core.common.b.n.a().g()).a(2, trackingInfo);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.f6860f, "");
        }
        com.anythink.core.common.a.a().a(trackingInfo.W(), trackingInfo.z(), aTBaseAdAdapter, list, this.a.p());
    }

    private void a(long j2, com.anythink.core.common.b.d dVar, AdError adError) {
        com.anythink.core.common.e.e trackingInfo = dVar.getTrackingInfo();
        if (this.f7432d) {
            return;
        }
        this.f7432d = true;
        com.anythink.core.common.j.c.a(trackingInfo, 0, adError, SystemClock.elapsedRealtime() - j2);
        com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.f6861g, adError.printStackTrace());
    }
}
