package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.m;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.gz;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.uy;
import com.bytedance.pangle.z.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static final uy z = uy.z();

    static boolean z(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            uy uyVar = z;
            uyVar.z(1000, 0, str, i, null);
            com.bytedance.pangle.log.z zVarZ = com.bytedance.pangle.log.z.z(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            z(com.bytedance.pangle.a.g.f505a, g.z.fv, str, i, -1L, null);
            g(str, i);
            e.z(com.bytedance.pangle.gc.dl.z(str, i));
            com.bytedance.pangle.z.z.z(false, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.dl.1
                @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                public void z() throws Throwable {
                    dl.m(file, str, i, stringBuffer);
                }
            }, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.dl.2
                @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                public void z() throws Throwable {
                    final Map mapE = dl.e(file, str, i, stringBuffer);
                    dl.gz(file, str, i, stringBuffer);
                    dl.g(dl.fo(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (fo.gz() || fo.dl()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.z.z.z(false, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.dl.2.1
                            @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                            public void z() throws Throwable {
                                dl.g(str, i, (Map<String, List<ZipEntry>>) mapE, stringBuffer);
                            }
                        }, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.dl.2.2
                            @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                            public void z() throws Throwable {
                                zArr2[0] = dl.uy(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = dl.g(str, i, zArr2[0], stringBuffer);
                    } else {
                        dl.g(str, i, (Map<String, List<ZipEntry>>) mapE, stringBuffer);
                        zArr[0] = dl.g(str, i, false, stringBuffer);
                        dl.dl(str, i);
                    }
                }
            });
            e.z(file);
            z(com.bytedance.pangle.a.g.gc, g.z.js, str, i, zVarZ.z(), stringBuffer.toString());
            zVarZ.z("success");
            uyVar.z(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof z) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                z(com.bytedance.pangle.a.g.gc, g.z.tb, str, i, -1L, stringBuffer.toString());
                z.z(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                i.z().z(str, i, "install");
            }
            return false;
        }
    }

    private static void g(String str, int i) {
        int iG = i.z().g(str, i, "install");
        int iG2 = i.z().g(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iG > 3 || iG2 > 3) {
            removeApkEntryFlag = 0;
        }
        i.z().z(str, i, removeApkEntryFlag);
        i.z().a(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(String str, int i, boolean z2, StringBuffer stringBuffer) {
        int iFo = i.z().fo(str, i);
        boolean z3 = (iFo & 1) != 0;
        boolean z4 = (iFo & 2) != 0;
        if (!z3 && !z4) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z5 = z2 && z3;
        String strG = com.bytedance.pangle.gc.dl.g(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z6 = com.bytedance.pangle.util.g.g.z(strG, z5, z4, str, i, 1);
        stringBuffer.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str, String str2, int i, StringBuffer stringBuffer) throws z {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iZ = new com.bytedance.pangle.res.z.dl().z(new File(str), false, sb);
        stringBuffer.append(iZ == 100 ? "modifyRes" : "noModifyRes").append(" cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        if (iZ == 100 || iZ == 200) {
            return;
        }
        String string = sb.toString();
        z(com.bytedance.pangle.a.g.gc, g.z.l, str2, i, -1L, string);
        z.z(1100, -2, str2, i, null);
        throw new z("modifyRes failed. result = " + iZ + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(File file, String str, int i, StringBuffer stringBuffer) throws z {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (com.bytedance.pangle.gz.gc.z(file.getAbsolutePath(), str, sb)) {
                    return;
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
                }
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.q, str, i, -1L, Log.getStackTraceString(e));
                z.z(1100, -3, str, i, e);
                throw new z(e.getMessage(), e);
            }
        } finally {
            stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
        stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> e(File file, String str, int i, StringBuffer stringBuffer) throws z {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.gc<Boolean, Map<String, List<ZipEntry>>> gcVarZ = com.bytedance.pangle.gc.g.z(file);
                boolean zBooleanValue = gcVarZ.z.booleanValue();
                Map<String, List<ZipEntry>> map = gcVarZ.g;
                if (zBooleanValue) {
                    return map;
                }
                throw new z(str2);
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.hh, str, i, -1L, null);
                z.z(1100, -5, str, i, e);
                throw new z(str2, e);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gz(File file, String str, int i, StringBuffer stringBuffer) throws z {
        PackageInfo packageArchiveInfo;
        List listAsList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                listAsList = Arrays.asList(packageInfo.requestedPermissions);
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.iq, str, i, -1L, null);
                z.z(1100, -4, str, i, e);
                throw new z("安装包权限校验失败", e);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
        if (packageArchiveInfo.requestedPermissions != null && packageArchiveInfo.requestedPermissions.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : packageArchiveInfo.requestedPermissions) {
                if (!listAsList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (!arrayList.isEmpty()) {
                ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                if (GlobalParam.getInstance().checkPermission()) {
                    throw new z("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                }
                stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fo(File file, String str, int i, StringBuffer stringBuffer) throws z {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strG = com.bytedance.pangle.gc.dl.g(str, i);
        try {
            try {
                gz.z(file.getAbsolutePath(), strG);
                return strG;
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.zw, str, i, -1L, null);
                z.z(1100, -6, str, i, e);
                throw new z("安装包拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws z {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.gc.g.z(new File(com.bytedance.pangle.gc.dl.g(str, i)), new File(com.bytedance.pangle.gc.dl.a(str, i)), str, map);
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.io, str, i, -1L, com.bytedance.pangle.log.g.z((Object) e));
                z.z(1100, -7, str, i, e);
                throw new z("安装包动态库拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uy(File file, String str, int i, StringBuffer stringBuffer) throws z {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (fo.dl()) {
                    com.bytedance.pangle.m.e.z(file, str, i);
                    com.bytedance.pangle.m.g.z(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                    m.z();
                } else if (fo.gz()) {
                    String strDl = com.bytedance.pangle.gc.dl.dl(str, i);
                    String strG = com.bytedance.pangle.gc.dl.g(str, i);
                    String str2 = strDl + File.separator + com.bytedance.pangle.m.g.z(strG);
                    if (com.bytedance.pangle.m.g.z(strG, strDl + File.separator + com.bytedance.pangle.m.g.z(strG)) && com.bytedance.pangle.m.g.z(str2)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                z(com.bytedance.pangle.a.g.gc, g.z.sy, str, i, -1L, null);
                throw new z("dexOpt1失败", e);
            }
        } finally {
            stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(String str, int i) throws z {
        try {
            if (fo.e() || fo.fo()) {
                i.z().dl(str, i, false);
                com.bytedance.pangle.m.g.z(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                m.z();
            }
        } catch (Exception e) {
            z(com.bytedance.pangle.a.g.gc, g.z.sy, str, i, -1L, null);
            throw new z("dexOpt2失败", e);
        }
    }

    public static void z(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.g.z(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.g.z(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.g.z(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.g.g(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.g.z(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
        }
        com.bytedance.pangle.a.g.z().z(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static class z extends IOException {
        private z(String str) {
            super(str);
        }

        private z(String str, Throwable th) {
            super(str, th);
        }
    }
}
