package com.ss.android.downloadlib.addownload;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.e.dl f1994a;
    private volatile com.ss.android.socialbase.downloader.e.dl dl;
    private volatile boolean e;
    private volatile com.ss.android.socialbase.downloader.e.dl g;
    private volatile boolean gc;
    private volatile boolean m;
    private volatile com.ss.android.socialbase.downloader.e.dl z;

    private static class z {
        private static kb z = new kb();
    }

    public static kb z() {
        return z.z;
    }

    private kb() {
        this.z = null;
        this.g = null;
        this.dl = null;
        this.f1994a = null;
        this.gc = false;
        this.m = false;
        this.e = false;
        com.ss.android.downloadlib.gc.z().g(new Runnable() { // from class: com.ss.android.downloadlib.addownload.kb.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kb.this.dl();
                } catch (Exception e) {
                    com.ss.android.downloadlib.gc.dl.z().z(false, e, "读取sp出错");
                }
            }
        });
    }

    public void z(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
        if (z(dlVar2) && wp.iq() != null && wp.iq().z(dlVar, dlVar2)) {
            com.ss.android.downloadlib.a.z.z().z("download_unfinished_push_retain", dlVar.a());
        }
    }

    public void g(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
        if (z(dlVar2, dlVar) && wp.iq() != null && wp.iq().g(dlVar, dlVar2)) {
            com.ss.android.downloadlib.a.z.z().z("download_uninstalled_push_retain", dlVar.a());
        }
    }

    public long g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        if (this.gc) {
            return;
        }
        String strValueOf = String.valueOf(g());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences sharedPreferencesZ = com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(sharedPreferencesZ.getString("unfinished_pushed_update_time", "0"))) {
            String string = sharedPreferencesZ.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.z = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(Integer.parseInt(string));
        }
        if (strValueOf.equals(sharedPreferencesZ.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = sharedPreferencesZ.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.g = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(Integer.parseInt(string2));
        }
        if (strValueOf.equals(sharedPreferencesZ.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = sharedPreferencesZ.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.dl = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(Integer.parseInt(string3));
        }
        if (strValueOf.equals(sharedPreferencesZ.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = sharedPreferencesZ.getString("uninstalled_pop_up_id", "0");
            this.f1994a = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.gc = true;
    }

    private boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return dlVar != null && dlVar.p() == -2;
    }

    private boolean z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.z.z.dl.dl dlVar2) {
        return (dlVar == null || dlVar2 == null || com.ss.android.downloadlib.e.i.z(dlVar2)) ? false : true;
    }
}
