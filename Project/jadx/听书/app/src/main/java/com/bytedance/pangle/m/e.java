package com.bytedance.pangle.m;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void z(File file, String str, int i) throws Throwable {
        ZipFile zipFile;
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            File file2 = new File(com.bytedance.pangle.gc.dl.fo(str, i));
            z(file2);
            int i2 = 1;
            int i3 = 1;
            while (true) {
                Object objValueOf = "";
                ZipEntry entry = zipFile.getEntry(str3 + (i3 == i2 ? "" : Integer.valueOf(i3)) + str2);
                if (entry != null) {
                    StringBuilder sbAppend = new StringBuilder().append(str3);
                    if (i3 != i2) {
                        objValueOf = Integer.valueOf(i3);
                    }
                    z zVar = new z(file2, sbAppend.append(objValueOf).append(str2).toString());
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < 3 && i5 == 0) {
                        try {
                            z(zipFile, entry, zVar, str3);
                            i5 = i2;
                        } catch (IOException e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + zVar.getAbsolutePath(), e);
                        }
                        i4++;
                        String str4 = str2;
                        String str5 = str3;
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Extraction " + (i5 != 0 ? "succeeded" : "failed") + " '" + zVar.getAbsolutePath() + "': length " + zVar.length());
                        if (i5 == 0) {
                            zVar.delete();
                            if (zVar.exists()) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + zVar.getPath() + "'");
                            }
                        }
                        str2 = str4;
                        str3 = str5;
                        i2 = 1;
                    }
                    String str6 = str2;
                    String str7 = str3;
                    if (i5 == 0) {
                        throw new IOException("Could not create zip file " + zVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                    }
                    arrayList.add(zVar);
                    i3++;
                    str2 = str6;
                    str3 = str7;
                    i2 = 1;
                } else {
                    z(str, i, file.getName(), arrayList);
                    com.bytedance.pangle.util.e.z(zipFile);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            com.bytedance.pangle.util.e.z(zipFile2);
            throw th;
        }
    }

    public static String z(String str, int i) {
        int iG = g(str, i);
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        while (i2 <= iG) {
            sb.append(new z(new File(com.bytedance.pangle.gc.dl.fo(str, i)), i2 == 1 ? "classes.dex" : "classes" + i2 + ".dex").getAbsolutePath()).append(":");
            i2++;
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void z(ZipFile zipFile, ZipEntry zipEntry, z zVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", zVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + zVar.getAbsolutePath() + "\")");
                }
                if (!fileCreateTempFile.renameTo(zVar)) {
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + zVar.getAbsolutePath() + "\"");
                }
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } finally {
            z(inputStream);
            fileCreateTempFile.delete();
        }
    }

    private static void z(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    private static void z(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void z(String str, int i, String str2, List<z> list) {
        String str3 = str + "-" + i;
        SharedPreferences.Editor editorEdit = z().edit();
        editorEdit.putInt(str3 + ".dex.number", list.size());
        editorEdit.commit();
    }

    private static SharedPreferences z() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int g(String str, int i) {
        return z((str + "-" + i) + ".dex.number");
    }

    private static int z(String str) {
        return z().getInt(str, 0);
    }

    private static class z extends File {
        public z(File file, String str) {
            super(file, str);
        }
    }
}
