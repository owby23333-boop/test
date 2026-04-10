package com.amgcyo.cuttadon.h.a;

import android.os.Build;
import com.kuaishou.weapon.p0.bh;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RootUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean a() {
        String str = Build.TAGS;
        return str != null && str.contains("setEditTextStringChange-keys");
    }

    private static boolean b() {
        for (String str : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean c() {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", bh.f16586y});
            boolean z2 = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
            if (processExec != null) {
                processExec.destroy();
            }
            return z2;
        } catch (Throwable unused) {
            if (processExec != null) {
                processExec.destroy();
            }
            return false;
        }
    }

    public static boolean d() {
        return a() || b() || c();
    }
}
