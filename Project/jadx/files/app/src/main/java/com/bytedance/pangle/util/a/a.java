package com.bytedance.pangle.util.a;

import android.text.TextUtils;
import com.bytedance.pangle.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static String[] a(File file) throws Throwable {
        ZipFile zipFile;
        String strA;
        String str;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement.getName().startsWith("META-INF/")) {
                    if (zipEntryNextElement.getName().endsWith("MANIFEST.MF")) {
                        z4 = true;
                    } else if (zipEntryNextElement.getName().endsWith(".SF")) {
                        z2 = true;
                    } else if (zipEntryNextElement.getName().endsWith(".RSA")) {
                        z3 = true;
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
            if (z4 && z2 && z3) {
                strA = f.a(sb.toString());
                str = "";
            } else {
                str = "without v1 signature.";
                strA = "";
            }
            c.a(zipFile);
        } catch (Exception unused2) {
            zipFile2 = zipFile;
            c.a(zipFile2);
            strA = "";
            str = strA;
        } catch (Throwable th2) {
            th = th2;
            c.a(zipFile);
            throw th;
        }
        String[] strArr = new String[3];
        strArr[0] = strA;
        strArr[1] = TextUtils.isEmpty(strA) ? "" : "V1";
        strArr[2] = str;
        return strArr;
    }
}
