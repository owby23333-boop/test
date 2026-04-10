package com.amgcyo.cuttadon.h.h;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.h.a.h;
import com.amgcyo.cuttadon.sdk.self.view.SelfBannerAdView;
import com.amgcyo.cuttadon.sdk.self.view.SelfSWXTAdView;
import com.amgcyo.cuttadon.sdk.self.view.SelfZTYW_BIG_AdView;
import com.amgcyo.cuttadon.sdk.self.view.SelfZTYW_SMALL_AdView;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;

/* JADX INFO: compiled from: SelfNewAdTools.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SelfNewAdTools.java */
    private static class C0102b {
        private static final b a = new b();
    }

    public static b a() {
        return C0102b.a;
    }

    private b() {
    }

    public void a(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        BaseAd baseAd;
        int style;
        if (normalAdParams == null || context == null || adFrameLayout == null || (baseAd = normalAdParams.getBaseAd()) == null || (style = baseAd.getStyle()) <= 0) {
            return;
        }
        String stochasticKey = normalAdParams.getStochasticKey();
        String[] selfAdPosition = normalAdParams.getSelfAdPosition();
        if (selfAdPosition == null || selfAdPosition.length <= 0) {
            selfAdPosition = new String[]{stochasticKey, normalAdParams.getAdPosition()};
        }
        for (String str : selfAdPosition) {
            String str2 = "值是：" + str;
        }
        NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(selfAdPosition, style, new boolean[0]);
        if (newApiAdA == null) {
            String str3 = style + " apiAd对象是空";
            return;
        }
        String str4 = style + " apiAd:" + newApiAdA.toString();
        if (adFrameLayout.getChildCount() > 0) {
            adFrameLayout.removeAllViews();
        }
        if (adFrameLayout.getVisibility() != 0) {
            adFrameLayout.setVisibility(0);
        }
        boolean z2 = newApiAdA.getIs_close() == 1 && !TextUtils.isEmpty(stochasticKey);
        if (style == 2) {
            SelfBannerAdView selfBannerAdView = new SelfBannerAdView(context);
            selfBannerAdView.a(newApiAdA, normalAdParams.isSpecialAdPosition());
            adFrameLayout.addView(selfBannerAdView);
        } else if (style == 3) {
            h.a(context, newApiAdA);
        } else if (style == 4) {
            SelfZTYW_BIG_AdView selfZTYW_BIG_AdView = new SelfZTYW_BIG_AdView(context);
            selfZTYW_BIG_AdView.a(newApiAdA);
            adFrameLayout.addView(selfZTYW_BIG_AdView);
        } else if (style == 5) {
            SelfSWXTAdView selfSWXTAdView = new SelfSWXTAdView(context);
            selfSWXTAdView.setEndAdData(newApiAdA);
            adFrameLayout.addView(selfSWXTAdView);
        } else if (style == 7) {
            SelfZTYW_SMALL_AdView selfZTYW_SMALL_AdView = new SelfZTYW_SMALL_AdView(context);
            selfZTYW_SMALL_AdView.setBottomAdData(newApiAdA);
            adFrameLayout.addView(selfZTYW_SMALL_AdView);
        }
        if (z2) {
            adFrameLayout.setDislikeImagview(stochasticKey);
        }
    }
}
