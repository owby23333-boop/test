package com.bytedance.pangle.util.g;

import com.bytedance.pangle.a.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.api.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean z(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new z(new com.bytedance.pangle.util.g.z.z().z(str)).z(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i5 = g.z.z;
            } else if (i2 == 2) {
                i5 = g.z.g;
            } else {
                i4 = 0;
                String str3 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                z(i4, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                return true;
            }
            i4 = i5;
            String str32 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str32)));
            z(i4, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str32);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i3 = g.z.dl;
                    } else {
                        i3 = i2 == 2 ? g.z.f506a : 0;
                    }
                    String str4 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
                    z(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, str4);
                }
                return false;
            } finally {
            }
        }
    }

    private static void z(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.g.z(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.g.z(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.g.z(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.g.g(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.g.z(th));
        } catch (JSONException e) {
            m.z(e);
        }
        com.bytedance.pangle.a.g.z().z(com.bytedance.pangle.a.g.uy, jSONObject, jSONObject3, jSONObject2);
    }
}
