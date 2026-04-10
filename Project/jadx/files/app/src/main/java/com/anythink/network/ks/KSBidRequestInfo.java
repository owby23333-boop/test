package com.anythink.network.ks;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class KSBidRequestInfo extends ATBidRequestInfo {
    String a;
    JSONObject b = new JSONObject();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12532e;

    KSBidRequestInfo(Map<String, Object> map, Map<String, Object> map2) {
        try {
            String str = (String) map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID);
            String str2 = (String) map.get("position_id");
            if (map.containsKey("orientation")) {
                this.f12530c = Integer.parseInt(map.get("orientation").toString());
            }
            if (map2 != null) {
                this.f12531d = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
                this.f12532e = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
            }
            if (!TextUtils.isEmpty(this.f12532e) && this.f12532e.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.f12532e = this.f12532e.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, String.valueOf(str2));
            }
            HashMap map3 = new HashMap();
            if (!TextUtils.isEmpty(this.f12531d)) {
                map3.put("thirdUserId", this.f12531d);
            }
            if (!TextUtils.isEmpty(this.f12532e)) {
                map3.put("extraData", this.f12532e);
            }
            KsScene.Builder builderScreenOrientation = new KsScene.Builder(Long.parseLong(str2)).adNum(1).screenOrientation(this.f12530c == 2 ? 2 : 1);
            builderScreenOrientation = map3.isEmpty() ? builderScreenOrientation : builderScreenOrientation.rewardCallbackExtraData(map3);
            Object obj = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? map2.get(ATAdConst.KEY.AD_WIDTH) : null;
            Object obj2 = map2.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map2.get(ATAdConst.KEY.AD_HEIGHT) : null;
            if (obj != null) {
                try {
                    int i2 = (int) Double.parseDouble(obj.toString());
                    if (i2 > 0) {
                        builderScreenOrientation.width(i2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj2 != null) {
                try {
                    int i3 = (int) Double.parseDouble(obj2.toString());
                    if (i3 > 0) {
                        builderScreenOrientation.height(i3);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.a = KsAdSDK.getLoadManager().getBidRequestTokenV2(builderScreenOrientation.build());
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID, str);
            this.b.put("unit_id", str2);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN, this.a);
        } catch (Throwable unused) {
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.a);
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.b;
    }
}
