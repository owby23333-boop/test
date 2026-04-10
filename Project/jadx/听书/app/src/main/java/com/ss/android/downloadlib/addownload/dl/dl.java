package com.ss.android.downloadlib.addownload.dl;

import android.content.Context;
import com.kuaishou.weapon.p0.bi;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.downloader.e;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    public static void z() throws Throwable {
        List<com.ss.android.socialbase.downloader.e.dl> listZ = com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext());
        if (listZ == null || listZ.size() <= 0) {
            return;
        }
        for (int i = 0; i < listZ.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVar = listZ.get(i);
            File file = new File(dlVar.wp(), dlVar.i());
            long jLastModified = file.lastModified();
            long jZ = ((long) com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("download_file_expire_hours", 0)) * bi.s;
            if (jZ <= 0) {
                jZ = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jZ) {
                z(file);
                e.g(wp.getContext()).uy(dlVar.e());
            }
        }
    }

    public static void g() throws Throwable {
        List listG = e.g(wp.getContext()).g("application/vnd.android.package-archive");
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i = 0; i < listG.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVar = (com.ss.android.socialbase.downloader.e.dl) listG.get(i);
            if (dlVar != null) {
                String str = dlVar.kb() + File.separator + dlVar.gz();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jZ = ((long) com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("download_complete_file_expire_hours", 0)) * bi.s;
                    if (jZ <= 0) {
                        jZ = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jZ && !i.m(wp.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        z(file);
                    }
                }
            }
        }
    }

    public static void z(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            z(externalCacheDir.getPath());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            goto L28
        L13:
            r0 = move-exception
            goto L1b
        L15:
            r3 = move-exception
            goto L2e
        L17:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1b:
            com.bytedance.sdk.component.utils.wp.z(r0)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r0)
        L28:
            r3.delete()
            return
        L2c:
            r3 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r0)
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.dl.dl.z(java.io.File):void");
    }

    private static void z(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                if (str3 != null) {
                    if (str.endsWith(File.separator)) {
                        str2 = str + str3;
                    } else {
                        str2 = str + File.separator + str3;
                    }
                    File file2 = new File(str2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        z(str2);
                    }
                }
            }
            file.delete();
        }
    }
}
