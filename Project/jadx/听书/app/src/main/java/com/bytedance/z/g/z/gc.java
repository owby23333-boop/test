package com.bytedance.z.g.z;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.z.g.gz.v;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static JSONObject z(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", v.z(stackTrace));
        return jSONObject;
    }

    static String z(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoZ = com.bytedance.z.g.gz.z.z(context, i);
        if (processErrorStateInfoZ == null || Process.myPid() != processErrorStateInfoZ.pid) {
            return null;
        }
        return g.z(processErrorStateInfoZ);
    }
}
