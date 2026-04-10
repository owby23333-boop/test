package com.ss.android.socialbase.appdownloader.m.z;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc {
    private static String z(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo z(File file) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        int iG;
        long j;
        z zVar = null;
        String strZ = null;
        zVar = null;
        zVar = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                while (true) {
                    nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream = null;
                        break;
                    }
                    if (nextEntry.isDirectory()) {
                        try {
                            zipInputStream2.closeEntry();
                        } catch (Throwable unused) {
                        }
                    } else {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipInputStream = zipInputStream2;
                            break;
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                if (nextEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            z zVar2 = new z();
                            try {
                                zVar2.z(zipInputStream);
                                do {
                                    iG = zVar2.g();
                                    if (iG == 1) {
                                        throw new dl("已达到END_DOCUMENT");
                                    }
                                } while (iG != 2);
                                int iGc = zVar2.gc();
                                String strZ2 = null;
                                String strZ3 = null;
                                for (int i = 0; i != iGc; i++) {
                                    if (DefaultUpdateParser.APIKeyLower.VERSION_NAME.equals(zVar2.z(i))) {
                                        strZ3 = z(zVar2, i);
                                    } else if (DefaultUpdateParser.APIKeyLower.VERSION_CODE.equals(zVar2.z(i))) {
                                        strZ = z(zVar2, i);
                                    } else if ("package".equals(zVar2.z(i))) {
                                        strZ2 = z(zVar2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(strZ);
                                } catch (dl unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new dl("versionCode获取失败: ".concat(String.valueOf(strZ)));
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = strZ3;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = strZ2;
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    zVar2.z();
                                } catch (Throwable unused4) {
                                }
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused6) {
                                }
                                return packageInfo;
                            } catch (Throwable th) {
                                th = th;
                                zVar = zVar2;
                                try {
                                    throw new dl("throwable: " + th.getMessage() + th.toString());
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw new dl("没有找到AndroidManifest.xml entry");
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            zipInputStream = null;
        }
    }

    public static PackageInfo z(Context context, File file, int i) {
        com.ss.android.socialbase.downloader.pf.z.z(268435456);
        return g(context, file, i);
    }

    private static PackageInfo g(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            z("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            z("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void z(String str, String str2) {
        if (com.ss.android.socialbase.downloader.downloader.dl.m() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
        }
    }

    private static String z(z zVar, int i) {
        int iG = zVar.g(i);
        int iDl = zVar.dl(i);
        if (iG == 3) {
            return zVar.a(i);
        }
        if (iG == 2) {
            return String.format("?%s%08X", z(iDl), Integer.valueOf(iDl));
        }
        if (iG >= 16 && iG <= 31) {
            return String.valueOf(iDl);
        }
        return String.format("<0x%X, type 0x%02X>", Integer.valueOf(iDl), Integer.valueOf(iG));
    }

    public static String z(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            z("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
