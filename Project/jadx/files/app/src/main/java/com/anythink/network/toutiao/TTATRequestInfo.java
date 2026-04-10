package com.anythink.network.toutiao;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TTATRequestInfo extends ATMediationRequestInfo {
    HashMap<String, Object> a;

    public TTATRequestInfo(String str, String str2, boolean z2) {
        this.networkFirmId = 15;
        this.a = new HashMap<>();
        this.a.put("app_id", str);
        this.a.put("slot_id", str2);
        this.a.put("personalized_template", z2 ? "1" : "0");
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
        this.className = TTATSplashAdapter.class.getName();
    }
}
