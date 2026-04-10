package com.bytedance.e.e.ga;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.market.sdk.utils.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private com.bytedance.e.e.ga bf;
    private Map<String, Object> d;
    private Context e;

    public e(@NonNull Context context, @NonNull com.bytedance.e.e.ga gaVar) {
        this.e = context;
        this.bf = gaVar;
    }

    @Nullable
    public Map<String, Object> bf() {
        if (this.d == null) {
            this.d = this.bf.p();
        }
        return this.d;
    }

    @NonNull
    public com.bytedance.e.e.ga d() {
        return this.bf;
    }

    @Nullable
    public Map<String, Object> e() {
        Map<String, Object> mapE = this.bf.e();
        if (mapE == null) {
            mapE = new HashMap<>(4);
        }
        if (e(mapE)) {
            try {
                PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 128);
                mapE.put("version_name", packageInfo.versionName);
                mapE.put(Constants.Update.VERSION_CODE, Integer.valueOf(packageInfo.versionCode));
                if (mapE.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapE.get(Constants.Update.VERSION_CODE);
                    }
                    mapE.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapE.put("version_name", com.bytedance.e.e.v.e.ga(this.e));
                mapE.put(Constants.Update.VERSION_CODE, Integer.valueOf(com.bytedance.e.e.v.e.vn(this.e)));
                if (mapE.get("update_version_code") == null) {
                    mapE.put("update_version_code", mapE.get(Constants.Update.VERSION_CODE));
                }
            }
        }
        return mapE;
    }

    public String ga() {
        return this.bf.bf();
    }

    public String tg() {
        return com.bytedance.e.e.v.e.tg(this.e);
    }

    public static boolean e(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey(Constants.Update.VERSION_CODE) && map.containsKey("update_version_code"));
    }
}
