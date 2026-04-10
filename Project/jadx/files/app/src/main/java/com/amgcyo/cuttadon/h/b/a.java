package com.amgcyo.cuttadon.h.b;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* JADX INFO: compiled from: CsjNewAdUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.amgcyo.cuttadon.h.b.b {

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CsjNewAdUtils.java */
    class C0090a implements TTAdNative.NativeExpressAdListener {
        final /* synthetic */ NormalAdParams a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdFrameLayout f3862e;

        C0090a(NormalAdParams normalAdParams, Context context, String str, String str2, AdFrameLayout adFrameLayout) {
            this.a = normalAdParams;
            this.b = context;
            this.f3860c = str;
            this.f3861d = str2;
            this.f3862e = adFrameLayout;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            boolean zIsFailRestart = this.a.isFailRestart();
            String str2 = "onError:" + i2 + " msg: " + str + " 是否需要弹窗重启：" + zIsFailRestart;
            if (zIsFailRestart) {
                a.this.a(this.b, new SdkErrorBean(i2, str, this.f3860c, this.f3861d));
            }
            this.f3862e.a(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (g.b(list)) {
                Object tag = this.f3862e.getTag();
                if (tag instanceof TTNativeExpressAd) {
                    String str = "信息流destory: " + tag.hashCode();
                    ((TTNativeExpressAd) tag).destroy();
                }
                if (this.f3862e.getVisibility() != 0) {
                    this.f3862e.setVisibility(0);
                }
                String stochasticKey = this.a.getStochasticKey();
                com.amgcyo.cuttadon.h.a.c.c(stochasticKey);
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                String str2 = "信息流加载成功：frameLayout--->>> " + this.f3862e.hashCode() + " TTNativeExpressAd--->>> " + tTNativeExpressAd.hashCode();
                a.this.a(stochasticKey, this.f3862e, this.b, tTNativeExpressAd);
                tTNativeExpressAd.render();
            }
        }
    }

    /* JADX INFO: compiled from: CsjNewAdUtils.java */
    class b implements TTAdNative.NativeExpressAdListener {
        final /* synthetic */ NormalAdParams a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdFrameLayout f3866e;

        b(NormalAdParams normalAdParams, Context context, String str, String str2, AdFrameLayout adFrameLayout) {
            this.a = normalAdParams;
            this.b = context;
            this.f3864c = str;
            this.f3865d = str2;
            this.f3866e = adFrameLayout;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            boolean zIsFailRestart = this.a.isFailRestart();
            String str2 = "onError:" + i2 + " msg: " + str + " 是否需要弹窗重启：" + zIsFailRestart;
            if (zIsFailRestart) {
                a.this.a(this.b, new SdkErrorBean(i2, str, this.f3864c, this.f3865d));
            }
            this.f3866e.a(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (g.b(list)) {
                Object tag = this.f3866e.getTag();
                if (tag instanceof TTNativeExpressAd) {
                    String str = "banner destory: " + tag.hashCode();
                    ((TTNativeExpressAd) tag).destroy();
                }
                if (this.f3866e.getVisibility() != 0) {
                    this.f3866e.setVisibility(0);
                }
                String stochasticKey = this.a.getStochasticKey();
                com.amgcyo.cuttadon.h.a.c.c(stochasticKey);
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                String str2 = "banner加载成功：frameLayout--->>> " + this.f3866e.hashCode() + " TTNativeExpressAd--->>> " + tTNativeExpressAd.hashCode();
                a.this.a(stochasticKey, this.f3866e, this.b, tTNativeExpressAd);
                tTNativeExpressAd.render();
            }
        }
    }

    /* JADX INFO: compiled from: CsjNewAdUtils.java */
    private static class c {
        private static final a a = new a(null);
    }

    /* synthetic */ a(C0090a c0090a) {
        this();
    }

    private void b(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        String strB;
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        strB = null;
        switch (adPosition) {
            case "csj_new_position_book_city":
                if (!normalAdParams.isBigAd()) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.b("b_small");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.b("b_big");
                    break;
                }
                break;
            case "csj_new_position_shelf":
                strB = com.amgcyo.cuttadon.sdk.utils.d.d("b_small");
                break;
            case "csj_new_position_lists":
                strB = com.amgcyo.cuttadon.sdk.utils.d.d("c_small");
                break;
            case "csj_new_position_read_bottom":
                strB = com.amgcyo.cuttadon.sdk.utils.d.f("b_small");
                break;
            case "csj_new_position_read_page":
            case "csj_new_position_read_end":
                if (!normalAdParams.isBigAd()) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.f("p_small");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.f("p_big");
                    break;
                }
                break;
            case "csj_new_position_read_bottom_comics":
                strB = com.amgcyo.cuttadon.sdk.utils.d.c("b_small");
                break;
            case "csj_new_position_read_page_comics":
            case "csj_new_position_read_end_comics":
                if (!normalAdParams.isBigAd()) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("p_small");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("p_big");
                    break;
                }
                break;
        }
        if (TextUtils.isEmpty(strB)) {
            String str = adPosition + " 位置上的广告位id是空的";
            return;
        }
        String str2 = adPosition + " 位置上的广告位id为：" + strB;
        normalAdParams.setAdUnitId(strB);
        d(context, normalAdParams, adFrameLayout);
    }

    public static a c() {
        return c.a;
    }

    private void d(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        TTAdNative tTAdNativeC;
        if (normalAdParams == null || adFrameLayout == null) {
            return;
        }
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        String adUnitId = normalAdParams.getAdUnitId();
        if (TextUtils.isEmpty(adUnitId) || (tTAdNativeC = c(context)) == null) {
            return;
        }
        int adWidth = normalAdParams.getAdWidth();
        if (adWidth <= 0) {
            adWidth = (int) UIUtils.getScreenWidthDp(context);
        }
        int adHeight = normalAdParams.getAdHeight();
        String str = "adWidth: " + adWidth + " adHeight: " + adHeight + " px2dip: " + n.b(adHeight);
        AdSlot adSlotA = a(adUnitId, adWidth, adHeight);
        StringBuilder sb = new StringBuilder();
        sb.append("adSlot：");
        sb.append(adSlotA != null);
        sb.toString();
        tTAdNativeC.loadBannerExpressAd(adSlotA, new b(normalAdParams, context, adPosition, adUnitId, adFrameLayout));
    }

    private void e(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        TTAdNative tTAdNativeC;
        if (normalAdParams == null || adFrameLayout == null) {
            return;
        }
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        String adUnitId = normalAdParams.getAdUnitId();
        if (TextUtils.isEmpty(adUnitId) || (tTAdNativeC = c(context)) == null) {
            return;
        }
        int adWidth = normalAdParams.getAdWidth();
        if (adWidth <= 0) {
            adWidth = (int) UIUtils.getScreenWidthDp(context);
        }
        int adHeight = normalAdParams.getAdHeight();
        String str = "adWidth: " + adWidth + " adHeight: " + adHeight + " px2dip: " + n.b(adHeight);
        tTAdNativeC.loadNativeExpressAd(a(adUnitId, adWidth, adHeight), new C0090a(normalAdParams, context, adPosition, adUnitId, adFrameLayout));
    }

    public void a(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        BaseAd baseAd;
        int style;
        if (normalAdParams == null || context == null || (baseAd = normalAdParams.getBaseAd()) == null || (style = baseAd.getStyle()) == 0 || TextUtils.isEmpty(baseAd.getPlatform())) {
            return;
        }
        if (style == 1) {
            normalAdParams.setBigAd(false);
            c(context, normalAdParams, adFrameLayout);
            return;
        }
        if (style == 2) {
            normalAdParams.setBigAd(true);
            c(context, normalAdParams, adFrameLayout);
        } else if (style == 3) {
            normalAdParams.setBigAd(false);
            b(context, normalAdParams, adFrameLayout);
        } else {
            if (style != 4) {
                return;
            }
            normalAdParams.setBigAd(true);
            b(context, normalAdParams, adFrameLayout);
        }
    }

    private a() {
    }

    private void c(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        boolean zH0;
        String strB;
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        zH0 = g.h0();
        StringBuilder sb = new StringBuilder();
        sb.append("当前应用是：");
        sb.append(zH0 ? "夜间模式" : "白天模式");
        sb.toString();
        strB = null;
        switch (adPosition) {
            case "csj_new_position_book_city":
                if (normalAdParams.isBigAd()) {
                    if (!zH0) {
                        strB = com.amgcyo.cuttadon.sdk.utils.d.b("i_big_white");
                    } else {
                        strB = com.amgcyo.cuttadon.sdk.utils.d.b("i_big_black");
                    }
                    break;
                } else {
                    strB = !zH0 ? com.amgcyo.cuttadon.sdk.utils.d.b("i_small_white") : com.amgcyo.cuttadon.sdk.utils.d.b("i_small_black");
                    break;
                }
                break;
            case "csj_new_position_shelf":
                if (zH0) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.d("b_small_black");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.d("b_small_white");
                    break;
                }
                break;
            case "csj_new_position_lists":
                if (zH0) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.d("c_small_black");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.d("c_small_white");
                    break;
                }
                break;
            case "csj_new_position_read_bottom":
                if (zH0) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.f("b_small_black");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.f("b_small_white");
                    break;
                }
                break;
            case "csj_new_position_read_page":
            case "csj_new_position_read_end":
                if (normalAdParams.isBigAd()) {
                    if (!zH0) {
                        strB = com.amgcyo.cuttadon.sdk.utils.d.f("p_big_white");
                    } else {
                        strB = com.amgcyo.cuttadon.sdk.utils.d.f("p_big_black");
                    }
                    break;
                } else {
                    strB = !zH0 ? com.amgcyo.cuttadon.sdk.utils.d.f("p_small_white") : com.amgcyo.cuttadon.sdk.utils.d.f("p_small_black");
                    break;
                }
                break;
            case "csj_new_position_read_bottom_comics":
                if (zH0) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("b_small_black");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("b_small_white");
                    break;
                }
                break;
            case "csj_new_position_read_page_comics":
            case "csj_new_position_read_end_comics":
                if (normalAdParams.isBigAd()) {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("p_big_white");
                    break;
                } else {
                    strB = com.amgcyo.cuttadon.sdk.utils.d.c("p_small_white");
                    break;
                }
                break;
        }
        if (TextUtils.isEmpty(strB)) {
            String str = adPosition + " 位置上的广告位id是空的";
            return;
        }
        String str2 = adPosition + " 位置上的广告位id为：" + strB;
        normalAdParams.setAdUnitId(strB);
        e(context, normalAdParams, adFrameLayout);
    }
}
