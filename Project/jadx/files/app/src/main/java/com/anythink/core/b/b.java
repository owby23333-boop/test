package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.k;
import com.anythink.core.common.k.s;
import com.anythink.core.common.w;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.anythink.core.common.k.a implements k.b {
    public static final String a = "b";
    Map<String, com.anythink.core.common.e.e> b = new ConcurrentHashMap(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f6511c = new Runnable() { // from class: com.anythink.core.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k.a f6513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.core.common.e.a f6517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Integer, d> f6518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f6519k;

    /* JADX INFO: renamed from: com.anythink.core.b.b$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.e a;
        final /* synthetic */ ai b;

        AnonymousClass5(com.anythink.core.common.e.e eVar, ai aiVar) {
            this.a = eVar;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.f6517i.b.f7584e != null) {
                if (this.a != null) {
                    b.this.f6517i.b.f7584e.a(this.a, ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", this.b.z()));
                }
                b.this.b.remove(this.b.t());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.b$6, reason: invalid class name */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.e a;
        final /* synthetic */ ai b;

        AnonymousClass6(com.anythink.core.common.e.e eVar, ai aiVar) {
            this.a = eVar;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.f6517i.b.f7584e != null) {
                com.anythink.core.common.e.e eVar = this.a;
                if (eVar != null) {
                    s.a(eVar, this.b, 0, false);
                    b.this.f6517i.b.f7584e.b(this.a);
                }
                b.this.b.remove(this.b.t());
            }
        }
    }

    public b(com.anythink.core.common.e.a aVar) {
        this.f6517i = aVar;
        this.f6512d = aVar.f7081d;
        this.f6514f = aVar.f7080c;
        this.f6515g = aVar.f7083f;
        List<ai> list = aVar.f7086i;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        Boolean bool = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= size) {
                break;
            }
            ai aiVar = list.get(i2);
            if (aiVar.l() == 1 || aiVar.l() == 3) {
                arrayList.add(aiVar);
                if (!n.a().v() && bool == null) {
                    if (aiVar == null || (aiVar.c() != 66 && aiVar.c() != 6)) {
                        z2 = false;
                    }
                    if (z2) {
                        bool = Boolean.TRUE;
                    }
                }
            } else if (aiVar.l() == 2) {
                arrayList3 = arrayList3 == null ? new ArrayList(size) : arrayList3;
                arrayList3.add(aiVar);
            } else if (aiVar.l() == 5) {
                arrayList4 = arrayList4 == null ? new ArrayList(size) : arrayList4;
                arrayList4.add(aiVar);
            } else if (aiVar.l() == 6) {
                arrayList5 = arrayList5 == null ? new ArrayList(size) : arrayList5;
                arrayList5.add(aiVar);
            } else if (aiVar.l() == 7) {
                arrayList2.add(aiVar);
            }
            i2++;
        }
        this.f6518j = new HashMap(5);
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f6518j.put(1, new c(aVar.a(arrayList, arrayList2, bool)));
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            this.f6518j.put(2, new a(aVar.a(arrayList3)));
        }
        if (arrayList4 != null && arrayList4.size() > 0) {
            this.f6518j.put(5, new h(aVar.b(arrayList4)));
        }
        if (arrayList5 == null || arrayList5.size() <= 0) {
            return;
        }
        this.f6518j.put(6, new g(aVar.c(arrayList5)));
    }

    private void f() {
        this.f6513e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Integer num, List<ai> list, List<ai> list2) {
        a(num, list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        try {
            if (this.f6513e != null) {
                this.f6513e.a(this.f6514f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        long j2 = this.f6517i.f7085h;
        if (j2 <= 0) {
            j2 = com.anythink.expressad.exoplayer.i.a.f9492f;
        }
        n.a().a(this.f6511c, j2);
    }

    private synchronized void e() {
        if (this.f6518j.size() == 0) {
            a();
            n.a().c(this.f6511c);
            if (this.f6513e != null) {
                this.f6513e.b(this.f6514f);
            }
            this.f6513e = null;
        }
    }

    @Override // com.anythink.core.common.k.b
    public final void a(boolean z2) {
        this.f6516h = z2;
    }

    @Override // com.anythink.core.common.k.a
    protected final synchronized void b() {
        Iterator it = new HashMap(this.f6518j).entrySet().iterator();
        while (it.hasNext()) {
            d dVar = (d) ((Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // com.anythink.core.common.k.b
    public final void a(k.a aVar) {
        this.f6513e = aVar;
        super.a(this.f6515g);
        long j2 = this.f6517i.f7085h;
        if (j2 <= 0) {
            j2 = com.anythink.expressad.exoplayer.i.a.f9492f;
        }
        n.a().a(this.f6511c, j2);
        this.f6519k = System.currentTimeMillis();
        for (Map.Entry entry : new HashMap(this.f6518j).entrySet()) {
            final Integer num = (Integer) entry.getKey();
            final d dVar = (d) entry.getValue();
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(b.this.f6516h);
                        dVar.a(new com.anythink.core.b.b.a() { // from class: com.anythink.core.b.b.2.1
                            @Override // com.anythink.core.b.b.a
                            public final void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                                b.a(b.this, aiVar, aTBaseAdAdapter);
                            }

                            @Override // com.anythink.core.b.b.a
                            public final void a(List<ai> list, List<ai> list2) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.this.b(num, list, list2);
                            }
                        });
                    }
                }
            });
        }
    }

    private void b(ai aiVar) {
        com.anythink.core.common.e.e eVar = this.b.get(aiVar.t());
        if (eVar != null) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass6(eVar, aiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Integer num) {
        d dVar = this.f6518j.get(num);
        if (dVar != null && dVar.c()) {
            this.f6518j.remove(num);
            e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:6:0x000a, B:11:0x0015, B:15:0x001f, B:19:0x0044, B:21:0x0059, B:26:0x007f, B:23:0x005f, B:25:0x0073, B:27:0x0083, B:31:0x008b, B:48:0x0115, B:35:0x00c8, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7, B:43:0x00f1, B:45:0x00f8, B:47:0x0109, B:44:0x00f5, B:49:0x0119, B:50:0x011c, B:52:0x0123, B:53:0x012b, B:55:0x013d, B:57:0x0146), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5 A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:6:0x000a, B:11:0x0015, B:15:0x001f, B:19:0x0044, B:21:0x0059, B:26:0x007f, B:23:0x005f, B:25:0x0073, B:27:0x0083, B:31:0x008b, B:48:0x0115, B:35:0x00c8, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7, B:43:0x00f1, B:45:0x00f8, B:47:0x0109, B:44:0x00f5, B:49:0x0119, B:50:0x011c, B:52:0x0123, B:53:0x012b, B:55:0x013d, B:57:0x0146), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0109 A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:6:0x000a, B:11:0x0015, B:15:0x001f, B:19:0x0044, B:21:0x0059, B:26:0x007f, B:23:0x005f, B:25:0x0073, B:27:0x0083, B:31:0x008b, B:48:0x0115, B:35:0x00c8, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7, B:43:0x00f1, B:45:0x00f8, B:47:0x0109, B:44:0x00f5, B:49:0x0119, B:50:0x011c, B:52:0x0123, B:53:0x012b, B:55:0x013d, B:57:0x0146), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0115 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(final java.lang.Integer r18, java.util.List<com.anythink.core.common.e.ai> r19, java.util.List<com.anythink.core.common.e.ai> r20) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.b.a(java.lang.Integer, java.util.List, java.util.List):void");
    }

    private void a(String str, ai aiVar, boolean z2) {
        boolean z3;
        if (aiVar.m() == 2) {
            com.anythink.core.common.e.b bVarA = com.anythink.core.common.a.a().a(str, aiVar);
            m mVarN = aiVar.N();
            if (bVarA != null) {
                try {
                    if (aiVar.aa()) {
                        m mVarN2 = bVarA.e().getUnitGroupInfo().N();
                        if (mVarN2 != null) {
                            j jVarB = f.a().b(mVarN2.f7342g, mVarN2.f7346k);
                            m mVarN3 = aiVar.N();
                            j jVarB2 = mVarN3 != null ? f.a().b(mVarN3.f7342g, mVarN3.f7346k) : null;
                            if (jVarB != null && jVarB2 != null) {
                                f.a().c(mVarN2.f7342g, mVarN2.f7346k);
                            }
                        }
                    } else {
                        z3 = com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(bVarA.e().getUnitGroupInfo());
                    }
                    if (z3) {
                        aiVar.a(aiVar, 2, aiVar.o(), 1);
                        ai unitGroupInfo = bVarA.e().getUnitGroupInfo();
                        m mVarN4 = unitGroupInfo.N();
                        if (mVarN4 != null) {
                            double dA = com.anythink.core.common.k.g.a(aiVar);
                            com.anythink.core.common.e.e eVarA = s.a(this.f6517i.f7080c, this.f6517i.f7081d, "", this.f6517i.f7091n, "", 1, 0, 0, this.f6517i.b != null ? this.f6517i.b.f7586g : null);
                            r rVar = new r();
                            rVar.a = 2;
                            rVar.b = dA;
                            rVar.f7378e = eVarA;
                            rVar.f7376c = aiVar;
                            rVar.f7377d = unitGroupInfo;
                            mVarN4.a(rVar, true);
                        }
                        w.a().a(this.f6517i.f7081d, this.f6517i.f7080c, unitGroupInfo);
                        com.anythink.core.common.a.a().a(str, aiVar.t());
                        return;
                    }
                    try {
                        ai unitGroupInfo2 = bVarA.e().getUnitGroupInfo();
                        double dA2 = com.anythink.core.common.k.g.a(unitGroupInfo2);
                        String str2 = unitGroupInfo2.N() != null ? unitGroupInfo2.N().token : "";
                        if (mVarN != null && !TextUtils.equals(mVarN.token, str2)) {
                            com.anythink.core.common.e.e eVarA2 = s.a(this.f6517i.f7080c, this.f6517i.f7081d, "", this.f6517i.f7091n, "", 1, 0, 0, this.f6517i.b != null ? this.f6517i.b.f7586g : null);
                            r rVar2 = new r();
                            rVar2.b = dA2;
                            rVar2.f7378e = eVarA2;
                            rVar2.f7376c = unitGroupInfo2;
                            rVar2.f7377d = aiVar;
                            if (unitGroupInfo2.aa()) {
                                rVar2.a = 3;
                                mVarN.a(rVar2, true);
                            } else {
                                rVar2.a = 2;
                                mVarN.a(rVar2, true);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    aiVar.a(bVarA.e().getUnitGroupInfo(), 1, aiVar.o(), z2 ? 1 : 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aiVar.l() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            if (this.f6517i.b.f7584e != null) {
                com.anythink.core.common.e.e eVarN = this.f6517i.f7096s.N();
                s.a(eVarN, aiVar, 0, false);
                eVarN.g(aTBaseAdAdapter.getNetworkPlacementId());
                this.b.put(aiVar.t(), eVarN);
                eVarN.d(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                eVarN.a(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                eVarN.b(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                this.f6517i.b.f7584e.a(eVarN);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(ai aiVar) {
        com.anythink.core.common.e.e eVar = this.b.get(aiVar.t());
        if (eVar != null) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(eVar, aiVar));
        }
    }

    static /* synthetic */ void a(b bVar, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aiVar.l() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            if (bVar.f6517i.b.f7584e != null) {
                com.anythink.core.common.e.e eVarN = bVar.f6517i.f7096s.N();
                s.a(eVarN, aiVar, 0, false);
                eVarN.g(aTBaseAdAdapter.getNetworkPlacementId());
                bVar.b.put(aiVar.t(), eVarN);
                eVarN.d(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                eVarN.a(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                eVarN.b(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                bVar.f6517i.b.f7584e.a(eVarN);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
