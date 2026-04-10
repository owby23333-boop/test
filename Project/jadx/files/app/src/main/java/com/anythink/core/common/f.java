package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.c.e;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.j;
import com.anythink.core.common.k;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T extends j> {
    protected Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f7392c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f7395f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected g f7400k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f7403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f7404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f7406q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<com.anythink.core.common.b.a> f7408s;
    private final String a = getClass().getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f7394e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f7396g = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7407r = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f7397h = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Object f7409t = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected com.anythink.core.common.b.a f7398i = new com.anythink.core.common.b.a() { // from class: com.anythink.core.common.f.1
        @Override // com.anythink.core.common.b.a
        public final void onAdLoadFail(AdError adError) {
            f.this.b();
            synchronized (f.this.f7409t) {
                Iterator it = f.this.f7408s.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.b.a aVar = (com.anythink.core.common.b.a) it.next();
                    if (aVar != null) {
                        com.anythink.core.common.k.n.a(f.this.f7392c, f.this.a(), g.i.f6878x, g.i.f6861g, "[listener:" + aVar.toString() + "]");
                        aVar.onAdLoadFail(adError);
                        it.remove();
                    }
                }
            }
            f.this.b(adError);
        }

        @Override // com.anythink.core.common.b.a
        public final void onAdLoaded() {
            synchronized (f.this.f7409t) {
                if (f.this.f7408s != null) {
                    Iterator it = f.this.f7408s.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.b.a aVar = (com.anythink.core.common.b.a) it.next();
                        if (aVar != null) {
                            com.anythink.core.common.k.n.a(f.this.f7392c, f.this.a(), g.i.f6878x, g.i.f6860f, "[listener:" + aVar.toString() + "]");
                            aVar.onAdLoaded();
                            it.remove();
                        }
                    }
                }
            }
            f.this.l();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Random f7399j = new Random();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    double f7401l = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f7402m = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ConcurrentHashMap<String, h> f7393d = new ConcurrentHashMap<>(5);

    /* JADX INFO: renamed from: com.anythink.core.common.f$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ j a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.anythink.core.common.b.a f7410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f7411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f7412e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f7413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f7414g;

        AnonymousClass2(j jVar, String str, com.anythink.core.common.b.a aVar, Context context, int[] iArr, String str2, Map map) {
            this.a = jVar;
            this.b = str;
            this.f7410c = aVar;
            this.f7411d = context;
            this.f7412e = iArr;
            this.f7413f = str2;
            this.f7414g = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (f.this) {
                if (!f.this.e() || this.a.f7583d == 0) {
                    if (f.this.i() || this.a.f7583d != 5) {
                        if (f.this.j() && this.a.f7583d == 0) {
                            String str = "PlacementId(" + this.b + ") the load api calls are not allowed in Auto-load mode";
                            return;
                        }
                        f.this.a(this.f7410c);
                        this.a.f7585f = f.this.f7398i;
                        if (this.a.f7583d != 4) {
                            f.this.f7397h = 1;
                        } else {
                            f.this.f7397h++;
                        }
                        f.this.k();
                        StringBuilder sb = new StringBuilder("PlacementId(");
                        sb.append(this.b);
                        sb.append(") start load type:");
                        sb.append(this.a.f7583d);
                        com.anythink.core.common.b.n.a().a(this.f7411d, com.anythink.core.common.b.n.a().p(), com.anythink.core.common.b.n.a().q());
                        final String strA = com.anythink.core.common.k.g.a(this.f7411d);
                        this.a.a = strA;
                        f.this.a(this.a.a, this.f7410c);
                        if (com.anythink.core.common.b.n.a().g() != null && !TextUtils.isEmpty(com.anythink.core.common.b.n.a().p()) && !TextUtils.isEmpty(com.anythink.core.common.b.n.a().q()) && !com.anythink.core.common.k.h.a(this.b)) {
                            if (f.this.g()) {
                                String str2 = "Placement(" + this.b + ") is loading.";
                                return;
                            }
                            final Context applicationContext = this.f7411d.getApplicationContext();
                            String strP = com.anythink.core.common.b.n.a().p();
                            String strQ = com.anythink.core.common.b.n.a().q();
                            boolean zV = com.anythink.core.common.b.n.a().v();
                            com.anythink.core.c.d dVarA = zV ? null : com.anythink.core.c.e.a(applicationContext).a(this.b);
                            final String strU = dVarA != null ? dVarA.U() : "";
                            final com.anythink.core.common.e.e eVarA = com.anythink.core.common.k.s.a(strA, this.b, "", dVarA, "", dVarA != null ? dVarA.l() : -1, this.a.f7583d, this.f7412e[0], this.a.f7586g);
                            eVarA.z(this.f7413f);
                            if (this.f7414g != null) {
                                eVarA.a(this.f7414g);
                            }
                            if (dVarA == null && !zV && ((!TextUtils.isEmpty(this.a.f7582c) || this.a.b != null) && f.this.a(this.b, strA, this.a, this.f7410c))) {
                                com.anythink.core.c.e.a(this.f7411d).a(null, strP, strQ, this.b, this.a.f7586g, null);
                                return;
                            }
                            if (f.this.f7394e == 1 && !f.this.d() && a.a().a(this.f7411d, this.b) != null) {
                                w.a().a(this.b, strA);
                                f.this.h();
                                eVarA.a(false);
                                eVarA.z(4);
                                com.anythink.core.common.j.a.a(applicationContext).a(10, eVarA);
                                com.anythink.core.common.j.a.a(applicationContext).a(12, eVarA);
                                f.this.f7395f = false;
                                return;
                            }
                            if (dVarA != null && f.this.f7405p) {
                                long jCurrentTimeMillis = System.currentTimeMillis() - f.this.f7406q;
                                if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < dVarA.aj()) {
                                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.loadFailInPacingError, "", "");
                                    eVarA.z(7);
                                    f.this.a(f.this.f7407r ? false : true, eVarA, new e(errorCode, errorCode.printStackTrace()));
                                    f.this.f7407r = true;
                                    return;
                                }
                            }
                            f.f(f.this);
                            f.g(f.this);
                            f.this.f7407r = false;
                            if (dVarA != null && com.anythink.core.a.b.a().a(applicationContext, this.b, dVarA)) {
                                AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.loadCappingError, "", "");
                                eVarA.z(8);
                                f.this.a(true, eVarA, (Throwable) new e(errorCode2, errorCode2.printStackTrace()));
                                return;
                            } else {
                                if (f.this.e()) {
                                    String str3 = "Placement(" + this.b + ") is loading.";
                                    return;
                                }
                                f.this.f7395f = true;
                                Iterator<h> it = f.this.f7393d.values().iterator();
                                while (it.hasNext()) {
                                    it.next().f();
                                }
                                com.anythink.core.c.e.a(this.f7411d).a(dVarA, strP, strQ, this.b, this.a.f7586g, new e.a() { // from class: com.anythink.core.common.f.2.1
                                    @Override // com.anythink.core.c.e.a
                                    public final void a(final com.anythink.core.c.d dVar) {
                                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.2.1.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                synchronized (f.this) {
                                                    f.this.f7404o = dVar.S();
                                                    com.anythink.core.common.k.s.a(eVarA, dVar);
                                                    if (TextUtils.equals(String.valueOf(dVar.X()), AnonymousClass2.this.f7413f)) {
                                                        f.a(f.this, applicationContext, AnonymousClass2.this.b, strA, dVar, eVarA, AnonymousClass2.this.a);
                                                        return;
                                                    }
                                                    AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.k.g.d(AnonymousClass2.this.f7413f) + ", Format corresponding to placement strategy: " + com.anythink.core.common.k.g.d(String.valueOf(dVar.X())));
                                                    f.this.a(errorCode3);
                                                    eVarA.a(false);
                                                    com.anythink.core.common.j.c.a(eVarA, errorCode3);
                                                    f.this.f7395f = false;
                                                }
                                            }
                                        });
                                    }

                                    @Override // com.anythink.core.c.e.a
                                    public final void b(final com.anythink.core.c.d dVar) {
                                        if (!TextUtils.equals(strU, dVar.U())) {
                                            f.this.f7394e = 0;
                                        }
                                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.2.1.2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                synchronized (f.this) {
                                                    try {
                                                        f.a(f.this, dVar, strA, AnonymousClass2.this.b);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }
                                            }
                                        });
                                    }

                                    @Override // com.anythink.core.c.e.a
                                    public final void a(AdError adError) {
                                        String str4 = g.i.f6861g;
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        String str5 = anonymousClass2.b;
                                        String strD = com.anythink.core.common.k.g.d(anonymousClass2.f7413f);
                                        String strPrintStackTrace = adError.printStackTrace();
                                        if (ATSDK.isNetworkLogDebug()) {
                                            try {
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put(NativeAdvancedJsUtils.f8246p, g.i.f6877w);
                                                jSONObject.put("result", str4);
                                                jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str5);
                                                jSONObject.put("adtype", strD);
                                                jSONObject.put(RewardItem.KEY_ERROR_MSG, strPrintStackTrace);
                                                com.anythink.core.common.k.n.a("anythink_network", jSONObject.toString(), TextUtils.equals(g.i.f6861g, str4));
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.placeStrategyError, adError.getPlatformCode(), adError.getPlatformMSG());
                                        eVarA.z(5);
                                        f.this.a(true, eVarA, errorCode3);
                                    }
                                });
                                return;
                            }
                        }
                        f.this.a(ErrorCode.getErrorCode(ErrorCode.appIdOrPlaceIdEmpty, "", ""));
                        if (com.anythink.core.common.b.n.a().A()) {
                            String str4 = "Please check these params in your code (AppId: " + com.anythink.core.common.b.n.a().p() + ", AppKey: " + com.anythink.core.common.b.n.a().q() + ", PlacementId: " + this.b + ad.f20406s;
                        }
                        f.this.f7395f = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ j b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f7420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.anythink.core.c.d f7421e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7422f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f7423g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.anythink.core.common.e.e f7424h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ al f7425i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f7426j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ List f7427k;

        AnonymousClass3(Context context, j jVar, String str, String str2, com.anythink.core.c.d dVar, boolean z2, List list, com.anythink.core.common.e.e eVar, al alVar, List list2, List list3) {
            this.a = context;
            this.b = jVar;
            this.f7419c = str;
            this.f7420d = str2;
            this.f7421e = dVar;
            this.f7422f = z2;
            this.f7423g = list;
            this.f7424h = eVar;
            this.f7425i = alVar;
            this.f7426j = list2;
            this.f7427k = list3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                new long[1][0] = System.currentTimeMillis();
                com.anythink.core.common.e.a aVar = new com.anythink.core.common.e.a();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.f7080c = this.f7419c;
                aVar.f7081d = this.f7420d;
                aVar.f7082e = this.f7421e.X();
                aVar.f7083f = this.f7421e.H();
                aVar.f7084g = this.f7421e.z();
                aVar.f7085h = this.f7421e.i();
                i.a();
                aVar.f7089l = i.a(this.f7421e, this.f7422f);
                i.a();
                aVar.f7092o = i.a(this.f7421e);
                i.a();
                aVar.f7093p = i.b(this.f7421e);
                aVar.f7086i = this.f7423g;
                aVar.f7091n = this.f7421e;
                aVar.f7096s = this.f7424h;
                aVar.f7100w = this.f7425i;
                aVar.f7094q = v.a().c(f.this.f7392c);
                if (this.f7426j.size() > 0) {
                    aVar.f7097t = (ai) this.f7426j.get(0);
                }
                ArrayList arrayList = new ArrayList();
                if (this.f7427k != null) {
                    arrayList.addAll(this.f7427k);
                }
                aVar.f7087j = arrayList;
                aVar.f7090m = this.f7422f;
                if (this.b.f7583d == 8) {
                    aVar.f7098u = 7;
                }
                com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar);
                bVar.a(ATSDK.isNetworkLogDebug());
                bVar.a(new k.a() { // from class: com.anythink.core.common.f.3.1
                    @Override // com.anythink.core.common.k.a
                    public final void a(String str, List<ai> list, List<ai> list2) {
                        boolean z2 = com.anythink.core.c.e.a(f.this.b).a(f.this.f7392c).j() == 1;
                        ArrayList arrayList2 = null;
                        for (ai aiVar : list2) {
                            if (z2 && (aiVar.l() == 1 || aiVar.l() == 3)) {
                                if (aiVar.P() != 1) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList(4);
                                    }
                                    aiVar.y(7);
                                    arrayList2.add(aiVar);
                                }
                            }
                            if (!z2 && aiVar.k() != 0) {
                                c.a().f7000c.put(aiVar.t(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                        if (list.size() > 0) {
                            w.a().a(AnonymousClass3.this.f7420d, str, list);
                        }
                        h hVar = f.this.f7393d.get(str);
                        if (hVar != null) {
                            hVar.a(list, list2, arrayList2);
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void b(String str) {
                        w.a().a(AnonymousClass3.this.f7420d, str);
                        h hVar = f.this.f7393d.get(str);
                        if (hVar != null) {
                            hVar.e();
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void a(String str) {
                        h hVar = f.this.f7393d.get(str);
                        if (hVar != null) {
                            hVar.d();
                        }
                    }
                });
            } catch (Throwable unused) {
                h hVar = f.this.f7393d.get(this.f7419c);
                if (hVar != null) {
                    hVar.e();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ double b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7429c;

        AnonymousClass4(ATBaseAdAdapter aTBaseAdAdapter, double d2, String str) {
            this.a = aTBaseAdAdapter;
            this.b = d2;
            this.f7429c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.e.e trackingInfo = this.a.getTrackingInfo();
            ai unitGroupInfo = this.a.getUnitGroupInfo();
            if (trackingInfo == null || unitGroupInfo == null || unitGroupInfo.j() || TextUtils.equals(trackingInfo.Y(), "2") || TextUtils.equals(trackingInfo.Y(), "4")) {
                return;
            }
            f fVar = f.this;
            if ((fVar.f7401l <= this.b || !fVar.f7402m.equals(this.f7429c)) && trackingInfo.H() != 35) {
                f fVar2 = f.this;
                fVar2.f7401l = this.b;
                fVar2.f7402m = this.f7429c;
                g gVar = fVar2.f7400k;
                if (gVar != null) {
                    gVar.cancel();
                    f.this.f7400k = null;
                }
                f.a(f.this, unitGroupInfo, trackingInfo);
            }
        }
    }

    public f(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f7392c = str;
        if (com.anythink.core.common.b.n.a().g() == null) {
            com.anythink.core.common.b.n.a().a(this.b);
        }
    }

    static /* synthetic */ boolean f(f fVar) {
        fVar.f7405p = false;
        return false;
    }

    static /* synthetic */ long g(f fVar) {
        fVar.f7406q = 0L;
        return 0L;
    }

    public abstract h a(T t2);

    protected abstract String a();

    public void a(String str, com.anythink.core.common.b.a aVar) {
    }

    public boolean a(String str, String str2, T t2, com.anythink.core.common.b.a aVar) {
        return false;
    }

    protected void b(AdError adError) {
    }

    public boolean g() {
        return false;
    }

    public final void h() {
        com.anythink.core.common.b.a aVar = this.f7398i;
        if (aVar != null) {
            aVar.onAdLoaded();
        }
    }

    public boolean i() {
        return !TextUtils.isEmpty(this.f7396g);
    }

    protected boolean j() {
        return false;
    }

    protected void k() {
    }

    protected void l() {
    }

    public final void b() {
        com.anythink.core.c.d dVarB = com.anythink.core.c.e.a(this.b).b(this.f7392c);
        if (this.f7405p || dVarB == null) {
            return;
        }
        this.f7405p = true;
        this.f7406q = System.currentTimeMillis();
    }

    protected final boolean c() {
        return System.currentTimeMillis() - this.f7406q <= com.anythink.expressad.exoplayer.i.a.f9492f;
    }

    public final boolean d() {
        return System.currentTimeMillis() - this.f7403n >= this.f7404o;
    }

    public final boolean e() {
        h hVar;
        if (this.f7395f) {
            return true;
        }
        return (TextUtils.isEmpty(this.f7396g) || (hVar = this.f7393d.get(this.f7396g)) == null || hVar.c()) ? false : true;
    }

    public final void f() {
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.f.5
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = f.this.f7400k;
                if (gVar != null) {
                    gVar.cancel();
                    f.this.f7400k = null;
                }
            }
        });
    }

    public final h c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f7393d.get(str);
    }

    public final void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.6
            @Override // java.lang.Runnable
            public final void run() {
                h hVar = f.this.f7393d.get(str);
                if (hVar != null) {
                    hVar.i();
                }
            }
        });
    }

    public final void a(com.anythink.core.common.b.a aVar) {
        synchronized (this.f7409t) {
            if (this.f7408s == null) {
                this.f7408s = new ArrayList();
            }
            if (aVar == null) {
                return;
            }
            boolean z2 = false;
            Iterator<com.anythink.core.common.b.a> it = this.f7408s.iterator();
            while (it.hasNext()) {
                if (it.next() == aVar) {
                    z2 = true;
                }
            }
            if (!z2) {
                this.f7408s.add(aVar);
            }
        }
    }

    public final void b(String str) {
        this.f7393d.remove(str);
    }

    private static void b(com.anythink.core.c.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(eVar.W(), dVar)) {
            eVar.z(2);
            throw new e(ErrorCode.getErrorCode(ErrorCode.inPacingError, "", ""), "Pacing.");
        }
    }

    public final void a(String str) {
        if (TextUtils.equals(str, com.anythink.core.c.e.a(this.b).a(this.f7392c).U())) {
            this.f7394e = 1;
            this.f7403n = System.currentTimeMillis();
            this.f7405p = false;
            this.f7406q = 0L;
            this.f7407r = false;
            return;
        }
        this.f7394e = 0;
    }

    public final void a(String str, double d2, ai aiVar) {
        h hVar = this.f7393d.get(str);
        if (hVar != null) {
            hVar.a(d2, aiVar);
        }
    }

    protected final void a(Context context, String str, String str2, T t2, com.anythink.core.common.b.a aVar) {
        Map<String, Object> mapC = v.a().c(str2);
        int[] iArr = {0};
        if (mapC.containsKey(ah.O)) {
            try {
                iArr[0] = ((Integer) mapC.get(ah.O)).intValue();
            } catch (Throwable unused) {
            }
        }
        int i2 = t2.f7583d;
        if (i2 == 0 || i2 == 3) {
            v.a().a(str2, new Throwable().getStackTrace());
        }
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(t2, str2, aVar, context, iArr, str, mapC));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.core.c.d r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(com.anythink.core.c.d, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: all -> 0x0079, e -> 0x0281, TRY_ENTER, TryCatch #0 {e -> 0x0281, blocks: (B:7:0x0067, B:11:0x0072, B:25:0x00a3, B:28:0x00a9, B:32:0x00b3, B:41:0x00c5, B:42:0x00d5, B:38:0x00bf, B:17:0x0081), top: B:104:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9 A[Catch: all -> 0x0079, e -> 0x0281, TryCatch #0 {e -> 0x0281, blocks: (B:7:0x0067, B:11:0x0072, B:25:0x00a3, B:28:0x00a9, B:32:0x00b3, B:41:0x00c5, B:42:0x00d5, B:38:0x00bf, B:17:0x0081), top: B:104:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf A[Catch: all -> 0x0079, e -> 0x0281, TryCatch #0 {e -> 0x0281, blocks: (B:7:0x0067, B:11:0x0072, B:25:0x00a3, B:28:0x00a9, B:32:0x00b3, B:41:0x00c5, B:42:0x00d5, B:38:0x00bf, B:17:0x0081), top: B:104:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4 A[Catch: e -> 0x0234, all -> 0x0278, TRY_LEAVE, TryCatch #3 {all -> 0x0278, blocks: (B:7:0x0067, B:23:0x0091, B:44:0x00d7, B:46:0x00e4, B:20:0x0089), top: B:104:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021f  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r25, java.lang.String r26, java.lang.String r27, com.anythink.core.c.d r28, com.anythink.core.common.e.e r29, T r30) {
        /*
            Method dump skipped, instruction units count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(android.content.Context, java.lang.String, java.lang.String, com.anythink.core.c.d, com.anythink.core.common.e.e, com.anythink.core.common.j):void");
    }

    private static void a(com.anythink.core.c.d dVar, com.anythink.core.common.e.e eVar) {
        if (dVar.aw()) {
            return;
        }
        eVar.z(5);
        throw new e(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
    }

    private static void a(com.anythink.core.c.d dVar, List list, List list2, List list3, com.anythink.core.common.e.e eVar) {
        if (list == null || list.size() == 0) {
            if (list2 == null || list2.size() == 0) {
                if (list3 == null || list3.size() == 0) {
                    eVar.z(5);
                    if (dVar.h() == 1) {
                        throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                    }
                    throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                }
            }
        }
    }

    private static void a(com.anythink.core.c.d dVar, ae aeVar, com.anythink.core.common.e.e eVar) {
        long jAb = dVar.ab();
        long jAc = dVar.ac();
        int i2 = aeVar != null ? aeVar.f7140d : 0;
        int i3 = aeVar != null ? aeVar.f7139c : 0;
        if ((jAb == -1 || i3 < jAb) && (jAc == -1 || i2 < jAc)) {
            return;
        }
        eVar.z(1);
        throw new e(ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", ""), "Capping.");
    }

    private void a(int i2, com.anythink.core.c.d dVar, List<ai> list, List<ai> list2, List<ai> list3, List<ai> list4, List<ai> list5, List<ai> list6, List<ai> list7, ae aeVar, com.anythink.core.common.e.e eVar) {
        AtomicInteger atomicInteger = new AtomicInteger(list.size() + list2.size() + list3.size());
        for (ai aiVar : list) {
            if (a(i2, dVar, eVar.W(), eVar, aeVar, aiVar, atomicInteger)) {
                aiVar.b();
                list7.add(aiVar);
            } else {
                list4.add(aiVar);
            }
        }
        for (ai aiVar2 : list2) {
            if (a(i2, dVar, eVar.W(), eVar, aeVar, aiVar2, atomicInteger)) {
                aiVar2.b();
                list7.add(aiVar2);
            } else {
                list5.add(aiVar2);
            }
        }
        for (ai aiVar3 : list3) {
            if (a(i2, dVar, eVar.W(), eVar, aeVar, aiVar3, atomicInteger)) {
                aiVar3.b();
                list7.add(aiVar3);
            } else {
                list6.add(aiVar3);
            }
        }
        if (list4.size() > 0 || list5.size() > 0 || list6.size() > 0) {
            return;
        }
        eVar.z(6);
        if (atomicInteger.get() == 0) {
            eVar.z(10);
        }
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
        throw new e(errorCode, errorCode.printStackTrace());
    }

    private void a(List<ai> list, List<ai> list2, com.anythink.core.common.e.e eVar, List<ai> list3) {
        boolean z2 = false;
        for (int size = list2.size() - 1; size >= 0; size--) {
            ai aiVar = list2.get(size);
            if (aiVar.aa()) {
                list3.add(aiVar);
            }
            if (aiVar.m() != 2) {
                com.anythink.core.common.e.b bVarA = a.a().a(this.f7392c, aiVar);
                ai aiVar2 = null;
                if (bVarA != null) {
                    aiVar.a(bVarA.e().getUnitGroupInfo(), 0, 3, 1);
                    aiVar2 = aiVar;
                }
                if (aiVar2 == null) {
                    try {
                        com.anythink.core.common.e.m mVarA = com.anythink.core.b.f.a().a(aiVar);
                        if (mVarA != null && !mVarA.a()) {
                            aiVar.a(mVarA, 0, 2, 1);
                            aiVar2 = aiVar;
                        } else if (mVarA != null) {
                            com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                            rVar.a = 1;
                            rVar.b = mVarA.getSortPrice();
                            rVar.f7378e = eVar;
                            rVar.f7376c = aiVar;
                            rVar.f7377d = aiVar;
                            mVarA.a(rVar, true);
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (aiVar2 != null) {
                    try {
                        if (aiVar.l() == 7) {
                            z2 = true;
                        }
                        list2.remove(size);
                        com.anythink.core.common.k.g.a(list, aiVar, false);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (z2) {
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                if (list2.get(size2).l() == 7) {
                    list2.remove(size2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, com.anythink.core.common.e.e eVar, Throwable th) {
        AdError errorCode;
        if (th instanceof e) {
            errorCode = ((e) th).a;
        } else {
            errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", th.getMessage());
        }
        a(z2, eVar, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, com.anythink.core.common.e.e eVar, AdError adError) {
        this.f7395f = false;
        a(adError);
        eVar.a(false);
        if (z2) {
            com.anythink.core.common.j.a.a(this.b).a(10, eVar);
            com.anythink.core.common.j.c.a(eVar, adError);
        }
    }

    private boolean a(int i2, com.anythink.core.c.d dVar, String str, com.anythink.core.common.e.e eVar, ae aeVar, ai aiVar, AtomicInteger atomicInteger) {
        com.anythink.core.common.e.d dVarD;
        com.anythink.core.common.e.e eVarN = eVar.N();
        com.anythink.core.common.k.s.a(eVarN, aiVar, 0, false);
        ae.a aVarA = aeVar != null ? aeVar.a(aiVar.t()) : null;
        int i3 = aVarA != null ? aVarA.f7145e : 0;
        int i4 = aVarA != null ? aVarA.f7144d : 0;
        if (aiVar.e() != -1 && i4 >= aiVar.e()) {
            aiVar.g(-5);
            aiVar.h("Out of Cap");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Cap", aiVar, i3, i4);
            com.anythink.core.common.j.c.a(eVarN, 2, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        }
        if (aiVar.f() != -1 && i3 >= aiVar.f()) {
            aiVar.g(-5);
            aiVar.h("Out of Cap");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Cap", aiVar, i3, i4);
            com.anythink.core.common.j.c.a(eVarN, 2, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        }
        if (com.anythink.core.a.c.a().a(str, aiVar)) {
            aiVar.g(-6);
            aiVar.h("Out of Pacing");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Pacing", aiVar, i3, i4);
            com.anythink.core.common.j.c.a(eVarN, 3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
            return true;
        }
        if (c.a().a(aiVar)) {
            aiVar.g(-6);
            aiVar.h("Request fail in pacing");
            com.anythink.core.common.k.n.a(str, eVar, "Request fail in pacing", aiVar, i3, i4);
            com.anythink.core.common.j.c.a(eVarN, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
            return true;
        }
        List<String> listL = com.anythink.core.common.b.n.a().l(this.f7392c);
        if (listL != null && listL.contains(aiVar.t())) {
            aiVar.g(-8);
            aiVar.h("Request fail in filter list");
            com.anythink.core.common.k.n.a(str, eVar, "Request fail in filter list", aiVar, i3, i4, listL);
            com.anythink.core.common.j.c.a(eVarN, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
            return true;
        }
        List<String> listM = com.anythink.core.common.b.n.a().m(this.f7392c);
        if (listM != null && listM.contains(String.valueOf(aiVar.c()))) {
            aiVar.g(-8);
            aiVar.h("Filter by network firm id.");
            com.anythink.core.common.k.n.a(str, eVar, "Filter by network firm id.", aiVar, i3, i4, listM);
            com.anythink.core.common.j.c.a(eVarN, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdfilterSourceError, "", "Filter by network firm id."));
            return true;
        }
        if (aiVar.j()) {
            if (c.a().b(aiVar)) {
                aiVar.g(-7);
                aiVar.h("Bid fail in pacing");
                com.anythink.core.common.k.n.a(str, eVar, "Bid fail in pacing", aiVar, i3, i4);
                com.anythink.core.common.j.c.a(eVarN, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                return true;
            }
            if (aiVar.X() != 1 && aiVar.l() == 2 && (dVarD = v.a().d(this.f7392c)) != null && dVarD.a(aiVar)) {
                aiVar.g(-7);
                aiVar.h("Can't Load On Showing");
                com.anythink.core.common.k.n.a(str, eVar, "Can't Load On Showing", aiVar, i3, i4);
                com.anythink.core.common.j.c.a(eVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                return true;
            }
        }
        if (!c.a().a(i2, dVar, aiVar)) {
            return false;
        }
        atomicInteger.decrementAndGet();
        aiVar.g(-8);
        aiVar.h("Error Code Request fail in pacing");
        com.anythink.core.common.k.n.a(str, eVar, "Error Code Request fail in pacing", aiVar, i3, i4);
        com.anythink.core.common.j.c.a(eVarN, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
        return true;
    }

    private List<ai> a(com.anythink.core.c.d dVar, String str, int i2, List<ai> list) {
        int i3;
        JSONArray jSONArray = new JSONArray();
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(this.f7392c);
        eVar.y(str);
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.X());
        eVar.z(sb.toString());
        eVar.w(dVar.U());
        eVar.t(i2);
        eVar.E(dVar.O());
        eVar.v(dVar.ae());
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap map = new HashMap(3);
        Iterator<ai> it = list.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            ai next = it.next();
            double dA = com.anythink.core.common.k.g.a(next);
            List arrayList2 = (List) linkedHashMap.get(String.valueOf(dA));
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(String.valueOf(dA), arrayList2);
            }
            Integer num = (Integer) map.get(String.valueOf(dA));
            if (num == null) {
                num = 0;
            }
            map.put(String.valueOf(dA), Integer.valueOf(num.intValue() + next.T()));
            arrayList2.add(next);
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (true) {
            int i4 = 1;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            List list2 = (List) entry.getValue();
            if (list2.size() > 1) {
                int iIntValue = ((Integer) map.get(entry.getKey())).intValue();
                ArrayList arrayList3 = new ArrayList();
                while (true) {
                    if (list2.size() <= 0) {
                        break;
                    }
                    if (list2.size() == i4) {
                        arrayList3.add((ai) list2.get(i3));
                        list2.remove(i3);
                        break;
                    }
                    int iNextInt = this.f7399j.nextInt(iIntValue) + i4;
                    Iterator it3 = list2.iterator();
                    int iT = 0;
                    while (true) {
                        if (it3.hasNext()) {
                            ai aiVar = (ai) it3.next();
                            if (aiVar.T() + iT >= iNextInt) {
                                arrayList3.add(aiVar);
                                list2.remove(aiVar);
                                iIntValue -= aiVar.T();
                                i3 = 0;
                                i4 = 1;
                                break;
                            }
                            iT += aiVar.T();
                            i3 = 0;
                            i4 = 1;
                        }
                    }
                }
                linkedHashMap.put((String) entry.getKey(), arrayList3);
                i3 = 0;
            }
        }
        new StringBuilder("Request UnitGroup's Number:").append(dVar.l());
        Iterator it4 = linkedHashMap.entrySet().iterator();
        int i5 = 0;
        while (it4.hasNext()) {
            for (ai aiVar2 : (List) ((Map.Entry) it4.next()).getValue()) {
                aiVar2.m((i5 / dVar.l()) + 1);
                StringBuilder sb2 = new StringBuilder("UnitGroupInfo requestLevel:");
                sb2.append(i5);
                sb2.append(" || layer:");
                sb2.append(aiVar2.E());
                arrayList.add(aiVar2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sortpriority", i5);
                    jSONObject.put("sorttype", aiVar2.o());
                    jSONObject.put("unit_id", aiVar2.t());
                    try {
                        jSONObject.put("bidresult", 1);
                        jSONObject.put("bidprice", aiVar2.M() ? String.valueOf(aiVar2.x()) : "0");
                        jSONArray.put(jSONObject);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
                i5++;
            }
        }
        eVar.s(jSONArray.toString());
        com.anythink.core.common.j.a.a(this.b).a(15, eVar);
        return arrayList;
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, String str, double d2) {
        com.anythink.core.common.b.n.a().a(new AnonymousClass4(aTBaseAdAdapter, d2, str));
    }

    private void a(ai aiVar, com.anythink.core.common.e.e eVar) {
        this.f7400k = new g(aiVar.p(), aiVar.p(), aiVar, eVar);
        this.f7400k.start();
    }

    public final void a(com.anythink.core.common.e.b bVar) {
        if (bVar.c()) {
            this.f7394e = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.anythink.core.api.ATAdStatusInfo a(android.content.Context r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            boolean r0 = r4.e()
            r1 = 0
            r2 = 1
            com.anythink.core.common.e.b r5 = r4.a(r5, r2, r1, r6)
            if (r5 == 0) goto L26
            com.anythink.core.api.BaseAd r6 = r5.f()
            com.anythink.core.api.ATBaseAdAdapter r3 = r5.e()
            if (r6 == 0) goto L1b
            com.anythink.core.common.b.j r6 = com.anythink.core.common.b.j.a(r6)
            goto L27
        L1b:
            if (r3 == 0) goto L26
            com.anythink.core.api.ATBaseAdAdapter r6 = r5.e()
            com.anythink.core.common.b.j r6 = com.anythink.core.common.b.j.a(r6)
            goto L27
        L26:
            r6 = 0
        L27:
            com.anythink.core.api.ATAdStatusInfo r3 = new com.anythink.core.api.ATAdStatusInfo
            if (r5 == 0) goto L2c
            r1 = 1
        L2c:
            r3.<init>(r0, r1, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(android.content.Context, java.util.Map):com.anythink.core.api.ATAdStatusInfo");
    }

    public final List<ATAdInfo> a(Context context) {
        List<com.anythink.core.common.e.b> listA;
        if (a(false, false, (Map<String, Object>) null) || (listA = a.a().a(context, this.f7392c, false, false, true, null)) == null || listA.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        Iterator<com.anythink.core.common.e.b> it = listA.iterator();
        while (it.hasNext()) {
            com.anythink.core.common.e.b next = it.next();
            BaseAd baseAdF = next != null ? next.f() : null;
            ATBaseAdAdapter aTBaseAdAdapterE = next != null ? next.e() : null;
            if (baseAdF != null) {
                arrayList.add(com.anythink.core.common.b.j.a(baseAdF));
            } else if (aTBaseAdAdapterE != null) {
                arrayList.add(com.anythink.core.common.b.j.a(aTBaseAdAdapterE));
            }
        }
        return arrayList;
    }

    public com.anythink.core.common.e.b a(Context context, boolean z2, boolean z3, Map<String, Object> map) {
        if (a(z3, z2, map)) {
            return null;
        }
        return a.a().a(context, this.f7392c, z2, z3, map);
    }

    private boolean a(boolean z2, boolean z3, Map<String, Object> map) {
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.f7392c);
        String str = TextUtils.isEmpty(this.f7396g) ? "" : this.f7396g;
        if (dVarA == null) {
            dVarA = com.anythink.core.c.e.a(this.b).a(this.f7392c);
        }
        if (dVarA == null) {
            com.anythink.core.common.e.e eVarA = com.anythink.core.common.k.s.a("", this.f7392c, "", null, "", -1, 0, 0, map);
            if (z2) {
                com.anythink.core.common.j.c.a(eVarA, 4, "", str);
            } else if (z3) {
                com.anythink.core.common.j.c.a(eVarA, false, 4, -1, "", -1, "", "", str, false, "");
            }
            return true;
        }
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(this.f7392c, dVarA)) {
            com.anythink.core.common.e.e eVarA2 = com.anythink.core.common.k.s.a("", this.f7392c, "", dVarA, "", dVarA.l(), 0, 0, map);
            if (z2) {
                com.anythink.core.common.j.c.a(eVarA2, 3, "", str);
            } else if (z3) {
                com.anythink.core.common.j.c.a(eVarA2, false, 3, -1, "", -1, "", "", str, false, "");
            }
            return true;
        }
        if (!com.anythink.core.a.a.a(this.b).a(dVarA, this.f7392c)) {
            return false;
        }
        com.anythink.core.common.e.e eVarA3 = com.anythink.core.common.k.s.a("", this.f7392c, "", dVarA, "", dVarA.l(), 0, 0, map);
        if (z2) {
            com.anythink.core.common.j.c.a(eVarA3, 2, "", str);
        } else if (z3) {
            com.anythink.core.common.j.c.a(eVarA3, false, 2, -1, "", -1, "", "", str, false, "");
        }
        return true;
    }

    public final void a(AdError adError) {
        com.anythink.core.common.b.a aVar = this.f7398i;
        if (aVar != null) {
            aVar.onAdLoadFail(adError);
        }
    }

    public final boolean a(ATAdStatusInfo aTAdStatusInfo) {
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.f7392c);
        if (this.f7394e != 1 || d() || aTAdStatusInfo == null || !aTAdStatusInfo.isReady()) {
            return j() || (dVarA != null && dVarA.V() == 1);
        }
        return false;
    }

    protected static String a(com.anythink.core.common.e.j jVar) {
        return jVar.b + jVar.f7302c + jVar.f7305f + System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v8 */
    static /* synthetic */ void a(f fVar, Context context, String str, String str2, com.anythink.core.c.d dVar, com.anythink.core.common.e.e eVar, j jVar) {
        boolean z2;
        boolean z3 = str2;
        a.a().a(fVar.f7392c, (String) z3, dVar);
        List<ai> listA = com.anythink.core.c.d.a(dVar.af(), dVar.ag());
        List<ai> listA2 = com.anythink.core.c.d.a(dVar.ah(), dVar.C(), dVar.ai(), dVar.A(), dVar.s(), dVar.ao(), dVar.ap());
        List<ai> listC = com.anythink.core.c.d.c(dVar.n());
        List<ai> listD = com.anythink.core.c.d.d(dVar.g());
        com.anythink.core.common.e.e eVar2 = null;
        if (listC != null) {
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.anythink.core.common.k.g.a(listA, listC.get(i2), false);
            }
        }
        try {
            try {
                if (dVar.aw()) {
                    if ((listA != null && listA.size() != 0) || ((listA2 != null && listA2.size() != 0) || (listD != null && listD.size() != 0))) {
                        ae aeVarA = com.anythink.core.a.a.a(context).a(str);
                        long jAb = dVar.ab();
                        long jAc = dVar.ac();
                        int i3 = aeVarA != null ? aeVarA.f7140d : 0;
                        int i4 = aeVarA != null ? aeVarA.f7139c : 0;
                        if (jAb == -1 || i4 < jAb) {
                            if (jAc != -1) {
                                if (i3 < jAc) {
                                }
                            }
                            com.anythink.core.a.c.a();
                            if (!com.anythink.core.a.c.a(eVar.W(), dVar)) {
                                ArrayList arrayList = new ArrayList(3);
                                List<ai> arrayList2 = new ArrayList<>(3);
                                List<ai> arrayList3 = new ArrayList<>(3);
                                List<ai> arrayList4 = new ArrayList<>(2);
                                z3 = 1;
                                z3 = 1;
                                try {
                                    fVar.a(jVar.f7583d, dVar, listA, listA2, listD, arrayList2, arrayList3, arrayList4, arrayList, aeVarA, eVar);
                                    List<ai> arrayList5 = new ArrayList<>(1);
                                    fVar.a(arrayList2, arrayList3, eVar, arrayList5);
                                    fVar.a(arrayList2, arrayList4, eVar, arrayList5);
                                    List<ai> listA3 = fVar.a(dVar, str2, eVar.F(), arrayList2);
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(listA3);
                                    arrayList6.addAll(arrayList);
                                    w.a().a(str, str2, dVar, arrayList6);
                                    boolean z4 = arrayList5.size() > 0;
                                    if (z4 || arrayList3.size() != 0) {
                                        z2 = false;
                                    } else {
                                        w.a().a(str, str2);
                                        z2 = true;
                                    }
                                    if (z2 && listA3.size() == 0 && arrayList4.size() == 0) {
                                        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                                        eVar.z(6);
                                        fVar.a(true, eVar, errorCode);
                                        fVar.f7395f = false;
                                        return;
                                    }
                                    com.anythink.core.a.b.a().b(fVar.b, str, dVar);
                                    eVar.a(true);
                                    com.anythink.core.common.j.a.a(fVar.b).a(10, eVar);
                                    Map<String, Object> mapC = v.a().c(fVar.f7392c);
                                    Map<String, al> map = x.a(fVar.b).a;
                                    al alVarRemove = map != null ? map.remove(str) : null;
                                    h hVarA = fVar.a(jVar);
                                    hVarA.f7546h = mapC;
                                    hVarA.f7547i = eVar;
                                    hVarA.a(jVar);
                                    hVarA.a(jVar.f7584e);
                                    hVarA.R = arrayList4;
                                    fVar.f7396g = str2;
                                    com.anythink.core.common.l.g gVar = new com.anythink.core.common.l.g();
                                    gVar.a = str;
                                    gVar.b = str2;
                                    gVar.f7814c = dVar;
                                    gVar.f7815d = listA3;
                                    gVar.f7816e = z2;
                                    gVar.f7817f = eVar.S();
                                    gVar.f7818g = alVarRemove;
                                    hVarA.a(gVar);
                                    fVar.f7393d.put(str2, hVarA);
                                    hVarA.b();
                                    fVar.f7395f = false;
                                    if (z2) {
                                        return;
                                    }
                                    com.anythink.core.common.k.b.a.a().b(new AnonymousClass3(context, jVar, str2, str, dVar, z4, arrayList3, eVar, alVarRemove, arrayList5, listA3));
                                    return;
                                } catch (e e2) {
                                    e = e2;
                                    eVar2 = eVar;
                                    fVar.a(z3, eVar2, e);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    eVar2 = eVar;
                                    fVar.a(z3, eVar2, th);
                                    return;
                                }
                            }
                            eVar.z(2);
                            throw new e(ErrorCode.getErrorCode(ErrorCode.inPacingError, "", ""), "Pacing.");
                        }
                        eVar.z(1);
                        throw new e(ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", ""), "Capping.");
                    }
                    eVar.z(5);
                    if (dVar.h() == 1) {
                        throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                    }
                    throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                }
                eVar.z(5);
                throw new e(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
            } catch (e e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (e e4) {
            e = e4;
            eVar2 = eVar;
            z3 = 1;
        } catch (Throwable th3) {
            th = th3;
            eVar2 = eVar;
            z3 = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.core.common.f r9, com.anythink.core.c.d r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(com.anythink.core.common.f, com.anythink.core.c.d, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void a(f fVar, ai aiVar, com.anythink.core.common.e.e eVar) {
        fVar.f7400k = new g(aiVar.p(), aiVar.p(), aiVar, eVar);
        fVar.f7400k.start();
    }
}
