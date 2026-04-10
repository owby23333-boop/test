package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends e {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected Map<Integer, Integer> f1655e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected boolean f1656f0;

    protected f(Context context, String str) {
        super(context, str);
        this.f1655e0 = new HashMap();
        this.f1656f0 = false;
    }

    private void d0() {
        if (s()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "抛出成功回调_广告池中广告满足数量直接返回......");
            if (m()) {
                Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前广告池中有广告且满足client bididing的返回条件...给出成功回调...");
                q();
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void A() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.J()) {
            super.A();
        } else {
            d0();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void X() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.J()) {
            super.X();
        } else {
            a0();
            c0();
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[FALL_THROUGH, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:16:0x002f->B:22:?, LOOP_END, SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
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
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a() {
        /*
            r3 = this;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r0 = r3.f1615d
            if (r0 == 0) goto L14
            boolean r0 = r0.J()
            if (r0 == 0) goto L14
            r0 = 0
            r3.f1656f0 = r0
            r3.c0()
            r3.A()
            goto L2f
        L14:
            super.a()
        L17:
            r0 = 13
            r1 = 52
            r2 = 96
            switch(r2) {
                case 94: goto L2f;
                case 95: goto L21;
                case 96: goto L2f;
                default: goto L20;
            }
        L20:
            goto L17
        L21:
            switch(r1) {
                case 55: goto L29;
                case 56: goto L2f;
                case 57: goto L35;
                default: goto L24;
            }
        L24:
            r1 = 55
            r0 = 61
            goto L21
        L29:
            switch(r0) {
                case 60: goto L35;
                case 61: goto L17;
                case 62: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L2f
        L2d:
            goto L2d
        L2f:
            r0 = 49
            switch(r0) {
                case 49: goto L35;
                case 50: goto L2f;
                case 51: goto L2f;
                default: goto L34;
            }
        L34:
            goto L2f
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.a():void");
    }

    protected void a(int i2, int i3, boolean z2) {
        int i4;
        if (i3 < -100) {
            b(i2, z2);
            return;
        }
        if (i3 == -100) {
            i4 = i2 + 1;
        } else {
            if (i3 == 0) {
                for (int i5 = 0; i5 < I(); i5++) {
                    int i6 = i2 + i5 + 1;
                    if (i6 < this.f1625n.size()) {
                        a(i6, z2);
                    }
                }
                return;
            }
            i4 = i(i2);
            if (i4 <= -1) {
                return;
            }
        }
        a(i4, z2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void a(int i2, boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.J()) {
            super.a(i2, z2);
        } else {
            c(i2, z2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void a(Message message) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.J()) {
            super.a(message);
            return;
        }
        b(message);
        while (true) {
            char c2 = 'J';
            char c3 = '7';
            while (true) {
                switch (c2) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c3) {
                            case '^':
                                c2 = 'I';
                                c3 = '`';
                                break;
                            case '_':
                            case '`':
                                break;
                            default:
                                if (c3 == '8' || c3 == '9') {
                                }
                                c2 = 'I';
                                c3 = '`';
                                break;
                        }
                        break;
                    case 'J':
                        if (c3 == '8') {
                        }
                        break;
                    default:
                        c2 = 'H';
                        break;
                }
                return;
            }
        }
    }

    protected void a0() {
        for (int i2 = 0; i2 < this.f1625n.size(); i2++) {
            this.f1655e0.put(this.f1625n.get(i2), 0);
        }
    }

    protected void b(int i2, boolean z2) {
        int iJ = j(i2);
        if (iJ > -1) {
            a(iJ, z2);
            return;
        }
        if (!b0() || this.f1656f0) {
            return;
        }
        this.f1656f0 = true;
        int iH = h(i2);
        if (iH > 0) {
            if (this.f1625n.get(iH).intValue() <= 0) {
                if (this.f1625n.get(iH).intValue() != 0 && v()) {
                    return;
                }
                a(iH, z2);
                return;
            }
            for (int i3 = 0; i3 < I(); i3++) {
                int i4 = iH + i3;
                if (i4 < this.f1625n.size()) {
                    a(i4, z2);
                }
            }
        }
    }

    protected void b(Message message) {
        StringBuilder sb;
        List<TTBaseAd> list;
        int i2;
        List<TTBaseAd> list2;
        List<TTBaseAd> list3;
        int i3 = message.what;
        if (i3 == 1) {
            if (message.arg1 == 10003) {
                int iIntValue = ((Integer) message.obj).intValue();
                this.f1655e0.put(Integer.valueOf(iIntValue), 4);
                if (p() && !x()) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前层超时....server Bidding 的请求还没有返回，继续执行下一层普通层(不一定执行)....mTTCommonAdPoolList.size()=" + this.f1626o.size());
                    int iF = f(iIntValue);
                    if (iF <= -1 || (i2 = i(iF)) <= -1) {
                        return;
                    }
                } else if (s()) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前层超时....广告池已有广告不执行下层....mTTCommonAdPoolList.size()=" + this.f1626o.size());
                    if (!m()) {
                        return;
                    }
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                    sb.append("当前层超时....广告池已有广告不执行下层且满足client bidding的返回条件....mTTCommonAdPoolList.size()=");
                    list = this.f1626o;
                } else {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前层超时....普通广告池没广告尝试执行下层(不一定执行)....mTTCommonAdPoolList.size()=" + this.f1626o.size());
                    int iF2 = f(iIntValue);
                    if (iF2 <= -1 || (i2 = i(iF2)) <= -1) {
                        return;
                    }
                }
                a(i2, false);
                return;
            }
            return;
        }
        if (i3 == 2) {
            M();
            return;
        }
        if (i3 == 3) {
            L();
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return;
            }
            this.f1635x.set(true);
            if (p() && x()) {
                if (s()) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告成功返回且到达ClientBidding的等待时间，广告池中的广告数量满足...直接返回......");
                    q();
                }
                if (this.f1630s.g() || !this.f1630s.f()) {
                    return;
                }
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有广告都已经加载完成....... ");
                List<TTBaseAd> list4 = this.f1628q;
                if ((list4 == null || list4.size() <= 0) && (((list2 = this.f1626o) == null || list2.size() <= 0) && ((list3 = this.f1627p) == null || list3.size() <= 0))) {
                    a(new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    return;
                }
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告返回且到达ClientBidding的等待时间，所有广告都有返回结果...直接返回......");
                q();
            }
            return;
        }
        int iIntValue2 = ((Integer) message.obj).intValue();
        if (this.f1655e0.get(Integer.valueOf(iIntValue2)) != null && this.f1655e0.get(Integer.valueOf(iIntValue2)).intValue() == 1) {
            this.f1655e0.put(Integer.valueOf(iIntValue2), 4);
        }
        if (!r()) {
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前层超时....P层广告池没广告或者数量不达标,尝试执行下层(不一定执行)....mTTPAdPoolList.size()=" + this.f1628q.size());
            int iF3 = f(iIntValue2);
            if (iF3 > -1) {
                b(iF3, false);
                return;
            }
            return;
        }
        sb = new StringBuilder();
        sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
        sb.append("当前层超时....广告池已有P层类型广告不执行下层....mTTPAdPoolList.size()=");
        list = this.f1628q;
        sb.append(list.size());
        Logger.w("TTMediationSDK", sb.toString());
        q();
    }

    public void b(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        AdSlot adSlot;
        int i2;
        if (this.f1618g == null || dVar == null) {
            return;
        }
        b((List<TTBaseAd>) null, adError);
        if (dVar != null && adError != null) {
            a(dVar.d(), dVar.c(), dVar.e(), com.bytedance.msdk.base.a.a(dVar.b(), dVar.h()), adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载失败...........adnName:" + dVar.c() + " ,slotId:" + dVar.d() + ",slotType:" + dVar.a() + ",loadSort:" + dVar.f() + ",showSort:" + dVar.g() + " ，adError:" + adError.toString());
        }
        if (dVar != null && dVar.a() == 0 && a(dVar.d())) {
            return;
        }
        this.f1630s.a(dVar.d());
        this.f1630s.a(dVar.f());
        if (dVar.j() || dVar.i()) {
            this.f1630s.a();
            U();
        }
        if (!dVar.m() || !s() || !m()) {
            if (this.a.get() || this.b.get()) {
                return;
            }
            List<TTBaseAd> list3 = this.f1628q;
            if ((list3 == null || list3.size() <= 0) && (((list = this.f1626o) == null || list.size() <= 0) && ((list2 = this.f1627p) == null || list2.size() <= 0))) {
                if (this.f1630s.g() || !this.f1630s.f() || (adSlot = this.f1619h) == null || TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(adSlot.getTestSlotId()))) {
                }
                a(adError, dVar);
                return;
            }
            if (!this.f1630s.g() && this.f1630s.f() && m()) {
                Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有层级和所有waterfall都已完成直接回调...");
                Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前广告池中有广告且满足client bididing的返回条件...给出成功回调...");
            }
            if (dVar.g() < -100) {
                if (this.f1655e0.get(Integer.valueOf(dVar.g())) != null && this.f1655e0.get(Integer.valueOf(dVar.g())).intValue() != 4) {
                    Handler handler = this.f1618g;
                    if (handler != null) {
                        handler.removeMessages(4, v.a(dVar.g()));
                    }
                    this.f1655e0.put(Integer.valueOf(dVar.g()), 3);
                    int iF = f(dVar.g());
                    if (iF > -1) {
                        Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前level为：" + dVar.g() + "的P层请求失败-----onAdFailed--》 加载下一层-nextIdx=" + iF);
                        b(iF, true);
                    }
                }
            } else if (dVar.k() && this.f1655e0.get(Integer.valueOf(dVar.g())) != null && this.f1655e0.get(Integer.valueOf(dVar.g())).intValue() != 4) {
                Handler handler2 = this.f1618g;
                if (handler2 != null) {
                    handler2.removeMessages(1, v.a(dVar.g()));
                }
                this.f1655e0.put(Integer.valueOf(dVar.g()), 3);
                int iF2 = f(dVar.g());
                if (iF2 > -1 && (i2 = i(iF2)) > -1) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前level为：" + dVar.g() + "的普通层请求失败-----onAdFailed--》 加载下一层-nextIdx=" + i2);
                    a(i2, true);
                }
            }
            if ((this.f1630s.g() || this.f1630s.f()) && m()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有广告都加载失败....");
                adError = new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL));
                a(adError, dVar);
                return;
            }
            return;
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告有返回结果且满足ClientBidding等待时间时广告池中有广告直接返回......");
        q();
    }

    protected boolean b0() {
        for (int i2 = 0; i2 < this.f1625n.size(); i2++) {
            if (this.f1625n.get(i2).intValue() < -100 && (this.f1655e0.get(this.f1625n.get(i2)).intValue() == 0 || this.f1655e0.get(this.f1625n.get(i2)).intValue() == 1)) {
                return false;
            }
        }
        return true;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    protected void c(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public void c(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (this.f1618g == null || dVar == null) {
            return;
        }
        if (dVar != null) {
            a(dVar.d(), dVar.c(), dVar.e(), com.bytedance.msdk.base.a.a(dVar.b(), dVar.h()), 0, AdLoadInfo.AD_LOADED);
        }
        a(list, dVar);
        if (dVar.a() == 0 && !h0.b(list)) {
            String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
            if (a(adNetworkSlotId)) {
                this.f1655e0.put(Integer.valueOf(list.get(0).getShowSort()), 3);
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "返回的普通广告被server Bidding过滤了......slotId:" + adNetworkSlotId);
                return;
            }
        }
        this.f1630s.a(dVar.d());
        if (t()) {
            b(list, dVar);
        }
        c(list);
        e(list);
        if (this.a.get() || this.b.get()) {
            return;
        }
        if (!h0.b(list) && list.get(0).isPAd() && r()) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "P层广告已经成功返回loadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            this.f1655e0.put(Integer.valueOf(list.get(0).getShowSort()), 2);
        } else if (((!p() && !n()) || (p() && x())) && !h0.b(list) && list.get(0).isNormalAd() && s()) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "普通层广告已经成功返回loadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            if (!m()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "满足广告的返回条件...直接返回...");
        } else if (dVar.m() && s() && m()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告返回结果且满足ClientBidding等待时间时广告池中有广告直接返回......");
        } else {
            if (!this.f1630s.f() || !m()) {
                return;
            }
            Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有层级和所有waterfall都已完成直接回调...");
        }
        q();
    }

    protected void c0() {
        if (h0.b(this.f1625n)) {
            return;
        }
        int iIntValue = this.f1625n.get(0).intValue();
        if (iIntValue < -100) {
            for (int i2 = 0; i2 < I(); i2++) {
                if (i2 < this.f1625n.size() && this.f1625n.get(i2).intValue() < -100) {
                    a(i2, false);
                }
            }
            return;
        }
        if (iIntValue == -100 || iIntValue == 0) {
            a(0, false);
            return;
        }
        for (int i3 = 0; i3 < I(); i3++) {
            if (i3 < this.f1625n.size()) {
                a(i3, false);
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x000e, code lost:
    
        continue;
     */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean d(int r4) {
        /*
            r3 = this;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r0 = r3.f1615d
            if (r0 == 0) goto L2c
            boolean r0 = r0.J()
            if (r0 == 0) goto L2c
            boolean r0 = r3.g(r4)
        Le:
            r4 = 49
            switch(r4) {
                case 49: goto L14;
                case 50: goto L14;
                case 51: goto L30;
                default: goto L13;
            }
        L13:
            goto Le
        L14:
            r1 = 52
            r2 = 96
            switch(r2) {
                case 94: goto Le;
                case 95: goto L1c;
                case 96: goto L30;
                default: goto L1b;
            }
        L1b:
            goto L14
        L1c:
            r2 = 49
        L1e:
            switch(r1) {
                case 55: goto L26;
                case 56: goto Le;
                case 57: goto L14;
                default: goto L21;
            }
        L21:
            r1 = 55
            r2 = 61
            goto L1e
        L26:
            switch(r2) {
                case 60: goto L30;
                case 61: goto L14;
                case 62: goto L2a;
                default: goto L29;
            }
        L29:
            goto Le
        L2a:
            goto L2a
        L2c:
            boolean r0 = super.d(r4)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.d(int):boolean");
    }

    protected int f(int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.f1625n.size(); i4++) {
            if (this.f1625n.get(i4).intValue() == i2) {
                i3 = i4;
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean g(int r14) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.g(int):boolean");
    }

    protected int h(int i2) {
        for (int i3 = 0; i3 < this.f1625n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.f1625n.size()) {
                int iIntValue = this.f1625n.get(i4).intValue();
                if (this.f1655e0.get(Integer.valueOf(iIntValue)) != null && this.f1655e0.get(Integer.valueOf(iIntValue)).intValue() == 0) {
                    return i4;
                }
            }
        }
        return -1;
    }

    protected int i(int i2) {
        int iIntValue;
        for (int i3 = 0; i3 < this.f1625n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.f1625n.size() && (iIntValue = this.f1625n.get(i4).intValue()) > 0 && this.f1655e0.get(Integer.valueOf(iIntValue)).intValue() == 0) {
                return i4;
            }
        }
        return -1;
    }

    protected int j(int i2) {
        int iIntValue;
        for (int i3 = 0; i3 < this.f1625n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.f1625n.size() && (iIntValue = this.f1625n.get(i4).intValue()) < -100 && this.f1655e0.get(Integer.valueOf(iIntValue)).intValue() == 0) {
                return i4;
            }
        }
        return -1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.J()) {
            super.onAdFailed(adError, dVar);
        } else {
            b(adError, dVar);
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null && cVar.J()) {
            c(list, dVar);
            while (true) {
                char c2 = '\r';
                char c3 = '4';
                switch (96) {
                    case 95:
                        while (true) {
                            switch (c3) {
                                case '7':
                                    switch (c2) {
                                        case '>':
                                            while (true) {
                                            }
                                            break;
                                    }
                                    break;
                                case '8':
                                    break;
                                case '9':
                                    break;
                                default:
                                    c3 = '7';
                                    c2 = '=';
                                    break;
                            }
                        }
                        break;
                }
                return;
            }
        }
        super.onAdLoaded(list, dVar);
        while (true) {
            switch (49) {
                case 49:
                    return;
            }
        }
    }
}
