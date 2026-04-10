package com.bytedance.sdk.openadsdk.hh;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kwad.sdk.collector.AppStatusRules;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static boolean dl = z().exists();
    private static Method g;
    private static Boolean z;

    public static File z() {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext()), ".csj_so");
    }

    public static void z(String str) {
        try {
            if (dl && g(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            z(str, th);
        }
    }

    private static boolean g(String str) {
        try {
            if (g == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                g = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) m.class.getClassLoader();
            if (g != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (m.class) {
                    g.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            dl = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, "lock load failed!");
            } catch (JSONException unused) {
            }
            v.z().z("so_load_fail", jSONObject, th);
        }
        return false;
    }

    private static boolean z(String str, Throwable th) {
        String strM = gk.m();
        String str2 = "lib" + str + ".so";
        File file = new File(strM, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return z(str, file.getAbsolutePath());
        }
        File file2 = new File(strM, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            z(file2, file, str2);
            File file3 = new File(strM, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return z(str, file3.getAbsolutePath());
                }
            }
            z(str, str2 + " unzip failed !", th);
            return false;
        }
        z(str, "load so filed! apk not exist! ", th);
        return false;
    }

    private static boolean z(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            z(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void z(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.bytedance.sdk.openadsdk.core.hh.g.g.z() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i != -1) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                } else {
                                    com.bytedance.sdk.component.m.dl.dl.g.z(bufferedInputStream);
                                    com.bytedance.sdk.component.m.dl.dl.g.z(bufferedOutputStream);
                                    com.bytedance.sdk.component.m.dl.dl.g.z(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.bytedance.sdk.component.m.dl.dl.g.z(bufferedInputStream);
                            com.bytedance.sdk.component.m.dl.dl.g.z(bufferedOutputStream);
                            com.bytedance.sdk.component.m.dl.dl.g.z(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable th6) {
            wp.g("SoLoaderUtil", th6);
        }
    }

    private static void z(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            q.z = false;
        }
        if (g()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str2);
        } catch (JSONException unused) {
        }
        v.z().z("so_load_fail", jSONObject, th);
    }

    public static boolean g() {
        Boolean bool = z;
        if (bool != null) {
            return bool.booleanValue();
        }
        z = Boolean.FALSE;
        try {
            Context context = zw.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                z = Boolean.TRUE;
            }
        } catch (Exception e) {
            wp.g("SoLoaderUtil", e);
        }
        return z.booleanValue();
    }
}
