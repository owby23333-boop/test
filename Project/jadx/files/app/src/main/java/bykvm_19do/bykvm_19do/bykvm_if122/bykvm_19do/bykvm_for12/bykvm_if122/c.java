package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private long f1548g0;

    protected c(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    static /* synthetic */ void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c r0, com.bytedance.msdk.api.AdError r1, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r2) {
        /*
            super.onAdFailed(r1, r2)
        L3:
            r0 = 93
            r1 = 93
        L7:
            switch(r1) {
                case 92: goto Lf;
                case 93: goto L12;
                case 94: goto Lb;
                default: goto La;
            }
        La:
            goto L3
        Lb:
            r1 = 4
            if (r0 <= r1) goto L3
            return
        Lf:
            switch(r0) {
                case 21: goto L18;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L12;
            }
        L12:
            switch(r0) {
                case 91: goto L18;
                case 92: goto L18;
                case 93: goto L18;
                default: goto L15;
            }
        L15:
            r0 = 91
            goto L12
        L18:
            r1 = 94
            r0 = 75
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c, com.bytedance.msdk.api.AdError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d):void");
    }

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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        /*
            r2 = this;
        L0:
            r0 = 93
            r1 = 93
        L4:
            switch(r1) {
                case 92: goto Lc;
                case 93: goto Lf;
                case 94: goto L8;
                default: goto L7;
            }
        L7:
            goto L0
        L8:
            r1 = 4
            if (r0 <= r1) goto L0
            goto L15
        Lc:
            switch(r0) {
                case 21: goto L15;
                case 22: goto L16;
                case 23: goto L16;
                default: goto Lf;
            }
        Lf:
            switch(r0) {
                case 91: goto L16;
                case 92: goto L15;
                case 93: goto L16;
                default: goto L12;
            }
        L12:
            r0 = 91
            goto Lf
        L15:
            return
        L16:
            r1 = 94
            r0 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c.O():void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                            break;
                    }
                    return;
                }
                if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return;
                    default:
                        c3 = '[';
                        break;
                }
            }
        }
    }

    public void a(AdSlot adSlot, b.f fVar) {
        this.f1548g0 = SystemClock.currentThreadTimeMillis();
        b.d().a(this.f1617f, this.f1548g0);
        this.f1619h = adSlot;
        this.f1634w = AdUtils.covertAdSlot2GMAdSlotBase(this.f1619h);
        this.I = null;
        this.f1643b0 = fVar;
        S();
        while (true) {
            for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
                if (c2 == 'J') {
                    while (true) {
                        char c3 = '7';
                        switch (16) {
                            case 53:
                                while (true) {
                                    switch (c3) {
                                        case 29:
                                            break;
                                        case 30:
                                            break;
                                        case 31:
                                            break;
                                        default:
                                            c3 = 30;
                                            break;
                                    }
                                }
                                break;
                        }
                        return;
                    }
                }
            }
            return;
        }
    }

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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(com.bytedance.msdk.api.AdError r2) {
        /*
            r1 = this;
        L0:
            r2 = 93
            r0 = 93
        L4:
            switch(r0) {
                case 92: goto Lc;
                case 93: goto Lf;
                case 94: goto L8;
                default: goto L7;
            }
        L7:
            goto L0
        L8:
            r0 = 4
            if (r2 <= r0) goto L0
            goto L15
        Lc:
            switch(r2) {
                case 21: goto L15;
                case 22: goto L16;
                case 23: goto L16;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 91: goto L16;
                case 92: goto L15;
                case 93: goto L16;
                default: goto L12;
            }
        L12:
            r2 = 91
            goto Lf
        L15:
            return
        L16:
            r0 = 94
            r2 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c.b(com.bytedance.msdk.api.AdError):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void b(List<j> list) {
        boolean z2;
        TTBaseAd tTBaseAd;
        super.b(list);
        Map<String, List<e>> mapB = b.d().b(this.f1617f);
        if (mapB != null) {
            if (mapB.keySet() == null) {
                while (true) {
                    switch (15) {
                        case 13:
                        case 14:
                        case 15:
                            return;
                    }
                }
            }
            CopyOnWriteArrayList<TTBaseAd> copyOnWriteArrayList = new CopyOnWriteArrayList();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(mapB.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                List<e> list2 = mapB.get((String) it.next());
                if (list2 != null && list2.size() > 0) {
                    for (e eVar : list2) {
                        if (eVar != null && (tTBaseAd = eVar.a) != null && tTBaseAd.isNormalAd()) {
                            copyOnWriteArrayList.add(eVar.a);
                        }
                    }
                }
            }
            if (copyOnWriteArrayList.size() != 0) {
                if (h0.a(list)) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "处理预缓存逻辑......没有胜出的普通广告，普通广告被全部过滤掉了");
                    return;
                }
                for (TTBaseAd tTBaseAd2 : copyOnWriteArrayList) {
                    Iterator<j> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = true;
                            break;
                        }
                        j next = it2.next();
                        if (tTBaseAd2 != null && next != null && tTBaseAd2.getAdNetworkSlotId().equals(next.d())) {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2) {
                        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "处理预缓存逻辑......已经响应的广告: " + tTBaseAd2.getAdNetworkSlotId() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                        copyOnWriteArrayList.remove(tTBaseAd2);
                    }
                }
                for (TTBaseAd tTBaseAd3 : copyOnWriteArrayList) {
                    if (tTBaseAd3 != null) {
                        mapB.remove(tTBaseAd3.getAdNetworkSlotId());
                    }
                }
                while (true) {
                    switch (31) {
                        case 31:
                        case 32:
                        case 33:
                            return;
                    }
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (list == null) {
            return;
        }
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null) {
                b.d().a(this.f1617f, new e(tTBaseAd, dVar, this.f1548g0, this.f1619h));
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        a(this, adError, dVar);
        b.d().a(this.f1617f, dVar.d(), this.f1548g0, adError);
        while (true) {
            char c2 = '\f';
            switch (96) {
                case 95:
                    while (true) {
                        switch (c2) {
                            case '^':
                            case '`':
                                return;
                            case '_':
                                break;
                            default:
                                c2 = '_';
                                break;
                        }
                    }
                    break;
                case 96:
                    return;
            }
        }
    }

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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected boolean t() {
        /*
            r2 = this;
        L0:
            r0 = 93
            r1 = 93
        L4:
            switch(r1) {
                case 92: goto Lc;
                case 93: goto Lf;
                case 94: goto L8;
                default: goto L7;
            }
        L7:
            goto L0
        L8:
            r1 = 4
            if (r0 <= r1) goto L0
            goto L15
        Lc:
            switch(r0) {
                case 21: goto L15;
                case 22: goto L17;
                case 23: goto L17;
                default: goto Lf;
            }
        Lf:
            switch(r0) {
                case 91: goto L17;
                case 92: goto L15;
                case 93: goto L17;
                default: goto L12;
            }
        L12:
            r0 = 91
            goto Lf
        L15:
            r0 = 1
            return r0
        L17:
            r1 = 94
            r0 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c.t():boolean");
    }
}
