package com.ss.android.downloadlib.gc;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.appdownloader.m.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements com.ss.android.z.z.a.z {

    private static class z {
        private static dl z = new dl();
    }

    public static dl z() {
        return z.z;
    }

    @Override // com.ss.android.z.z.a.z
    public void z(Throwable th, String str) {
        z(true, th, str);
    }

    public void z(boolean z2, Throwable th, String str) {
        if (g()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z2) {
            g(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        i.z(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        i.z(jSONObject, "stack", Log.getStackTraceString(th));
        wp.gz();
    }

    public void z(String str) {
        z(true, str);
    }

    public void z(boolean z2, String str) {
        if (g()) {
            return;
        }
        if (z2) {
            g(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        i.z(jSONObject, "stack", z(new Throwable()));
        wp.gz();
    }

    public void g(String str) {
        g(true, str);
    }

    public void g(boolean z2, String str) {
        if (g()) {
            return;
        }
        if (z2) {
            g(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        i.z(jSONObject, "stack", z(new Throwable()));
        wp.gz();
    }

    private void g(Throwable th) {
        if (m.g(wp.getContext())) {
            throw new com.ss.android.downloadlib.gc.z(th);
        }
    }

    public static String z(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean g() {
        return wp.fo().optInt("enable_monitor", 1) != 1;
    }
}
