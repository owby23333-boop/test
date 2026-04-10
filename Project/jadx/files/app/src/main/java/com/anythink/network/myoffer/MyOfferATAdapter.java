package com.anythink.network.myoffer;

import android.content.Context;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.e;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.s;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATAdapter extends CustomNativeAdapter {
    e a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12576c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12577d = false;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a((a) null);
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        e eVar = this.a;
        if (eVar == null || !eVar.a()) {
            return null;
        }
        return new MyOfferATNativeAd(context, this.a);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12576c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12576c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.b = (j) map.get(g.k.a);
        }
        if (map.containsKey(s.b)) {
            this.f12577d = ((Boolean) map.get(s.b)).booleanValue();
        }
        this.a = new e(context, this.b, this.f12576c, this.f12577d);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12576c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.b = (j) map.get(g.k.a);
        }
        this.a = new e(context, this.b, this.f12576c, this.f12577d);
        final Context applicationContext = context.getApplicationContext();
        this.a.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (((ATBaseAdAdapter) MyOfferATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATAdapter.this).mLoadListener.onAdCacheLoaded(new MyOfferATNativeAd(applicationContext, MyOfferATAdapter.this.a));
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) MyOfferATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    private void a(Context context) {
        this.a = new e(context, this.b, this.f12576c, this.f12577d);
    }
}
