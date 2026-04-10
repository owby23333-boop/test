package com.bytedance.sdk.openadsdk.core.kb;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.kb.a.pf;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a {
    private dl z;

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        return false;
    }

    public e(dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(final String str, final String str2, final String str3, final int i, final String str4, String str5, int i2, final String str6, final String str7) {
        if (!this.z.dl()) {
            return false;
        }
        long jA = this.z.a();
        final TTAdInteractionListener tTAdInteractionListenerZ = pf.z();
        if (tTAdInteractionListenerZ == null || !z(1440L, this.z.e())) {
            return false;
        }
        com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.e.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str);
                map.put("app_icon_url", str2);
                map.put("event_id", Integer.valueOf(i));
                map.put(an.o, str3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", str7);
                    jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str4);
                    jSONObject.putOpt("tag", str6);
                } catch (Exception unused) {
                }
                boolean zDl = eo.dl(zw.getContext(), str3);
                map.put("event_token", com.bytedance.sdk.component.utils.z.g(jSONObject.toString()));
                tTAdInteractionListenerZ.onAdEvent(zDl ? 102 : 101, map);
            }
        }, jA * 1000);
        return true;
    }

    public boolean z(long j, int i) {
        try {
            Long lValueOf = -1L;
            boolean z = true;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                wp.g("notification", "error", e.getMessage());
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strZ = z();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strZ)) {
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
                String[] strArrSplit = strZ.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    Long.parseLong(strArrSplit[length - 1]);
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() <= lValueOf.longValue()) {
                    z = false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2).append("_");
                    }
                }
                sb.append(jCurrentTimeMillis);
                z(sb.toString());
                return z;
            }
            return false;
        } catch (Exception e2) {
            wp.z(e2);
            return false;
        }
    }

    public static String z() {
        return com.bytedance.sdk.openadsdk.core.g.z().get("notification_b", "");
    }

    public static void z(String str) {
        com.bytedance.sdk.openadsdk.core.g.z().put("notification_b", str);
    }
}
