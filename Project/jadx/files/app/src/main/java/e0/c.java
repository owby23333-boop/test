package e0;

import android.content.Context;

/* JADX INFO: compiled from: SharedPreferencesUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences("prefs_sn_android", 0).edit().putString(str, str2).apply();
    }
}
