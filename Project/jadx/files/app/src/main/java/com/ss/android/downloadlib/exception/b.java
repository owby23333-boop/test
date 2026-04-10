package com.ss.android.downloadlib.exception;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.u.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.ss.android.download.api.ox.mb {

    private static class mb {
        private static b mb = new b();
    }

    public static b mb() {
        return mb.mb;
    }

    public void ox(String str) {
        ox(true, str);
    }

    @Override // com.ss.android.download.api.ox.mb
    public void mb(Throwable th, String str) {
        mb(true, th, str);
    }

    public void ox(boolean z2, String str) {
        if (ox()) {
            return;
        }
        if (z2) {
            ox(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", mb(new Throwable()));
        x.ww().mb("service_ttdownloader", 3, jSONObject);
    }

    public void mb(boolean z2, Throwable th, String str) {
        if (ox()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z2) {
            ox(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", Log.getStackTraceString(th));
        x.ww().mb("service_ttdownloader", 1, jSONObject);
    }

    private void ox(Throwable th) {
        if (h.ox(x.getContext())) {
            throw new com.ss.android.downloadlib.exception.mb(th);
        }
    }

    private boolean ox() {
        return x.lz().optInt("enable_monitor", 1) != 1;
    }

    public void mb(String str) {
        mb(true, str);
    }

    public void mb(boolean z2, String str) {
        if (ox()) {
            return;
        }
        if (z2) {
            ox(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", mb(new Throwable()));
        x.ww().mb("service_ttdownloader", 2, jSONObject);
    }

    public static String mb(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
