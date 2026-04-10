package com.amgcyo.cuttadon.h.i.g;

import android.content.Context;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.network.toutiao.TTATConst;
import java.util.HashMap;

/* JADX INFO: compiled from: ToponFeedPreloadUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: ToponFeedPreloadUtil.java */
    class a implements ATNativeNetworkListener {
        final /* synthetic */ NormalAdParams a;

        a(b bVar, NormalAdParams normalAdParams) {
            this.a = normalAdParams;
        }

        @Override // com.anythink.nativead.api.ATNativeNetworkListener
        public void onNativeAdLoadFail(AdError adError) {
            String str = "pre onNativeAdLoadFail:" + adError.getFullErrorInfo();
            this.a.setAdWidth(0);
            this.a.setAdHeight(0);
        }

        @Override // com.anythink.nativead.api.ATNativeNetworkListener
        public void onNativeAdLoaded() {
            this.a.setAdWidth(0);
            this.a.setAdHeight(0);
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.i.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ToponFeedPreloadUtil.java */
    private static class C0105b {
        private static final b a = new b();
    }

    public static b a() {
        return C0105b.a;
    }

    public void a(Context context, NormalAdParams normalAdParams) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        int adHeight = normalAdParams.getAdHeight();
        String str = "pre loadFeedAd adWidthPx: " + adWidth + " adHeightPx: " + adHeight;
        ATNative aTNative = new ATNative(context, adUnitId, new a(this, normalAdParams));
        HashMap map = new HashMap();
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(adWidth));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(adHeight));
        map.put(TTATConst.NATIVE_AD_IMAGE_HEIGHT, 0);
        map.put(GDTATConst.AD_HEIGHT, -2);
        aTNative.setLocalExtra(map);
        aTNative.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("模板信息流广告预加载", "ToponFeedPreloadUtil"));
        aTNative.makeAdRequest();
    }
}
