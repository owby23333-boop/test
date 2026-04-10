package com.amgcyo.cuttadon.h.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ks.view.KsFeedNativeBigAdView;
import com.amgcyo.cuttadon.sdk.ks.view.KsFeedNativeSmallAdView;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.sdk.utils.d;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* JADX INFO: compiled from: KsSdkAdTools.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.amgcyo.cuttadon.h.e.a {

    /* JADX INFO: compiled from: KsSdkAdTools.java */
    class a implements KsLoadManager.NativeAdListener {
        final /* synthetic */ Context a;
        final /* synthetic */ AdFrameLayout b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3955g;

        a(Context context, AdFrameLayout adFrameLayout, boolean z2, String str, String str2, int i2, String str3) {
            this.a = context;
            this.b = adFrameLayout;
            this.f3951c = z2;
            this.f3952d = str;
            this.f3953e = str2;
            this.f3954f = i2;
            this.f3955g = str3;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            String str2 = "广告数据请求失败" + i2 + str;
            c.this.a(this.a, i2, str);
            if (this.b.getChildCount() > 0) {
                this.b.removeAllViews();
                String str3 = "广告数据请求失败" + i2 + str;
            }
            if (this.f3951c) {
                c.this.a(this.a, new SdkErrorBean(i2, str, this.f3952d, this.f3953e), n.f3691e);
            }
            this.b.a(str, i2);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list == null || list.isEmpty()) {
                c.this.a(this.a, 80020, "暂无数据返回，请稍后重试!");
                return;
            }
            if (this.b.getChildCount() > 0) {
                this.b.removeAllViews();
            }
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            int i2 = this.f3954f;
            if (i2 == 2) {
                KsFeedNativeBigAdView ksFeedNativeBigAdView = new KsFeedNativeBigAdView(this.a);
                ksFeedNativeBigAdView.setKsFeedNativeData(list.get(0));
                this.b.addView(ksFeedNativeBigAdView);
                this.b.setDislikeImagview(this.f3955g);
            } else if (i2 == 1) {
                KsFeedNativeSmallAdView ksFeedNativeSmallAdView = new KsFeedNativeSmallAdView(this.a);
                ksFeedNativeSmallAdView.setKsFeedNativeData(list.get(0));
                this.b.addView(ksFeedNativeSmallAdView);
                this.b.setDislikeImagview(this.f3955g);
            }
            com.amgcyo.cuttadon.h.a.c.c(this.f3955g);
        }
    }

    /* JADX INFO: compiled from: KsSdkAdTools.java */
    private static class b {
        private static final c a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        return b.a;
    }

    private c() {
    }

    public void a(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        BaseAd baseAd;
        int style;
        String strL;
        if (normalAdParams == null || context == null || adFrameLayout == null || (baseAd = normalAdParams.getBaseAd()) == null || (style = baseAd.getStyle()) <= 0) {
            return;
        }
        int adWidth = normalAdParams.getAdWidth();
        if (adWidth <= 0) {
            adWidth = com.amgcyo.cuttadon.utils.otherutils.n.c(context);
        }
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        String str = "adPosition： " + adPosition + "  style：" + style + "  acceptedHeightDpSize: " + normalAdParams.getAdHeight() + " 夜间模式：" + g.h0() + " width: " + adWidth;
        strL = null;
        switch (adPosition) {
            case "csj_new_position_book_city":
                if (style != 1) {
                    strL = d.l("i_big_white");
                    break;
                } else {
                    strL = d.l("i_small_white");
                    break;
                }
                break;
            case "csj_new_position_shelf":
                strL = d.n("b_small_white");
                break;
            case "csj_new_position_lists":
                strL = d.n("c_small_white");
                break;
            case "csj_new_position_read_bottom":
                strL = d.o("b_small_white");
                break;
            case "csj_new_position_read_page":
            case "csj_new_position_read_end":
                if (style != 1) {
                    strL = d.o("p_big_white");
                    break;
                } else {
                    strL = d.o("p_small_white");
                    break;
                }
                break;
            case "csj_new_position_read_bottom_comics":
                strL = d.m("b_small_white");
                break;
            case "csj_new_position_read_page_comics":
            case "csj_new_position_read_end_comics":
                if (style != 1) {
                    strL = d.m("p_big_white");
                    break;
                } else {
                    strL = d.m("p_small_white");
                    break;
                }
                break;
        }
        String str2 = strL;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        normalAdParams.setAdUnitId(str2);
        a(style, adPosition, adFrameLayout, context, str2, normalAdParams.isFailRestart(), normalAdParams.getStochasticKey());
    }

    private void a(int i2, String str, AdFrameLayout adFrameLayout, Context context, String str2, boolean z2, String str3) {
        String str4 = "KsFeedNativeUtils style：" + i2 + " adPosition: " + str + " codeId: " + str2;
        if (!TextUtils.isEmpty(str2) && o.c(str2)) {
            KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(str2).longValue()).build();
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager != null && ksSceneBuild != null) {
                loadManager.loadNativeAd(ksSceneBuild, new a(context, adFrameLayout, z2, str, str2, i2, str3));
                return;
            }
            a(context, 80019, str2 + "_广告位id异常!");
            return;
        }
        a(context, 80019, str2 + "_广告位id异常!");
    }
}
