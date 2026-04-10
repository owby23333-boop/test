package com.bytedance.e.e.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.e.e.v.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static JSONObject e(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", bh.e(stackTrace));
        return jSONObject;
    }

    public static String e(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoE = com.bytedance.e.e.v.e.e(context, i);
        if (processErrorStateInfoE == null || Process.myPid() != processErrorStateInfoE.pid) {
            return null;
        }
        return bf.e(processErrorStateInfoE);
    }
}
