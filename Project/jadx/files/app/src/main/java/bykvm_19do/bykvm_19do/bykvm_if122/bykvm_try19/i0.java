package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i0 {
    public static void a(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, boolean z2) {
        String message;
        if (tTBaseAd == null || !tTBaseAd.isMultiBiddingAd()) {
            return;
        }
        if (jVar == null) {
            tTBaseAd.setCpm(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }
        String levelTag = tTBaseAd.getLevelTag();
        Map<String, String> mapR = jVar.r();
        if (TextUtils.isEmpty(levelTag)) {
            if (z2) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, adSlot, tTBaseAd, AdError.ERROR_CODE_NO_LEVEL_TAG, AdError.getMessage(AdError.ERROR_CODE_NO_LEVEL_TAG));
            }
            message = AdError.getMessage(AdError.ERROR_CODE_NO_LEVEL_TAG);
        } else {
            if (mapR != null) {
                String str = mapR.get(levelTag);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        tTBaseAd.setCpm(Double.valueOf(str).doubleValue());
                        return;
                    } catch (Exception unused) {
                    }
                } else if (z2) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, adSlot, tTBaseAd, AdError.ERROR_CODE_NO_MATCH_LEVEL_TAG, AdError.getMessage(AdError.ERROR_CODE_NO_MATCH_LEVEL_TAG));
                }
                tTBaseAd.setCpm(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }
            if (z2) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, adSlot, tTBaseAd, AdError.ERROR_CODE_NO_MATCH_LEVEL_TAG, AdError.getMessage(AdError.ERROR_CODE_NO_MATCH_LEVEL_TAG));
            }
            message = AdError.getMessage(AdError.ERROR_CODE_NO_MATCH_LEVEL_TAG);
        }
        tTBaseAd.setErrorMsg(message);
        tTBaseAd.setCpm(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }
}
