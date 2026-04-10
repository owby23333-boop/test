package com.anythink.network.directly;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DirectlyBidRequestInfo extends ATBidRequestInfo {
    JSONObject a = new JSONObject();

    public void fillBannerData(Map<String, Object> map) {
        try {
            String string = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE).toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] strArrSplit = string.split("x");
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            this.a.put("ad_width", i2);
            this.a.put("ad_height", i3);
        } catch (Throwable unused) {
        }
    }

    public void fillSplashData() {
        try {
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.a;
    }
}
