package com.bytedance.pangle.util.z;

import android.text.TextUtils;
import com.bytedance.pangle.util.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String[] z(File file) throws Throwable {
        String strZ;
        String str;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith("META-INF/")) {
                        if (zipEntryNextElement.getName().endsWith("MANIFEST.MF")) {
                            z3 = true;
                        } else if (zipEntryNextElement.getName().endsWith(".SF")) {
                            z = true;
                        } else if (zipEntryNextElement.getName().endsWith(".RSA")) {
                            z2 = true;
                        }
                        arrayList.add(Long.valueOf(zipEntryNextElement.getCrc()));
                    }
                }
                Collections.sort(arrayList, Collections.reverseOrder());
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((Long) it.next());
                }
                if (z3 && z && z2) {
                    strZ = m.z(sb.toString());
                    str = "";
                } else {
                    str = "without v1 signature.";
                    strZ = "";
                }
                dl.z(zipFile2);
            } catch (Exception unused) {
                zipFile = zipFile2;
                dl.z(zipFile);
                strZ = "";
                str = strZ;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                dl.z(zipFile);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        String[] strArr = new String[3];
        strArr[0] = strZ;
        strArr[1] = TextUtils.isEmpty(strZ) ? "" : "V1";
        strArr[2] = str;
        return strArr;
    }
}
