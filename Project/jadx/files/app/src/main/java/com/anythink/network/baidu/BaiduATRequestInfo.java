package com.anythink.network.baidu;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BaiduATRequestInfo extends ATMediationRequestInfo {
    HashMap<String, Object> a;

    public BaiduATRequestInfo(String str, String str2) {
        this.networkFirmId = 22;
        this.a = new HashMap<>();
        this.a.put("app_id", str);
        this.a.put("ad_place_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public Map<String, Object> getRequestParamMap() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(String str) {
        if (((str.hashCode() == 52 && str.equals("4")) ? (byte) 0 : (byte) -1) != 0) {
            return;
        }
        this.className = BaiduATSplashAdapter.class.getName();
    }
}
