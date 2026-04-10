package com.anythink.network.onlineapi;

import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.d.e;
import com.anythink.basead.d.h;
import com.anythink.basead.e.d;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATAdapter extends CustomNativeAdapter {
    e a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12591c;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12591c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int iMin;
        this.f12591c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (j) map.get(g.k.a);
        this.a = new e(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        final int i2 = -1;
        if (map2 != null) {
            try {
                iMin = Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString());
            } catch (Throwable unused) {
                iMin = -1;
            }
            try {
                i2 = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            } catch (Throwable unused2) {
            }
        } else {
            iMin = -1;
        }
        final int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = context.getResources().getDisplayMetrics().heightPixels;
        if (iMin <= 0) {
            iMin = Math.min(i3, i4);
        }
        if (i2 <= 0) {
            i2 = (iMin * 3) / 4;
        }
        if (iMin <= i3) {
            i3 = iMin;
        }
        if (i2 > i4) {
            i2 = i4;
        }
        final Context applicationContext = context.getApplicationContext();
        this.a.a(new d() { // from class: com.anythink.network.onlineapi.OnlineApiATAdapter.1
            @Override // com.anythink.basead.e.d
            public final void onNativeAdLoadError(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) OnlineApiATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.d
            public final void onNativeAdLoaded(h... hVarArr) {
                OnlineApiATNativeAd[] onlineApiATNativeAdArr = new OnlineApiATNativeAd[hVarArr.length];
                for (int i5 = 0; i5 < hVarArr.length; i5++) {
                    hVarArr[i5].a(i3, i2);
                    onlineApiATNativeAdArr[i5] = new OnlineApiATNativeAd(applicationContext, hVarArr[i5]);
                }
                if (((ATBaseAdAdapter) OnlineApiATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATAdapter.this).mLoadListener.onAdCacheLoaded(onlineApiATNativeAdArr);
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map) {
        this.f12591c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (j) map.get(g.k.a);
        this.a = new e(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
    }
}
