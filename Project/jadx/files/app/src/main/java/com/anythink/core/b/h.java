package com.anythink.core.b;

import android.os.SystemClock;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {
    private String a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.core.b.b.a f6563c;

    public h(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.a = "IH Bidding";
    }

    private static void b(ai aiVar, String str, long j2, int i2) {
        d.a(aiVar, str, j2, i2);
    }

    @Override // com.anythink.core.b.d
    protected final void a(ai aiVar, l lVar, long j2) {
    }

    private void b(ai aiVar) {
        m mVar = new m(true, aiVar.x(), aiVar.y(), "", "", "", "");
        mVar.f7341f = aiVar.n() + System.currentTimeMillis();
        mVar.f7340e = aiVar.n();
        com.anythink.core.common.e.a aVar = this.f6527d;
        if (aVar != null) {
            mVar.b(aVar.f7080c);
        }
        a(aiVar, mVar);
    }

    @Override // com.anythink.core.b.d
    protected final void a(final com.anythink.core.b.b.a aVar) {
        this.f6563c = aVar;
        this.b = SystemClock.elapsedRealtime();
        List<ai> list = this.f6527d.f7086i;
        if (this.f6528e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Start IH Bidding List", d.a(list));
            } catch (Exception unused) {
            }
            n.a(n.a, jSONObject.toString(), false);
        }
        if (f.a().b() == null) {
            Iterator<ai> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ATBaseAdAdapter aTBaseAdAdapterA = com.anythink.core.common.k.i.a(it.next());
                if (aTBaseAdAdapterA != null) {
                    MediationBidManager bidManager = aTBaseAdAdapterA.getBidManager();
                    if (bidManager != null) {
                        f.a().a(bidManager);
                    }
                }
            }
        }
        MediationBidManager mediationBidManagerB = f.a().b();
        if (mediationBidManagerB == null) {
            a((List<ai>) null, -9);
        } else {
            mediationBidManagerB.setBidRequestUrl(this.f6527d.f7092o);
            mediationBidManagerB.startBid(this.f6527d, new MediationBidManager.BidListener() { // from class: com.anythink.core.b.h.1
                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidFail(String str) {
                }

                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidStart(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                    com.anythink.core.b.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(aiVar, aTBaseAdAdapter);
                    }
                }

                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidSuccess(List<ai> list2) {
                    h.this.a(list2, -1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<ai> list, int i2) {
        if (this.f6529f.get()) {
            return;
        }
        this.f6529f.set(true);
        List<ai> arrayList = list == null ? new ArrayList<>() : list;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator<ai> it = this.f6527d.f7086i.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            ai next = it.next();
            Iterator<ai> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ai next2 = it2.next();
                if (next.t().equals(next2.t())) {
                    next2.a(jElapsedRealtime);
                    next2.g(0);
                    m mVar = new m(true, next2.x(), next2.y(), "", "", "", "");
                    mVar.f7341f = next2.n() + System.currentTimeMillis();
                    mVar.f7340e = next2.n();
                    if (this.f6527d != null) {
                        mVar.b(this.f6527d.f7080c);
                    }
                    a(next2, mVar);
                    z2 = true;
                }
            }
            if (!z2) {
                if (MediationBidManager.NO_BID_TOKEN_ERROR.equals(next.z())) {
                    b(next, "No Bid Info.", 0L, -2);
                } else {
                    b(next, "No Bid Info.", jElapsedRealtime, i2);
                }
                if (a(next, "No Bid Info.", i2)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        if (this.f6528e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("IH Bidding Success List", d.a(arrayList));
                jSONObject.put("IH Bidding Fail List", d.a(arrayList2));
            } catch (Exception unused) {
            }
            n.a(this.a, jSONObject.toString(), false);
        }
        this.f6529f.set(true);
        if (this.f6563c != null) {
            this.f6563c.a(arrayList, arrayList2);
        }
    }

    @Override // com.anythink.core.b.d
    protected final void a() {
        a((List<ai>) null, -3);
    }
}
