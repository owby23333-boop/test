package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.e {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected boolean f1639g0;

    class a implements Runnable {
        final /* synthetic */ TTBaseAd a;

        a(TTBaseAd tTBaseAd) {
            this.a = tTBaseAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.a;
            if (tTBaseAd == null || !tTBaseAd.adnHasAdVideoCachedApi() || !this.a.isCacheSuccess() || (d.this.N instanceof GMCustomTTBaseAd)) {
                return;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(d.this.f1617f, this.a.getAdNetworkSlotId()) + "在show时触发了预加载【" + this.a.getAdNetWorkName() + "】, loadSort: " + this.a.getLoadSort() + ", showSort: " + this.a.getShowSort());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b bVarD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
            d dVar = d.this;
            bVarD.b(dVar.H, dVar.f1617f, dVar.e());
        }
    }

    class b implements Runnable {
        final /* synthetic */ TTBaseAd a;
        final /* synthetic */ Activity b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f1640c;

        b(TTBaseAd tTBaseAd, Activity activity, Map map) {
            this.a = tTBaseAd;
            this.b = activity;
            this.f1640c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.a;
            if (tTBaseAd != null) {
                d dVar = d.this;
                dVar.N = tTBaseAd;
                dVar.N.setHasShown(true);
                d dVar2 = d.this;
                dVar2.N.setTTAdatperCallback(dVar2.I);
                d dVar3 = d.this;
                dVar3.N.setTTAdatperRewardPlayAgainCallback(dVar3.J);
                if (d.this.N.canAdReuse()) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a aVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a();
                    d dVar4 = d.this;
                    if (aVarA.c(dVar4.f1617f, dVar4.N.getAdNetworkSlotId(), d.this.e())) {
                        d dVar5 = d.this;
                        TTBaseAd tTBaseAd2 = dVar5.N;
                        dVar5.a(tTBaseAd2, tTBaseAd2.getAdNetworkSlotId());
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(TTLogUtil.getTagThirdLevelByEvent(d.this.f1617f, TTLogUtil.TAG_EVENT_SHOW));
                sb.append("展示的广告类型：");
                sb.append(com.bytedance.msdk.base.a.a(d.this.N.getAdNetworkPlatformId()));
                sb.append(",slotId：");
                sb.append(d.this.N.getAdNetworkSlotId());
                sb.append(",slotType:");
                sb.append(d.this.N.getAdNetworkSlotType());
                sb.append(",isReady()：");
                d dVar6 = d.this;
                sb.append(dVar6.N.isReady(dVar6.f1617f));
                sb.append("，是否为缓存广告:");
                sb.append(d.this.N.isCacheSuccess());
                Logger.d("TTMediationSDK", sb.toString());
                d.this.N.showAd(this.b, this.f1640c);
                m.b().j(d.this.f1617f + "");
                l lVarB = l.b();
                d dVar7 = d.this;
                lVarB.e(dVar7.f1617f, dVar7.N.getAdNetworkSlotId());
                d dVar8 = d.this;
                dVar8.L = true;
                if (dVar8.N != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d.this.N);
                    d.this.a(arrayList);
                }
                d dVar9 = d.this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(dVar9.N, dVar9.f1619h, false);
            }
        }
    }

    public interface c {
        void a();
    }

    protected d(Context context, String str) {
        super(context, str);
        this.f1639g0 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        a(r12, r20, r21);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r17, java.util.List<com.bytedance.msdk.base.TTBaseAd> r18, boolean r19, android.app.Activity r20, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r21) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.a(java.util.List, java.util.List, boolean, android.app.Activity, java.util.Map):boolean");
    }

    private boolean i0() {
        boolean zE = z.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        boolean zF = z.f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "setting 下发是否为弱网执行：" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().J() + "，当前网络环境：2G-type=" + zE + ",3G-type=" + zF);
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().J() && (zE || zF);
    }

    protected void a(Activity activity, c cVar) {
        List<j> listK;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> listA;
        TTBaseAd tTBaseAd;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.f1619h, cVar2 != null ? cVar2.C() : null);
        if (this.L || this.b.get()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((List<TTBaseAd>) null, this.f1619h);
            if (cVar == null) {
                return;
            }
        } else {
            List<TTBaseAd> listU = u();
            try {
                listK = K();
            } catch (Throwable th) {
                th.printStackTrace();
                listK = null;
            }
            if (listK != null && listK.size() > 0) {
                HashMap<String, TTBaseAd> mapD = d(listU);
                for (j jVar : listK) {
                    if (jVar != null) {
                        String strD = jVar.d();
                        TTBaseAd tTBaseAd2 = mapD.get(strD);
                        if (tTBaseAd2 != null && tTBaseAd2.isReady(this.f1617f) && !tTBaseAd2.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd2.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady(this.f1617f));
                            a(tTBaseAd2, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                            return;
                        }
                        if (jVar.a() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, strD, e()) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(strD, this.f1619h, false) == 3 && (listA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(strD, this.f1619h)) != null && listA.size() > 0 && (tTBaseAd = listA.get(0).a) != null && tTBaseAd.isReady(this.f1617f) && !tTBaseAd.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady(this.f1617f));
                            c(tTBaseAd);
                            a(tTBaseAd, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                            return;
                        }
                    }
                }
            }
            if (listU != null && listU.size() > 0) {
                for (TTBaseAd tTBaseAd3 : listU) {
                    if (tTBaseAd3 != null && tTBaseAd3.isReady(this.f1617f) && !tTBaseAd3.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd3.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd3.isReady(this.f1617f));
                        a(tTBaseAd3, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(listU, this.f1619h);
            if (cVar == null) {
                return;
            }
        }
        cVar.a();
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b A[LOOP:3: B:63:0x013b->B:110:0x013b, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0146 -> B:72:0x014e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.Activity r10, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r11, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c r12) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.a(android.app.Activity, java.util.Map, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d$c):void");
    }

    public void a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ThreadHelper.runOnUiThread(new b(tTBaseAd, activity, map));
        while (true) {
            switch (54) {
                case 52:
                case 53:
                case 54:
                    return;
            }
        }
    }

    public void a(boolean z2) {
        this.f1639g0 = z2;
    }

    protected void b(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, c cVar) {
        a(activity, map, cVar);
    }

    public void d(TTBaseAd tTBaseAd) {
        ThreadHelper.runOnUiThread(new a(tTBaseAd));
    }

    public void e0() {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (this.N.getAdType() == 10 || this.N.getAdType() == 8 || this.N.getAdType() == 7) {
            if (this.N.adnHasAdVideoCachedApi() && this.N.isCacheSuccess() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f1617f, e()) != 0) {
                z4 = false;
            }
            if (this.N.getAdNetworkPlatformId() == 4) {
                z3 = false;
                if (this.N.canAdReuse() || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, this.N.getAdNetworkSlotId(), e())) {
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.N.getAdNetworkSlotId(), this.f1619h, this.f1629r, z3, this.S, this.f1633v, this.H, this.f1634w);
                return;
            }
            z2 = z4;
        } else {
            z2 = true;
        }
        z3 = z2;
        if (this.N.canAdReuse()) {
        }
    }

    public boolean f0() {
        return this.f1639g0;
    }

    public boolean g0() {
        List<j> listK;
        try {
            listK = K();
        } catch (Throwable th) {
            th.printStackTrace();
            listK = null;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        return p.a(this.f1628q, this.f1627p, this.f1626o, this.f1619h, this.L, this.b, this.f1617f, e(), listK, cVar != null ? cVar.C() : null);
    }

    public void h0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 4) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.H, this.f1617f, e());
    }
}
