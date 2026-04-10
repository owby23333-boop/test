package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    class a implements a.d {
        final /* synthetic */ long a;
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f1564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f1565d;

        a(long j2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar, int[] iArr, d.a aVar) {
            this.a = j2;
            this.b = bVar;
            this.f1564c = iArr;
            this.f1565d = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(g gVar) {
            f fVar = f.this;
            long j2 = this.a;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar = this.b;
            fVar.a(j2, bVar.a, bVar.f1561d, this.f1564c[0], gVar, this.f1565d);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(AdError adError) {
            f.this.a(this.a, this.f1564c[0], adError, this.b.a, this.f1565d);
        }
    }

    class b implements a.d {
        final /* synthetic */ long a;
        final /* synthetic */ AdSlot b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c f1567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f1568d;

        b(long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, d.a aVar) {
            this.a = j2;
            this.b = adSlot;
            this.f1567c = cVar;
            this.f1568d = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(g gVar) {
            f.this.a(this.a, this.b, this.f1567c, 4, gVar, this.f1568d);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(AdError adError) {
            f.this.a(this.a, 4, adError, this.b, this.f1568d);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0072. Please report as an issue. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0088 -> B:32:0x0079). Please report as a decompilation issue!!! */
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
    private java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r6, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L8d
            int r1 = r6.size()
            if (r1 != 0) goto Lb
            goto L8d
        Lb:
            if (r7 == 0) goto L8d
            java.util.List r1 = r7.B()
            if (r1 == 0) goto L6c
            java.util.List r1 = r7.B()
            int r1 = r1.size()
            if (r1 == 0) goto L8d
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r7 = r7.B()
            java.util.Iterator r7 = r7.iterator()
        L2a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L8d
            java.lang.Object r1 = r7.next()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r1 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) r1
            java.util.Iterator r2 = r6.iterator()
        L3a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L2a
            java.lang.Object r3 = r2.next()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r3 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) r3
            if (r1 == 0) goto L3a
            if (r3 == 0) goto L3a
            int r4 = r1.f()
            if (r4 != 0) goto L3a
            java.lang.String r4 = r1.d()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3a
            java.lang.String r4 = r1.d()
            java.lang.String r3 = r3.d()
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L3a
            r0.add(r1)
            goto L2a
        L6c:
            r6 = 69
            r7 = 10
            r1 = 89
            switch(r6) {
                case 69: goto L76;
                case 70: goto L79;
                case 71: goto L81;
                default: goto L75;
            }
        L75:
            goto L6c
        L76:
            switch(r7) {
                case 10: goto L8d;
                case 11: goto L88;
                case 12: goto L83;
                default: goto L79;
            }
        L79:
            switch(r7) {
                case 12: goto L7d;
                case 13: goto L8d;
                case 14: goto L8d;
                default: goto L7c;
            }
        L7c:
            goto L88
        L7d:
            switch(r1) {
                case 37: goto L8d;
                case 38: goto L8d;
                case 39: goto L81;
                default: goto L80;
            }
        L80:
            goto L8d
        L81:
            r1 = 37
        L83:
            r6 = 27
            if (r1 >= r6) goto L88
            goto L8d
        L88:
            r7 = 14
            r1 = -25
            goto L79
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f.a(java.util.List, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, int i2, AdError adError, AdSlot adSlot, d.a aVar) {
        int i3 = (adError == null || adError.code != -1) ? 5 : 4;
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......onFail  result:" + i3);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
        aVar2.f1556e = i3;
        aVar2.f1557f = System.currentTimeMillis() - j2;
        aVar2.f1558g = adError;
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, g gVar, d.a aVar) {
        int i3;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar2;
        j jVarA;
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响返回.............");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (cVar == null || gVar == null || h0.a(gVar.d())) {
            i3 = (gVar == null || h0.a(gVar.c())) ? i2 : 2;
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            aVar2 = null;
        } else {
            List<h> listD = gVar.d();
            aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
            aVar2.f1559h = listD.size();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("winners : {");
            for (h hVar : listD) {
                if (hVar != null && (jVarA = cVar.a(hVar.i())) != null) {
                    j jVarB = jVarA.b();
                    sb.append(" [ AdnName:" + jVarB.e() + ",slotId:" + jVarB.d() + ",loadSort:" + jVarB.p() + ",showSort:" + jVarB.y() + "] ");
                    jVarB.a(hVar);
                    arrayList.add(jVarB);
                }
            }
            sb.append("}");
            if (h0.a(arrayList)) {
                int i4 = h0.a(gVar.c()) ? i2 : 2;
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
                i3 = i4;
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<j> listA = a(gVar.c(), cVar);
                if (listA == null || listA.size() <= 0) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                } else {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(listA);
                    i3 = 1;
                }
                aVar2.a = copyOnWriteArrayList;
            }
        }
        if (gVar != null) {
            String strB = gVar.b();
            if (!TextUtils.isEmpty(strB)) {
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.f1554c = strB;
            }
            if (gVar.e()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.b = true;
            }
            if (!h0.a(gVar.a())) {
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.f1555d = gVar.a();
            }
        }
        if (aVar2 == null) {
            aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
        }
        aVar2.f1556e = i3;
        aVar2.f1557f = jCurrentTimeMillis - j2;
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    public void a(String str, long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, @NonNull d.a aVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c().a(str, new b(j2, adSlot, cVar, aVar));
    }

    /* JADX INFO: Infinite loop detected, blocks: 2, insns: 0 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0093. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d
    public void a(java.util.Map<java.lang.String, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter> r16, android.content.Context r17, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b r18, @androidx.annotation.NonNull bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d.a r19) {
        /*
            r15 = this;
            r4 = r18
            if (r4 == 0) goto L77
            com.bytedance.msdk.api.AdSlot r0 = r4.a
            if (r0 == 0) goto L77
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r0 = r4.f1561d
            if (r0 == 0) goto L77
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r0 = r4.b
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0.a(r0)
            if (r0 == 0) goto L15
            goto L77
        L15:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r0 = r4.f1561d
            java.lang.String r0 = r0.C()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.bytedance.msdk.api.AdSlot r2 = r4.a
            java.lang.String r2 = r2.getAdUnitId()
            java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagSecondLevel(r2)
            r1.append(r2)
            java.lang.String r2 = "开启server bidding网络请求......："
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TTMediationSDK"
            com.bytedance.msdk.adapter.util.Logger.e(r2, r1)
            com.bytedance.msdk.api.AdSlot r1 = r4.a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r7 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c()
            com.bytedance.msdk.api.AdSlot r8 = r4.a
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r9 = r4.b
            java.util.List<com.bytedance.msdk.base.TTBaseAd> r10 = r4.f1560c
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r11 = r4.f1561d
            int r12 = r4.f1562e
            boolean r13 = r4.f1563f
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f$a r14 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f$a
            r0 = 1
            int[] r5 = new int[r0]
            r0 = 0
            r1 = 4
            r5[r0] = r1
            r0 = r14
            r1 = r15
            r4 = r18
            r6 = r19
            r0.<init>(r2, r4, r5, r6)
            r4 = r7
            r5 = r16
            r6 = r17
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L9f
        L77:
            r0 = 0
            r1 = r19
            r1.a(r0)
            r0 = 61
            r1 = 29
            r1 = 61
            r2 = 29
        L85:
            r3 = 84
        L87:
            r4 = 27
            switch(r3) {
                case 84: goto La0;
                case 85: goto L99;
                case 86: goto L8d;
                default: goto L8c;
            }
        L8c:
            goto L85
        L8d:
            switch(r2) {
                case 37: goto L93;
                case 38: goto L9b;
                case 39: goto La0;
                default: goto L90;
            }
        L90:
            r2 = 39
            goto L8d
        L93:
            switch(r1) {
                case 25: goto L85;
                case 26: goto La0;
                case 27: goto L85;
                default: goto L96;
            }
        L96:
            r1 = 27
            goto L93
        L99:
            if (r2 >= r4) goto L9f
        L9b:
            if (r1 <= r0) goto L9f
        L9d:
        L9e:
            goto L9d
        L9f:
            return
        La0:
            r3 = 85
            r2 = 93
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f.a(java.util.Map, android.content.Context, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d$a):void");
    }
}
