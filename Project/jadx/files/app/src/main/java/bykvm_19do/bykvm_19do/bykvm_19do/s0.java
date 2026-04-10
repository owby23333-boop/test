package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {
    private static String a = null;
    private static boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f744c = s0.class.getSimpleName() + "#";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static o0<z0> f745d = new a();

    static final class a extends o0<z0> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public z0 a(Object... objArr) {
            if (objArr.length == 0) {
                return null;
            }
            return new z0((Context) objArr[0]);
        }
    }

    public static String a() {
        return a;
    }

    public static String a(SharedPreferences sharedPreferences) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strA = q0.a(sharedPreferences);
        t0.b("TrackerDr", f744c + "getCdid takes " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        return strA;
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static Map<String, String> a(Context context, SharedPreferences sharedPreferences) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> mapA = f745d.b(context).a(100L);
        t0.b("TrackerDr", f744c + "getOaid takes " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        return mapA;
    }

    public static void a(Context context) {
        f745d.b(context).a(false);
    }

    public static void a(e eVar) {
        z0.a(eVar);
    }

    public static void a(String str) {
        a = str;
    }

    public static void a(boolean z2) {
        b = z2;
    }

    public static boolean b() {
        return b;
    }
}
