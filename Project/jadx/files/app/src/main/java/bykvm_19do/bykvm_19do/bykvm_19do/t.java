package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static final String[] a = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", Constants.KEY_PACKAGE, "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] b = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, am.ai, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z2, b bVar) {
        HashMap<String, String> mapA;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(a.length + 10);
        int i2 = 0;
        while (true) {
            String[] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i2], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(b[i2], strOptString);
            }
            i2++;
        }
        if (bVar != null) {
            try {
                mapA = bVar.a(context);
            } catch (Exception e2) {
                l0.a(e2);
            }
        } else {
            mapA = null;
        }
        if (m0.b(context) && mapA != null) {
            map.putAll(mapA);
        }
        try {
            HashMap<String, String> mapA2 = a.i() == null ? null : a.i().a();
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
        } catch (Exception e3) {
            l0.a(e3);
        }
        if (a.f626f.size() > 0) {
            map.putAll(a.f626f);
        }
        if (z2) {
            map.put("ssmix", "a");
        }
        String strB = h0.b(context);
        if (!TextUtils.isEmpty(strB)) {
            map.put(com.anythink.expressad.d.a.b.da, strB);
        }
        String str2 = (String) a.a("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) a.a("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", DispatchConstants.ANDROID);
        int iIntValue = ((Integer) a.a("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) a.a("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) a.a("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strA = s0.a(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strA)) {
            map.put("oaid", strA);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? '&' : '?');
        return m0.a(sb.toString(), map, "UTF-8");
    }

    public static String[] a(v1 v1Var, Context context, JSONObject jSONObject) {
        String[] strArrD = v1Var.f().d();
        String[] strArr = new String[strArrD.length];
        String str = a.h() ? "?tt_data=a" : "?";
        for (int i2 = 0; i2 < strArrD.length; i2++) {
            strArr[i2] = a(context, jSONObject, strArrD[i2] + str, true, a.j());
            strArr[i2] = s.a(strArr[i2], s.f742d);
        }
        return strArr;
    }
}
