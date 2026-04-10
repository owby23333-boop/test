package com.sntech.okhttpconnection.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.sntech.okhttpconnection.log.Ccatch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.case, reason: invalid class name */
/* JADX INFO: compiled from: URLLog.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ccase {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean f96do = false;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m109do(Context context, String str, String str2, Celse celse) {
        Context applicationContext = context.getApplicationContext();
        Cdo.f110if = applicationContext;
        Cdo.f108for = str;
        Cdo.f111new = str2;
        Cdo.f113try = celse;
        if (celse.f117new == 0) {
            return;
        }
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("cloude_log_config", 0);
        boolean z2 = sharedPreferences.getBoolean(ConnType.PK_OPEN, false);
        boolean z3 = sharedPreferences.getBoolean("grey", false);
        Set<String> stringSet = sharedPreferences.getStringSet("whiteListOfHost", new HashSet());
        Set<String> stringSet2 = sharedPreferences.getStringSet("blackListOfHost", new HashSet());
        String string = sharedPreferences.getString("webViewSupportList", null);
        Cdo.f107else = sharedPreferences.getBoolean("configPL", false);
        Ccatch.Cif cif = new Ccatch.Cif(z2, z3, stringSet, stringSet2, string);
        if (z2) {
            Cdo.m117do(cif);
            Cdo.m118do(cif.f98case);
        }
        if (TextUtils.isEmpty(Cdo.f113try.m121if())) {
            return;
        }
        Ccatch.m112do(applicationContext, new Ccatch.Cdo() { // from class: com.sntech.okhttpconnection.log.a
            @Override // com.sntech.okhttpconnection.log.Ccatch.Cdo
            /* JADX INFO: renamed from: do, reason: not valid java name */
            public final void mo108do(Ccatch.Cif cif2) {
                Ccase.m110do(cif2);
            }
        });
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m110do(Ccatch.Cif cif) {
        StringBuilder sbA = y.b.a("pl = ");
        sbA.append(Cdo.f107else);
        sbA.toString();
        if (Cdo.f107else) {
            String str = "conf = " + cif;
        }
        if (cif.f99do) {
            if (f96do) {
                Cdo.m117do(cif);
                Cdo.m118do(cif.f98case);
                return;
            }
            return;
        }
        if (f96do) {
            Map<String, String> map = Cdo.f105case;
            synchronized (map) {
                ((HashMap) map).clear();
            }
            synchronized (Cdo.f109goto) {
            }
            synchronized (Cdo.f112this) {
            }
            f96do = false;
        }
    }
}
