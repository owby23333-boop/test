package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import ms.bz.bd.c.Pgl.pblt;

/* JADX INFO: loaded from: classes9.dex */
public class pblr implements pblt.pgla {

    public static class pgla {
        public ZipEntry bf;
        public ZipFile e;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.e = zipFile;
            this.bf = zipEntry;
        }
    }

    private void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    private String[] e(Context context, String str) {
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        ZipFile zipFile = null;
        for (String str2 : e(context)) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException unused) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private pgla e(Context context, String[] strArr, String str, pblu pbluVar) {
        String[] strArrE = e(context);
        int length = strArrE.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArrE[i2];
            int i3 = i;
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
                int i5 = i;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = i;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i] = str3;
                            objArr[1] = str2;
                            pbluVar.getClass();
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new pgla(zipFile, entry);
                            }
                            i7++;
                            i = 0;
                        }
                        i5 = i6;
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
            i = 0;
        }
    }

    public void e(Context context, String[] strArr, String str, File file, pblu pbluVar) throws Throwable {
        String[] strArrE;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        pgla pglaVar = null;
        closeable = null;
        Closeable closeable = null;
        try {
            pgla pglaVarE = e(context, strArr, str, pbluVar);
            try {
                if (pglaVarE == null) {
                    try {
                        strArrE = e(context, str);
                    } catch (Exception e) {
                        strArrE = new String[]{e.toString()};
                    }
                    throw new pbls(str, strArr, strArrE);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        try {
                            ZipFile zipFile = pglaVarE.e;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    String.format(Locale.US, "Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = pglaVarE.e.getInputStream(pglaVarE.bf);
                            } catch (FileNotFoundException | IOException unused2) {
                                inputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = null;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    try {
                                        byte[] bArr = new byte[4096];
                                        long j = 0;
                                        while (true) {
                                            int i3 = inputStream.read(bArr);
                                            if (i3 == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i3);
                                            j += (long) i3;
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        if (j == file.length()) {
                                            e(inputStream);
                                            e(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            try {
                                                ZipFile zipFile2 = pglaVarE.e;
                                                if (zipFile2 != null) {
                                                    zipFile2.close();
                                                    return;
                                                }
                                                return;
                                            } catch (IOException unused3) {
                                                return;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        closeable = fileOutputStream;
                                        e(inputStream);
                                        e(closeable);
                                        throw th;
                                    }
                                } catch (FileNotFoundException | IOException unused4) {
                                }
                            } catch (FileNotFoundException | IOException unused5) {
                                fileOutputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            e(inputStream);
                            e(fileOutputStream);
                        }
                    } catch (IOException unused6) {
                    }
                    i = i2;
                }
            } catch (Throwable th5) {
                th = th5;
                pglaVar = pglaVarE;
                if (pglaVar != null) {
                    try {
                        ZipFile zipFile3 = pglaVar.e;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
