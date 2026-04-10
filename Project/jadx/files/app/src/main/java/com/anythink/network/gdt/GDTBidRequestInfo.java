package com.anythink.network.gdt;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.qq.e.comm.managers.GDTAdSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GDTBidRequestInfo extends ATBidRequestInfo {
    String a;
    JSONObject b = new JSONObject();

    GDTBidRequestInfo(Map<String, Object> map) {
        try {
            String string = map.get("app_id").toString();
            String string2 = map.get("unit_id").toString();
            HashMap map2 = new HashMap();
            GDTATInitManager.getInstance();
            GDTATInitManager.a(map2, map);
            this.a = GDTAdSdk.getGDTAdManger().getBuyerId(map2);
            this.b.put("app_id", string);
            this.b.put("unit_id", string2);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID, this.a);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, GDTAdSdk.getGDTAdManger().getSDKInfo(string2));
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
