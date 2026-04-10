package com.yuewen;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class pc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15997a = "context";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15998b = "common";
    public static kv3<pc3> c;

    @Nullable
    public static pc3 a() {
        kv3<pc3> kv3Var = c;
        if (kv3Var == null) {
            return null;
        }
        return kv3Var.get();
    }

    public static void e(kv3<pc3> kv3Var) {
        c = kv3Var;
    }

    public abstract Map<String, Object> b(String str);

    public abstract void c(String str, JSONObject jSONObject);

    public boolean d() {
        return true;
    }
}
