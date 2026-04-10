package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private static volatile boolean ayI;
    private static AtomicInteger ayH = new AtomicInteger(0);
    private static volatile boolean axr = false;

    private static int CZ() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int iSZ = fVar.sZ();
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "config mode:" + iSZ);
        return iSZ;
    }

    private static void Da() {
        if (axr) {
            return;
        }
        ayH.set(Dd());
        ayI = az.i("kssdk_kv_mode", "downgrade", false);
        axr = true;
    }

    public static void Db() {
        if (De() || CZ() == 0) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.w.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.a.a aVarDc = w.Dc();
                if (aVarDc == null) {
                    return;
                }
                w.c(aVarDc);
                com.kwad.sdk.utils.a.b bVar = (com.kwad.sdk.utils.a.b) ServiceProvider.get(com.kwad.sdk.utils.a.b.class);
                if (bVar != null) {
                    bVar.a(aVarDc);
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.a.a Dc() {
        com.kwad.sdk.utils.a.a aVar = new com.kwad.sdk.utils.a.a();
        SharedPreferences sharedPreferencesEw = az.ew("ksadsdk_kv_perf");
        if (sharedPreferencesEw == null) {
            return null;
        }
        try {
            Map<String, ?> all = sharedPreferencesEw.getAll();
            if (all == null) {
                return null;
            }
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
            aVar.aBC = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesEw.edit();
            Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
            while (it2.hasNext()) {
                editorEdit.putInt(it2.next().getKey(), 0);
            }
            editorEdit.apply();
            d(aVar);
            e(aVar);
        } catch (Throwable unused) {
        }
        return aVar;
    }

    private static int Dd() {
        int iC = az.c("kssdk_kv_mode", Constants.KEY_MODE, 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "local mode:" + iC);
        return iC;
    }

    public static boolean De() {
        Da();
        return ayH.get() == 0;
    }

    private static boolean Df() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int Dg() {
        Da();
        int iCZ = (ayI || !Df()) ? 0 : CZ();
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "targetMode:" + iCZ);
        return iCZ;
    }

    public static void Dh() {
        Da();
        int i2 = ayH.get();
        int iDg = Dg();
        boolean z2 = i2 != iDg;
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "needTransfer:" + z2);
        if (z2) {
            transfer(iDg);
        }
    }

    private static void Di() {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.w.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context context = x.getContext();
                    if (context == null) {
                        return;
                    }
                    Iterator<String> it = d.a.Ye.iterator();
                    while (it.hasNext()) {
                        w.H(context, it.next());
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.e("Ks_UnionHelper", Log.getStackTraceString(e2));
                }
                w.cb(0);
                w.ayH.set(0);
            }
        });
    }

    private static void Dj() {
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "transferToKv");
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.w.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context context = x.getContext();
                    if (context != null) {
                        Iterator<String> it = d.a.Ye.iterator();
                        while (it.hasNext()) {
                            w.G(context, it.next());
                        }
                        w.cb(1);
                        w.ayH.set(1);
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.e("Ks_UnionHelper", Log.getStackTraceString(e2));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Context context, String str) {
        SharedPreferences sharedPreferencesEw;
        com.kwad.sdk.utils.kwai.c cVarAr = com.kwad.sdk.utils.kwai.e.ar(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (sharedPreferencesEw = az.ew(str)) == null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesEw.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (cVarAr.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences sharedPreferencesEw2 = az.ew(str);
        if (sharedPreferencesEw2 == null) {
            cVarAr.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        cVarAr.putAll(sharedPreferencesEw2.getAll());
        cVarAr.putBoolean("sp_to_kv_transfer_flag", true);
        az.ab(str, "kv_to_sp_transfer_flag");
        a(str, cVarAr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(Context context, String str) {
        SharedPreferences sharedPreferencesEw = az.ew(str);
        if (sharedPreferencesEw == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesEw.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (sharedPreferencesEw.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.kwai.c cVarAr = com.kwad.sdk.utils.kwai.e.ar(context, str);
        Map<String, Object> all = cVarAr.getAll();
        if (all.isEmpty()) {
            az.h(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        az.a(str, all);
        az.h(str, "kv_to_sp_transfer_flag", true);
        cVarAr.remove("sp_to_kv_transfer_flag");
        cVarAr.release();
    }

    @WorkerThread
    public static void Z(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.w.1
            @Override // java.lang.Runnable
            public final void run() {
                int iC = az.c("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    az.ab("ksadsdk_kv_perf", str);
                } else {
                    az.b("ksadsdk_kv_perf", str, iC + 1);
                }
            }
        });
    }

    private static void a(String str, com.kwad.sdk.utils.kwai.c cVar) {
        if (d.a.Yf.contains(str)) {
            return;
        }
        cVar.release();
    }

    public static void aa(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.w.2
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferences sharedPreferencesEw = az.ew("ksadsdk_kv_perf");
                if (sharedPreferencesEw != null && sharedPreferencesEw.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        az.b("ksadsdk_kv_perf_failed", str, az.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        az.b("ksadsdk_kv_perf_success", str, az.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.a.a aVar) {
        int i2 = aVar.aBD;
        double d2 = i2;
        double d3 = i2 + aVar.aBE;
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d2 / d3 > 0.10000000149011612d) {
            ayI = true;
            com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "need downgrade");
            az.h("kssdk_kv_mode", "downgrade", true);
        }
        if (ayI) {
            Dh();
        }
    }

    static void cb(int i2) {
        az.b("kssdk_kv_mode", Constants.KEY_MODE, i2);
    }

    private static void d(com.kwad.sdk.utils.a.a aVar) {
        SharedPreferences sharedPreferencesEw = az.ew("ksadsdk_kv_perf_failed");
        int iIntValue = 0;
        if (sharedPreferencesEw == null) {
            aVar.aBD = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesEw.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aBD = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesEw.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private static void e(com.kwad.sdk.utils.a.a aVar) {
        SharedPreferences sharedPreferencesEw = az.ew("ksadsdk_kv_perf_success");
        int iIntValue = 0;
        if (sharedPreferencesEw == null) {
            aVar.aBE = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesEw.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aBE = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesEw.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private static void transfer(int i2) {
        if (i2 == 0) {
            Di();
        } else if (i2 == 1) {
            Dj();
        }
    }
}
