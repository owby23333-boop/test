package com.kwai.sodler.lib.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.p;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static File a(File file, String str, File file2) throws IOException {
        String strTM = a.tM();
        File file3 = null;
        if (TextUtils.isEmpty(strTM)) {
            com.kwai.sodler.lib.a.w("plugin.so", "Cpu abis is null.");
        } else {
            new StringBuilder("Try install soLib, supported abi = ").append(strTM);
            File file4 = new File(file, "lib" + File.separator + strTM + File.separator + str);
            if (file4.exists()) {
                File file5 = new File(file2, str);
                if (!file4.renameTo(file5)) {
                    throw new IOException("Rename soLib fail.");
                }
                StringBuilder sb = new StringBuilder("Rename soLib, from = ");
                sb.append(file4.getAbsolutePath());
                sb.append(", to = ");
                sb.append(file5.getAbsolutePath());
                file3 = file5;
            }
        }
        if (file3 == null) {
            StringBuilder sb2 = new StringBuilder("Can not install ");
            sb2.append(str);
            sb2.append(", NO_MATCHING_ABIS");
        }
        return file3;
    }

    public static Set<String> h(File file, File file2) throws Throwable {
        ZipFile zipFile;
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        p.S(file2);
        StringBuilder sb = new StringBuilder("copy so file to ");
        sb.append(file2.getAbsolutePath());
        sb.append(", apk = ");
        sb.append(file.getName());
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                closeable = null;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        if (name != null && !name.contains("../")) {
                            if (!name.startsWith("lib" + File.separator)) {
                                new StringBuilder("not lib dir entry, skip ").append(name);
                            } else if (zipEntryNextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                new StringBuilder("create dir ").append(file3.getAbsolutePath());
                                p.S(file3);
                            } else {
                                File file4 = new File(file2, name);
                                new StringBuilder("unzip soLib file ").append(file4.getAbsolutePath());
                                p.T(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                                        while (true) {
                                            try {
                                                int i2 = bufferedInputStream.read(bArr);
                                                if (i2 == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, i2);
                                            } catch (IOException e2) {
                                                e = e2;
                                                zipFile2 = zipFile;
                                                closeable = bufferedOutputStream;
                                                try {
                                                    com.kwai.sodler.lib.a.e("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile2;
                                                    bufferedInputStream2 = bufferedInputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedInputStream2 = bufferedInputStream;
                                                closeable = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                        hashSet.add(file4.getName());
                                        bufferedInputStream2 = bufferedInputStream;
                                        closeable = bufferedOutputStream;
                                    } catch (IOException e3) {
                                        e = e3;
                                        bufferedInputStream = bufferedInputStream2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    closeable = fileOutputStream;
                                    bufferedInputStream = bufferedInputStream2;
                                    zipFile2 = zipFile;
                                    com.kwai.sodler.lib.a.e("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                return hashSet;
            } catch (IOException e6) {
                e = e6;
                closeable = null;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                closeable = null;
            }
        } catch (IOException e7) {
            e = e7;
            closeable = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            closeable = null;
        }
    }
}
