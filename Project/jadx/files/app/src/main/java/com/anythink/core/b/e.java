package com.anythink.core.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.b.i;
import com.anythink.core.b.i.AnonymousClass1;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f6536g = 10000.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final String f6537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final List<JSONObject> f6538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<ai> f6539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List<ai> f6540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f6541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f6542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f6543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    com.anythink.core.b.b.a f6544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f6545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected m f6546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f6547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected AtomicBoolean f6548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected AtomicBoolean f6549t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Runnable f6554y;

    public e(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.f6537h = getClass().getSimpleName() + ":";
        this.f6538i = new ArrayList();
        this.f6539j = new ArrayList();
        this.f6540k = new ArrayList();
        this.f6548s = new AtomicBoolean(false);
        this.f6549t = new AtomicBoolean(false);
        this.f6550u = new ConcurrentHashMap<>();
        this.f6551v = new ConcurrentHashMap<>();
        this.f6552w = new ConcurrentHashMap<>();
        this.f6553x = new ConcurrentHashMap<>();
        this.f6554y = new Runnable() { // from class: com.anythink.core.b.e.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.g();
                    }
                });
            }
        };
        List<ai> list = aVar.f7086i;
        if (list != null && list.size() > 0) {
            for (ai aiVar : aVar.f7086i) {
                if (aiVar != null) {
                    this.f6550u.put(aiVar.t(), aiVar);
                    this.f6552w.put(aiVar.t(), aiVar);
                }
            }
        }
        List<ai> list2 = aVar.f7088k;
        if (list2 != null && list2.size() > 0) {
            for (ai aiVar2 : aVar.f7088k) {
                this.f6551v.put(aiVar2.t(), aiVar2);
            }
        }
        JSONObject jSONObject = aVar.f7095r;
        if (jSONObject != null) {
            this.f6538i.add(jSONObject);
        }
        ai aiVar3 = aVar.f7097t;
        if (aiVar3 != null) {
            this.f6546q = aiVar3.N();
            this.f6547r = aVar.f7097t.t();
            if (this.f6546q == null) {
                com.anythink.core.common.e.b bVarA = com.anythink.core.common.a.a().a(aVar.f7081d, aVar.f7097t);
                if (bVarA != null) {
                    this.f6546q = bVarA.e().getUnitGroupInfo().N();
                } else {
                    this.f6546q = f.a().a(aVar.f7097t);
                }
            }
        }
        this.f6541l = aVar.f7080c;
        this.f6542m = aVar.f7081d;
        this.f6543n = b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(final long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6537h);
        sb.append("beginRequestBidInfo");
        ArrayList arrayList = new ArrayList();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a(arrayList, concurrentHashMap);
        this.f6549t.set(true);
        a(arrayList, new com.anythink.core.common.g.i() { // from class: com.anythink.core.b.e.3
            @Override // com.anythink.core.common.g.i
            public final void onLoadCanceled(int i2) {
                synchronized (e.class) {
                    e.this.f6549t.set(false);
                    e.this.d();
                    e.this.a((List<m>) null, SystemClock.elapsedRealtime() - j2, "onLoadCanceled.", (Map<String, ai>) concurrentHashMap);
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadError(int i2, String str, AdError adError) {
                synchronized (e.class) {
                    e.this.f6549t.set(false);
                    e.this.d();
                    e.this.a((List<m>) null, SystemClock.elapsedRealtime() - j2, adError != null ? adError.getPlatformMSG() : "", (Map<String, ai>) concurrentHashMap);
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadFinish(int i2, Object obj) {
                synchronized (e.class) {
                    e.this.f6549t.set(false);
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
                    List listA = e.a(e.this, obj);
                    e.a(e.this, obj, listA);
                    e.this.a((List<m>) listA, jElapsedRealtime, (String) null, (Map<String, ai>) concurrentHashMap);
                    e.this.d();
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadStart(int i2) {
            }
        });
    }

    private void e() {
        n.a().c(this.f6554y);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.f6537h
            r0.append(r1)
            java.lang.String r1 = "handleBidTokenResult"
            r0.append(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.ai> r0 = r7.f6552w
            int r0 = r0.size()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L26
            r7.e()
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6549t
            boolean r0 = r0.get()
            if (r0 != 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            int r3 = r7.h()
            if (r3 <= 0) goto L45
            if (r0 != 0) goto L46
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6548s
            boolean r0 = r0.get()
            if (r0 == 0) goto L41
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6549t
            boolean r0 = r0.get()
            if (r0 != 0) goto L41
            r0 = 1
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L45
            goto L46
        L45:
            r1 = 0
        L46:
            if (r1 == 0) goto L4e
            long r0 = r7.f6545p
            r7.b(r0)
            return
        L4e:
            java.util.List<com.anythink.core.common.e.ai> r0 = r7.f6539j
            int r0 = r0.size()
            if (r0 <= 0) goto L66
            boolean r0 = r7.o()
            if (r0 == 0) goto L66
            r2 = 0
            r3 = 0
            r6 = 0
            java.lang.String r5 = ""
            r1 = r7
            r1.a(r2, r3, r5, r6)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.e.f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.f6529f.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6537h);
        sb.append("get token short timeout.");
        this.f6548s.set(true);
        if (h() > 0) {
            b(SystemClock.elapsedRealtime());
        }
    }

    private synchronized int h() {
        return this.f6538i.size();
    }

    private boolean i() {
        return !this.f6549t.get() && this.f6538i.size() > 0;
    }

    private boolean j() {
        return this.f6548s.get() && !this.f6549t.get();
    }

    private synchronized void k() {
        if (!this.f6529f.get()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6537h);
            sb.append("finishCallback: ");
            this.f6529f.set(true);
            e();
            this.f6552w.clear();
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.f6550u);
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.f6551v);
            n();
            m();
            l();
        }
    }

    private void l() {
        com.anythink.core.b.b.a aVar;
        if ((this.f6540k.size() > 0 || this.f6539j.size() > 0) && (aVar = this.f6544o) != null) {
            aVar.a(this.f6540k, this.f6539j);
        }
        this.f6540k.clear();
        this.f6539j.clear();
    }

    private synchronized void m() {
        if (o()) {
            this.f6529f.set(true);
        }
    }

    private void n() {
        if (this.f6528e) {
            if (this.f6540k.size() > 0 || this.f6539j.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("S2S HeadBidding Success List", d.a(this.f6540k));
                    jSONObject.put("S2S HeadBidding Fail List", d.a(this.f6539j));
                } catch (Exception unused) {
                }
                com.anythink.core.common.k.n.a(com.anythink.core.common.k.n.a, jSONObject.toString(), false);
            }
        }
    }

    private boolean o() {
        return this.f6550u.size() == 0 && this.f6551v.size() == 0 && this.f6552w.size() == 0;
    }

    protected abstract void a(List<JSONObject> list, com.anythink.core.common.g.i iVar);

    protected abstract String b();

    protected final synchronized void d() {
        if (!this.f6549t.get() && this.f6538i.size() > 0) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.e.4
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.b(SystemClock.elapsedRealtime());
                }
            });
        }
    }

    @Override // com.anythink.core.b.d
    public final void a(boolean z2) {
        this.f6528e = z2;
    }

    @Override // com.anythink.core.b.d
    protected final void a(com.anythink.core.b.b.a aVar) {
        List<ai> list;
        this.f6545p = SystemClock.elapsedRealtime();
        this.f6544o = aVar;
        if (this.f6528e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("S2S Start HeadBidding List", d.a(this.f6527d.f7086i));
                jSONObject.put("S2S Start HeadBidding List(Directly)", d.b(this.f6538i));
            } catch (Exception unused) {
            }
            com.anythink.core.common.k.n.a(com.anythink.core.common.k.n.a, jSONObject.toString(), false);
        }
        if (this.f6527d.f7086i.size() == 0 && (list = this.f6527d.f7088k) != null && list.size() > 0) {
            b(this.f6545p);
            return;
        }
        long jT = this.f6527d.f7091n.t();
        if (jT <= 0) {
            jT = 500;
        }
        n.a().a(this.f6554y, jT);
        Iterator<Map.Entry<String, ai>> it = this.f6550u.entrySet().iterator();
        while (it.hasNext()) {
            ai value = it.next().getValue();
            i iVar = new i(this.f6527d);
            i.a aVar2 = new i.a() { // from class: com.anythink.core.b.e.2
                @Override // com.anythink.core.b.i.a
                public final void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                    com.anythink.core.b.b.a aVar3 = e.this.f6544o;
                    if (aVar3 != null) {
                        aVar3.a(aiVar, aTBaseAdAdapter);
                    }
                }

                @Override // com.anythink.core.b.i.a
                public final void a(ai aiVar, JSONObject jSONObject2) {
                    if (e.this.f6529f.get()) {
                        return;
                    }
                    e.this.f6552w.remove(aiVar.t());
                    e.a(e.this, aiVar);
                    e.this.a(jSONObject2, aiVar);
                    e.b(e.this);
                }

                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // com.anythink.core.b.i.a
                public final void a(String str, ai aiVar) {
                    if (e.this.f6529f.get()) {
                        return;
                    }
                    if (str == null) {
                        str = "";
                    }
                    e.this.f6552w.remove(aiVar.t());
                    e.this.f6550u.remove(aiVar.t());
                    e.a(e.this, str, aiVar);
                    byte b = -1;
                    switch (str.hashCode()) {
                        case -1295842379:
                            if (str.equals(ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
                                b = 1;
                            }
                            break;
                        case -49992206:
                            if (str.equals(ATBidRequestInfo.BIDTOKEN_OBTAIN_TIMEOUT_TYPE)) {
                                b = 5;
                            }
                            break;
                        case 56988620:
                            if (str.equals(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE)) {
                                b = 4;
                            }
                            break;
                        case 204511524:
                            if (str.equals(ATBidRequestInfo.INIT_ERROR_TYPE)) {
                                b = 2;
                            }
                            break;
                        case 1316982070:
                            if (str.equals(ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE)) {
                                b = 3;
                            }
                            break;
                        case 1956498070:
                            if (str.equals(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE)) {
                                b = 0;
                            }
                            break;
                    }
                    if (b == 0 || b == 1 || b == 2 || b == 3) {
                        e.this.b(aiVar, str, 0L, -9);
                    } else if (b == 4 || b == 5) {
                        e.this.b(aiVar, str, 0L, -2);
                    } else {
                        e.this.b(aiVar, "Unknown error: ".concat(String.valueOf(str)), 0L, -9);
                    }
                    e.b(e.this);
                }
            };
            iVar.f6565d = aVar2;
            ATBaseAdAdapter aTBaseAdAdapterA = com.anythink.core.common.k.i.a(value);
            if (aTBaseAdAdapterA == null) {
                aVar2.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, value);
            } else {
                com.anythink.core.common.k.b.a.a().a(iVar.new AnonymousClass1(aTBaseAdAdapterA, value));
            }
        }
    }

    private void b(ai aiVar) {
        int iC = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, this.f6527d, SystemClock.elapsedRealtime() - this.f6545p, true, f.a().b(iC));
        f.a().a(iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ai aiVar, String str, long j2, int i2) {
        d.a(aiVar, str, j2, i2);
        this.f6539j.add(aiVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void b(com.anythink.core.b.e r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.f6537h
            r0.append(r1)
            java.lang.String r1 = "handleBidTokenResult"
            r0.append(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.ai> r0 = r7.f6552w
            int r0 = r0.size()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L26
            r7.e()
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6549t
            boolean r0 = r0.get()
            if (r0 != 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            int r3 = r7.h()
            if (r3 <= 0) goto L45
            if (r0 != 0) goto L46
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6548s
            boolean r0 = r0.get()
            if (r0 == 0) goto L41
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f6549t
            boolean r0 = r0.get()
            if (r0 != 0) goto L41
            r0 = 1
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L45
            goto L46
        L45:
            r1 = 0
        L46:
            if (r1 == 0) goto L4e
            long r0 = r7.f6545p
            r7.b(r0)
            return
        L4e:
            java.util.List<com.anythink.core.common.e.ai> r0 = r7.f6539j
            int r0 = r0.size()
            if (r0 <= 0) goto L66
            boolean r0 = r7.o()
            if (r0 == 0) goto L66
            r2 = 0
            r3 = 0
            r6 = 0
            java.lang.String r5 = ""
            r1 = r7
            r1.a(r2, r3, r5, r6)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.e.b(com.anythink.core.b.e):void");
    }

    private void a(long j2) {
        n.a().a(this.f6554y, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(JSONObject jSONObject, ai aiVar) {
        this.f6538i.add(jSONObject);
        this.f6553x.put(aiVar.t(), aiVar);
    }

    private synchronized void a(List<JSONObject> list, Map<String, ai> map) {
        list.addAll(this.f6538i);
        this.f6538i.clear();
        map.putAll(this.f6553x);
        this.f6553x.clear();
    }

    private void a(m mVar) {
        if (TextUtils.isEmpty(mVar.f7344i)) {
            return;
        }
        try {
            com.anythink.core.common.e.g gVarA = com.anythink.core.common.a.c.a(mVar.token, new JSONObject(mVar.f7344i), mVar.f7339d);
            if (gVarA == null) {
                return;
            }
            if (mVar.f7339d == 67) {
                com.anythink.core.common.d.c.a(this.f6527d.a).a(gVarA.p(), gVarA.P());
                com.anythink.core.common.d.b.a(this.f6527d.a).a(gVarA.q(), gVarA.P());
            }
            com.anythink.core.common.a.a.a().a(this.f6527d.a, mVar.f7339d, mVar.f7346k, mVar.token, mVar.f7344i);
        } catch (Throwable unused) {
        }
    }

    private void a(long j2, int i2, String str, Map<String, ai> map) {
        for (ai aiVar : map.values()) {
            if (a(aiVar, str, i2)) {
                this.f6540k.add(aiVar);
            } else {
                b(aiVar, str, j2, i2);
            }
        }
        map.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<m> list, long j2, String str, Map<String, ai> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6537h);
        sb.append("handleResult: ");
        if (list != null && list.size() > 0) {
            Collections.sort(list);
            for (int i2 = 0; i2 < list.size(); i2++) {
                m mVar = list.get(i2);
                this.f6550u.remove(mVar.f7346k);
                ai aiVarRemove = map.remove(mVar.f7346k);
                if (aiVarRemove == null && this.f6551v.containsKey(mVar.f7346k)) {
                    aiVarRemove = this.f6551v.remove(mVar.f7346k);
                    this.f6551v.clear();
                }
                if (aiVarRemove != null) {
                    if (mVar.isSuccessWithUseType()) {
                        int i3 = i2 + 1;
                        int size = list.size();
                        double dA = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                        if (i3 < size) {
                            m mVar2 = list.get(i3);
                            double sortPrice = mVar2.getSortPrice();
                            dA = sortPrice == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? f.a().a(mVar2.f7342g, aiVarRemove.t()) : sortPrice;
                        }
                        a(aiVarRemove.c(), mVar, dA);
                    }
                    a(aiVarRemove, mVar, j2);
                }
            }
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2 != null) {
                    this.f6550u.remove(str2);
                }
                if (this.f6551v.containsKey(str2)) {
                    this.f6551v.clear();
                }
            }
        }
        if (map != null) {
            a(j2, -4, TextUtils.isEmpty(str) ? "No Response error." : "No Response error." + str, map);
        }
        if (this.f6540k.size() >= 2) {
            Collections.sort(this.f6540k);
        }
        n();
        m();
        l();
    }

    private List<m> a(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("data");
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                m mVarA = m.a(jSONArrayOptJSONArray.optString(i2));
                if (mVarA != null) {
                    mVarA.b(this.f6541l);
                }
                arrayList.add(mVarA);
            }
        }
        return arrayList;
    }

    private void a(Object obj, List<m> list) {
        JSONArray jSONArrayOptJSONArray;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("wf") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("wf")) != null) {
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    arrayList.add(j.a(jSONArrayOptJSONArray.optString(i3)));
                }
                Collections.sort(arrayList);
                int size = arrayList.size();
                double d2 = 10000.0d;
                if (size == 1) {
                    j jVar = (j) arrayList.get(0);
                    if (jVar.f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE && TextUtils.equals(this.f6547r, jVar.b)) {
                        jVar.f6568c = 10000.0d;
                        Iterator<m> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            m next = it.next();
                            if (TextUtils.equals(jVar.b, next.f7346k) && next.isSuccessWithUseType()) {
                                m mVar = this.f6546q;
                                if (mVar == null || !TextUtils.equals(mVar.f7342g, jVar.f6569d)) {
                                    this.f6546q = next;
                                }
                                jVar.f6568c = Math.max(jVar.f6568c, next.f7350o);
                            }
                        }
                        f.a().a(jVar.f6569d, jVar.b, jVar);
                        return;
                    }
                    return;
                }
                int i4 = size - 1;
                while (i2 < size) {
                    j jVar2 = (j) arrayList.get(i2);
                    if (jVar2.f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE && TextUtils.equals(this.f6547r, jVar2.b)) {
                        if (i2 == 0) {
                            int i5 = i2 + 1;
                            if (((j) arrayList.get(i5)).f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                                jVar2.f6568c = d2;
                            } else {
                                jVar2.f6568c = ((j) arrayList.get(i5)).f6568c + 0.1d;
                            }
                        } else if (i2 == i4) {
                            int i6 = i2 - 1;
                            if (((j) arrayList.get(i6)).f6568c - 0.1d <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                                jVar2.f6568c = ((j) arrayList.get(i6)).f6568c / 2.0d;
                            } else {
                                jVar2.f6568c = ((j) arrayList.get(i6)).f6568c - 0.1d;
                            }
                        } else {
                            double d3 = ((j) arrayList.get(i2 - 1)).f6568c;
                            double d4 = d3 - 0.1d;
                            double d5 = d3 - ((j) arrayList.get(i2 + 1)).f6568c;
                            if (Math.abs(d5) <= 0.1d) {
                                d4 = d3 - (d5 / 2.0d);
                            }
                            jVar2.f6568c = d4;
                        }
                        Iterator<m> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            m next2 = it2.next();
                            if (TextUtils.equals(jVar2.b, next2.f7346k) && next2.isSuccessWithUseType()) {
                                m mVar2 = this.f6546q;
                                if (mVar2 == null || !TextUtils.equals(mVar2.f7342g, jVar2.f6569d)) {
                                    this.f6546q = next2;
                                }
                                jVar2.f6568c = Math.max(jVar2.f6568c, next2.f7350o);
                            }
                        }
                        f.a().a(jVar2.f6569d, jVar2.b, jVar2);
                    }
                    i2++;
                    d2 = 10000.0d;
                }
            }
        }
    }

    private void a(String str, ai aiVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int iC = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, this.f6527d, SystemClock.elapsedRealtime() - this.f6545p, false, f.a().b(iC));
        f.a().a(iC);
    }

    @Override // com.anythink.core.b.d
    protected void a(ai aiVar, l lVar, long j2) {
        String str;
        int i2;
        int i3;
        boolean z2 = lVar instanceof m;
        if (z2) {
            m mVar = (m) lVar;
            if (mVar.isSuccessWithUseType()) {
                if (z2 && !TextUtils.isEmpty(mVar.f7344i)) {
                    try {
                        com.anythink.core.common.e.g gVarA = com.anythink.core.common.a.c.a(mVar.token, new JSONObject(mVar.f7344i), mVar.f7339d);
                        if (gVarA != null) {
                            if (mVar.f7339d == 67) {
                                com.anythink.core.common.d.c.a(this.f6527d.a).a(gVarA.p(), gVarA.P());
                                com.anythink.core.common.d.b.a(this.f6527d.a).a(gVarA.q(), gVarA.P());
                            }
                            com.anythink.core.common.a.a.a().a(this.f6527d.a, mVar.f7339d, mVar.f7346k, mVar.token, mVar.f7344i);
                        }
                    } catch (Throwable unused) {
                    }
                }
                aiVar.a(j2);
                this.f6540k.add(aiVar);
                if (aiVar.l() != 3 && aiVar.l() != 7) {
                    mVar.f7341f = aiVar.n() + System.currentTimeMillis();
                } else {
                    mVar.f7341f = mVar.f7340e + System.currentTimeMillis();
                }
                a(aiVar, mVar);
                return;
            }
            if (mVar.useType == 2) {
                i2 = 1;
                aiVar.Q();
                str = "filter by s2s bid max count";
                i3 = 0;
            } else {
                str = "errorCode:[" + mVar.a + "],errorMsg:[" + mVar.errorMsg + "]";
                i2 = 0;
                i3 = -1;
            }
            if (a(aiVar, str, i3, i2)) {
                this.f6540k.add(aiVar);
            } else {
                b(aiVar, str, j2, i3);
            }
        }
    }

    @Override // com.anythink.core.b.d
    protected final void a() {
        k();
    }

    static /* synthetic */ void a(e eVar, ai aiVar) {
        int iC = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, eVar.f6527d, SystemClock.elapsedRealtime() - eVar.f6545p, true, f.a().b(iC));
        f.a().a(iC);
    }

    static /* synthetic */ void a(e eVar, String str, ai aiVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int iC = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, eVar.f6527d, SystemClock.elapsedRealtime() - eVar.f6545p, false, f.a().b(iC));
        f.a().a(iC);
    }

    static /* synthetic */ List a(e eVar, Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("data");
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                m mVarA = m.a(jSONArrayOptJSONArray.optString(i2));
                if (mVarA != null) {
                    mVarA.b(eVar.f6541l);
                }
                arrayList.add(mVarA);
            }
        }
        return arrayList;
    }

    static /* synthetic */ void a(e eVar, Object obj, List list) {
        JSONArray jSONArrayOptJSONArray;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (!jSONObject.has("wf") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("wf")) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                arrayList.add(j.a(jSONArrayOptJSONArray.optString(i3)));
            }
            Collections.sort(arrayList);
            int size = arrayList.size();
            double d2 = 10000.0d;
            if (size == 1) {
                j jVar = (j) arrayList.get(0);
                if (jVar.f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE && TextUtils.equals(eVar.f6547r, jVar.b)) {
                    jVar.f6568c = 10000.0d;
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        m mVar = (m) it.next();
                        if (TextUtils.equals(jVar.b, mVar.f7346k) && mVar.isSuccessWithUseType()) {
                            m mVar2 = eVar.f6546q;
                            if (mVar2 == null || !TextUtils.equals(mVar2.f7342g, jVar.f6569d)) {
                                eVar.f6546q = mVar;
                            }
                            jVar.f6568c = Math.max(jVar.f6568c, mVar.f7350o);
                        }
                    }
                    f.a().a(jVar.f6569d, jVar.b, jVar);
                    return;
                }
                return;
            }
            int i4 = size - 1;
            while (i2 < size) {
                j jVar2 = (j) arrayList.get(i2);
                if (jVar2.f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE && TextUtils.equals(eVar.f6547r, jVar2.b)) {
                    if (i2 == 0) {
                        int i5 = i2 + 1;
                        if (((j) arrayList.get(i5)).f6568c == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            jVar2.f6568c = d2;
                        } else {
                            jVar2.f6568c = ((j) arrayList.get(i5)).f6568c + 0.1d;
                        }
                    } else if (i2 == i4) {
                        int i6 = i2 - 1;
                        if (((j) arrayList.get(i6)).f6568c - 0.1d <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            jVar2.f6568c = ((j) arrayList.get(i6)).f6568c / 2.0d;
                        } else {
                            jVar2.f6568c = ((j) arrayList.get(i6)).f6568c - 0.1d;
                        }
                    } else {
                        double d3 = ((j) arrayList.get(i2 - 1)).f6568c;
                        double d4 = d3 - 0.1d;
                        double d5 = d3 - ((j) arrayList.get(i2 + 1)).f6568c;
                        if (Math.abs(d5) <= 0.1d) {
                            d4 = d3 - (d5 / 2.0d);
                        }
                        jVar2.f6568c = d4;
                    }
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        m mVar3 = (m) it2.next();
                        if (TextUtils.equals(jVar2.b, mVar3.f7346k) && mVar3.isSuccessWithUseType()) {
                            m mVar4 = eVar.f6546q;
                            if (mVar4 == null || !TextUtils.equals(mVar4.f7342g, jVar2.f6569d)) {
                                eVar.f6546q = mVar3;
                            }
                            jVar2.f6568c = Math.max(jVar2.f6568c, mVar3.f7350o);
                        }
                    }
                    f.a().a(jVar2.f6569d, jVar2.b, jVar2);
                }
                i2++;
                d2 = 10000.0d;
            }
        }
    }
}
