package com.bytedance.pangle.e.z;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static String z(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static gc z(File file) {
        ZipFile zipFile;
        z zVar;
        PackageInfo packageArchiveInfo;
        int iG;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                e.z((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    e.z(zipFile2);
                    return null;
                }
                zVar = new z();
                try {
                    zVar.z(zipFile2.getInputStream(entry));
                    do {
                        iG = zVar.g();
                        if (iG == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                zVar.z();
                            } catch (Throwable unused) {
                            }
                            e.z(zipFile2);
                            return null;
                        }
                    } while (iG != 2);
                    int iDl = zVar.dl();
                    String strZ = null;
                    String strZ2 = null;
                    for (int i2 = 0; i2 != iDl; i2++) {
                        if (DefaultUpdateParser.APIKeyLower.VERSION_CODE.equals(zVar.z(i2))) {
                            strZ = z(zVar, i2);
                        } else if ("package".equals(zVar.z(i2))) {
                            strZ2 = z(zVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strZ);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strZ)));
                        try {
                            zVar.z();
                        } catch (Throwable unused3) {
                        }
                        e.z(zipFile2);
                        return null;
                    }
                    gc gcVar = new gc(strZ2, i);
                    try {
                        zVar.z();
                    } catch (Throwable unused4) {
                    }
                    e.z(zipFile2);
                    return gcVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable unused5) {
                        packageArchiveInfo = null;
                    }
                    try {
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        gc gcVar2 = new gc(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (zVar != null) {
                            try {
                                zVar.z();
                            } catch (Throwable unused6) {
                            }
                        }
                        e.z(zipFile);
                        return gcVar2;
                    } finally {
                        if (zVar != null) {
                            try {
                                zVar.z();
                            } catch (Throwable unused7) {
                            }
                        }
                        e.z(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            zVar = null;
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
}
