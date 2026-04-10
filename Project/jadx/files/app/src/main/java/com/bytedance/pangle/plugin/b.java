package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import com.umeng.message.proguard.ad;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class b {
    private static final h a = h.a();

    public static class a extends IOException {
        /* synthetic */ a(String str, byte b) {
            this(str);
        }

        /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    static boolean a(final File file, final String str, final int i2) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        try {
            a.a(1000, 0, str, i2, null);
            com.bytedance.pangle.log.a aVarA = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f14508e, b.a.f14524n, str, i2, -1L, null);
            g.a(com.bytedance.pangle.d.c.a(str, i2));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0298a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0298a
                public final void a() {
                    b.a(file, str, i2, stringBuffer);
                }
            }, new a.InterfaceC0298a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0298a
                public final void a() throws Throwable {
                    final Map mapF = b.f(file, str, i2, stringBuffer);
                    b.c(file, str, i2, stringBuffer);
                    b.a(b.g(file, str, i2, stringBuffer), str, i2, stringBuffer);
                    if (i.e() || i.b()) {
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0298a() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.a.a.InterfaceC0298a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i2, mapF, stringBuffer);
                            }
                        }, new a.InterfaceC0298a() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.a.a.InterfaceC0298a
                            public final void a() throws Throwable {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.e(file, str, i2, stringBuffer);
                            }
                        });
                    } else {
                        b.a(str, i2, mapF, stringBuffer);
                        b.e(file, str, i2, stringBuffer);
                    }
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f14509f, b.a.f14525o, str, i2, aVarA.a(), stringBuffer.toString());
            aVarA.a("success");
            a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, 0, str, i2, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14526p, str, i2, -1L, stringBuffer.toString());
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -1, str, i2, th);
            }
            return false;
        }
    }

    static /* synthetic */ void c(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte b = 0;
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
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
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), b);
                        }
                    }
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14528r, str, i2, -1L, null);
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -4, str, i2, e2);
                throw new a("安装包权限校验失败", e2, b);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0226: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:72:0x0226 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x022a: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:74:0x022a */
    static /* synthetic */ void e(File file, String str, int i2, StringBuffer stringBuffer) throws Throwable {
        String str2;
        String str3;
        String str4;
        ZipFile zipFile;
        String str5;
        ZipEntry zipEntry;
        String str6 = ".dex";
        String str7 = "classes";
        String str8 = ";";
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                try {
                    if (!i.b()) {
                        str4 = ";";
                        if (i.d() || i.f()) {
                            com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i2).apply();
                            f.a();
                        } else if (i.e()) {
                            String strC = com.bytedance.pangle.d.c.c(str, i2);
                            String strB = com.bytedance.pangle.d.c.b(str, i2);
                            com.bytedance.pangle.e.b.a(strB, strC + File.separator + com.bytedance.pangle.e.b.a(strB));
                        }
                    } else {
                        if (!file.exists() || str == null) {
                            throw new IOException("Could not check apk info " + file.getAbsolutePath());
                        }
                        try {
                            zipFile = new ZipFile(file);
                            try {
                                ArrayList arrayList = new ArrayList();
                                File file2 = new File(com.bytedance.pangle.d.c.i(str, i2));
                                com.bytedance.pangle.e.g.a(file2);
                                int i3 = 1;
                                while (true) {
                                    StringBuilder sb = new StringBuilder(str7);
                                    Object objValueOf = "";
                                    sb.append(i3 == 1 ? "" : Integer.valueOf(i3));
                                    sb.append(str6);
                                    ZipEntry entry = zipFile.getEntry(sb.toString());
                                    if (entry == null) {
                                        str4 = str8;
                                        file.getName();
                                        SharedPreferences.Editor editorEdit = com.bytedance.pangle.e.g.a().edit();
                                        editorEdit.putInt((str + "-" + i2) + ".dex.number", arrayList.size());
                                        editorEdit.commit();
                                        g.a(zipFile);
                                        com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i2).apply();
                                        f.a();
                                        break;
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str7);
                                    String str9 = str8;
                                    if (i3 != 1) {
                                        try {
                                            objValueOf = Integer.valueOf(i3);
                                        } catch (Throwable th) {
                                            th = th;
                                            g.a(zipFile);
                                            throw th;
                                        }
                                    }
                                    sb2.append(objValueOf);
                                    sb2.append(str6);
                                    g.a aVar = new g.a(file2, sb2.toString());
                                    String str10 = str6;
                                    int i4 = 0;
                                    boolean z2 = false;
                                    while (i4 < 3 && !z2) {
                                        try {
                                            com.bytedance.pangle.e.g.a(zipFile, entry, aVar, str7);
                                            str5 = str7;
                                            zipEntry = entry;
                                            z2 = true;
                                        } catch (IOException e2) {
                                            str5 = str7;
                                            zipEntry = entry;
                                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + aVar.getAbsolutePath(), e2);
                                        }
                                        int i5 = i4 + 1;
                                        StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                                        sb3.append(z2 ? "succeeded" : "failed");
                                        sb3.append(" '");
                                        sb3.append(aVar.getAbsolutePath());
                                        sb3.append("': length ");
                                        sb3.append(aVar.length());
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
                                        if (!z2) {
                                            aVar.delete();
                                            if (aVar.exists()) {
                                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                                            }
                                        }
                                        i4 = i5;
                                        str7 = str5;
                                        entry = zipEntry;
                                    }
                                    String str11 = str7;
                                    if (!z2) {
                                        throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i3 + ad.f20406s);
                                    }
                                    arrayList.add(aVar);
                                    i3++;
                                    str6 = str10;
                                    str8 = str9;
                                    str7 = str11;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            zipFile = null;
                        }
                    }
                    stringBuffer.append("dexOpt cost:");
                    stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    stringBuffer.append(str4);
                } catch (Exception e3) {
                    e = e3;
                    str8 = str3;
                    a(com.bytedance.pangle.c.b.f14509f, b.a.f14532v, str, i2, -1L, null);
                    throw new a("dexOpt失败", e, (byte) 0);
                } catch (Throwable th4) {
                    th = th4;
                    str8 = str2;
                    stringBuffer.append("dexOpt cost:");
                    stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    stringBuffer.append(str8);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i2, StringBuffer stringBuffer) {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte b = 0;
        try {
            try {
                e<Boolean, Map<String, List<ZipEntry>>> eVarA = com.bytedance.pangle.d.b.a(file);
                boolean zBooleanValue = eVarA.a.booleanValue();
                Map<String, List<ZipEntry>> map = eVarA.b;
                if (zBooleanValue) {
                    return map;
                }
                throw new a(str2, b);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14533w, str, i2, -1L, null);
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -5, str, i2, e2);
                throw new a(str2, e2, b);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(";");
        }
        stringBuffer.append("checkMatchHostAbi cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strB = com.bytedance.pangle.d.c.b(str, i2);
        try {
            try {
                com.bytedance.pangle.util.h.a(file.getAbsolutePath(), strB);
                return strB;
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14529s, str, i2, -1L, null);
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -6, str, i2, e2);
                throw new a("安装包拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(";");
        }
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j2))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    static /* synthetic */ void a(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                    return;
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14527q, str, i2, -1L, null);
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -3, str, i2, e2);
                throw new a(e2.getMessage(), e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(";");
        }
        stringBuffer.append("checkSignature cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(";");
    }

    static /* synthetic */ void a(String str, String str2, int i2, StringBuffer stringBuffer) throws a {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        byte b = 0;
        int iA = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(iA == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(";");
        if (iA == 100 || iA == 200) {
            return;
        }
        String string = sb.toString();
        a(com.bytedance.pangle.c.b.f14509f, b.a.f14534x, str2, i2, -1L, string);
        a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -2, str2, i2, null);
        throw new a("modifyRes failed. result = " + iA + ", errorLog = " + string, b);
    }

    static /* synthetic */ void a(String str, int i2, Map map, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i2)), new File(com.bytedance.pangle.d.c.d(str, i2)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f14509f, b.a.f14530t, str, i2, -1L, null);
                a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -7, str, i2, e2);
                throw new a("安装包动态库拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(";");
        }
    }
}
