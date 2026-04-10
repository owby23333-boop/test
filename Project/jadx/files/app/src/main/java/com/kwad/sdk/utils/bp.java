package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class bp {

    public static class a extends ZipOutputStream {
        private Map<String, Integer> aAC;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aAC = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) throws IOException {
            ZipEntry zipEntry2;
            Integer numValueOf;
            String name = zipEntry.getName();
            Integer num = this.aAC.get(name);
            if (num == null || num.intValue() <= 0) {
                zipEntry2 = zipEntry;
                numValueOf = 1;
            } else {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", com.umeng.message.proguard.ad.f20405r + num + ")."));
                numValueOf = Integer.valueOf(num.intValue() + 1);
            }
            this.aAC.put(name, numValueOf);
            super.putNextEntry(zipEntry2);
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) throws IOException {
        BufferedInputStream bufferedInputStream;
        File[] fileArrListFiles;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.d.b.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
            return;
        }
        if (!file.exists()) {
            com.kwad.sdk.core.d.b.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
            return;
        }
        String strEF = TextUtils.isEmpty(str) ? eF(file.getName()) : str + File.separator + eF(file.getName());
        if (!file.isFile()) {
            if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                a(zipOutputStream, file2, strEF, bArr);
            }
            return;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                zipOutputStream.putNextEntry(new ZipEntry(strEF));
                while (true) {
                    int i2 = bufferedInputStream.read(bArr, 0, bArr.length);
                    if (-1 == i2) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i2);
                }
            } catch (IOException e2) {
                e = e2;
                com.kwad.sdk.core.d.b.e("ZipUtils", "error doZip", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        }
    }

    private static boolean a(File[] fileArr, File file) throws Throwable {
        boolean z2 = false;
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            try {
                byte[] bArr = new byte[4096];
                a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
                for (int i2 = 0; i2 <= 0; i2++) {
                    try {
                        a(aVar2, fileArr[0], null, bArr);
                    } catch (IOException e2) {
                        e = e2;
                        aVar = aVar2;
                        com.kwad.sdk.core.d.b.e("ZipUtils", "error zip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        return z2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        throw th;
                    }
                }
                aVar2.flush();
                aVar2.closeEntry();
                com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
                z2 = true;
            } catch (IOException e3) {
                e = e3;
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String eF(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    public static boolean unZip(InputStream inputStream, String str) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                            String name = nextEntry.getName();
                            if (!name.contains("../")) {
                                if (nextEntry.isDirectory()) {
                                    new File(str + "/" + name).mkdirs();
                                } else {
                                    File file2 = new File(str + "/" + name);
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                        while (true) {
                                            try {
                                                try {
                                                    int i2 = zipInputStream.read(bArr);
                                                    if (i2 == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, i2);
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip when write", e);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                throw th;
                                            }
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                    } catch (IOException e3) {
                                        e = e3;
                                        fileOutputStream = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = null;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                    zipInputStream.closeEntry();
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        zipInputStream2 = zipInputStream;
                        com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipInputStream = zipInputStream2;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (IOException e6) {
            e = e6;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            zipInputStream = null;
            bufferedInputStream = null;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }
}
