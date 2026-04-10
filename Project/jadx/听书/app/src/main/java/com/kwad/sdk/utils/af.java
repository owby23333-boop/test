package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class af {
    private static AtomicInteger aZC = new AtomicInteger(0);
    private static volatile boolean aZD = false;
    private static volatile boolean aZE;

    private static boolean Qk() {
        return true;
    }

    private static int Qe() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int iBJ = hVar.BJ();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + iBJ);
        return iBJ;
    }

    private static void Qf() {
        if (aZD) {
            return;
        }
        aZC.set(Qi());
        aZE = bo.m("kssdk_kv_mode", "downgrade", false);
        aZD = true;
    }

    public static void at(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    int iC = bo.c("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bo.ay("ksadsdk_kv_perf", str);
                    } else {
                        bo.b("ksadsdk_kv_perf", str, iC + 1);
                    }
                } catch (Exception e) {
                    bo.ay("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        });
    }

    public static void au(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                SharedPreferences sharedPreferencesHo = bo.ho("ksadsdk_kv_perf");
                if (sharedPreferencesHo != null && sharedPreferencesHo.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bo.b("ksadsdk_kv_perf_failed", str, bo.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bo.b("ksadsdk_kv_perf_success", str, bo.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    public static void Qg() {
        if (Qj() || Qe() == 0) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.utils.b.a aVarQh = af.Qh();
                if (aVarQh == null) {
                    return;
                }
                af.c(aVarQh);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(aVarQh);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.kwad.sdk.utils.b.a aVar) {
        if (((double) aVar.bcR) / ((double) (aVar.bcR + aVar.bcS)) > 0.10000000149011612d) {
            aZE = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bo.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aZE) {
            Qm();
        }
    }

    public static com.kwad.sdk.utils.b.a Qh() {
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences sharedPreferencesHo = bo.ho("ksadsdk_kv_perf");
        if (sharedPreferencesHo == null) {
            return null;
        }
        try {
            Map<String, ?> all = sharedPreferencesHo.getAll();
            if (all == null) {
                return null;
            }
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
            aVar.bcQ = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesHo.edit();
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

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesHo = bo.ho("ksadsdk_kv_perf_failed");
        int iIntValue = 0;
        if (sharedPreferencesHo != null) {
            Map<String, ?> all = sharedPreferencesHo.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    iIntValue += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.bcR = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesHo.edit();
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        aVar.bcR = 0;
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesHo = bo.ho("ksadsdk_kv_perf_success");
        int iIntValue = 0;
        if (sharedPreferencesHo != null) {
            Map<String, ?> all = sharedPreferencesHo.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    iIntValue += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.bcS = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesHo.edit();
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        aVar.bcS = 0;
    }

    private static int Qi() {
        int iC = bo.c("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + iC);
        return iC;
    }

    static void eP(int i) {
        bo.b("kssdk_kv_mode", "mode", i);
    }

    private static boolean Qj() {
        Qf();
        return aZC.get() == 0;
    }

    private static boolean gW(String str) {
        return i.a.ase.contains(str);
    }

    public static boolean gX(String str) {
        boolean z = Qj() || !gW(str);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "shouldUseModeSp:" + z);
        return z;
    }

    private static int Ql() {
        Qf();
        int iQe = (aZE || !Qk()) ? 0 : Qe();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + iQe);
        return iQe;
    }

    public static void Qm() {
        Qf();
        int i = aZC.get();
        int iQl = Ql();
        boolean z = i != iQl;
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(iQl);
        }
    }

    private static void transfer(int i) {
        if (i == 0) {
            Qn();
        } else if (i == 1) {
            Qo();
        }
    }

    private static void Qn() {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context == null) {
                        return;
                    }
                    Iterator<String> it = i.a.ase.iterator();
                    while (it.hasNext()) {
                        af.S(context, it.next());
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                af.eP(0);
                af.aZC.set(0);
            }
        });
    }

    private static void Qo() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.ase.iterator();
                        while (it.hasNext()) {
                            af.R(context, it.next());
                        }
                        af.eP(1);
                        af.aZC.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Context context, String str) {
        SharedPreferences sharedPreferencesHo;
        com.kwad.sdk.utils.a.c cVarAy = com.kwad.sdk.utils.a.e.ay(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (sharedPreferencesHo = bo.ho(str)) == null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesHo.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (cVarAy.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences sharedPreferencesHo2 = bo.ho(str);
        if (sharedPreferencesHo2 == null) {
            cVarAy.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        cVarAy.putAll(sharedPreferencesHo2.getAll());
        cVarAy.putBoolean("sp_to_kv_transfer_flag", true);
        bo.ay(str, "kv_to_sp_transfer_flag");
        a(str, cVarAy);
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (i.a.asf.contains(str)) {
            return;
        }
        cVar.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Context context, String str) {
        SharedPreferences sharedPreferencesHo = bo.ho(str);
        if (sharedPreferencesHo == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesHo.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (sharedPreferencesHo.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c cVarAy = com.kwad.sdk.utils.a.e.ay(context, str);
        Map<String, Object> all = cVarAy.getAll();
        if (all.isEmpty()) {
            bo.l(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bo.a(str, all);
        bo.l(str, "kv_to_sp_transfer_flag", true);
        cVarAy.remove("sp_to_kv_transfer_flag");
        cVarAy.release();
    }
}
