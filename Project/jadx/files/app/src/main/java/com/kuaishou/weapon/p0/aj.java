package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class aj {
    private static final String A = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    private static final String B = "aW8ueHVkd29mdGVuY2VudG1t";
    private static final String C = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    private static final String D = "Y29tLnR4eS5hbnl3aGVyZQ==";
    private static final String E = "Y29tLmRpbmd3ZWkueHVuaWpp";
    private static final String F = "bWUud2Vpc2h1LmV4cA==";
    private static final String G = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    private static final String H = "ZXUuZmFpcmNvZGUueGx1YQ==";
    private static final String I = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    private static final String J = "Y29tLndpbmQuY290dGVy";
    private static final String K = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";
    private static final String a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";
    private static final String b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16533c = "b3JnLmF1dG9qcy5hdXRvanM=";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16534d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f16535e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f16536f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f16537g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f16538h = "Y29tLm13ci5keg==";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f16539i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f16540j = "Y29tLng4enMuc2FuZGJveA==";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f16541k = "Y29tLmYxcGxheWVy";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f16542l = "Y29tLmNvZmZhY2UuaXZhZGVy";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f16543m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f16544n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f16545o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f16546p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f16547q = "Y29tLm1pbmkubGl2ZS5saXZl";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f16548r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f16549s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f16550t = "dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f16551u = "dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f16552v = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f16553w = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f16554x = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f16555y = "Y29tLnNrLnNwcm9tb3Rlcg==";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f16556z = "Y29tLnNlc2FtZS5wcm94eQ==";

    public static String a() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
            for (int i2 = 0; i2 < 20; i2++) {
                sb.append(new File(strArr[i2]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private JSONObject a(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (a(context, list.get(i2))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    jSONObject.put(sb.toString(), 1);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.contains(".")) {
                str = new String(c.a(str.getBytes(), 2));
            }
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private JSONObject n(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f16536f)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f16537g)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f16538h)) {
                jSONObject.put("2", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject o(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, a)) {
                jSONObject.put("0", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject p(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f16540j)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f16541k)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject q(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f16542l)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f16543m)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f16544n)) {
                jSONObject.put("2", 1);
            }
            if (a(context, f16545o)) {
                jSONObject.put("3", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject r(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f16546p)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f16547q)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i2 = 1;
            jSONObject.put("0", a(context, a) ? 1 : 0);
            jSONObject.put("1", a(context, b) ? 1 : 0);
            jSONObject.put("2", a(context, f16533c) ? 1 : 0);
            jSONObject.put("3", a(context, f16534d) ? 1 : 0);
            if (!a(context, f16535e)) {
                i2 = 0;
            }
            jSONObject.put("4", i2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b(Context context) {
        return a(context, f16539i) ? 1 : 0;
    }

    public JSONObject c(Context context) {
        try {
            JSONObject jSONObjectO = o(context);
            if (jSONObjectO == null) {
                return null;
            }
            if (jSONObjectO.length() > 0) {
                return jSONObjectO;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        try {
            JSONObject jSONObjectN = n(context);
            if (jSONObjectN == null) {
                return null;
            }
            if (jSONObjectN.length() > 0) {
                return jSONObjectN;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e(Context context) {
        try {
            JSONObject jSONObjectP = p(context);
            if (jSONObjectP == null) {
                return null;
            }
            if (jSONObjectP.length() > 0) {
                return jSONObjectP;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f(Context context) {
        try {
            JSONObject jSONObjectQ = q(context);
            if (jSONObjectQ == null) {
                return null;
            }
            if (jSONObjectQ.length() > 0) {
                return jSONObjectQ;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject g(Context context) {
        try {
            JSONObject jSONObjectR = r(context);
            if (jSONObjectR == null) {
                return null;
            }
            if (jSONObjectR.length() > 0) {
                return jSONObjectR;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject h(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f16548r);
            arrayList.add(f16549s);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject i(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f16552v);
            arrayList.add(f16553w);
            arrayList.add(J);
            arrayList.add(K);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject j(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f16554x);
            arrayList.add(f16555y);
            arrayList.add(G);
            arrayList.add(H);
            arrayList.add(I);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject k(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f16556z);
            arrayList.add(A);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject l(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(B);
            arrayList.add(C);
            arrayList.add(D);
            arrayList.add(E);
            arrayList.add(F);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject m(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f16550t);
            arrayList.add(f16551u);
            JSONObject jSONObjectA = a(context, arrayList);
            if (jSONObjectA == null) {
                return null;
            }
            if (jSONObjectA.length() > 0) {
                return jSONObjectA;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
