package com.bytedance.pangle.dl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a.g;
import com.bytedance.pangle.gc.dl;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.a;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.gz;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.uy;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int z(String str) {
        String strZ;
        File[] fileArrKb;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strZ = dl.z(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strZ).listFiles(new FileFilter() { // from class: com.bytedance.pangle.dl.g.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && i.z().a(str, i2) && (fileArrKb = dl.kb(str, i2)) != null && fileArrKb.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void z(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZ = dl.z(str);
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        final String strConcat = "version-".concat(String.valueOf(i));
        new File(strZ).listFiles(new FileFilter() { // from class: com.bytedance.pangle.dl.g.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !strConcat.equals(file.getName())) {
                    e.z(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        i.z().g(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.pangle.dl.z z(java.io.File r7, java.util.List<java.io.File> r8) throws org.json.JSONException, java.io.IOException {
        /*
            java.lang.String r0 = "Zeus/install_pangle"
            r1 = 0
            if (r7 == 0) goto La7
            if (r8 == 0) goto La7
            int r2 = r8.size()
            if (r2 <= 0) goto La7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L75
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L75
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L75
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L72
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L6f
        L21:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto L2b
            r2.append(r6)     // Catch: java.lang.Throwable -> L6d
            goto L21
        L2b:
            com.bytedance.pangle.uy r6 = com.bytedance.pangle.uy.z()     // Catch: java.lang.Throwable -> L6d
            com.bytedance.pangle.ZeusPluginDecodeCallback r6 = r6.a()     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto L61
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r6.decode(r2)     // Catch: java.lang.Throwable -> L6d
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L6d
            if (r6 != 0) goto L5b
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6d
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = "DexPluginUtils parse dex config json success"
            com.bytedance.pangle.log.ZeusLogger.i(r0, r2)     // Catch: java.lang.Throwable -> L6d
            com.bytedance.pangle.dl.z r7 = com.bytedance.pangle.dl.z.z(r6, r7, r8)     // Catch: java.lang.Throwable -> L6d
            r3.close()
            r4.close()
            r5.close()
            return r7
        L5b:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode content is empty"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L6d
            goto L66
        L61:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode callback is null"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L6d
        L66:
            r3.close()
            r4.close()
            goto L92
        L6d:
            r7 = move-exception
            goto L79
        L6f:
            r7 = move-exception
            r5 = r1
            goto L79
        L72:
            r7 = move-exception
            r4 = r1
            goto L78
        L75:
            r7 = move-exception
            r3 = r1
            r4 = r3
        L78:
            r5 = r4
        L79:
            java.lang.String r8 = "DexPluginUtils parse dex config fail throw error "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r8.concat(r7)     // Catch: java.lang.Throwable -> L96
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L96
            if (r3 == 0) goto L8b
            r3.close()
        L8b:
            if (r4 == 0) goto L90
            r4.close()
        L90:
            if (r5 == 0) goto La7
        L92:
            r5.close()
            goto La7
        L96:
            r7 = move-exception
            if (r3 == 0) goto L9c
            r3.close()
        L9c:
            if (r4 == 0) goto La1
            r4.close()
        La1:
            if (r5 == 0) goto La6
            r5.close()
        La6:
            throw r7
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.dl.g.z(java.io.File, java.util.List):com.bytedance.pangle.dl.z");
    }

    public static boolean z(z zVar, long j) {
        List<File> listA;
        File fileGc;
        if (zVar != null) {
            listA = zVar.a();
            fileGc = zVar.gc();
        } else {
            listA = null;
            fileGc = null;
        }
        if (fileGc != null && listA != null && listA.size() > 0) {
            int iDl = zVar.dl();
            String strG = zVar.g();
            ZeusPluginStateListener.postStateChange(strG, 11, new Object[0]);
            com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.f505a, g.z.fv, strG, iDl, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strG + " version is " + iDl);
            String strKb = i.z().kb(strG);
            if (!TextUtils.isEmpty(strKb) && z(strKb) >= iDl) {
                com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.gc, g.z.tb, strG, iDl, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String strE = TextUtils.isEmpty(zVar.e()) ? strG : zVar.e();
            if (!dl.uy(strE, iDl)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strG + " version=" + iDl);
                    for (File file : listA) {
                        if (file.getName().endsWith(".dex")) {
                            String strZ = dl.z(strE, iDl, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            gz.z(file.getAbsolutePath(), strZ);
                        }
                    }
                    if (fileGc.getName().endsWith(".json")) {
                        String strWp = dl.wp(strE, iDl);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + fileGc.getName());
                        gz.z(fileGc.getAbsolutePath(), strWp);
                    }
                    if (dl.uy(strE, iDl)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strG + " version = " + iDl);
                        ZeusPluginStateListener.postStateChange(strG, 12, new Object[0]);
                        com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.gc, g.z.js, strG, iDl, SystemClock.elapsedRealtime() - j, "install success");
                        i.z().g(strE, iDl, true);
                        if (!TextUtils.isEmpty(zVar.e())) {
                            i.z().dl(strG, strE);
                            i.z().a(strG, strKb);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.gc, g.z.tb, strG, iDl, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.gc, g.z.tb, strG, iDl, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    m.z(e);
                }
            } else {
                com.bytedance.pangle.plugin.dl.z(com.bytedance.pangle.a.g.gc, g.z.js, strG, iDl, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strG + " version = " + iDl);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    private static String g(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static boolean z(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.z)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strKb = i.z().kb(plugin.mPkgName);
            if (TextUtils.isEmpty(strKb)) {
                strKb = plugin.mPkgName;
            }
            int iZ = z(strKb);
            if (iZ == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrKb = dl.kb(strKb, iZ);
            if (fileArrKb != null && fileArrKb.length != 0) {
                String strWp = dl.wp(strKb, iZ);
                if (TextUtils.isEmpty(strWp)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strWp);
                if (file.exists() && file.isFile()) {
                    z zVarZ = z(file, (List<File>) Arrays.asList(fileArrKb));
                    ((com.bytedance.pangle.plugin.z) plugin).z(zVarZ);
                    if (zVarZ == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!zVarZ.z()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrKb) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strG = g(sb2.toString());
                    if (TextUtils.isEmpty(strG)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> mapGc = uy.z().gc();
                    if (mapGc != null && mapGc.size() != 0) {
                        JSONObject jSONObject = mapGc.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String strOptString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(strOptString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(strOptString);
                            if (plugin2 != null) {
                                if (fo.kb()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strG)));
                                    return a.z(plugin2.mClassLoader, strG);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(strG, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=").append(strG);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=").append(strOptString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ").append(th);
            return false;
        }
    }
}
