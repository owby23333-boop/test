package com.anythink.expressad.atsignalcommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    private static final String[] a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};
    private static final Pattern b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f8335c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f8336d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f8337e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, String> f8338f = new HashMap();

    static {
        for (h hVar : h.values()) {
            f8338f.put(hVar.a(), hVar.b());
        }
    }

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Pattern b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return f8337e;
        }
        if ("mraid:".equals(str)) {
            return f8335c;
        }
        if ("ssp:".equals(str)) {
            return f8336d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return f8337e;
        }
        return null;
    }

    public static String c(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            boolean z2 = true;
            if (cCharAt > 255) {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(cCharAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(cCharAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= 2) {
                        z2 = false;
                        break;
                    }
                    if (cArr[i3] == cCharAt) {
                        stringBuffer.append("\\".concat(String.valueOf(cCharAt)));
                        break;
                    }
                    i3++;
                }
                if (!z2) {
                    stringBuffer.append(cCharAt);
                }
            }
        }
        return new String(stringBuffer);
    }

    public static boolean d(String str) {
        return e(str).startsWith(c.C0205c.f10205e);
    }

    public static String e(String str) {
        String str2 = f8338f.get(f(str));
        return str2 == null ? "" : str2;
    }

    private static String f(String str) {
        String path;
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (iLastIndexOf = path.lastIndexOf(".")) == -1) ? "" : path.substring(iLastIndexOf + 1);
    }
}
