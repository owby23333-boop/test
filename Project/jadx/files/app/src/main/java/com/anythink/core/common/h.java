package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.k;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    int A;
    int B;
    ConcurrentHashMap<String, ai> D;
    ai F;
    protected Runnable J;
    com.anythink.core.common.l.f L;
    ai N;
    double O;
    ai Q;
    List<ai> R;
    protected WeakReference<Context> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f7541c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.anythink.core.c.d f7543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f7544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f7545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Map<String, Object> f7546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    com.anythink.core.common.e.e f7547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected j f7548j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected com.anythink.core.common.b.b f7550l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f7554p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f7555q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    List<ai> f7558t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    List<ai> f7559u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    List<ai> f7560v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    String f7562x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    long f7564z;
    private final String T = getClass().getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f7542d = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f7549k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f7551m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f7552n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected boolean f7553o = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f7556r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f7557s = false;
    Object C = new Object();
    double E = -1.0d;
    protected Runnable I = null;
    protected Runnable M = new Runnable() { // from class: com.anythink.core.common.h.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().b(new Runnable() { // from class: com.anythink.core.common.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.a();
                }
            });
        }
    };
    boolean P = false;
    boolean S = false;
    protected Context a = com.anythink.core.common.b.n.a().g();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    List<com.anythink.core.common.l.e> f7561w = Collections.synchronizedList(new ArrayList(2));

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    AdError f7563y = ErrorCode.getErrorCode(ErrorCode.noADError, "", "");
    protected Map<String, com.anythink.core.common.l.d> G = new ConcurrentHashMap();
    List<ai> H = Collections.synchronizedList(new ArrayList(3));
    com.anythink.core.common.l.h K = new com.anythink.core.common.l.h();

    /* JADX INFO: renamed from: com.anythink.core.common.h$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.I = null;
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.j();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.h$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.o();
        }
    }

    public static class a {
        public static final int a = 1;
        public static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f7566c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7567d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f7568e = 5;
    }

    public h(Context context) {
        this.b = new WeakReference<>(context);
    }

    private synchronized boolean A() {
        new StringBuilder("hasFinishAllRequest:isFinishBidding: ").append(this.f7551m);
        new StringBuilder("hasFinishAllRequest:requestWaitingPool: ").append(this.f7558t.size());
        new StringBuilder("hasFinishAllRequest:requestingPool: ").append(this.f7559u.size());
        new StringBuilder("hasFinishAllRequest:defaultRequestWaitingPool: ").append(this.f7560v.size());
        new StringBuilder("hasFinishAllRequest:showCapWaitingPool: ").append(this.f7561w.size());
        if (this.f7558t.size() == 0 && this.f7560v.size() == 0 && this.f7561w.size() == 0) {
            if (this.f7559u.size() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean B() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.List<com.anythink.core.common.e.ai> r0 = r1.f7558t     // Catch: java.lang.Throwable -> L16
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L14
            java.util.List<com.anythink.core.common.e.ai> r0 = r1.f7559u     // Catch: java.lang.Throwable -> L16
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L14
            r0 = 1
        L12:
            monitor-exit(r1)
            return r0
        L14:
            r0 = 0
            goto L12
        L16:
            r0 = move-exception
            monitor-exit(r1)
            goto L1a
        L19:
            throw r0
        L1a:
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.B():boolean");
    }

    private boolean C() {
        return (this.f7543e.j() != 1 || this.f7549k == 8 || v.a().f(this.f7545g)) ? false : true;
    }

    static /* synthetic */ boolean c(int i2) {
        return i2 == 3 || i2 == 5;
    }

    private static boolean d(int i2) {
        return i2 == 3 || i2 == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7545g);
        sb.append(":filled timeup to check cache.");
        com.anythink.core.common.e.b bVarA = com.anythink.core.common.a.a().a(this.a, this.f7545g);
        this.f7557s = true;
        if (this.f7553o || bVarA == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7545g);
            sb2.append(":filled timeup to check no cache, do nothing.");
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f7545g);
            sb3.append(":filled timeup to check cache exist.");
            d(bVarA.e() != null ? bVarA.e().getUnitGroupInfo() : null);
            b(9);
        }
    }

    private synchronized void k() {
        if (this.f7554p) {
            synchronized (this.f7558t) {
                for (ai aiVar : this.f7558t) {
                    if (aiVar != null && aiVar.j()) {
                        a(aiVar);
                    }
                }
                this.f7558t.clear();
            }
            synchronized (this.f7561w) {
                for (com.anythink.core.common.l.e eVar : this.f7561w) {
                    if (eVar != null && eVar.a() != null && eVar.a().j()) {
                        a(eVar.a());
                    }
                }
                this.f7561w.clear();
            }
            synchronized (this.f7560v) {
                this.f7560v.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        double dA = this.L.a(false);
        double dS = s();
        new StringBuilder("checkWaterfallStatus: vail requesting num: ").append(this.L.d());
        new StringBuilder("checkWaterfallStatus:isFinishBidding:").append(this.f7551m);
        new StringBuilder("checkWaterfallStatus:currentCacheNum >= mStrategy.getCachedOffersNum():").append(this.B >= this.f7543e.am());
        new StringBuilder("checkWaterfallStatus:getCacheLowestPrice() > getWaitingResponseMaxPrice():").append(dA > dS);
        new StringBuilder("checkWaterfallStatus:requestHasShow:").append(this.K.c());
        new StringBuilder("checkWaterfallStatus:hasLongTimeout:").append(this.K.b());
        if ((this.f7551m && this.B >= this.f7543e.am() && dA > dS) || this.K.c() || this.K.b()) {
            this.f7554p = true;
            k();
            if (this.L.d() == 0) {
                com.anythink.core.common.l.f.a(this.a, this.f7545g);
                q();
            }
        }
        p();
        if (this.f7554p || A()) {
            q();
        }
    }

    private void m() {
        if (this.f7543e.m() <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7545g);
            sb.append(": no filled count down.");
        } else {
            this.I = new AnonymousClass2();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7545g);
            sb2.append(": start filled count down.");
            com.anythink.core.common.b.n.a().a(this.I, this.f7543e.m());
        }
    }

    private Runnable n() {
        return new AnonymousClass3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        if (!this.f7553o && this.f7560v.size() > 0) {
            this.J = null;
            ai aiVarRemove = this.f7560v.remove(0);
            new StringBuilder("handleDefaultAdSourceRequest: startLoadDefaultAdSource:").append(aiVarRemove.ab());
            this.f7559u.add(aiVarRemove);
            StringBuilder sb = new StringBuilder("handleDefaultAdSourceRequest:start to request: waiting size:");
            sb.append(this.f7560v.size());
            sb.append("; requesting size:");
            sb.append(this.L.f());
            b(aiVarRemove, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        r2 = r8.f7561w;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        r3 = r8.f7561w.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        if (r3.hasNext() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        r4 = r3.next().a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        if (com.anythink.core.common.k.g.a(r4) <= r0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        new java.lang.StringBuilder("tryToSendWinNotice(), do not send win: ").append(r4.ab());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void p() {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.p():void");
    }

    private synchronized void q() {
        if (!this.K.e()) {
            new StringBuilder("tryToSendLossNotice(), mHasHBAdSource: ").append(this.K.e());
        } else {
            if (this.K.b()) {
                return;
            }
            this.L.a(com.anythink.core.common.k.s.a(this.f7544f, this.f7545g, this.f7542d, this.f7543e, "", 1, this.f7549k, this.f7541c, this.f7548j != null ? this.f7548j.f7586g : null), this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        boolean z2;
        double dS = s();
        if (this.E >= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (((this.f7551m || this.f7556r) && this.E >= dS) || this.f7557s) {
                if (!this.f7553o) {
                    b(-1);
                }
                w();
            }
        } else if (this.f7551m) {
            if (this.J == null || !B()) {
                z2 = false;
            } else {
                com.anythink.core.common.b.n.a().c(this.J);
                this.J.run();
                this.J = null;
                z2 = true;
            }
            if (z2) {
                return;
            }
            if (A() && !this.f7553o) {
                z();
            }
        }
    }

    private double s() {
        ai aiVar;
        com.anythink.core.common.l.e eVar;
        ai aiVarH;
        ai aiVarA = null;
        if (this.f7543e.a() == 2) {
            synchronized (this.G) {
                Iterator<Map.Entry<String, com.anythink.core.common.l.d>> it = this.G.entrySet().iterator();
                aiVar = null;
                if (it != null) {
                    while (it.hasNext()) {
                        com.anythink.core.common.l.d value = it.next().getValue();
                        if (value != null && !value.g() && (aiVarH = value.h()) != null && (aiVar == null || com.anythink.core.common.k.g.a(aiVarH) > com.anythink.core.common.k.g.a(aiVar))) {
                            aiVar = aiVarH;
                        }
                    }
                }
            }
        } else {
            aiVar = null;
        }
        ai aiVar2 = this.f7558t.size() > 0 ? this.f7558t.get(0) : null;
        synchronized (this.f7561w) {
            if (this.f7561w.size() > 0 && (eVar = this.f7561w.get(0)) != null) {
                aiVarA = eVar.a();
            }
        }
        return Math.max(Math.max(com.anythink.core.common.k.g.a(aiVar2), com.anythink.core.common.k.g.a(aiVarA)), com.anythink.core.common.k.g.a(aiVar));
    }

    private synchronized void t() {
        this.f7560v.clear();
        if (this.J != null) {
            com.anythink.core.common.b.n.a().c(this.J);
            this.J = null;
        }
    }

    private void u() {
        v();
        if (this.P) {
            return;
        }
        h();
    }

    private synchronized boolean v() {
        if (this.R != null && this.R.size() != 0) {
            if (this.K.c()) {
                return false;
            }
            this.S = true;
            ArrayList arrayList = new ArrayList(3);
            arrayList.addAll(this.R);
            this.R.clear();
            a(8, arrayList, new k.a() { // from class: com.anythink.core.common.h.6
                @Override // com.anythink.core.common.k.a
                public final void a(String str) {
                }

                @Override // com.anythink.core.common.k.a
                public final void a(String str, List<ai> list, List<ai> list2) {
                    w wVarA = w.a();
                    h hVar = h.this;
                    wVarA.b(hVar.f7545g, hVar.f7544f, list);
                    for (ai aiVar : list) {
                        aiVar.y(8);
                        h.this.f7559u.add(aiVar);
                        h.this.b(aiVar, 3);
                    }
                }

                @Override // com.anythink.core.common.k.a
                public final void b(String str) {
                    h hVar = h.this;
                    hVar.S = false;
                    hVar.r();
                }
            });
            return true;
        }
        return false;
    }

    private synchronized void w() {
        if (this.f7551m) {
            if (this.K.c()) {
                return;
            }
            if (this.H != null && this.H.size() != 0) {
                if (this.f7555q) {
                    return;
                }
                this.f7555q = true;
                a(7, this.H, new k.a() { // from class: com.anythink.core.common.h.7
                    @Override // com.anythink.core.common.k.a
                    public final void a(String str) {
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void a(String str, List<ai> list, List<ai> list2) {
                        if (h.this.K.c()) {
                            String unused = h.this.T;
                            Iterator<ai> it = list.iterator();
                            while (it.hasNext()) {
                                h.this.a(it.next());
                            }
                            return;
                        }
                        w wVarA = w.a();
                        h hVar = h.this;
                        wVarA.b(hVar.f7545g, hVar.f7544f, list);
                        h hVar2 = h.this;
                        if (hVar2.B < hVar2.f7543e.am()) {
                            String unused2 = h.this.T;
                            h.this.a(list, (List<ai>) null, (List<ai>) null);
                            h.this.l();
                            return;
                        }
                        String unused3 = h.this.T;
                        double dA = h.this.L.a(false);
                        int size = list.size();
                        ArrayList<ai> arrayList = new ArrayList(size);
                        ArrayList arrayList2 = new ArrayList(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            ai aiVar = list.get(i2);
                            if (com.anythink.core.common.k.g.a(aiVar) > dA) {
                                arrayList.add(aiVar);
                            } else {
                                arrayList2.add(aiVar);
                            }
                        }
                        for (ai aiVar2 : arrayList) {
                            aiVar2.y(7);
                            h.this.f7559u.add(aiVar2);
                            h.this.b(aiVar2, 5);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            h.this.a((ai) it2.next());
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void b(String str) {
                    }
                });
            }
        }
    }

    private boolean x() {
        if (this.J == null || !B()) {
            return false;
        }
        com.anythink.core.common.b.n.a().c(this.J);
        this.J.run();
        this.J = null;
        return true;
    }

    private void y() {
        j jVar;
        this.f7553o = true;
        this.f7552n = false;
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
        String str = this.f7544f;
        String str2 = this.f7545g;
        String str3 = this.f7542d;
        com.anythink.core.c.d dVar = this.f7543e;
        String str4 = this.f7562x;
        int iL = dVar.l();
        int i2 = this.f7549k;
        int i3 = this.f7541c;
        j jVar2 = this.f7548j;
        com.anythink.core.common.j.c.a(com.anythink.core.common.k.s.a(str, str2, str3, dVar, str4, iL, i2, i3, jVar2 != null ? jVar2.f7586g : null), this.f7563y);
        if (!this.P) {
            if ((this.f7543e.j() != 1 || this.f7549k == 8 || v.a().f(this.f7545g)) ? false : true) {
                f fVarB = v.a().b(this.f7545g);
                if (fVarB != null && (jVar = this.f7548j) != null) {
                    jVar.f7583d = 8;
                    Context context = this.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f7543e.X());
                    fVarB.a(context, sb.toString(), this.f7545g, this.f7548j, (com.anythink.core.common.b.a) null);
                }
            } else {
                a(this.f7563y);
            }
        }
        f();
    }

    private void z() {
        if (com.anythink.core.common.a.a().a(this.a, this.f7545g) != null) {
            b(9);
        } else {
            if (v()) {
                return;
            }
            y();
        }
    }

    public abstract void a(ATBaseAdAdapter aTBaseAdAdapter);

    public final void f() {
        this.P = true;
        v.a().b(this.f7545g).b(this.f7544f);
    }

    public void g() {
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
    }

    public void h() {
        com.anythink.core.common.b.a aVar;
        com.anythink.core.common.k.n.a("Mediation", "placementId:" + this.f7545g + ";result_callback:success;loadType:" + this.f7549k + ";");
        j jVar = this.f7548j;
        if (jVar == null || (aVar = jVar.f7585f) == null) {
            return;
        }
        aVar.onAdLoaded();
        this.f7548j.f7585f = null;
    }

    public final void i() {
        synchronized (this.f7561w) {
            if (this.f7561w.size() > 0) {
                ai aiVarA = this.f7561w.remove(0).a();
                if (!this.f7553o || this.B < this.f7543e.am() || com.anythink.core.common.k.g.a(aiVarA) > this.E) {
                    this.f7559u.add(aiVarA);
                    b(aiVarA, 4);
                }
            }
            if (this.f7561w.size() > 0) {
                for (com.anythink.core.common.l.e eVar : this.f7561w) {
                    ai aiVarA2 = eVar.a();
                    if (!this.f7553o || this.B < this.f7543e.am() || com.anythink.core.common.k.g.a(aiVarA2) > this.E) {
                        int iB = eVar.b();
                        if (iB == 1) {
                            a(aiVarA2, 1);
                            e(iB);
                        } else if (iB == 2) {
                            a(aiVarA2, 2);
                            e(iB);
                        } else if (iB == 3) {
                            this.f7559u.add(aiVarA2);
                            b(aiVarA2, 3);
                        }
                    }
                }
            }
            this.f7561w.clear();
        }
        l();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.h$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.common.l.b {
        AnonymousClass5() {
        }

        @Override // com.anythink.core.common.l.b
        public final void a(com.anythink.core.common.e.e eVar) {
            com.anythink.core.common.j.a.a(h.this.a).a(1, eVar);
            com.anythink.core.common.k.g.a(eVar, g.i.a, g.i.f6862h, "");
        }

        @Override // com.anythink.core.common.l.b
        public final void b(com.anythink.core.common.e.e eVar) {
            h.a(h.this, eVar);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
            h.this.a(aTBaseAdAdapter);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, String str2) {
            h.this.a(str);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
            h.this.a(str, aTBaseAdAdapter, aiVar);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
            IATAdFilter iATAdFilterO = com.anythink.core.common.b.n.a().o(h.this.f7545g);
            BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            if (iATAdFilterO != null && iATAdFilterO.isAdFilter(com.anythink.core.common.b.j.a(aTBaseAdAdapter), baseAd)) {
                com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                aVar.a = 8;
                aVar.f7771c = aTBaseAdAdapter.getTrackingInfo().K();
                aVar.b = ErrorCode.getErrorCode(ErrorCode.adSourceNotFilledError, "", "");
                aVar.f7772d = aTBaseAdAdapter.getTrackingInfo();
                aVar.f7773e = aTBaseAdAdapter.getUnitGroupInfo();
                h.this.a(str, aVar);
                return;
            }
            h.this.a(str, aTBaseAdAdapter, baseAdArr != null ? Arrays.asList(baseAdArr) : null);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, com.anythink.core.common.l.a aVar) {
            h.this.a(str, aVar);
        }
    }

    private synchronized void e(int i2) {
        try {
            int iE = i2 != 2 ? this.L.e() : this.L.f();
            if (iE == 0) {
                StringBuilder sb = new StringBuilder("checkToAddAdSourceToRequestingPool: vail requesting num: ");
                sb.append(iE);
                sb.append(" | requestFrom: ");
                sb.append(i2);
                a(this.L.b(i2), i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void d() {
        this.f7556r = true;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(ai aiVar) {
        this.f7559u.remove(aiVar);
    }

    private void c(ai aiVar) {
        if (this.D == null) {
            this.D = new ConcurrentHashMap<>();
        }
        this.D.put(aiVar.t(), aiVar);
    }

    private int f(int i2) {
        return i2 > 0 ? i2 : this.B < this.f7543e.am() ? 5 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ai aiVar) {
        com.anythink.core.common.e.m mVarN;
        if (aiVar == null) {
            return;
        }
        double dA = com.anythink.core.common.k.g.a(aiVar);
        if (aiVar.j() && aiVar.c() == 1 && dA == 10000.0d && (mVarN = aiVar.N()) != null) {
            dA = mVarN.f7350o;
        }
        if (dA > com.anythink.core.common.k.g.a(this.Q)) {
            this.Q = aiVar;
        }
    }

    protected final void b() {
        long jO;
        this.f7560v = this.L.c();
        List<ai> list = this.f7560v;
        if (list == null || list.size() <= 0) {
            jO = 1000;
        } else {
            jO = this.f7543e.o();
            if (this.f7558t.size() == 0 && this.f7551m) {
                jO = 0;
            }
            this.J = new AnonymousClass3();
        }
        this.f7564z = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7545g);
        sb.append(": start waterfall.");
        if (this.f7543e.m() > 0) {
            this.I = new AnonymousClass2();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7545g);
            sb2.append(": start filled count down.");
            com.anythink.core.common.b.n.a().a(this.I, this.f7543e.m());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f7545g);
            sb3.append(": no filled count down.");
        }
        com.anythink.core.common.b.n.a().a(this.M, this.f7543e.R());
        if (this.f7560v.size() == 0 && this.f7558t.size() == 0 && this.f7551m) {
            v();
        }
        a(this.L.h(), 1);
        if (this.J != null) {
            com.anythink.core.common.b.n.a().a(this.J, jO);
        }
    }

    private void c(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = this.f7550l;
        if (bVar != null) {
            bVar.d(eVar);
        }
    }

    protected final synchronized void a() {
        ConcurrentHashMap concurrentHashMap;
        this.K.a();
        synchronized (this.G) {
            concurrentHashMap = new ConcurrentHashMap(this.G);
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.l.d dVar = (com.anythink.core.common.l.d) ((Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.c();
            }
        }
        if (!this.f7553o) {
            this.f7553o = true;
            z();
        }
        l();
    }

    public final void e() {
        synchronized (this.C) {
            this.f7551m = true;
            this.f7556r = true;
            r();
            l();
        }
    }

    public final boolean c() {
        if (this.f7553o) {
            return true;
        }
        return this.f7551m && this.f7558t.size() == 0 && this.L.d() == 0;
    }

    private void a(Map<String, Object> map) {
        this.f7546h = map;
    }

    private void a(com.anythink.core.common.e.e eVar) {
        this.f7547i = eVar;
    }

    public final void a(com.anythink.core.common.b.b bVar) {
        this.f7550l = bVar;
    }

    public final void a(j jVar) {
        this.f7548j = jVar;
    }

    public final void a(int i2) {
        this.f7549k = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        if (aiVar != null && aiVar.j() && aiVar.L() == 2) {
            String str = this.f7544f;
            String str2 = this.f7545g;
            String str3 = this.f7542d;
            com.anythink.core.c.d dVar = this.f7543e;
            int i2 = this.f7549k;
            int i3 = this.f7541c;
            j jVar = this.f7548j;
            com.anythink.core.common.l.f.a(aiVar, com.anythink.core.common.k.s.a(str, str2, str3, dVar, "", 1, i2, i3, jVar != null ? jVar.f7586g : null), this.F, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ai aiVar, final int i2) {
        this.L.a(1, i2);
        com.anythink.core.common.k.b.a.a().b(new Runnable() { // from class: com.anythink.core.common.h.4
            @Override // java.lang.Runnable
            public final void run() {
                String string;
                synchronized (h.this) {
                    if (h.this.K.b()) {
                        return;
                    }
                    if (com.anythink.core.common.k.t.a(aiVar) && TextUtils.isEmpty(v.a().a(h.this.f7545g, aiVar.c()))) {
                        v.a().a(h.this.f7545g, aiVar.c(), aiVar.g());
                    }
                    boolean zC = h.c(i2);
                    h hVar = h.this;
                    String str = hVar.f7544f;
                    String str2 = hVar.f7545g;
                    String str3 = hVar.f7542d;
                    com.anythink.core.c.d dVar = hVar.f7543e;
                    if (zC) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(aiVar.c());
                        string = sb.toString();
                    } else {
                        string = hVar.f7562x;
                    }
                    String str4 = string;
                    int iL = h.this.f7543e.l();
                    h hVar2 = h.this;
                    int i3 = hVar2.f7549k;
                    int i4 = hVar2.f7541c;
                    j jVar = hVar2.f7548j;
                    com.anythink.core.common.e.e eVarA = com.anythink.core.common.k.s.a(str, str2, str3, dVar, str4, iL, i3, i4, jVar != null ? jVar.f7586g : null);
                    com.anythink.core.common.e.e eVar = h.this.f7547i;
                    if (eVar != null) {
                        eVarA.a(eVar.a());
                    }
                    com.anythink.core.common.k.s.a(eVarA, aiVar, h.this.A, true);
                    eVarA.a(SystemClock.elapsedRealtime() - h.this.f7564z);
                    com.anythink.core.common.e.d dVarD = v.a().d(h.this.f7545g);
                    int i5 = 0;
                    if (dVarD != null && dVarD.a(aiVar)) {
                        com.anythink.core.common.k.n.a(h.this.f7545g, eVarA, "Can't Load On Showing", aiVar, -1, -1);
                        com.anythink.core.common.j.c.a(eVarA, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                        v.a().a(h.this.f7545g, dVarD.a(), h.this.f7544f);
                        synchronized (h.this.f7561w) {
                            Iterator<com.anythink.core.common.l.e> it = h.this.f7561w.iterator();
                            while (it.hasNext() && com.anythink.core.common.k.g.a(it.next().a()) > com.anythink.core.common.k.g.a(aiVar)) {
                                i5++;
                            }
                            h.this.f7561w.add(i5, new com.anythink.core.common.l.e(aiVar, i2));
                        }
                        h.this.b(aiVar);
                        h.this.L.a(i2);
                        h.this.L.a(-1, i2);
                        h hVar3 = h.this;
                        hVar3.a(hVar3.L.b(i2), i2);
                        return;
                    }
                    String unused = h.this.T;
                    new StringBuilder("startAdSourceRequest: ").append(aiVar.ab());
                    try {
                        if (aiVar.j()) {
                            String unused2 = h.this.T;
                            com.anythink.core.common.e.m mVarN = aiVar.N();
                            if (aiVar.c() != 66 && aiVar.c() != 67) {
                                com.anythink.core.b.f.a().a(aiVar.t());
                            }
                            if (mVarN != null && mVarN.a()) {
                                i5 = 1;
                            }
                            if (i5 != 0 && mVarN != null) {
                                com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                                rVar.a = 1;
                                rVar.b = mVarN.getSortPrice();
                                rVar.f7378e = eVarA;
                                rVar.f7376c = aiVar;
                                rVar.f7377d = aiVar;
                                mVarN.a(rVar, true);
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                    com.anythink.core.common.l.d dVar2 = new com.anythink.core.common.l.d(aiVar, i2);
                    String strA = dVar2.a();
                    h.this.G.put(strA, dVar2);
                    h.this.A++;
                    if (i5 != 0) {
                        com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                        aVar.a = 6;
                        aVar.b = ErrorCode.getErrorCode(ErrorCode.noADError, "", "Bid result has expired.");
                        aVar.f7771c = 0L;
                        aVar.f7772d = eVarA;
                        aVar.f7773e = aiVar;
                        h.this.a(strA, aVar);
                        return;
                    }
                    if (aiVar.j()) {
                        h.this.d(aiVar);
                    }
                    int iAc = aiVar.ac();
                    if (iAc > 0) {
                        eVarA.f7243q = iAc;
                    } else {
                        h hVar4 = h.this;
                        if (hVar4.f7552n && hVar4.B < hVar4.f7543e.am()) {
                            eVarA.f7243q = 5;
                        }
                    }
                    h.a(h.this, dVar2, eVarA);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<ai> list, int i2) {
        if (!this.K.b() && !this.K.c() && list != null && list.size() != 0) {
            this.f7559u.addAll(list);
            new StringBuilder("addAdSourceToRequestingPool:start to request:  requesting size:").append(this.f7559u.size());
            Iterator<ai> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), i2);
            }
        }
    }

    private void b(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = this.f7550l;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    private void b(com.anythink.core.common.l.d dVar) {
        if (dVar.d() == null || !dVar.d().booleanValue() || dVar.f() == 2 || !dVar.d().booleanValue()) {
            return;
        }
        this.B++;
    }

    public final void b(int i2) {
        if (this.I != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7545g);
            sb.append(":remove filled countdown.");
            com.anythink.core.common.b.n.a().c(this.I);
            this.I = null;
        }
        boolean z2 = i2 == 5 || i2 == 9 || i2 == 10;
        this.f7553o = true;
        this.f7552n = true;
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f7564z;
        String str = this.f7544f;
        String str2 = this.f7545g;
        String str3 = this.f7542d;
        com.anythink.core.c.d dVar = this.f7543e;
        String str4 = this.f7562x;
        int iL = dVar.l();
        int i3 = this.f7549k;
        int i4 = this.f7541c;
        j jVar = this.f7548j;
        com.anythink.core.common.e.e eVarA = com.anythink.core.common.k.s.a(str, str2, str3, dVar, str4, iL, i3, i4, jVar != null ? jVar.f7586g : null);
        eVarA.a(true);
        eVarA.d(jElapsedRealtime);
        if (z2) {
            eVarA.z(i2);
        }
        com.anythink.core.common.j.a.a(this.a).a(12, eVarA);
        f fVarB = v.a().b(this.f7545g);
        if (fVarB != null && i2 != 10) {
            fVarB.a(this.f7543e.U());
        }
        com.anythink.core.common.l.f.a(this.a, this.f7545g);
        u();
    }

    private synchronized void a(ai aiVar, int i2) {
        List<ai> list;
        try {
            if (i2 != 2) {
                list = this.f7558t;
            } else {
                list = this.f7560v;
            }
            synchronized (list) {
                com.anythink.core.common.k.g.a(list, aiVar, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:5:0x0005, B:6:0x0009, B:8:0x000f, B:12:0x0038, B:14:0x003f, B:17:0x0047, B:39:0x00c9, B:40:0x00cd, B:42:0x00d3, B:44:0x00eb, B:45:0x00f2, B:46:0x0100, B:20:0x0064, B:35:0x0096, B:37:0x00ad, B:38:0x00af, B:24:0x007e, B:48:0x0102), top: B:54:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.List<com.anythink.core.common.e.ai> r13, java.util.List<com.anythink.core.common.e.ai> r14, java.util.List<com.anythink.core.common.e.ai> r15) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.a(java.util.List, java.util.List, java.util.List):void");
    }

    private void b(long j2) {
        com.anythink.core.common.b.n.a().a(this.M, j2);
    }

    private ai b(String str) {
        ConcurrentHashMap<String, ai> concurrentHashMap = this.D;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    protected final void a(com.anythink.core.common.l.g gVar) {
        this.L = new com.anythink.core.common.l.f(gVar);
        this.f7558t = this.L.a();
        this.f7559u = this.L.b();
        this.f7551m = gVar.f7816e;
        this.f7544f = gVar.b;
        this.f7545g = gVar.a;
        this.f7543e = gVar.f7814c;
        this.f7541c = gVar.f7817f;
        this.f7562x = com.anythink.core.common.l.f.a(gVar.f7815d);
    }

    private void a(long j2) {
        if (this.J != null) {
            com.anythink.core.common.b.n.a().a(this.J, j2);
        }
    }

    private void a(com.anythink.core.common.l.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.l.c cVar = new com.anythink.core.common.l.c();
        cVar.a = this.a;
        cVar.b = this.b;
        cVar.f7774c = this.f7544f;
        cVar.f7775d = this.f7545g;
        cVar.f7776e = this.f7543e;
        cVar.f7777f = this.f7546h;
        cVar.f7778g = this.A;
        cVar.f7779h = eVar;
        dVar.a(cVar);
        dVar.a(new AnonymousClass5());
        dVar.b();
    }

    private void a(com.anythink.core.common.e.e eVar, AdError adError) {
        com.anythink.core.common.b.b bVar = this.f7550l;
        if (bVar != null) {
            bVar.b(eVar, adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        com.anythink.core.common.l.d dVarRemove = this.G.remove(str);
        if (dVarRemove == null) {
            return;
        }
        a(dVarRemove, aTBaseAdAdapter, aiVar, aTBaseAdAdapter.getTrackingInfo());
        new StringBuilder("[Enter] onCacheAdLoaded: ").append(aiVar.ab());
        b(aiVar);
        t();
        c(aTBaseAdAdapter.getTrackingInfo());
        aiVar.t();
        a(dVarRemove);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x00b2, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x000a, B:9:0x0016, B:11:0x003f, B:13:0x0049, B:14:0x004c, B:16:0x007d, B:18:0x0085, B:20:0x0091, B:22:0x0099, B:23:0x00ad), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(java.lang.String r12, com.anythink.core.api.ATBaseAdAdapter r13, java.util.List<? extends com.anythink.core.api.BaseAd> r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r13 == 0) goto La
            com.anythink.core.common.e.e r0 = r13.getTrackingInfo()     // Catch: java.lang.Throwable -> Lb2
            r0.x()     // Catch: java.lang.Throwable -> Lb2
        La:
            java.util.Map<java.lang.String, com.anythink.core.common.l.d> r0 = r11.G     // Catch: java.lang.Throwable -> Lb2
            java.lang.Object r12 = r0.remove(r12)     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.l.d r12 = (com.anythink.core.common.l.d) r12     // Catch: java.lang.Throwable -> Lb2
            if (r12 != 0) goto L16
            monitor-exit(r11)
            return
        L16:
            com.anythink.core.common.e.e r0 = r13.getTrackingInfo()     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.e.ai r1 = r13.getUnitGroupInfo()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = "[Enter] onAdLoaded(): "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = r1.ab()     // Catch: java.lang.Throwable -> Lb2
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb2
            r11.b(r1)     // Catch: java.lang.Throwable -> Lb2
            r11.t()     // Catch: java.lang.Throwable -> Lb2
            r11.a(r12, r13, r1, r0)     // Catch: java.lang.Throwable -> Lb2
            long r2 = r1.B()     // Catch: java.lang.Throwable -> Lb2
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L4c
            long r2 = r0.J()     // Catch: java.lang.Throwable -> Lb2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L4c
            com.anythink.core.common.j.c.a(r0)     // Catch: java.lang.Throwable -> Lb2
        L4c:
            com.anythink.core.common.e.e r2 = r13.getTrackingInfo()     // Catch: java.lang.Throwable -> Lb2
            r11.c(r2)     // Catch: java.lang.Throwable -> Lb2
            android.content.Context r2 = r11.a     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.j.a r2 = com.anythink.core.common.j.a.a(r2)     // Catch: java.lang.Throwable -> Lb2
            r3 = 2
            r2.a(r3, r0)     // Catch: java.lang.Throwable -> Lb2
            long r9 = r1.p()     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.a r4 = com.anythink.core.common.a.a()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r5 = r11.f7545g     // Catch: java.lang.Throwable -> Lb2
            int r6 = r0.z()     // Catch: java.lang.Throwable -> Lb2
            r7 = r13
            r8 = r14
            r4.a(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r14 = com.anythink.core.common.b.g.i.b     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = com.anythink.core.common.b.g.i.f6860f     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = ""
            com.anythink.core.common.k.g.a(r0, r14, r2, r3)     // Catch: java.lang.Throwable -> Lb2
            boolean r14 = r11.P     // Catch: java.lang.Throwable -> Lb2
            if (r14 != 0) goto Lad
            com.anythink.core.common.l.h r14 = r11.K     // Catch: java.lang.Throwable -> Lb2
            boolean r14 = r14.c()     // Catch: java.lang.Throwable -> Lb2
            if (r14 != 0) goto Lad
            com.anythink.core.common.v r14 = com.anythink.core.common.v.a()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = r11.f7545g     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.f r3 = r14.b(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r3 == 0) goto Lad
            com.anythink.core.c.d r14 = r11.f7543e     // Catch: java.lang.Throwable -> Lb2
            int r14 = r14.T()     // Catch: java.lang.Throwable -> Lb2
            if (r14 <= 0) goto Lad
            java.lang.String r7 = r11.f7544f     // Catch: java.lang.Throwable -> Lb2
            double r5 = com.anythink.core.common.k.g.a(r1)     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.b.n r14 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> Lb2
            com.anythink.core.common.f$4 r0 = new com.anythink.core.common.f$4     // Catch: java.lang.Throwable -> Lb2
            r2 = r0
            r4 = r13
            r2.<init>(r4, r5, r7)     // Catch: java.lang.Throwable -> Lb2
            r14.a(r0)     // Catch: java.lang.Throwable -> Lb2
        Lad:
            r11.a(r12)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r11)
            return
        Lb2:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.a(java.lang.String, com.anythink.core.api.ATBaseAdAdapter, java.util.List):void");
    }

    private void a(com.anythink.core.common.l.d dVar, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, com.anythink.core.common.e.e eVar) {
        eVar.g(aTBaseAdAdapter.getNetworkPlacementId());
        double dA = dVar.f() != 2 ? com.anythink.core.common.k.g.a(aiVar) : 0.0d;
        if (dA > this.E) {
            this.E = dA;
        }
        d(aiVar);
        if (this.F == null || com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(this.F)) {
            this.F = aiVar;
            com.anythink.core.b.f.a().a(this.f7545g, this.F);
        }
        this.L.b(aiVar);
        double d2 = this.O;
        if (d2 <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            eVar.f7245s = 0;
        } else if (d2 < dA) {
            eVar.f7245s = 2;
        } else {
            eVar.f7245s = 1;
        }
        com.anythink.core.common.l.f.a(this.a, this.f7545g, this.f7544f, aiVar, null);
    }

    private void a(com.anythink.core.common.l.d dVar) {
        boolean zE = dVar.e();
        if (zE) {
            this.L.a(-1, dVar.f());
        }
        b(dVar);
        r();
        if (zE) {
            if (this.L.d() == 0 && this.f7558t.size() == 0 && (this.f7556r || this.f7551m)) {
                v();
            }
            new StringBuilder("checkToRequestNextAdSource: try to call next AdSource.||").append(dVar.f());
            this.L.a(dVar.f());
            a(this.L.b(dVar.f()), dVar.f());
            l();
        }
    }

    private void a(int i2, List<ai> list, final k.a aVar) {
        boolean z2 = this.N != null || com.anythink.core.common.k.t.a(this.H);
        com.anythink.core.common.e.a aVar2 = new com.anythink.core.common.e.a();
        aVar2.a = this.a;
        aVar2.b = this.f7548j;
        aVar2.f7080c = this.f7544f;
        aVar2.f7081d = this.f7545g;
        aVar2.f7082e = this.f7543e.X();
        aVar2.f7083f = this.f7543e.H();
        aVar2.f7084g = this.f7543e.z();
        i.a();
        aVar2.f7089l = i.a(this.f7543e, z2);
        i.a();
        aVar2.f7092o = i.a(this.f7543e);
        i.a();
        aVar2.f7093p = i.b(this.f7543e);
        aVar2.f7086i = list;
        aVar2.f7091n = this.f7543e;
        aVar2.f7096s = this.f7547i;
        aVar2.f7094q = this.f7546h;
        aVar2.f7100w = this.L.g();
        List<ai> listB = w.a().b(this.f7545g, this.f7544f);
        if (listB == null) {
            aVar2.f7087j = new ArrayList(4);
        } else {
            aVar2.f7087j = listB;
        }
        aVar2.f7090m = z2;
        aVar2.f7098u = i2;
        aVar2.f7097t = this.N;
        aVar2.f7099v = com.anythink.core.common.k.g.a(this.Q);
        com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar2);
        bVar.a(ATSDK.isNetworkLogDebug());
        bVar.a(new k.a() { // from class: com.anythink.core.common.h.8
            @Override // com.anythink.core.common.k.a
            public final void a(String str, List<ai> list2, List<ai> list3) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str, list2, list3);
                }
            }

            @Override // com.anythink.core.common.k.a
            public final void b(String str) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(str);
                }
            }

            @Override // com.anythink.core.common.k.a
            public final void a(String str) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str);
                }
            }
        });
    }

    protected synchronized void a(String str, com.anythink.core.common.l.a aVar) {
        com.anythink.core.common.e.e eVar = aVar.f7772d;
        ai aiVar = aVar.f7773e;
        AdError adError = aVar.b;
        long j2 = aVar.f7771c;
        String strX = eVar.x();
        com.anythink.core.common.l.d dVarRemove = this.G.remove(str);
        if (dVarRemove == null) {
            return;
        }
        new StringBuilder("[Enter] onAdError(): ").append(aiVar.ab());
        b(aiVar);
        this.f7563y.putNetworkErrorMsg(strX, eVar.H(), eVar.T(), adError);
        com.anythink.core.common.j.c.a(eVar, aVar.a, adError, j2);
        if (j2 > 0) {
            if (this.f7550l != null) {
                this.f7550l.b(eVar, adError);
            }
            com.anythink.core.common.k.g.a(eVar, g.i.b, g.i.f6861g, adError.printStackTrace());
        }
        a(dVarRemove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str) {
        if (this.K.b()) {
            return;
        }
        a(this.G.get(str));
    }

    public final synchronized void a(double d2, ai aiVar) {
        if (!this.K.g() && aiVar != null && aiVar.j()) {
            this.K.h();
        }
        if (d2 > this.O) {
            this.O = d2;
        }
        int iX = this.f7543e.X();
        if (iX == 0 || iX == 2) {
            return;
        }
        this.K.d();
        v.a().b(this.f7545g).b(this.f7544f);
        if (!this.f7553o) {
            b(10);
        }
        l();
    }

    public void a(AdError adError) {
        com.anythink.core.common.b.a aVar;
        com.anythink.core.common.k.n.a("Mediation", "placementId:" + this.f7545g + ";result_callback:fail;loadType:" + this.f7549k + ";");
        j jVar = this.f7548j;
        if (jVar == null || (aVar = jVar.f7585f) == null) {
            return;
        }
        aVar.onAdLoadFail(adError);
        this.f7548j.f7585f = null;
    }

    private void a(List<ai> list) {
        this.R = list;
    }

    static /* synthetic */ void a(h hVar, com.anythink.core.common.l.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.l.c cVar = new com.anythink.core.common.l.c();
        cVar.a = hVar.a;
        cVar.b = hVar.b;
        cVar.f7774c = hVar.f7544f;
        cVar.f7775d = hVar.f7545g;
        cVar.f7776e = hVar.f7543e;
        cVar.f7777f = hVar.f7546h;
        cVar.f7778g = hVar.A;
        cVar.f7779h = eVar;
        dVar.a(cVar);
        dVar.a(hVar.new AnonymousClass5());
        dVar.b();
    }

    static /* synthetic */ void a(h hVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = hVar.f7550l;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }
}
