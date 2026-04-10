package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
final class b {
    static boolean b(Context context, String str, String str2) throws Exception {
        String strL = h.l(context, str2);
        c(new File(strL));
        String strN = h.n(context, str2);
        String strO = h.o(context, str2);
        String strP = h.p(context, str2);
        try {
            o(str, strN);
            p(str, strP);
            return k.b(context, strN, strO, strP).tD() != null;
        } catch (Exception e2) {
            c(new File(strN));
            c(new File(strO));
            c(new File(strP));
            c(new File(strL));
            throw e2;
        }
    }

    private static void c(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            c(file2);
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused2) {
            }
        } finally {
        }
    }

    private static void o(String str, String str2) {
        d(new FileInputStream(str), new FileOutputStream(str2));
    }

    private static void p(String str, String str2) throws Throwable {
        ZipFile zipFile;
        String str3 = w.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.isDirectory()) {
                    String name = zipEntryNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                        d(zipFile.getInputStream(zipEntryNextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
            }
            try {
                zipFile.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
