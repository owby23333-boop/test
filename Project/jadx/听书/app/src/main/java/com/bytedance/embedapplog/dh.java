package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dh {
    private static bm<pd> z = new bm<pd>() { // from class: com.bytedance.embedapplog.dh.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.bm
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public pd z(Object... objArr) {
            return new pd((Context) objArr[0]);
        }
    };

    public static void z(Context context) {
        z.g(context).g();
    }

    public static String z(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return xf.z(sharedPreferences);
    }

    public static Map<String, String> z(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        pd pdVarG = z.g(context);
        return pdVarG.z(pdVarG.z() instanceof lt ? 200 : 100);
    }

    public static String z(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void z(gc gcVar) {
        pd.z(gcVar);
    }
}
