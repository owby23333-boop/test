package com.anythink.network.directly;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d.d;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.network.adx.AdxATInterstitialAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirectlyATInterstitialAdapter extends AdxATInterstitialAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12409d = 0;

    public void fixDirectlyInterstitial() {
        i iVarD;
        d dVar = this.b;
        if (dVar == null || (iVarD = dVar.d()) == null) {
            return;
        }
        iVarD.d(this.f12409d == 0 ? 2 : 1);
        aa aaVar = (aa) iVarD;
        if (aaVar.Y() == 5 && this.f12409d == 0) {
            aaVar.j(3);
        }
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "Directly";
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        if (map.containsKey("unit_type") && (obj = map.get("unit_type")) != null) {
            this.f12409d = Integer.parseInt(obj.toString());
        }
        super.loadCustomNetworkAd(context, map, map2);
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        fixDirectlyInterstitial();
        super.show(activity);
    }
}
