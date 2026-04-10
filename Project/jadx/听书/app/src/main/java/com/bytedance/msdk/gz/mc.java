package com.bytedance.msdk.gz;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f491a = "ToolUtils";
    private static String dl;
    private static String g;
    private static String z;

    public static synchronized String z() {
        if (TextUtils.isEmpty(z) && com.bytedance.msdk.core.g.getContext() != null) {
            try {
                z = com.bytedance.msdk.core.g.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.a(f491a, "ToolUtils getPackageName throws exception :" + th);
            }
        }
        return z;
    }

    public static synchronized String g() {
        if (TextUtils.isEmpty(g) && com.bytedance.msdk.core.g.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.msdk.core.g.getContext().getPackageManager().getPackageInfo(z(), 0);
                g = String.valueOf(packageInfo.versionCode);
                dl = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.a(f491a, "ToolUtils getVersionCode throws exception :" + th);
            }
        }
        return g;
    }

    public static synchronized String dl() {
        if (TextUtils.isEmpty(dl) && com.bytedance.msdk.core.g.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.msdk.core.g.getContext().getPackageManager().getPackageInfo(z(), 0);
                g = String.valueOf(packageInfo.versionCode);
                dl = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.a(f491a, "ToolUtils getVersionName throws exception :" + th);
            }
        }
        return dl;
    }

    public static String a() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String z(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return z.g(str.substring(17), dl(str.substring(1, 17)));
    }

    private static String dl(String str) {
        String strZ = z.z(str);
        if (str != null) {
            return strZ;
        }
        String strZ2 = g.z();
        return strZ2.concat(strZ2).substring(8, 24);
    }

    public static String gc() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return i.z(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean z(com.bytedance.sdk.component.fo.g gVar) {
        if (gVar == null || !com.bytedance.sdk.component.fo.a.z.z(gVar.dl())) {
            return (gVar == null || gVar.a() == null || gVar.a().startsWith("{") || gVar.a().endsWith("}")) ? false : true;
        }
        return true;
    }

    public static String z(byte[] bArr) {
        com.bytedance.sdk.component.a.z zVarM;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (zVarM = m()) == null) {
                    return null;
                }
                String strG = com.bytedance.sdk.openadsdk.core.un.i.g(zVarM.decrypt(bArr));
                if (TextUtils.isEmpty(strG)) {
                    return null;
                }
                return strG;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return null;
    }

    public static byte[] g(String str) {
        com.bytedance.sdk.component.a.z zVarM = m();
        if (zVarM == null) {
            return null;
        }
        return zVarM.encrypt(a(str));
    }

    private static byte[] a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.wp.z(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                com.bytedance.sdk.component.utils.wp.z(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            com.bytedance.sdk.component.utils.wp.z(e4);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static JSONObject z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strZ = z.z();
                String str = "2" + strZ + z.z(jSONObject.toString(), z.z(strZ));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static com.bytedance.sdk.component.a.z m() {
        return (com.bytedance.sdk.component.a.z) com.bytedance.sdk.openadsdk.ats.dl.z("armor_service");
    }
}
