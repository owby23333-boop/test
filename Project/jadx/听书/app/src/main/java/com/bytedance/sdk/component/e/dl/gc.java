package com.bytedance.sdk.component.e.dl;

import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements com.bytedance.sdk.component.e.g, com.bytedance.sdk.component.e.z {
    private static boolean dl;
    private static Method g;
    private static Method z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.component.a.g.z f702a;
    private final boolean gc;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            z = cls.getDeclaredMethod("readMapXml", InputStream.class);
            g = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            z.setAccessible(true);
            g.setAccessible(true);
            dl = true;
        } catch (Exception unused) {
            dl = false;
        }
    }

    public static boolean z() {
        return dl;
    }

    public gc(com.bytedance.sdk.component.a.g.z zVar) {
        this.f702a = zVar;
        this.gc = false;
    }

    public gc(com.bytedance.sdk.component.a.g.z zVar, boolean z2) {
        this.f702a = zVar;
        this.gc = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.e.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> z(java.io.File r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = com.bytedance.sdk.component.e.dl.gc.dl
            if (r0 == 0) goto L70
            boolean r0 = r7.exists()
            if (r0 == 0) goto L70
            boolean r0 = r7.canRead()
            r1 = 0
            if (r0 != 0) goto L21
            java.lang.String r0 = "can't read file "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r0.concat(r7)
            java.lang.String r0 = "PropReaderWriter"
            com.bytedance.sdk.component.utils.wp.g(r0, r7)
            return r1
        L21:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r3 = 49152(0xc000, float:6.8877E-41)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.reflect.Method r2 = com.bytedance.sdk.component.e.dl.gc.z     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            java.lang.Object[] r3 = new java.lang.Object[]{r0}     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            com.bytedance.sdk.component.e.z.g r2 = new com.bytedance.sdk.component.e.z.g     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            r2.<init>()     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            com.bytedance.sdk.component.a.g.z r3 = r6.f702a     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            boolean r4 = r6.gc     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            java.util.Map r7 = r2.z(r1, r3, r4)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L68
            r0.close()     // Catch: java.io.IOException -> L4a
        L4a:
            return r7
        L4b:
            r1 = move-exception
            goto L53
        L4d:
            r7 = move-exception
            goto L6a
        L4f:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L53:
            java.lang.String r2 = "XmlReader"
            java.lang.String r3 = "read file exception: "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.String r7 = r3.concat(r7)     // Catch: java.lang.Throwable -> L68
            com.bytedance.sdk.component.utils.wp.g(r2, r7, r1)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L70
            r0.close()     // Catch: java.io.IOException -> L70
            goto L70
        L68:
            r7 = move-exception
            r1 = r0
        L6a:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6f
        L6f:
            throw r7
        L70:
            java.util.Map r7 = java.util.Collections.emptyMap()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.dl.gc.z(java.io.File):java.util.Map");
    }

    @Override // com.bytedance.sdk.component.e.g
    public void z(Map<String, Object> map, File file) throws Throwable {
        if (!dl || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    g.invoke(null, new com.bytedance.sdk.component.e.z.g().z(map, this.f702a, this.gc), fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    wp.g("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
