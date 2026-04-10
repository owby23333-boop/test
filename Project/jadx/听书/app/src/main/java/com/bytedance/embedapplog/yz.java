package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class yz {
    private static final String[] z = {"ab_version", an.F, "language", "os_api", an.z, "google_aid", "build_serial", an.P, "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] g = {"ab_version", an.F, "language", "os_api", an.z, "google_aid", "build_serial", an.P, "iid", NativeUnifiedADAppInfoImpl.Keys.APP_NAME, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, an.ai, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String z(Context context, JSONObject jSONObject, String str, boolean z2, g gVar) {
        HashMap<String, String> mapZ;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(z.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = z;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(g[i], strOptString);
            }
            i++;
        }
        if (gVar != null) {
            try {
                mapZ = gVar.z(context);
            } catch (Exception e) {
                cb.g(e);
            }
        } else {
            mapZ = null;
        }
        if (o.dl(context) && mapZ != null) {
            map.putAll(mapZ);
        }
        try {
            HashMap<String, String> mapZ2 = z.dl() == null ? null : z.dl().z();
            if (mapZ2 != null) {
                map.putAll(mapZ2);
            }
        } catch (Exception e2) {
            cb.g(e2);
        }
        if (z.dl.size() > 0) {
            map.putAll(z.dl);
        }
        if (z2) {
            map.put("ssmix", "a");
        }
        String strZ = ly.z(context);
        if (!TextUtils.isEmpty(strZ)) {
            map.put("ac", strZ);
        }
        String str2 = (String) z.z("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) z.z("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString(an.y, null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put(an.y, strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) z.z("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) z.z("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) z.z("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strZ2 = dh.z(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strZ2)) {
            map.put("oaid", strZ2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return o.z(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, "UTF-8");
    }

    public static String[] z(ti tiVar, Context context, JSONObject jSONObject) {
        String[] strArrG = tiVar.gz().g();
        String[] strArr = new String[strArrG.length];
        String str = z.gz() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrG.length; i++) {
            String strZ = z(context, jSONObject, strArrG[i] + str, true, z.a());
            strArr[i] = strZ;
            strArr[i] = r.z(strZ, r.g);
        }
        return strArr;
    }
}
