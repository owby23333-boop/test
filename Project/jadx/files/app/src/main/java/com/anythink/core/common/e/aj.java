package com.anythink.core.common.e;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class aj {
    public int a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<b> f7179c;

    public final synchronized void a(List<b> list) {
        synchronized (this) {
            this.f7179c = list;
        }
    }

    public final synchronized List<b> b() {
        ArrayList arrayList = null;
        if (this.f7179c == null) {
            return null;
        }
        for (b bVar : this.f7179c) {
            if (bVar.d() <= 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final synchronized void c() {
        if (this.f7179c != null) {
            this.f7179c.clear();
            this.f7179c = null;
        }
    }

    public final boolean d() {
        List<b> list = this.f7179c;
        return list != null && list.size() > 0;
    }

    public final synchronized b a() {
        if (this.f7179c != null) {
            for (b bVar : this.f7179c) {
                if (bVar.d() <= 0) {
                    boolean z2 = true;
                    if (this.f7179c.indexOf(bVar) < this.f7179c.size() - 1) {
                        z2 = false;
                    }
                    bVar.a(z2);
                    return bVar;
                }
            }
        }
        return null;
    }

    public final synchronized void a(b bVar) {
        if (this.f7179c != null && this.f7179c.size() > 0) {
            this.f7179c.remove(bVar);
        }
    }

    public final void a(e eVar) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            this.a = -1;
            this.b = eVar.X();
            if (this.f7179c != null) {
                for (b bVar : this.f7179c) {
                    if (bVar.j()) {
                        ATBaseAdAdapter aTBaseAdAdapterE = bVar.e();
                        aTBaseAdAdapterE.setTrackingInfo(eVar);
                        eVar.g(aTBaseAdAdapterE.getNetworkPlacementId());
                        bVar.b(-1);
                        BaseAd baseAdF = bVar.f();
                        if (baseAdF != null) {
                            baseAdF.setTrackingInfo(eVar.N());
                        }
                        arrayList.add(bVar);
                    }
                }
            }
            this.f7179c = arrayList;
        }
    }
}
