package com.ss.android.downloadlib.g;

import android.os.Build;
import com.ss.android.downloadlib.addownload.wp;

/* JADX INFO: loaded from: classes4.dex */
public class fo {
    public static boolean z(com.ss.android.g.z.g.z zVar) {
        return com.ss.android.socialbase.appdownloader.m.gc.gc() && Build.VERSION.SDK_INT < 29 && wp.wp() != null && wp.wp().z() && com.ss.android.downloadlib.e.gc.z(zVar).g("invoke_app_form_background_switch") == 1 && zVar.p();
    }
}
