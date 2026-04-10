package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class bm extends k {
    public bm() {
        super(true, false);
    }

    private boolean bf() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    private String d() {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
            return line;
        } catch (Throwable th2) {
            th = th2;
            try {
                tx.bf(th);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                return line;
            } catch (Throwable th3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.bytedance.embedapplog.k
    public boolean e(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (e()) {
            sb.append("MIUI-");
        } else if (bf()) {
            sb.append("FLYME-");
        } else {
            String strD = d();
            if (bf.e(strD)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(strD)) {
                sb.append(strD);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean e() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
