package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private Context a;
    private bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f1973c;

    public a(@NonNull Context context, @NonNull bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e eVar) {
        this.a = context;
        this.b = eVar;
    }

    public static boolean a(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @NonNull
    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e a() {
        return this.b;
    }

    @Nullable
    public Map<String, Object> b() {
        if (this.f1973c == null) {
            this.f1973c = this.b.e();
        }
        return this.f1973c;
    }

    public String c() {
        return this.b.c();
    }

    @Nullable
    public Map<String, Object> d() {
        Map<String, Object> mapF = this.b.f();
        if (mapF == null) {
            mapF = new HashMap<>(4);
        }
        if (a(mapF)) {
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128);
                mapF.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapF.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapF.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapF.get("version_code");
                    }
                    mapF.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapF.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.d(this.a));
                mapF.put("version_code", Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.c(this.a)));
                if (mapF.get("update_version_code") == null) {
                    mapF.put("update_version_code", mapF.get("version_code"));
                }
            }
        }
        return mapF;
    }

    public String e() {
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.b(this.a);
    }
}
