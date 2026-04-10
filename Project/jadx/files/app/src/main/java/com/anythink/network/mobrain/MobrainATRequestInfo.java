package com.anythink.network.mobrain;

import android.text.TextUtils;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.network.mobrain.MobrainConfig;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class MobrainATRequestInfo extends ATMediationRequestInfo {
    HashMap<String, Object> a;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATRequestInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[SupportNetworkFirmId.values().length];

        static {
            try {
                a[SupportNetworkFirmId.PANGLE_NETWORK_FIRM_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum SupportNetworkFirmId {
        PANGLE_NETWORK_FIRM_ID
    }

    public MobrainATRequestInfo(String str, String str2, SupportNetworkFirmId supportNetworkFirmId, String str3, String str4) {
        this.networkFirmId = 46;
        this.a = new HashMap<>();
        this.a.put("app_id", str);
        this.a.put("slot_id", str2);
        if (supportNetworkFirmId != null) {
            String str5 = AnonymousClass1.a[supportNetworkFirmId.ordinal()] == 1 ? AgooConstants.ACK_PACK_ERROR : null;
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MobrainConfig.KEY.MOBRAIN_SPLASH_NETWORK_FIRM_ID, str5);
                jSONObject.put(MobrainConfig.KEY.MORBAIN_DEFAULT_APP_ID, str3);
                jSONObject.put(MobrainConfig.KEY.MORBAIN_DEFAULT_PLACEMENT_ID, str4);
                this.a.put("default_info", jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
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
        this.className = MobrainATSplashAdapter.class.getName();
    }
}
