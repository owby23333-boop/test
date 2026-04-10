package com.bytedance.sdk.gromore.z.z.e.dl;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Bundle z(com.bytedance.msdk.api.dl.z zVar) {
        Bundle bundle = new Bundle();
        if (zVar == null) {
            return bundle;
        }
        float fG = zVar.g();
        String strDl = zVar.dl();
        Map<String, Object> mapA = zVar.a();
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        Object obj = mapA.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj instanceof Bundle) {
            Bundle bundle2 = (Bundle) obj;
            bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, fG);
            bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, strDl);
            return bundle2;
        }
        bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, strDl);
        bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, fG);
        Object obj2 = mapA.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj2 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj2).booleanValue());
        }
        Object obj3 = mapA.get("transId");
        if (obj3 instanceof String) {
            bundle.putString("transId", (String) obj3);
        }
        Object obj4 = mapA.get(MediationConstant.KEY_REASON);
        if (obj4 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj4).intValue());
        }
        Object obj5 = mapA.get("gromoreExtra");
        if (obj5 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj5);
        }
        Object obj6 = mapA.get(MediationConstant.KEY_ERROR_CODE);
        if (obj6 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_ERROR_CODE, ((Integer) obj6).intValue());
        }
        Object obj7 = mapA.get(MediationConstant.KEY_ERROR_MSG);
        if (obj7 instanceof String) {
            bundle.putString(MediationConstant.KEY_ERROR_MSG, (String) obj7);
        }
        Object obj8 = mapA.get(MediationConstant.KEY_ADN_NAME);
        if (!(obj8 instanceof String)) {
            return bundle;
        }
        bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj8);
        return bundle;
    }
}
