package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class n extends e2 {
    n() {
        super(true, false);
    }

    private boolean a() {
        return Class.forName("miui.os.Build").getName().length() > 0;
    }

    private boolean b() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:29|3)|(2:27|4)|31|5|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c() {
        /*
            r4 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "getprop ro.build.version.emui"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L28
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L28
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L28
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L26
            r2.close()     // Catch: java.lang.Throwable -> L26
        L22:
            r2.close()     // Catch: java.io.IOException -> L30
            goto L30
        L26:
            r1 = move-exception
            goto L2a
        L28:
            r1 = move-exception
            r2 = r0
        L2a:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r1)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L30
            goto L22
        L30:
            return r0
        L31:
            r0 = move-exception
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.io.IOException -> L37
        L37:
            goto L39
        L38:
            throw r0
        L39:
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.n.c():java.lang.String");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        String str;
        StringBuilder sb = new StringBuilder(16);
        if (a()) {
            str = "MIUI-";
        } else {
            if (!b()) {
                String strC = c();
                if (i.a(strC)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strC)) {
                    sb.append(strC);
                    str = "-";
                }
                sb.append(Build.VERSION.INCREMENTAL);
                jSONObject.put("rom", sb.toString());
                return true;
            }
            str = "FLYME-";
        }
        sb.append(str);
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }
}
