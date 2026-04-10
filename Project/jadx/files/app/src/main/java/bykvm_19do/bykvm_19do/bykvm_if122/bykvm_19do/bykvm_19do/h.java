package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.v2.ad.GMAdTokenCallback;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMPrimeNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private GMNativeAdLoadCallback f1373g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMAdTokenCallback f1374h0;

    class a implements a.c {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a() {
            ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) h.this).L = true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a(GMNativeAd gMNativeAd) {
            h.this.a(gMNativeAd, false);
            h.this.a(gMNativeAd);
        }
    }

    class b implements a.c {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a() {
            ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) h.this).L = true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a(GMNativeAd gMNativeAd) {
            h.this.a(gMNativeAd, false);
        }
    }

    public h(Context context, String str) {
        super(context, str);
    }

    private List<GMNativeAd> a(List<TTBaseAd> list, int i2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<TTBaseAd> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i2) {
            TTBaseAd next = it.next();
            arrayList.add(next);
            if (Logger.isDebug()) {
                Logger.e("TTMediationSDK", "");
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "返回给开发者最终广告：slotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",广告类型：" + com.bytedance.msdk.base.a.a(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            arrayList2.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a(next, this.f1619h, new a()));
            it.remove();
        }
        a(arrayList);
        return arrayList2;
    }

    private void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative) {
        int i2;
        AdSlot adSlot2;
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_feed");
        }
        if (d0()) {
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot3 = this.f1619h;
            if (adSlot3 != null) {
                adSlot3.setAdType(5);
                if (this.f1619h.getAdCount() <= 0) {
                    adSlot2 = this.f1619h;
                    i2 = 1;
                } else {
                    i2 = 3;
                    if (this.f1619h.getAdCount() > 3) {
                        adSlot2 = this.f1619h;
                    }
                    TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f1619h);
                }
                adSlot2.setAdCount(i2);
                TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f1619h);
            }
            this.f1634w = gMAdSlotNative;
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GMNativeAd gMNativeAd) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar;
        TTBaseAd tTBaseAd = gMNativeAd.getTTBaseAd();
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 7 || (tTBaseAd instanceof GMCustomTTBaseAd) || (cVar = this.f1615d) == null || cVar.I()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().b(this.H, this.f1617f, e());
    }

    private void a(String str, List<TTBaseAd> list) {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> listA;
        TTBaseAd tTBaseAd;
        if (b(str, list) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f1619h, false) != 3 || (listA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f1619h)) == null || listA.size() <= 0) {
            return;
        }
        for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : listA) {
            if (eVar != null && (tTBaseAd = eVar.a) != null && !tTBaseAd.isHasShown() && eVar.a.isReady(this.f1617f)) {
                list.add(eVar.a);
                c(eVar.a);
            }
        }
    }

    private boolean b(String str, List<TTBaseAd> list) {
        if (list != null && list.size() > 0) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null && TextUtils.equals(str, tTBaseAd.getAdNetworkSlotId())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e0() {
        List<TTBaseAd> list;
        try {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> listK = K();
            if (listK == null || listK.size() <= 0) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : listK) {
                if (jVar != null) {
                    String strD = jVar.d();
                    if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, strD, e())) {
                        if (jVar.f() == 100) {
                            list = this.f1628q;
                        } else if (jVar.f() == 0) {
                            list = this.f1626o;
                        }
                        a(strD, list);
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1628q, (Comparator<TTBaseAd>) null);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1626o, (Comparator<TTBaseAd>) null);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1627p, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.c());
            Logger.d("TMe", "--==-- sorted ok");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void f(List<TTBaseAd> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<TTBaseAd> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (TTBaseAd tTBaseAd : arrayList) {
            if (tTBaseAd != null && !tTBaseAd.isHasShown() && tTBaseAd.isReady(l())) {
                list.add(tTBaseAd);
            }
        }
    }

    private List<GMNativeAd> f0() {
        AdSlot adSlot = this.f1619h;
        if (adSlot == null) {
            return null;
        }
        int adCount = adSlot.getAdCount();
        f(this.f1628q);
        f(this.f1627p);
        f(this.f1626o);
        e0();
        List<TTBaseAd> listU = u();
        listU.size();
        return a(listU, adCount);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1373g0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        List<GMNativeAd> listF0;
        if (this.f1373g0 == null || (listF0 = f0()) == null || listF0.size() <= 0) {
            return;
        }
        if (Logger.isDebug()) {
            Logger.e("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + listF0.size());
        }
        for (GMNativeAd gMNativeAd : listF0) {
            if (gMNativeAd != null) {
                if (gMNativeAd instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a) {
                    ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a) gMNativeAd).a(true);
                }
                if (gMNativeAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, gMNativeAd.getAdNetworkRitId(), e())) {
                    a(gMNativeAd.getTTBaseAd(), gMNativeAd.getAdNetworkRitId());
                }
            }
        }
        this.f1373g0.onAdLoaded(listF0);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void a(AdError adError) {
        GMAdTokenCallback gMAdTokenCallback;
        super.a(adError);
        if (this.A != 0 || (gMAdTokenCallback = this.f1374h0) == null) {
            return;
        }
        this.A = 2;
        gMAdTokenCallback.onAdTokenLoadedFail(adError);
    }

    public void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative, GMAdTokenCallback gMAdTokenCallback) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null && cVar.I()) {
            this.f1374h0 = gMAdTokenCallback;
            a(adSlot, gMAdSlotNative);
        } else if (gMAdTokenCallback != null) {
            gMAdTokenCallback.onAdTokenLoadedFail(new AdError(AdError.ERROR_COED_NOT_PRIME, AdError.getMessage(AdError.ERROR_COED_NOT_PRIME)));
        }
    }

    public void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        this.f1373g0 = gMNativeAdLoadCallback;
        a(adSlot, gMAdSlotNative);
    }

    public void a(GMNativeAd gMNativeAd, boolean z2) {
        TTBaseAd tTBaseAd = gMNativeAd.getTTBaseAd();
        if (tTBaseAd != null && tTBaseAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, gMNativeAd.getAdNetworkRitId(), e())) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(gMNativeAd.getAdNetworkRitId(), this.f1619h, this.f1629r, z2, this.S, this.f1633v, this.H, this.f1634w);
        }
    }

    public void a(String str, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        AdError adError;
        if (this.A != 1) {
            if (gMNativeAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_COED_NO_TOKEN, AdError.getMessage(AdError.ERROR_COED_NO_TOKEN));
            }
        } else if (this.f1637z) {
            if (gMNativeAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_LOADED, AdError.getMessage(AdError.ERROR_CODE_LOADED));
            }
        } else if (this.M) {
            Logger.e("TTMediationSDK", "调用过销毁方法_destroy()！！！");
            if (gMNativeAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
            }
        } else if (!this.f1630s.g()) {
            this.f1637z = true;
            this.f1373g0 = gMNativeAdLoadCallback;
            c(str);
            return;
        } else if (gMNativeAdLoadCallback == null) {
            return;
        } else {
            adError = new AdError(AdError.AD_REQUEST_TIMEOUT, "Ad load timeout!");
        }
        gMNativeAdLoadCallback.onAdLoadedFail(adError);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void a(List<TTBaseAd> list, AdError adError) {
        ArrayList arrayList;
        super.a(list, adError);
        if (this.f1373g0 instanceof GMPrimeNativeAdLoadCallback) {
            if (h0.a(list)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                Iterator<TTBaseAd> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a(it.next(), this.f1619h, new b()));
                }
            }
            ((GMPrimeNativeAdLoadCallback) this.f1373g0).onSingleAdLoad(arrayList, adError);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMAdTokenCallback gMAdTokenCallback;
        GMNativeAdLoadCallback gMNativeAdLoadCallback = this.f1373g0;
        if (gMNativeAdLoadCallback != null) {
            gMNativeAdLoadCallback.onAdLoadedFail(adError);
        }
        if (this.A != 0 || this.f1637z || (gMAdTokenCallback = this.f1374h0) == null) {
            return;
        }
        this.A = 2;
        gMAdTokenCallback.onAdTokenLoadedFail(adError);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void b(String str) {
        GMAdTokenCallback gMAdTokenCallback;
        super.b(str);
        if (this.A != 0 || (gMAdTokenCallback = this.f1374h0) == null) {
            return;
        }
        this.A = 1;
        gMAdTokenCallback.onAdTokenLoaded(str);
    }
}
