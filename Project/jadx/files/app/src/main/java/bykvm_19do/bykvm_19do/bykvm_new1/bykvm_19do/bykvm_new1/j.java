package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private SharedPreferences a;

    public j(Context context) {
        this.a = context.getSharedPreferences("npth", 0);
    }

    public String a() {
        String strC = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e().c();
        return (TextUtils.isEmpty(strC) || "0".equals(strC)) ? this.a.getString("device_id", "0") : strC;
    }

    public void a(String str) {
        this.a.edit().putString("device_id", str).apply();
    }
}
