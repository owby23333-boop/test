package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class q0 {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static String b = "";

    static String a(SharedPreferences sharedPreferences) {
        if (a.compareAndSet(false, true)) {
            b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(b)) {
                b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", b).apply();
            }
        }
        return b;
    }
}
