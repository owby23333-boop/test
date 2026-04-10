package com.getkeepsafe.relinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.getkeepsafe.relinker.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ApkLibraryInstaller.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: com.getkeepsafe.relinker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApkLibraryInstaller.java */
    private static class C0313a {
        public ZipFile a;
        public ZipEntry b;

        public C0313a(ZipFile zipFile, ZipEntry zipEntry) {
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    private String[] a(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    private C0313a a(Context context, String[] strArr, String str, c cVar) {
        String[] strArrA = a(context);
        int length = strArrA.length;
        char c2 = 0;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArrA[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c2] = str3;
                            objArr[1] = str2;
                            cVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C0313a(zipFile, entry);
                            }
                            i7++;
                            c2 = 0;
                        }
                        i5 = i6;
                        c2 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c2 = 0;
        }
    }

    private String[] a(Context context, String str) {
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : a(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // com.getkeepsafe.relinker.b.a
    @SuppressLint({"SetWorldReadable"})
    public void a(Context context, String[] strArr, String str, File file, c cVar) throws Throwable {
        C0313a c0313aA;
        String[] strArrA;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jA;
        Closeable closeable = null;
        try {
            c0313aA = a(context, strArr, str, cVar);
            try {
                if (c0313aA == null) {
                    try {
                        strArrA = a(context, str);
                    } catch (Exception e2) {
                        strArrA = new String[]{e2.toString()};
                    }
                    throw new MissingLibraryException(str, strArr, strArrA);
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 < 5) {
                        cVar.a("Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = c0313aA.a.getInputStream(c0313aA.b);
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            jA = a(inputStream, fileOutputStream);
                                            fileOutputStream.getFD().sync();
                                        } catch (FileNotFoundException unused) {
                                            a(inputStream);
                                        } catch (IOException unused2) {
                                            a(inputStream);
                                        } catch (Throwable th) {
                                            th = th;
                                            closeable = fileOutputStream;
                                            a(inputStream);
                                            a(closeable);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused3) {
                                        fileOutputStream = null;
                                    } catch (IOException unused4) {
                                        fileOutputStream = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (FileNotFoundException unused5) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (IOException unused6) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = null;
                                }
                                if (jA != file.length()) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                } else {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    if (c0313aA != null) {
                                        try {
                                            if (c0313aA.a != null) {
                                                c0313aA.a.close();
                                                return;
                                            }
                                            return;
                                        } catch (IOException unused7) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                        } catch (IOException unused8) {
                        }
                        i2 = i3;
                    } else {
                        cVar.a("FATAL! Couldn't extract the library from the APK!");
                        if (c0313aA != null) {
                            try {
                                if (c0313aA.a != null) {
                                    c0313aA.a.close();
                                    return;
                                }
                                return;
                            } catch (IOException unused9) {
                                return;
                            }
                        }
                        return;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (c0313aA != null) {
                    try {
                        if (c0313aA.a != null) {
                            c0313aA.a.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            c0313aA = null;
        }
    }

    private long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                outputStream.flush();
                return j2;
            }
            outputStream.write(bArr, 0, i2);
            j2 += (long) i2;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
