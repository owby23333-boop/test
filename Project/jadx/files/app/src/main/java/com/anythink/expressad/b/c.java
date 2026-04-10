package com.anythink.expressad.b;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String a = "UnzipUtility";
    private static final int b = 4096;

    public static int a(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        String canonicalPath;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            fileOutputStream = null;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    o.d(a, e2.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    o.d(a, e3.getMessage());
                                }
                            }
                            return 2;
                        }
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                canonicalPath = file2.getCanonicalPath();
                            } catch (IOException unused) {
                                canonicalPath = "";
                            }
                            if (TextUtils.isEmpty(canonicalPath) || canonicalPath.startsWith("..") || canonicalPath.startsWith("../") || !canonicalPath.startsWith(str2)) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e4) {
                                        o.d(a, e4.getMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        o.d(a, e5.getMessage());
                                    }
                                }
                                return 2;
                            }
                            if (zipEntryNextElement.isDirectory()) {
                                file2.mkdirs();
                            } else {
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                try {
                                    inputStream = zipFile.getInputStream(zipEntryNextElement);
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i2 = inputStream.read(bArr, 0, 1024);
                                        if (i2 == -1) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, i2);
                                        fileOutputStream2.flush();
                                    }
                                    fileOutputStream = fileOutputStream2;
                                } catch (IOException e6) {
                                    e = e6;
                                    fileOutputStream = fileOutputStream2;
                                    o.d(a, e.getMessage());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e7) {
                                            o.d(a, e7.getMessage());
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        return 3;
                                    }
                                    try {
                                        fileOutputStream.close();
                                        return 3;
                                    } catch (IOException e8) {
                                        o.d(a, e8.getMessage());
                                        return 3;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e9) {
                                            o.d(a, e9.getMessage());
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        throw th;
                                    }
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e10) {
                                        o.d(a, e10.getMessage());
                                        throw th;
                                    }
                                }
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e11) {
                                o.d(a, e11.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                o.d(a, e12.getMessage());
                            }
                        }
                        return 2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            }
            zipFile.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    o.d(a, e14.getMessage());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e15) {
                    o.d(a, e15.getMessage());
                }
            }
            return 0;
        } catch (IOException e16) {
            e = e16;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static void a(ZipInputStream zipInputStream, String str) throws Throwable {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 != -1) {
                            bufferedOutputStream2.write(bArr, 0, i2);
                        } else {
                            bufferedOutputStream2.close();
                            return;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
