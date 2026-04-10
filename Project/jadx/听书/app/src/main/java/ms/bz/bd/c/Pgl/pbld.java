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
import ms.bz.bd.c.Pgl.e1;

/* JADX INFO: loaded from: classes4.dex */
public final class pbld implements e1.pgla {

    private static class pgla {
        public ZipEntry g;
        public ZipFile z;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.z = zipFile;
            this.g = zipEntry;
        }
    }

    private static pgla z(Context context, String[] strArr, String str, g1 g1Var) {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        int i = 0;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArr2[i2];
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
                            g1Var.getClass();
                            String.format(Locale.US, "Looking for %s in APK %s...", str3, str2);
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

    private static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String[] z(Context context, String str) {
        String[] strArr;
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr2 = applicationInfo.splitSourceDirs;
        if (strArr2 == null || strArr2.length == 0) {
            strArr = new String[]{applicationInfo.sourceDir};
        } else {
            strArr = new String[strArr2.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr2, 0, strArr, 1, strArr2.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr) {
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

    public final void z(Context context, String[] strArr, String str, File file, g1 g1Var) {
        pgla pglaVarZ;
        String[] strArrZ;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        pgla pglaVar = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            pglaVarZ = z(context, strArr, str, g1Var);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (pglaVarZ == null) {
                try {
                    strArrZ = z(context, str);
                } catch (Exception e) {
                    strArrZ = new String[]{e.toString()};
                }
                throw new y0(str, strArr, strArrZ);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    g1Var.getClass();
                    try {
                        ZipFile zipFile = pglaVarZ.z;
                        if (zipFile != null) {
                            zipFile.close();
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                g1Var.getClass();
                String.format(Locale.US, "Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = pglaVarZ.z.getInputStream(pglaVarZ.g);
                        } catch (FileNotFoundException | IOException unused2) {
                            inputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (FileNotFoundException | IOException unused3) {
                            fileOutputStream = null;
                            z(inputStream);
                            z(fileOutputStream);
                            i = i2;
                        } catch (Throwable th4) {
                            th = th4;
                        }
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
                                    z(inputStream);
                                    z(fileOutputStream);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    try {
                                        ZipFile zipFile2 = pglaVarZ.z;
                                        if (zipFile2 != null) {
                                            zipFile2.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused4) {
                                        return;
                                    }
                                }
                                z(inputStream);
                                z(fileOutputStream);
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream2 = fileOutputStream;
                                z(inputStream);
                                z(fileOutputStream2);
                                throw th;
                            }
                        } catch (FileNotFoundException | IOException unused5) {
                            z(inputStream);
                            z(fileOutputStream);
                        }
                    }
                } catch (IOException unused6) {
                }
                i = i2;
            }
        } catch (Throwable th6) {
            th = th6;
            pglaVar = pglaVarZ;
            if (pglaVar != null) {
                try {
                    ZipFile zipFile3 = pglaVar.z;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }
}
