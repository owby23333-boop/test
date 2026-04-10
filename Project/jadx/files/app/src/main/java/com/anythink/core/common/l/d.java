package com.anythink.core.common.l;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.i;
import com.anythink.core.common.k.s;
import com.anythink.core.common.k.t;
import com.anythink.core.common.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final String a = "d";
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ai f7780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.anythink.core.common.e.e f7781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f7782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f7783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ATBaseAdAdapter f7784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    b f7785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f7786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f7787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f7788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f7789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Runnable f7790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Runnable f7791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    c f7792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Boolean f7793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f7794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String f7795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f7796s;

    /* JADX INFO: renamed from: com.anythink.core.common.l.d$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ ai b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7797c;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, Map map) {
            this.a = aTBaseAdAdapter;
            this.b = aiVar;
            this.f7797c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = d.this.f7785h;
            if (bVar != null) {
                bVar.a(this.a);
            }
            Context contextA = d.a(d.this);
            byte b = 0;
            if (contextA == null) {
                if (d.this.f7785h != null) {
                    com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                    aVar.a = 0;
                    aVar.f7771c = SystemClock.elapsedRealtime() - d.this.f7788k;
                    aVar.b = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", "Request Context is null! Please check the Ad init Context.");
                    d.this.a(this.a, aVar);
                    return;
                }
                return;
            }
            d.a(d.this, contextA, this.b, this.a);
            try {
                Map<String, Object> mapB = d.b(d.this);
                d.this.f7784g = this.a;
                this.a.internalLoad(contextA, this.f7797c, mapB, new a(d.this, d.this, this.a, b));
                com.anythink.core.common.e.e trackingInfo = this.a.getTrackingInfo();
                trackingInfo.g(this.a.getNetworkPlacementId());
                if (d.this.f7785h != null) {
                    d.this.f7785h.b(trackingInfo);
                }
            } catch (Throwable th) {
                com.anythink.core.common.l.a aVar2 = new com.anythink.core.common.l.a();
                aVar2.a = 0;
                aVar2.f7771c = SystemClock.elapsedRealtime() - d.this.f7788k;
                aVar2.b = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", th.getMessage());
                d.this.a(this.a, aVar2);
            }
        }
    }

    public class a implements ATCustomLoadListener {
        ATBaseAdAdapter a;
        d b;

        /* synthetic */ a(d dVar, d dVar2, ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(dVar2, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(final BaseAd... baseAdArr) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            a.this.b.a(a.this.a, baseAdArr);
                            a.this.b = null;
                            a.this.a = null;
                        }
                    }
                }
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            a.this.b.q();
                        }
                    }
                }
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(final String str, final String str2) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                            aVar.a = 0;
                            aVar.b = ErrorCode.getErrorCode(ErrorCode.noADError, str, str2);
                            aVar.f7771c = SystemClock.elapsedRealtime() - d.this.f7788k;
                            a.this.b.a(a.this.a, aVar);
                            a.this.b = null;
                            a.this.a = null;
                        }
                    }
                }
            });
        }

        private a(d dVar, ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = dVar;
            this.a = aTBaseAdAdapter;
        }
    }

    public d(ai aiVar, int i2) {
        this.f7780c = aiVar;
        this.f7794q = i2;
        this.f7782e = this.f7780c.t();
        this.f7795r = this.f7782e + "_" + hashCode();
    }

    private void i() {
        if (this.f7790m != null) {
            n.a().c(this.f7790m);
            this.f7790m = null;
        }
    }

    private void j() {
        if (this.f7791n != null) {
            n.a().c(this.f7791n);
            this.f7791n = null;
        }
    }

    private Map<String, Object> k() {
        c cVar = this.f7792o;
        com.anythink.core.c.d dVar = cVar.f7776e;
        String str = cVar.f7774c;
        if (dVar == null) {
            return new HashMap();
        }
        Map<String, Object> mapA = dVar.a(this.b, str, this.f7780c);
        int iC = this.f7780c.c();
        if (iC == 2) {
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.f7792o.a).b(n.a().p());
            if (aVarB != null) {
                mapA.put(g.k.f6906p, Boolean.valueOf(aVarB.j() == 1));
            }
        } else if (iC == 6) {
            JSONObject jSONObjectA = com.anythink.core.common.k.g.a(this.f7792o.a, str, this.b, dVar.X(), this.f7783f);
            if (dVar.av() == 1) {
                mapA.put("tp_info", jSONObjectA.toString());
            }
        }
        if (t.a(this.f7780c) && this.f7792o.f7776e.aq() == 1) {
            ae aeVarA = com.anythink.core.a.a.a(this.f7792o.a).a(this.b);
            mapA.put(g.k.f6901k, Integer.valueOf(aeVarA != null ? aeVarA.f7139c : 0));
            synchronized (v.a().a(this.b)) {
                String strA = v.a().a(this.b, this.f7780c.c());
                if (!TextUtils.isEmpty(strA)) {
                    mapA.put(g.k.f6902l, strA);
                }
            }
        }
        return mapA;
    }

    private Map<String, Object> l() {
        Map<String, Object> map = this.f7792o.f7777f;
        return map == null ? new HashMap(2) : map;
    }

    private Context m() {
        Context contextE = this.f7792o.b.get();
        if (!(contextE instanceof Activity)) {
            contextE = n.a().E();
        }
        if (ATSDK.isNetworkLogDebug()) {
            "requestContext = ".concat(String.valueOf(contextE));
        }
        return contextE;
    }

    private boolean n() {
        return !this.f7796s || this.f7787j || s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        if (n()) {
            return;
        }
        this.f7786i = true;
        new StringBuilder("network short timeout: ").append(this.f7782e);
        if (this.f7785h != null) {
            this.f7785h.a(this.f7795r, this.f7782e);
        }
    }

    private Runnable p() {
        return new Runnable() { // from class: com.anythink.core.common.l.d.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.o();
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        i();
        this.f7789l = SystemClock.elapsedRealtime() - this.f7788k;
        if (this.f7781d != null) {
            this.f7781d.c(this.f7789l);
        }
    }

    private void r() {
        this.f7784g = null;
    }

    private boolean s() {
        return this.f7793p != null;
    }

    private long t() {
        return this.f7788k;
    }

    public final void b() {
        BaseAd baseAdB;
        ATBaseAdAdapter aTBaseAdAdapterA;
        boolean z2;
        String str;
        this.f7796s = true;
        com.anythink.core.common.e.b bVarA = com.anythink.core.common.a.a().a(this.b, this.f7780c);
        if (bVarA != null && bVarA.a()) {
            b bVar = this.f7785h;
            if (bVar != null) {
                bVar.b(bVarA.e().getTrackingInfo());
            }
            b(bVarA.e(), this.f7780c);
            return;
        }
        m mVarN = this.f7780c.N();
        if (mVarN == null || !mVarN.f7354s) {
            baseAdB = null;
            aTBaseAdAdapterA = null;
            z2 = false;
        } else {
            com.anythink.core.b.c.a aVar = mVarN.f7353r;
            if (aVar != null) {
                aTBaseAdAdapterA = aVar.a();
                baseAdB = aVar.b();
            } else {
                baseAdB = null;
                aTBaseAdAdapterA = null;
            }
            mVarN.f7353r = null;
            z2 = true;
        }
        if (aTBaseAdAdapterA == null && !z2) {
            aTBaseAdAdapterA = i.a(this.f7780c);
        }
        if (aTBaseAdAdapterA == null) {
            if (this.f7785h != null) {
                com.anythink.core.common.l.a aVar2 = new com.anythink.core.common.l.a();
                aVar2.a = 0;
                aVar2.f7771c = z2 ? this.f7780c.k() : 0L;
                String str2 = z2 ? ErrorCode.c2sBiddingCacheError : "2002";
                if (z2) {
                    str = "";
                } else {
                    str = this.f7780c.h() + " does not exist!";
                }
                aVar2.b = ErrorCode.getErrorCode(str2, "", str);
                a((ATBaseAdAdapter) null, aVar2);
                return;
            }
            return;
        }
        try {
            com.anythink.core.common.k.d.a(this.f7780c.c(), aTBaseAdAdapterA.getNetworkSDKVersion());
        } catch (Throwable unused) {
        }
        this.f7781d = s.a(aTBaseAdAdapterA, this.f7781d, this.f7780c);
        b bVar2 = this.f7785h;
        if (bVar2 != null) {
            bVar2.a(this.f7781d);
        }
        long jB = this.f7780c.B();
        if (jB != -1) {
            this.f7790m = p();
            n.a().a(this.f7790m, jB);
        }
        long jQ = this.f7780c.q();
        if (jQ != -1) {
            this.f7791n = p();
            n.a().a(this.f7791n, jQ);
        }
        this.f7788k = SystemClock.elapsedRealtime();
        Context context = this.f7792o.b.get();
        if (context != null && (context instanceof Activity)) {
            aTBaseAdAdapterA.refreshActivityContext((Activity) context);
        }
        if (!z2) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapterA, this.f7780c, k());
            if (TextUtils.equals(String.valueOf(this.f7792o.f7776e.X()), "2")) {
                n.a().a(anonymousClass1);
                return;
            } else {
                com.anythink.core.common.k.b.a.a().b(anonymousClass1);
                return;
            }
        }
        b bVar3 = this.f7785h;
        if (bVar3 != null) {
            bVar3.b(this.f7781d);
        }
        if (baseAdB != null) {
            a(aTBaseAdAdapterA, baseAdB);
        } else {
            a(aTBaseAdAdapterA, new BaseAd[0]);
        }
    }

    public final boolean e() {
        return (s() && this.f7786i) ? false : true;
    }

    public final int f() {
        return this.f7794q;
    }

    public final boolean g() {
        return this.f7786i;
    }

    public final ai h() {
        return this.f7780c;
    }

    public final String a() {
        return this.f7795r;
    }

    public final synchronized void c() {
        if (n()) {
            return;
        }
        this.f7793p = Boolean.FALSE;
        this.f7787j = true;
        com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
        aVar.a = 0;
        aVar.f7771c = SystemClock.elapsedRealtime() - this.f7788k;
        aVar.b = ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "");
        a(this.f7784g, aVar);
    }

    public final Boolean d() {
        return this.f7793p;
    }

    public final void a(c cVar) {
        this.f7792o = cVar;
        this.b = cVar.f7775d;
        this.f7781d = cVar.f7779h;
        this.f7783f = cVar.f7778g;
    }

    public final void a(b bVar) {
        this.f7785h = bVar;
    }

    private void a(long j2) {
        if (j2 == -1) {
            return;
        }
        this.f7791n = p();
        n.a().a(this.f7791n, j2);
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapter, aiVar, k());
        if (TextUtils.equals(String.valueOf(this.f7792o.f7776e.X()), "2")) {
            n.a().a(anonymousClass1);
        } else {
            com.anythink.core.common.k.b.a.a().b(anonymousClass1);
        }
    }

    private void a(Context context, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.c.a.am()) {
            p pVarA = p.a(n.a().g());
            try {
                if (pVarA.c(aiVar.c()) || !aTBaseAdAdapter.setUserDataConsent(context, pVarA.c(), ATSDK.isEUTraffic(this.f7792o.a))) {
                    return;
                }
                pVarA.b(aiVar.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.f7784g = aTBaseAdAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
        if (n()) {
            return;
        }
        ai unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        this.f7781d.d((SystemClock.elapsedRealtime() - this.f7788k) + (unitGroupInfo.l() == 2 ? unitGroupInfo.k() : 0L));
        i();
        j();
        this.f7784g = null;
        this.f7793p = Boolean.TRUE;
        if (this.f7786i) {
            this.f7781d.f7244r = 1;
        }
        com.anythink.core.common.e.e eVar = this.f7781d;
        if (aTBaseAdAdapter != null && unitGroupInfo != null) {
            Map<String, Object> networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
            m mVarN = unitGroupInfo.N();
            if (mVarN != null) {
                mVarN.a(networkInfoMap);
                mVarN.a(eVar);
            }
        }
        if (this.f7785h != null) {
            this.f7785h.a(this.f7795r, aTBaseAdAdapter, baseAdArr);
        }
    }

    private static void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, com.anythink.core.common.e.e eVar) {
        if (aTBaseAdAdapter == null || aiVar == null) {
            return;
        }
        Map<String, Object> networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
        m mVarN = aiVar.N();
        if (mVarN != null) {
            mVarN.a(networkInfoMap);
            mVarN.a(eVar);
        }
    }

    private void b(long j2) {
        if (j2 == -1) {
            return;
        }
        this.f7790m = p();
        n.a().a(this.f7790m, j2);
    }

    private synchronized void b(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        if (n()) {
            return;
        }
        i();
        j();
        this.f7784g = null;
        this.f7793p = Boolean.TRUE;
        if (this.f7786i) {
            this.f7781d.f7244r = 1;
        }
        if (this.f7785h != null) {
            this.f7785h.a(this.f7795r, aTBaseAdAdapter, aiVar);
        }
    }

    public final synchronized void a(final ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.l.a aVar) {
        if (n()) {
            return;
        }
        i();
        j();
        if (aTBaseAdAdapter != null) {
            n.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (aTBaseAdAdapter != null) {
                            aTBaseAdAdapter.destory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        this.f7784g = null;
        this.f7793p = Boolean.FALSE;
        if (this.f7787j) {
            this.f7781d.f7244r = 2;
        } else if (this.f7786i) {
            this.f7781d.f7244r = 1;
        }
        if (!this.f7787j) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.anythink.core.common.c.a().a(this.f7782e, jCurrentTimeMillis);
            com.anythink.core.common.c.a().a(this.f7782e, jCurrentTimeMillis, aVar.b);
        }
        aVar.f7772d = this.f7781d;
        aVar.f7773e = this.f7780c;
        if (this.f7785h != null) {
            this.f7785h.a(this.f7795r, aVar);
        }
    }

    static /* synthetic */ Map b(d dVar) {
        Map<String, Object> map = dVar.f7792o.f7777f;
        return map == null ? new HashMap(2) : map;
    }

    static /* synthetic */ Context a(d dVar) {
        Context contextE = dVar.f7792o.b.get();
        if (!(contextE instanceof Activity)) {
            contextE = n.a().E();
        }
        if (ATSDK.isNetworkLogDebug()) {
            "requestContext = ".concat(String.valueOf(contextE));
        }
        return contextE;
    }

    static /* synthetic */ void a(d dVar, Context context, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.c.a.am()) {
            p pVarA = p.a(n.a().g());
            try {
                if (pVarA.c(aiVar.c()) || !aTBaseAdAdapter.setUserDataConsent(context, pVarA.c(), ATSDK.isEUTraffic(dVar.f7792o.a))) {
                    return;
                }
                pVarA.b(aiVar.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
