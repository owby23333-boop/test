package com.bytedance.sdk.component.adexpress.z.g;

import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static com.bytedance.sdk.component.adexpress.z.dl.z z;

    public static void z() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(gc.e(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.z.dl.z zVarZ = com.bytedance.sdk.component.adexpress.z.dl.z.z(new JSONObject(new String(bArr, "utf-8")));
                    if (zVarZ != null) {
                        z = zVarZ;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        wp.dl("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.z.dl.z g() {
        return z;
    }

    public static synchronized void z(com.bytedance.sdk.component.adexpress.z.dl.z zVar) {
        if (zVar != null) {
            if (zVar.m()) {
                z = zVar;
            }
        }
    }

    public static void dl() {
        gc.z(gc.e(), g(), "temp_pkg_info.json");
    }

    public static boolean z(String str) {
        return gc.z(g(), str);
    }

    public static boolean g(com.bytedance.sdk.component.adexpress.z.dl.z zVar) {
        return gc.dl(g(), zVar);
    }

    public static void a() {
        gc.g(gc.e(), g(), "temp_pkg_info.json");
        z = null;
    }
}
