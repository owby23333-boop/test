package com.bytedance.msdk.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.i0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.base.a;
import com.bytedance.msdk.base.b;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTAbsAdLoaderAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdapterLoaderListener f13920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j f13921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f13925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f13926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f13927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f13930m;
    protected AdSlot mAdSlot;
    protected GMAdSlotBase mGMAdSlotBase;
    protected i mTTExtraModel;
    protected String mWaterfallAbTestParam;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f13931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private h f13933p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13934q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13935r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f13936s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f13937t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13938u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13939v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13940w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13941x;
    private boolean a = false;
    private boolean b = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile long f13942y = -1;

    public interface AdapterLoaderListener {
        void onAdFailed(AdError adError, d dVar);

        void onAdLoaded(TTBaseAd tTBaseAd, d dVar);

        void onAdLoaded(List<TTBaseAd> list, d dVar);

        void onAdVideoCache();
    }

    private class CallBackRunnable implements Runnable {
        private String a;
        private TTBaseAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<TTBaseAd> f13944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private AdError f13945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f13946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f13947f;

        CallBackRunnable(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError, String str2, boolean z2) {
            this.a = str;
            this.b = tTBaseAd;
            this.f13944c = list;
            this.f13945d = adError;
            this.f13946e = str2;
            this.f13947f = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd;
            String str;
            String levelTag;
            StringBuilder sb;
            String str2;
            if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                d dVar = new d();
                dVar.a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType()).e(TTAbsAdLoaderAdapter.this.f13938u).b(TTAbsAdLoaderAdapter.this.f13935r).c(TTAbsAdLoaderAdapter.this.f13923f).d(TTAbsAdLoaderAdapter.this.f13924g).a(TTAbsAdLoaderAdapter.this.getAdNetWorkName()).c(TTAbsAdLoaderAdapter.this.getCustomAdNetWorkName()).b(TTAbsAdLoaderAdapter.this.f13936s);
                TTBaseAd tTBaseAd2 = null;
                if ("adload_ads".equals(this.a) || "adload_ad".equals(this.a)) {
                    boolean zEquals = "adload_ads".equals(this.a);
                    int i2 = AdError.ERROR_CODE_NO_AD;
                    if (zEquals) {
                        List<TTBaseAd> list = this.f13944c;
                        int size = list != null ? list.size() : 0;
                        List<TTBaseAd> list2 = this.f13944c;
                        if (list2 != null && list2.size() > 0) {
                            i2 = 20000;
                        }
                        for (TTBaseAd tTBaseAd3 : this.f13944c) {
                            if (tTBaseAd3 != null) {
                                TTAbsAdLoaderAdapter.this.b(tTBaseAd3);
                                if (tTBaseAd2 == null) {
                                    tTBaseAd2 = tTBaseAd3;
                                }
                            }
                        }
                        if (TTAbsAdLoaderAdapter.this.isClientBidding() || TTAbsAdLoaderAdapter.this.isMultiBidding() || TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            for (TTBaseAd tTBaseAd4 : this.f13944c) {
                                if (tTBaseAd4 != null) {
                                    TTAbsAdLoaderAdapter.this.a(i2, tTBaseAd4, 1, this.f13946e);
                                }
                            }
                        } else {
                            TTAbsAdLoaderAdapter.this.a(i2, tTBaseAd2, size, this.f13946e);
                        }
                        if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                            TTAbsAdLoaderAdapter.this.f13920c.onAdLoaded(this.f13944c, dVar);
                        }
                        if (!TTAbsAdLoaderAdapter.this.isServerBidding() || h0.b(this.f13944c)) {
                            return;
                        } else {
                            tTBaseAd = this.f13944c.get(0);
                        }
                    } else {
                        if (this.b != null) {
                            i2 = 20000;
                        }
                        TTAbsAdLoaderAdapter.this.b(this.b);
                        TTAbsAdLoaderAdapter.this.a(i2, this.b, 1, this.f13946e);
                        if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                            TTAbsAdLoaderAdapter.this.f13920c.onAdLoaded(this.b, dVar);
                        }
                        if (!TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            return;
                        } else {
                            tTBaseAd = this.b;
                        }
                    }
                    TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = TTAbsAdLoaderAdapter.this;
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, tTAbsAdLoaderAdapter.mAdSlot, tTAbsAdLoaderAdapter.f13921d, TTAbsAdLoaderAdapter.this.f13929l);
                    return;
                }
                if (!"failed".equals(this.a)) {
                    if ("ad_video_cache".equals(this.a)) {
                        if (this.b == null || !(TTAbsAdLoaderAdapter.this.f13939v == 10 || TTAbsAdLoaderAdapter.this.f13939v == 8 || TTAbsAdLoaderAdapter.this.f13939v == 7)) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f13922e, TTLogUtil.TAG_EVENT_FILL) + "onAdVideoCache-----ttAd=" + this.b);
                            return;
                        }
                        TTAbsAdLoaderAdapter.this.b(this.b);
                        AdError adError = this.f13945d;
                        if (adError != null && adError.code == 30010 && TTAbsAdLoaderAdapter.this.a()) {
                            ThreadHelper.postDelayOnMSDKThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.CallBackRunnable.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    CallBackRunnable.this.b.setCacheSuccess(true);
                                    CallBackRunnable callBackRunnable = CallBackRunnable.this;
                                    TTAbsAdLoaderAdapter.this.a(callBackRunnable.b);
                                    if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                        TTBaseAd tTBaseAd5 = CallBackRunnable.this.b;
                                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd5, tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.f13921d);
                                    }
                                    if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                                        TTAbsAdLoaderAdapter.this.f13920c.onAdVideoCache();
                                    }
                                }
                            }, 1000L);
                            return;
                        }
                        this.b.setCacheSuccess(true);
                        TTAbsAdLoaderAdapter.this.a(this.b);
                        if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            TTBaseAd tTBaseAd5 = this.b;
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd5, tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.f13921d);
                        }
                        if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                            TTAbsAdLoaderAdapter.this.f13920c.onAdVideoCache();
                            return;
                        }
                        return;
                    }
                    return;
                }
                TTBaseAd tTBaseAd6 = this.b;
                if (tTBaseAd6 != null) {
                    String strValueOf = String.valueOf(tTBaseAd6.getCpm());
                    levelTag = this.b.getLevelTag();
                    str = strValueOf;
                } else {
                    str = null;
                    levelTag = null;
                }
                if (TTAbsAdLoaderAdapter.this.f13935r == 2 || !this.f13947f) {
                    AdError adError2 = this.f13945d;
                    TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter3 = TTAbsAdLoaderAdapter.this;
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adError2, tTAbsAdLoaderAdapter3.mAdSlot, tTAbsAdLoaderAdapter3.f13921d, TTAbsAdLoaderAdapter.this.f13930m, TTAbsAdLoaderAdapter.this.f13931n, TTAbsAdLoaderAdapter.this.f13932o, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f13929l);
                } else {
                    AdError adError3 = this.f13945d;
                    TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter4 = TTAbsAdLoaderAdapter.this;
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adError3, tTAbsAdLoaderAdapter4.mAdSlot, tTAbsAdLoaderAdapter4.f13921d, TTAbsAdLoaderAdapter.this.f13930m, TTAbsAdLoaderAdapter.this.f13931n, TTAbsAdLoaderAdapter.this.f13932o, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f13929l, str, levelTag, this.f13946e);
                }
                if (this.f13945d != null) {
                    if (b.f14440c) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f13922e, TTLogUtil.TAG_EVENT_FILL_FAIL));
                        sb.append("AdNetWorkName[");
                        sb.append(TTAbsAdLoaderAdapter.this.getAllAdNetWorkName());
                        sb.append("] AdUnitId[");
                        sb.append(TTAbsAdLoaderAdapter.this.f13936s);
                        sb.append("] AdType[");
                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter5 = TTAbsAdLoaderAdapter.this;
                        sb.append(tTAbsAdLoaderAdapter5.a(tTAbsAdLoaderAdapter5.mAdSlot, tTAbsAdLoaderAdapter5.getAdNetWorkName(), a.a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.f13938u, TTAbsAdLoaderAdapter.this.f13921d, TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                        sb.append("] 请求失败 (loadSort=");
                        sb.append(TTAbsAdLoaderAdapter.this.f13923f);
                        sb.append(",showSort=");
                        sb.append(TTAbsAdLoaderAdapter.this.f13924g);
                        str2 = "),error=";
                    } else {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f13922e, TTLogUtil.TAG_EVENT_FILL_FAIL));
                        sb.append("AdNetWorkName[");
                        sb.append(TTAbsAdLoaderAdapter.this.getAllAdNetWorkName());
                        sb.append("] AdType[");
                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter6 = TTAbsAdLoaderAdapter.this;
                        sb.append(tTAbsAdLoaderAdapter6.a(tTAbsAdLoaderAdapter6.mAdSlot, tTAbsAdLoaderAdapter6.getAdNetWorkName(), a.a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.f13938u, TTAbsAdLoaderAdapter.this.f13921d, TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                        str2 = "] 请求失败 error=";
                    }
                    sb.append(str2);
                    sb.append(this.f13945d.thirdSdkErrorCode);
                    sb.append(",msg=");
                    sb.append(this.f13945d.thirdSdkErrorMessage);
                    Logger.e("TTMediationSDK", sb.toString());
                    if (TTAbsAdLoaderAdapter.this.f13921d != null) {
                        String str3 = this.f13945d.thirdSdkErrorCode + "";
                        String strA = TTAbsAdLoaderAdapter.this.a(this.f13945d.thirdSdkErrorMessage);
                        Logger.e("TTMediationSDK", "errorCode = " + str3 + " errorCodeList = " + strA);
                        c cVarA = c.a();
                        String strE = TTAbsAdLoaderAdapter.this.f13921d.e();
                        String strD = TTAbsAdLoaderAdapter.this.f13921d.d();
                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter7 = TTAbsAdLoaderAdapter.this;
                        cVarA.a(strE, strD, tTAbsAdLoaderAdapter7.a(tTAbsAdLoaderAdapter7.f13921d.e(), str3, strA));
                    }
                }
                if (TTAbsAdLoaderAdapter.this.f13920c != null) {
                    TTAbsAdLoaderAdapter.this.f13920c.onAdFailed(this.f13945d, dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(AdSlot adSlot, String str, String str2) {
        return adSlot == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        r7 = new java.lang.StringBuilder();
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r0.hasNext() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        r7.append((java.lang.String) r0.next());
        r7.append("_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        if (r7.length() <= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        r7.delete(r7.length() - 1, r7.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
    
        return r7.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto Lf
            java.lang.String r7 = ""
            goto L90
        Lf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char[] r7 = r7.toCharArray()
            r2 = 0
            r3 = 0
        L1a:
            int r4 = r7.length
            if (r3 >= r4) goto L5b
            char r4 = r7[r3]
            r5 = 48
            if (r4 < r5) goto L37
            r5 = 57
            if (r4 > r5) goto L37
            r1.append(r4)
            int r4 = r7.length
            int r4 = r4 + (-1)
            if (r3 != r4) goto L4b
            java.lang.String r7 = r1.toString()
            r0.add(r7)
            goto L5b
        L37:
            int r4 = r1.length()
            if (r4 <= 0) goto L4b
            java.lang.String r4 = r1.toString()
            r0.add(r4)
            int r4 = r1.length()
            r1.delete(r2, r4)
        L4b:
            int r4 = r0.size()
            if (r4 <= 0) goto L58
            java.lang.Object r7 = r0.get(r2)
            java.lang.String r7 = (java.lang.String) r7
            goto L90
        L58:
            int r3 = r3 + 1
            goto L1a
        L5b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.Iterator r0 = r0.iterator()
        L64:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L79
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r7.append(r1)
            java.lang.String r1 = "_"
            r7.append(r1)
            goto L64
        L79:
            int r0 = r7.length()
            if (r0 <= 0) goto L8c
            int r0 = r7.length()
            int r0 = r0 + (-1)
            int r1 = r7.length()
            r7.delete(r0, r1)
        L8c:
            java.lang.String r7 = r7.toString()
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.a(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || !str.equals("gdt")) {
            return str2;
        }
        return str2 + "_" + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, TTBaseAd tTBaseAd, int i3, String str) {
        StringBuilder sb;
        String str2;
        String str3 = i2 == 20000 ? AdError.AD_LOAD_SUCCESS_MSG : AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG;
        boolean z2 = this.f13937t;
        if (this.f13935r != 2 && tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, i2, str3, this.f13929l, this.mAdSlot, this.f13930m, i3, z2 ? 1 : 0, str, this.f13942y != -1 ? SystemClock.elapsedRealtime() - this.f13942y : -1L);
        }
        if (b.f14440c) {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f13922e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdUnitId[");
            sb.append(this.f13936s);
            sb.append("] AdType[");
            sb.append(a(this.mAdSlot, getAdNetWorkName(), a.a(this.mAdSlot.getAdType(), this.f13938u, this.f13921d, this.mAdSlot.getAdStyleType())));
            sb.append("] 请求成功 (loadSort=");
            sb.append(this.f13923f);
            sb.append(",showSort=");
            sb.append(this.f13924g);
            str2 = ad.f20406s;
        } else {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f13922e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdType[");
            sb.append(a(this.mAdSlot, getAdNetWorkName(), a.a(this.mAdSlot.getAdType(), this.f13938u, this.f13921d, this.mAdSlot.getAdStyleType())));
            str2 = "] 请求成功";
        }
        sb.append(str2);
        Logger.i("TTMediationSDK", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTBaseAd tTBaseAd) {
        StringBuilder sb;
        String str;
        if (this.f13935r != 2 && tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.mAdSlot, tTBaseAd, this.f13921d);
        }
        if (b.f14440c) {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f13922e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdUnitId[");
            sb.append(this.f13936s);
            sb.append("] AdType[");
            sb.append(a.a(this.mAdSlot.getAdType(), this.f13938u, this.f13921d, this.mAdSlot.getAdStyleType()));
            sb.append("] 视频缓存成功 (loadSort=");
            sb.append(this.f13923f);
            sb.append(",showSort=");
            sb.append(this.f13924g);
            str = ad.f20406s;
        } else {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f13922e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdType[");
            sb.append(a.a(this.mAdSlot.getAdType(), this.f13938u, this.f13921d, this.mAdSlot.getAdStyleType()));
            str = "] 视频缓存成功 ";
        }
        sb.append(str);
        Logger.i("TTMediationSDK", sb.toString());
    }

    private final void a(TTBaseAd tTBaseAd, AdError adError, boolean z2) {
        this.b = true;
        if (this.a) {
            return;
        }
        this.a = true;
        this.f13929l = System.currentTimeMillis() - this.f13928k;
        a("failed", tTBaseAd, (List<TTBaseAd>) null, adError, z2);
    }

    private void a(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError, boolean z2) {
        ThreadHelper.runOnMSDKThread(new CallBackRunnable(str, tTBaseAd, list, adError, u.a(this.f13921d) ? u.b(Thread.currentThread().getStackTrace()) : null, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().J() && (z.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) || z.f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TTBaseAd tTBaseAd) {
        j jVar;
        if (tTBaseAd == null) {
            return;
        }
        int i2 = this.f13935r;
        if (i2 == 0 || i2 == 100) {
            double d2 = this.f13925h;
            if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                tTBaseAd.setCpm(d2);
            }
        }
        if (isServerBidding() && (jVar = this.f13921d) != null) {
            tTBaseAd.setServerBiddingShowCpm(jVar.w());
            tTBaseAd.setServerBiddingLoadCpm(this.f13921d.v());
            if (this.f13921d.x() != null) {
                tTBaseAd.setAid(this.f13921d.x().c());
                tTBaseAd.setAdExtra(this.f13921d.x().a());
                tTBaseAd.setWinCallback(this.f13921d.x().j());
                tTBaseAd.setFailCallback(this.f13921d.x().e());
                tTBaseAd.setPricingType(this.f13921d.x().h());
            }
        }
        tTBaseAd.setAdNetworkSlotType(this.f13935r);
        tTBaseAd.setLoadSort(this.f13923f);
        tTBaseAd.setShowSort(this.f13924g);
        tTBaseAd.setSdkVersion(getSdkVersion());
        j jVar2 = this.f13921d;
        tTBaseAd.setAdNetWorkName(jVar2 != null ? jVar2.e() : getAdNetWorkName());
        j jVar3 = this.f13921d;
        tTBaseAd.setCustomAdNetWorkName(jVar3 != null ? jVar3.h() : null);
        tTBaseAd.setExchangeRate(this.f13927j);
        tTBaseAd.setAdNetworkSlotId(this.f13936s);
        tTBaseAd.setRit(this.f13922e);
        tTBaseAd.putEventParam("waterfall_abtest", this.mWaterfallAbTestParam);
        tTBaseAd.setSdkNum(a.a(getAdNetWorkName()));
        tTBaseAd.setMediationRitReqTypeFromRealReq(this.f13931n);
        tTBaseAd.setMediationRitReqTypeSrcFromRealReq(this.f13932o);
        tTBaseAd.setLinkIdFromRealReq(this.f13926i);
        tTBaseAd.setMediationRitReqType(this.f13931n);
        tTBaseAd.setMediationRitReqTypeSrc(this.f13932o);
        j jVar4 = this.f13921d;
        tTBaseAd.setOriginType(jVar4 != null ? jVar4.s() : -1);
        tTBaseAd.setSubAdType(this.f13938u);
        tTBaseAd.setAdType(this.f13939v);
        i0.a(tTBaseAd, this.f13921d, this.mAdSlot, false);
        i iVar = this.mTTExtraModel;
        if (iVar != null) {
            int i3 = iVar.b;
            if (i3 != 1) {
                i3 = 0;
            }
            tTBaseAd.putEventParam("if_test", Integer.valueOf(i3));
            tTBaseAd.putEventParam("server_bidding_extra", this.mTTExtraModel.a);
        }
        h hVar = this.f13933p;
        if (hVar == null || hVar.d() == null) {
            return;
        }
        tTBaseAd.putExtraMsg("extra_data_and_no_parse", this.f13933p.d());
    }

    public abstract void destroy();

    public final int getAdLoadCount() {
        return this.f13934q;
    }

    public abstract String getAdNetWorkName();

    public final String getAdSlotId() {
        return this.f13936s;
    }

    public String getAdapterRit() {
        return this.f13922e;
    }

    public final String getAdm() {
        h hVar;
        if (isServerBidding() && (hVar = this.f13933p) != null) {
            return hVar.b();
        }
        return null;
    }

    public String getAllAdNetWorkName() {
        if (this.f13921d == null || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(this.f13921d.e())) {
            return getAdNetWorkName();
        }
        return this.f13921d.h() + "_" + this.f13921d.e();
    }

    public String getBiddingToken(Context context, String str, GMAdSlotBase gMAdSlotBase) {
        return null;
    }

    public String getClientReqId() {
        String str = !TextUtils.isEmpty(this.f13926i) ? this.f13926i : null;
        if (TextUtils.isEmpty(this.f13936s)) {
            return str;
        }
        return (str + "_") + this.f13936s;
    }

    public String getCustomAdNetWorkName() {
        if (this.f13921d == null || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(this.f13921d.e())) {
            return null;
        }
        return this.f13921d.h();
    }

    public final Object getExtraDataNoParse() {
        h hVar;
        if (isServerBidding() && (hVar = this.f13933p) != null) {
            return hVar.d();
        }
        return null;
    }

    public int getIfTest() {
        i iVar = this.mTTExtraModel;
        if (iVar != null) {
            return iVar.b;
        }
        return 0;
    }

    public int getReqBiddingType() {
        return this.f13935r;
    }

    public abstract String getSdkVersion();

    public boolean hasNotifyFail() {
        return this.b;
    }

    public boolean hasNotifySuccess() {
        return this.a;
    }

    public boolean isClientBidding() {
        return this.f13935r == 1;
    }

    public boolean isMultiBidding() {
        return this.f13935r == 3;
    }

    public boolean isServerBidding() {
        return this.f13935r == 2;
    }

    public abstract void loadAd(Context context, Map<String, Object> map);

    public final void loadAdInter(@NonNull final Context context, @NonNull j jVar, @NonNull final Map<String, Object> map, @NonNull AdSlot adSlot, i iVar, int i2, GMAdSlotBase gMAdSlotBase) {
        this.a = false;
        this.b = false;
        this.f13921d = jVar;
        this.f13922e = adSlot.getAdUnitId();
        this.f13934q = adSlot.getAdCount();
        this.f13926i = adSlot.getLinkedId();
        this.f13939v = adSlot.getAdType();
        this.f13938u = jVar.z();
        this.f13923f = jVar.p();
        this.f13924g = jVar.y();
        this.f13936s = jVar.d();
        this.f13933p = jVar.x();
        this.f13927j = jVar.j();
        this.mAdSlot = adSlot;
        this.mTTExtraModel = iVar;
        this.f13935r = jVar.f();
        this.mWaterfallAbTestParam = jVar.A();
        this.f13930m = i2;
        this.mGMAdSlotBase = gMAdSlotBase;
        Object obj = map.get("key_mediation_rit_req_type");
        this.f13931n = obj != null ? ((Integer) obj).intValue() : 1;
        Object obj2 = map.get("key_mediation_rit_req_type_src");
        this.f13932o = obj2 != null ? ((Integer) obj2).intValue() : 1;
        Object obj3 = map.get("key_is_from_developer_req");
        this.f13940w = obj3 != null && ((Boolean) obj3).booleanValue();
        Object obj4 = map.get("key_requestwfb_ms");
        long jLongValue = obj4 instanceof Long ? ((Long) obj4).longValue() : -1L;
        Object obj5 = map.get("const_is_custom");
        boolean z2 = obj5 != null && ((Boolean) obj5).booleanValue();
        if (jVar != null && !jVar.G()) {
            this.f13941x = this.f13931n == 4 ? 3 : 0;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, adSlot, getSdkVersion(), this.f13940w, this.f13941x, i2, this.f13931n, this.f13932o, (AdError) null, jLongValue);
        }
        this.f13925h = (isServerBidding() || isClientBidding() || isMultiBidding()) ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : jVar.i();
        this.f13928k = System.currentTimeMillis();
        if (jVar != null && !z2) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().e(jVar.d(), getSdkVersion());
        }
        if (jVar != null && (TextUtils.equals("mintegral", jVar.e()) || TextUtils.equals("baidu", jVar.e()) || TextUtils.equals("admob", jVar.e()))) {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TTAbsAdLoaderAdapter.this.loadAd(context, map);
                    } catch (Throwable unused) {
                        TTAbsAdLoaderAdapter.this.notifyAdFailed(new AdError("主线程ADN请求广告崩溃"));
                    }
                }
            });
            return;
        }
        try {
            loadAd(context, map);
        } catch (Throwable unused) {
            notifyAdFailed(new AdError("子线程ADN请求广告崩溃"));
        }
    }

    public final void nativeDislikeClick(TTBaseAd tTBaseAd, String str, Map<String, Object> map) {
        if (tTBaseAd == null || tTBaseAd.getAdType() != 5) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.mAdSlot, str);
    }

    public final void notifyAdFailed(AdError adError) {
        a((TTBaseAd) null, adError, true);
    }

    public final void notifyAdLoaded(GMCustomAd gMCustomAd) {
        notifyAdLoaded(gMCustomAd.getTTBaseAd());
    }

    public final void notifyAdLoaded(TTBaseAd tTBaseAd) {
        int i2;
        if (this.f13942y == -1) {
            this.f13942y = SystemClock.elapsedRealtime();
        }
        if (tTBaseAd != null) {
            tTBaseAd.setAdNetworkSlotType(this.f13935r);
            tTBaseAd.setExchangeRate(this.f13927j);
            tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
            i0.a(tTBaseAd, this.f13921d, this.mAdSlot, true);
            if (this.mAdSlot != null && ((i2 = this.f13935r) == 1 || i2 == 3)) {
                double bidFloor = this.mAdSlot.getBidFloor();
                if (bidFloor > PangleAdapterUtils.CPM_DEFLAUT_VALUE && bidFloor > tTBaseAd.getCpm()) {
                    a(tTBaseAd, new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), true);
                    return;
                }
            }
        }
        if (this.a) {
            return;
        }
        this.a = true;
        this.f13929l = System.currentTimeMillis() - this.f13928k;
        a("adload_ad", tTBaseAd, (List<TTBaseAd>) null, (AdError) null, true);
        j jVar = this.f13921d;
        if (jVar != null && jVar.t() == 10 && this.f13938u == 1) {
            notifyAdVideoCache(tTBaseAd, (AdError) null);
        }
    }

    public final void notifyAdLoaded(List<TTBaseAd> list) {
        int i2;
        if (this.f13942y == -1) {
            this.f13942y = SystemClock.elapsedRealtime();
        }
        if (list != null) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
                }
            }
        }
        List<TTBaseAd> arrayList = new ArrayList<>();
        if (!h0.a(list)) {
            arrayList.addAll(list);
        }
        if (!h0.b(list)) {
            int i3 = this.f13935r;
            int i4 = 3;
            if (i3 == 1 || i3 == 3) {
                Iterator<TTBaseAd> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TTBaseAd next = it.next();
                    next.setAdNetworkSlotType(this.f13935r);
                    next.setExchangeRate(this.f13927j);
                    i0.a(next, this.f13921d, this.mAdSlot, true);
                    if (this.mAdSlot != null && ((i2 = this.f13935r) == 1 || i2 == i4)) {
                        double bidFloor = this.mAdSlot.getBidFloor();
                        if (bidFloor > PangleAdapterUtils.CPM_DEFLAUT_VALUE && bidFloor > next.getCpm()) {
                            arrayList.remove(next);
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), this.mAdSlot, this.f13921d, this.f13930m, this.f13931n, this.f13932o, getSdkVersion(), this.f13929l, String.valueOf(next.getCpm()), next.getLevelTag(), u.a(this.f13921d) ? u.b(Thread.currentThread().getStackTrace()) : null);
                            i4 = 3;
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    a((TTBaseAd) null, new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), false);
                    return;
                }
            }
        }
        if (this.a) {
            return;
        }
        this.a = true;
        this.f13929l = System.currentTimeMillis() - this.f13928k;
        a("adload_ads", (TTBaseAd) null, arrayList, (AdError) null, true);
    }

    public final void notifyAdLoadedCustom(List<? extends GMCustomAd> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<? extends GMCustomAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTTBaseAd());
            }
            notifyAdLoaded(arrayList);
        }
    }

    public final void notifyAdVideoCache(GMCustomAd gMCustomAd, AdError adError) {
        notifyAdVideoCache(gMCustomAd.getTTBaseAd(), adError);
    }

    public final void notifyAdVideoCache(TTBaseAd tTBaseAd, AdError adError) {
        if (this.b) {
            return;
        }
        a("ad_video_cache", tTBaseAd, (List<TTBaseAd>) null, adError, true);
    }

    public void removeFromParent(View view) {
        UIUtils.removeFromParent(view);
    }

    public final void setAdapterListener(AdapterLoaderListener adapterLoaderListener) {
        this.f13920c = adapterLoaderListener;
    }

    public void setTotalTimedOut(boolean z2) {
        this.f13937t = z2;
    }
}
