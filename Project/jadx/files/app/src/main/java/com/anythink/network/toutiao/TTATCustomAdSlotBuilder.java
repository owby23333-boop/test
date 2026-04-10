package com.anythink.network.toutiao;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.b.g;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTATCustomAdSlotBuilder extends AdSlot.Builder {
    private final String a = TTATCustomAdSlotBuilder.class.getSimpleName();

    private TTATCustomAdSlotBuilder() {
    }

    public TTATCustomAdSlotBuilder(String str, Map<String, Object> map, Map<String, Object> map2) {
        setCodeId(str);
        try {
            if (map.containsKey(g.k.f6901k)) {
                int iIntValue = ((Integer) map.get(g.k.f6901k)).intValue();
                if (ATSDK.isNetworkLogDebug()) {
                    "adLoadSeq: ".concat(String.valueOf(iIntValue));
                }
                setAdloadSeq(iIntValue);
            }
        } catch (Throwable unused) {
        }
        try {
            if (map.containsKey(g.k.f6902l)) {
                String strOptString = new JSONObject((String) map.get(g.k.f6902l)).optString("slot_id", "");
                if (!TextUtils.isEmpty(strOptString)) {
                    if (ATSDK.isNetworkLogDebug()) {
                        "primeRit: ".concat(String.valueOf(strOptString));
                    }
                    setPrimeRit(strOptString);
                }
            }
        } catch (Throwable unused2) {
        }
        if (map2 == null || !map2.containsKey(TTATConst.AD_LOAD_TYPE)) {
            return;
        }
        Object obj = map2.get(TTATConst.AD_LOAD_TYPE);
        if (obj instanceof TTAdLoadType) {
            setAdLoadType((TTAdLoadType) obj);
        }
    }
}
