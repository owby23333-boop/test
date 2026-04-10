package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.b;
import com.anythink.basead.d.e;
import com.anythink.basead.d.h;
import com.anythink.basead.e.d;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATAdapter extends CustomNativeAdapter {
    e a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12316c;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        this.f12316c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"));
        if (this.f12316c) {
            adxBidRequestInfo.fillAdAcceptType();
        }
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        j jVar = this.b;
        return jVar != null ? jVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int intFromMap;
        this.b = (j) map.get(g.k.a);
        this.a = new e(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
        this.f12316c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"));
        final boolean zEquals = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "close_button", "0"));
        final boolean zEquals2 = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "v_m", "0"));
        final String stringFromMap = ATInitMediation.getStringFromMap(map, "video_autoplay", "1");
        int iMin = -1;
        if (map2 != null) {
            iMin = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH);
            intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT);
        } else {
            intFromMap = -1;
        }
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        if (iMin <= 0) {
            iMin = Math.min(i2, i3);
        }
        if (intFromMap <= 0) {
            intFromMap = (iMin * 3) / 4;
        }
        final int i4 = iMin > i2 ? i2 : iMin;
        final int i5 = intFromMap > i3 ? i3 : intFromMap;
        final Context applicationContext = context.getApplicationContext();
        this.a.a(new d() { // from class: com.anythink.network.adx.AdxATAdapter.1
            @Override // com.anythink.basead.e.d
            public final void onNativeAdLoadError(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) AdxATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.d
            public final void onNativeAdLoaded(h... hVarArr) {
                AdxATNativeAd[] adxATNativeAdArr = new AdxATNativeAd[hVarArr.length];
                for (int i6 = 0; i6 < hVarArr.length; i6++) {
                    h hVar = hVarArr[i6];
                    hVar.a(i4, i5);
                    hVar.a(zEquals2);
                    hVar.a(stringFromMap);
                    adxATNativeAdArr[i6] = new AdxATNativeAd(applicationContext, hVar, AdxATAdapter.this.f12316c, zEquals);
                }
                if (((ATBaseAdAdapter) AdxATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATAdapter.this).mLoadListener.onAdCacheLoaded(adxATNativeAdArr);
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map) {
        this.b = (j) map.get(g.k.a);
        this.a = new e(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
    }
}
