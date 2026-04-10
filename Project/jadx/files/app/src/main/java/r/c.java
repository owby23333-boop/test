package r;

import com.sntech.x2.Cif;

/* JADX INFO: compiled from: SpUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a(String str, String str2) {
        return Cif.f137do.getSharedPreferences("sn_mediation", 0).getString(str, null);
    }

    public static void b(String str, String str2) {
        Cif.f137do.getSharedPreferences("sn_mediation", 0).edit().putString(str, str2).apply();
    }
}
