package com.anythink.core.b;

import android.content.Context;
import android.os.SystemClock;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.n;
import com.anythink.core.common.k.s;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d {
    public static final String a = "a";
    private List<ai> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.core.b.b.a f6482c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6483g;

    public a(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.b = Collections.synchronizedList(new ArrayList(this.f6527d.f7086i));
    }

    @Override // com.anythink.core.b.d
    protected final void a(com.anythink.core.b.b.a aVar) {
        this.f6482c = aVar;
        List<ai> list = this.f6527d.f7086i;
        int size = list.size();
        this.f6483g = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            final ai aiVar = list.get(i2);
            ATBaseAdAdapter aTBaseAdAdapterA = com.anythink.core.common.k.i.a(aiVar);
            if (aTBaseAdAdapterA == null) {
                a(false, ATBiddingResult.fail(aiVar.h() + "not exist!"), aiVar, -9, (com.anythink.core.b.c.a) null);
            } else {
                try {
                    com.anythink.core.b.b.b bVar = new com.anythink.core.b.b.b(aTBaseAdAdapterA) { // from class: com.anythink.core.b.a.1
                        private void a(final ATBiddingResult aTBiddingResult, final com.anythink.core.b.c.a aVar2) {
                            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a.this.a(aTBiddingResult.isSuccessWithUseType(), aTBiddingResult, aiVar, aTBiddingResult.isSuccessWithUseType() ? 0 : -1, aVar2);
                                }
                            });
                        }

                        @Override // com.anythink.core.api.ATBiddingListener
                        public final void onC2SBidResult(ATBiddingResult aTBiddingResult) {
                            ATBaseAdAdapter aTBaseAdAdapter = this.f6525c;
                            if (aTBaseAdAdapter != null) {
                                aTBaseAdAdapter.releaseLoadResource();
                            }
                            a(aTBiddingResult, null);
                        }

                        @Override // com.anythink.core.api.ATBiddingListener
                        public final void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
                            ATBaseAdAdapter aTBaseAdAdapter = this.f6525c;
                            if (aTBaseAdAdapter != null) {
                                aTBaseAdAdapter.releaseLoadResource();
                            }
                            a(aTBiddingResult, new com.anythink.core.b.c.a(this.f6525c, baseAd));
                        }
                    };
                    new StringBuilder("start c2s bid request: ").append(aTBaseAdAdapterA.getNetworkName());
                    com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(this.f6527d.a).a(this.f6527d.f7081d);
                    Map<String, Object> mapA = dVarA.a(this.f6527d.f7081d, this.f6527d.f7080c, aiVar);
                    try {
                        double dA = aiVar.a(dVarA);
                        if (dA > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            mapA.put("bid_floor", Double.valueOf(dA * a(aiVar)));
                        }
                    } catch (Throwable th) {
                        String str = "C2S startBidRequest with exception:" + th.getMessage();
                    }
                    com.anythink.core.common.e.e eVarN = this.f6527d.f7096s.N();
                    s.a(eVarN, aiVar, 0, false);
                    com.anythink.core.common.k.g.a(mapA, eVarN);
                    if (this.f6527d.f7098u == 8) {
                        mapA.put(g.k.f6900j, this.f6527d.f7099v < PangleAdapterUtils.CPM_DEFLAUT_VALUE ? "0" : Double.valueOf(this.f6527d.f7099v));
                    }
                    Context contextA = this.f6527d.b != null ? this.f6527d.b.a() : null;
                    if (contextA == null) {
                        contextA = this.f6527d.a;
                    }
                    boolean zInternalStartBiddingRequest = aTBaseAdAdapterA.internalStartBiddingRequest(contextA, mapA, this.f6527d.f7094q, bVar);
                    aVar.a(aiVar, aTBaseAdAdapterA);
                    if (!zInternalStartBiddingRequest) {
                        a(ATBiddingResult.fail("This network don't support head bidding in current TopOn's version."), aiVar);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a(ATBiddingResult.fail(th2.getMessage()), aiVar);
                }
            }
        }
    }

    private void a(ai aiVar, l lVar, long j2, int i2, com.anythink.core.b.c.a aVar) {
        if (lVar.isSuccessWithUseType()) {
            aiVar.a(j2);
            aiVar.a(lVar.currency);
            StringBuilder sb = new StringBuilder("C2S Bidding Success: , AdSoruceId:");
            sb.append(aiVar.t());
            sb.append(", NetworkFirmId:");
            sb.append(aiVar.c());
            sb.append(" | price:");
            sb.append(lVar.getPrice());
            sb.append(" | sortPrice:");
            sb.append(lVar.getSortPrice());
            sb.append(" | currency:");
            sb.append(lVar.currency.toString());
            double dA = a(lVar.getSortPrice(), aiVar);
            if (dA <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                String str = "NetworkName:" + aiVar.d() + ",AdSoruceId:" + aiVar.t() + " c2s price return 0,please check network placement c2s config";
                dA = com.anythink.core.common.k.g.a(aiVar);
            }
            m mVar = new m(true, dA, lVar.token, lVar.winNoticeUrl, lVar.loseNoticeUrl, lVar.displayNoticeUrl, "");
            mVar.f7347l = a(aiVar);
            mVar.setBiddingNotice(lVar.biddingNotice);
            mVar.f7341f = aiVar.n() + System.currentTimeMillis();
            mVar.f7340e = aiVar.n();
            mVar.f7346k = aiVar.t();
            mVar.f7339d = aiVar.c();
            mVar.f7353r = aVar;
            mVar.f7354s = aVar != null;
            com.anythink.core.common.e.a aVar2 = this.f6527d;
            if (aVar2 != null) {
                mVar.b(aVar2.f7080c);
            }
            a(aiVar.c(), mVar, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            a(aiVar, mVar);
            String str2 = g.i.f6860f;
            com.anythink.core.common.e.a aVar3 = this.f6527d;
            n.a(str2, aVar3.f7081d, com.anythink.core.common.k.g.d(String.valueOf(aVar3.f7082e)), aiVar);
            return;
        }
        d.a(aiVar, lVar.errorMsg, j2, i2);
        String str3 = g.i.f6861g;
        com.anythink.core.common.e.a aVar4 = this.f6527d;
        n.a(str3, aVar4.f7081d, com.anythink.core.common.k.g.d(String.valueOf(aVar4.f7082e)), aiVar);
    }

    @Override // com.anythink.core.b.d
    protected final void a(ai aiVar, l lVar, long j2) {
        a(aiVar, lVar, j2, -1, (com.anythink.core.b.c.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z2, ATBiddingResult aTBiddingResult, ai aiVar, int i2, com.anythink.core.b.c.a aVar) {
        boolean z3;
        if (z2) {
            f fVarA = f.a();
            String strT = aiVar.t();
            if (fVarA.f6559e != null) {
                if (fVarA.f6559e.get(strT + "_c2sfirstStatus") == null) {
                    z3 = true;
                    com.anythink.core.common.j.c.a(this.f6527d.f7081d, aiVar, z3, SystemClock.elapsedRealtime() - this.f6483g, this.f6527d);
                } else {
                    z3 = false;
                    com.anythink.core.common.j.c.a(this.f6527d.f7081d, aiVar, z3, SystemClock.elapsedRealtime() - this.f6483g, this.f6527d);
                }
            } else {
                z3 = true;
                com.anythink.core.common.j.c.a(this.f6527d.f7081d, aiVar, z3, SystemClock.elapsedRealtime() - this.f6483g, this.f6527d);
            }
        }
        f fVarA2 = f.a();
        String strT2 = aiVar.t();
        if (fVarA2.f6559e == null) {
            fVarA2.f6559e = new ConcurrentHashMap<>();
        }
        fVarA2.f6559e.put(strT2 + "_c2sfirstStatus", 1);
        if (!this.f6529f.get()) {
            a(aiVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.f6483g, i2, aVar);
            List<ai> listSynchronizedList = Collections.synchronizedList(new ArrayList(1));
            listSynchronizedList.add(aiVar);
            this.b.remove(aiVar);
            if (this.b.size() == 0) {
                this.f6529f.set(true);
            }
            if (this.f6482c != null) {
                if (!z2 ? a(aiVar, aTBiddingResult.errorMsg, -1) : z2) {
                    this.f6482c.a(listSynchronizedList, (List<ai>) null);
                    return;
                }
                this.f6482c.a((List<ai>) null, listSynchronizedList);
            }
            return;
        }
        if (aTBiddingResult != null && aTBiddingResult.biddingNotice != null) {
            aTBiddingResult.biddingNotice.notifyBidLoss("2", PangleAdapterUtils.CPM_DEFLAUT_VALUE, new HashMap(1));
        }
    }

    private synchronized void a(ATBiddingResult aTBiddingResult, ai aiVar) {
        a(false, aTBiddingResult, aiVar, -1, (com.anythink.core.b.c.a) null);
    }

    private static ATBiddingResult a(String str) {
        return ATBiddingResult.fail(str);
    }

    @Override // com.anythink.core.b.d
    public final synchronized void a() {
        if (!this.f6529f.get()) {
            this.f6529f.set(true);
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            for (ai aiVar : this.b) {
                if (a(aiVar, "bid timeout", -3)) {
                    arrayList.add(aiVar);
                } else {
                    a(aiVar, ATBiddingResult.fail("bid timeout!"), SystemClock.elapsedRealtime() - this.f6483g, -3, (com.anythink.core.b.c.a) null);
                    arrayList2.add(aiVar);
                }
            }
            this.b.clear();
            this.f6529f.set(true);
            if (this.f6482c != null) {
                this.f6482c.a(arrayList, arrayList2);
            }
            this.f6482c = null;
        }
    }
}
