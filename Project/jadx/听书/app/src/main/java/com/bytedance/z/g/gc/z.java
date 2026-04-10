package com.bytedance.z.g.gc;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private Map<String, Object> dl;
    private com.bytedance.z.g.gc g;
    private Context z;

    public z(Context context, com.bytedance.z.g.gc gcVar) {
        this.z = context;
        this.g = gcVar;
    }

    public Map<String, Object> z() {
        Map<String, Object> mapZ = this.g.z();
        if (mapZ == null) {
            mapZ = new HashMap<>(4);
        }
        if (z(mapZ)) {
            try {
                PackageInfo packageInfo = this.z.getPackageManager().getPackageInfo(this.z.getPackageName(), 128);
                mapZ.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapZ.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapZ.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapZ.get("version_code");
                    }
                    mapZ.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapZ.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.bytedance.z.g.gz.z.gc(this.z));
                mapZ.put("version_code", Integer.valueOf(com.bytedance.z.g.gz.z.m(this.z)));
                if (mapZ.get("update_version_code") == null) {
                    mapZ.put("update_version_code", mapZ.get("version_code"));
                }
            }
        }
        return mapZ;
    }

    public Map<String, Object> g() {
        if (this.dl == null) {
            this.dl = this.g.e();
        }
        return this.dl;
    }

    public static boolean z(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public com.bytedance.z.g.gc dl() {
        return this.g;
    }

    public String a() {
        return com.bytedance.z.g.gz.z.a(this.z);
    }

    public String gc() {
        return this.g.g();
    }
}
