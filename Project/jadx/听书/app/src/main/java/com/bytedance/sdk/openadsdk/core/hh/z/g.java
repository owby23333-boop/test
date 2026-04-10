package com.bytedance.sdk.openadsdk.core.hh.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.a;
import com.bytedance.sdk.openadsdk.ls.gc;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static long fo;
    private static long gz;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FileOutputStream f1129a;
    private Function<SparseArray<Object>, Object> m;
    private static final String z = File.separator + "next";
    private static final String g = File.separator + "tmp";
    private static final String dl = File.separator + "conf";
    private static final g gc = new g();
    private static final HashMap<String, String> e = new HashMap<>();

    private g() {
    }

    public static g z() {
        return gc;
    }

    public void z(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = zw.getContext().getApplicationContext();
        e.g(new fo("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.hh.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    g.this.z(applicationContext, (List<z>) g.dl(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean z(android.content.Context r3, int r4, java.lang.String r5) {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.core.uy r3 = com.bytedance.sdk.openadsdk.core.uy.ls()
            com.bytedance.sdk.openadsdk.core.hh.z r3 = r3.uf()
            int r3 = r3.z(r5)
            com.bytedance.sdk.openadsdk.core.uy r5 = com.bytedance.sdk.openadsdk.core.uy.ls()
            boolean r5 = r5.vm()
            if (r5 == 0) goto L1b
            boolean r3 = r2.z(r3)
            return r3
        L1b:
            r5 = -1
            if (r4 == r5) goto L33
            r5 = 1
            if (r4 == r5) goto L34
            r0 = 2
            if (r4 == r0) goto L34
            r0 = 3
            if (r4 == r0) goto L34
            r1 = 4
            if (r4 == r1) goto L31
            r1 = 5
            if (r4 == r1) goto L31
            if (r3 != r0) goto L33
            r4 = r5
            goto L34
        L31:
            r3 = 0
            return r3
        L33:
            r4 = r3
        L34:
            boolean r3 = r2.z(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.hh.z.g.z(android.content.Context, int, java.lang.String):boolean");
    }

    private boolean z(int i) {
        if (i != 1) {
            if (i == 3 || i == 4 || i == 5) {
                return false;
            }
        } else if (!v.a(zw.getContext())) {
            return false;
        }
        return true;
    }

    public void z(Function<SparseArray<Object>, Object> function) {
        this.m = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Context context, List<z> list) {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.core.q.v.z().z("", 7105, 0, "", 14, e2.getMessage(), 0L);
                    wp.g("PluginUpdater", "Handle file error: " + e2);
                }
                if (z(context)) {
                    list.size();
                    final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                    for (final z zVar : list) {
                        e.g(new fo("pl download") { // from class: com.bytedance.sdk.openadsdk.core.hh.z.g.2
                            @Override // java.lang.Runnable
                            public void run() throws Exception {
                                g.this.z(context, zVar);
                                countDownLatch.countDown();
                            }
                        });
                    }
                    countDownLatch.await();
                }
            } finally {
                g(context);
            }
        }
    }

    private boolean z(Context context) {
        try {
            File fileA = a(context);
            if (!fileA.exists()) {
                fileA.mkdirs();
            }
            File file = new File(fileA, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                wp.g("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.f1129a = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            wp.g("PluginUpdater", "Acquire file lock failed");
            this.f1129a.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.f1129a;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            wp.g("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private void g(Context context) {
        FileOutputStream fileOutputStream = this.f1129a;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                wp.z(e2);
            }
        }
        File fileA = a(context);
        if (fileA.exists()) {
            for (File file : fileA.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static File dl(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "tt_pangle_bykv_file", 0);
    }

    private static File a(Context context) {
        return new File(dl(context), g);
    }

    private static File gc(Context context) {
        return new File(dl(context), z);
    }

    private static File m(Context context) {
        return new File(dl(context), dl);
    }

    private static boolean z(z zVar) {
        return "com.byted.pangle".equals(zVar.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, z zVar) throws Exception {
        int iZ;
        String message;
        try {
            if (!z(context, zVar.uy, zVar.z)) {
                message = uy.ls().uf() + ":" + zVar.uy;
                iZ = 20;
            } else {
                iZ = z(context, a(context), zVar);
                z(zVar, iZ);
                message = "";
            }
        } catch (C0174g e2) {
            iZ = e2.z();
            message = e2.getMessage();
            z(zVar.z, 1004);
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z(zVar.z, z(zVar) ? 7105 : 0, zVar.g, zVar.f1131a, iZ, message, fo - gz);
    }

    private void z(z zVar, int i) {
        SparseArray<Object> sparseArrayG;
        PluginValueSet pluginValueSetG;
        if (this.m == null || !g(zVar, i)) {
            return;
        }
        SparseArray<Object> sparseArrayG2 = a.z().z(2, zVar.toString()).z(3, zVar.z).g();
        boolean z2 = i == 6 || i == 10 || i == 16;
        SparseArray<Object> sparseArrayG3 = gc.z().z(z2).z(z2 ? 0 : 1004).z(sparseArrayG2).g();
        try {
            if (com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
                sparseArrayG = a.z(sparseArrayG3).z(1).z(SparseArray.class).g();
            } else {
                sparseArrayG = a.z().z(1).z(SparseArray.class).z(-99999979, sparseArrayG3).g();
            }
            Object objApply = this.m.apply(sparseArrayG);
            if (objApply instanceof SparseArray) {
                pluginValueSetG = com.bykv.z.z.z.z.z.z((SparseArray<Object>) objApply).g();
            } else {
                pluginValueSetG = (com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl) && (objApply instanceof PluginValueSet)) ? (PluginValueSet) objApply : null;
            }
            if (pluginValueSetG == null || !pluginValueSetG.booleanValue(4) || zVar.kb == null) {
                return;
            }
            HashMap<String, String> map = e;
            map.put(zVar.z, new File(zVar.kb).getName());
            z(zVar.z, zVar.dl);
            map.values();
        } catch (Exception e2) {
            wp.dl("PluginUpdater", "Download pl done, but install error:" + e2.getMessage());
        }
    }

    private boolean g(z zVar, int i) {
        z(zVar);
        return (i == 21 || i == 18) ? false : true;
    }

    private static void z(String str, String str2) {
        if (str == null) {
            return;
        }
        uy.ls().z(str, str2);
    }

    private static int z(Context context, File file, z zVar) throws Exception {
        if (zVar == null) {
            return 2;
        }
        try {
            if (TextUtils.isEmpty(zVar.f1131a)) {
                return 2;
            }
            if (TextUtils.isEmpty(zVar.z)) {
                return 12;
            }
            if (!z(zVar) && !uy.ls().lq().has(zVar.z)) {
                return 17;
            }
            if (dl(zVar)) {
                return 18;
            }
            if (g(zVar.g)) {
                return 21;
            }
            if (!g(zVar)) {
                return 19;
            }
            File fileM = m(context);
            if (!fileM.exists()) {
                fileM.mkdirs();
            }
            boolean z2 = true;
            if (z(zVar) && gk.dl >= zVar.g) {
                String str = "-" + com.bytedance.sdk.component.utils.gc.g(zVar.z) + "-" + gk.dl + "-" + gk.dl;
                zVar.fo = gk.dl;
                zVar.gz = gk.dl;
                zVar.e = true;
                z(new File(fileM, str + ".conf"), zVar);
                return 10;
            }
            if (TextUtils.isEmpty(zVar.gc) && !zVar.z()) {
                return 1;
            }
            String strG = com.bytedance.sdk.component.utils.gc.g(zVar.z);
            StringBuilder sb = new StringBuilder();
            String strG2 = com.bytedance.sdk.component.utils.gc.g(zVar.gc);
            if (!TextUtils.isEmpty(strG2)) {
                sb.append(strG2).append("-");
            }
            sb.append(strG).append("-").append(zVar.gz).append("-").append(zVar.fo);
            String string = sb.toString();
            File fileGc = gc(context);
            if (!fileGc.exists()) {
                fileGc.mkdirs();
            }
            File file2 = new File(fileGc, string + (zVar.z() ? ".dex.zip" : ".apk"));
            if (file2.exists()) {
                zVar.m = com.bytedance.sdk.component.utils.gc.z(file2);
                zVar.kb = file2.getAbsolutePath();
                return 16;
            }
            if (file2.getName().equals(e.get(zVar.z))) {
                return 21;
            }
            com.bytedance.sdk.openadsdk.core.q.v.z().z(zVar.z, z(zVar) ? 7105 : 0, zVar.g, zVar.f1131a, 7, "", 0L);
            File file3 = new File(file, string);
            com.bytedance.sdk.component.fo.g.g gVarA = com.bytedance.sdk.openadsdk.core.io.gc.z().g().a();
            gVarA.z(zVar.f1131a);
            gVarA.z(file.getAbsolutePath(), string);
            gz = System.currentTimeMillis();
            com.bytedance.sdk.component.fo.g gVarZ = gVarA.z();
            if (gVarZ != null && gVarZ.gz()) {
                fo = System.currentTimeMillis();
                if (!file3.exists()) {
                    return 13;
                }
                z(fileGc, strG);
                z(fileM, strG);
                if (!file3.renameTo(file2)) {
                    return 5;
                }
                File file4 = new File(fileM, file3.getName() + ".conf");
                zVar.m = com.bytedance.sdk.component.utils.gc.z(file2);
                zVar.kb = file2.getAbsolutePath();
                if (zVar.g >= a(zVar)) {
                    z2 = false;
                }
                zVar.e = z2;
                return z(file4, zVar) ? 6 : 15;
            }
            throw new C0174g(9, gVarZ != null ? gVarZ.z() + " : " + gVarZ.g() : "no response");
        } catch (Exception e2) {
            wp.g("PluginUpdater", "Download file error: " + e2);
            if (e2 instanceof C0174g) {
                throw e2;
            }
            String message = e2.getMessage();
            try {
                message = Log.getStackTraceString(e2);
            } catch (Throwable th) {
                wp.z(th);
            }
            throw new C0174g(14, message);
        }
    }

    private static boolean g(z zVar) {
        int iG;
        JSONObject jSONObjectOptJSONObject;
        if (z(zVar)) {
            iG = gk.dl;
        } else {
            iG = (!uy.ls().lq().has(zVar.z) || (jSONObjectOptJSONObject = uy.ls().lq().optJSONObject(zVar.z)) == null) ? 0 : g(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iG >= zVar.gz && iG <= zVar.fo;
    }

    private static boolean dl(z zVar) {
        if (z(zVar)) {
            return 7105 == zVar.g;
        }
        JSONObject jSONObjectOptJSONObject = uy.ls().lq().optJSONObject(zVar.z);
        return (jSONObjectOptJSONObject != null ? g(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0) == zVar.g;
    }

    private static boolean g(int i) {
        File fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext());
        if (fileZ == null) {
            return false;
        }
        return new File(fileZ.getParent() + "/pangle_p/com.byted.pangle/version-" + i).exists();
    }

    private static int a(z zVar) {
        int iG;
        if (z(zVar)) {
            iG = 7105;
        } else {
            if (!uy.ls().lq().has(zVar.z)) {
                return 0;
            }
            JSONObject jSONObjectOptJSONObject = uy.ls().lq().optJSONObject(zVar.z);
            iG = jSONObjectOptJSONObject != null ? g(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        }
        return iG;
    }

    private static boolean z(File file, z zVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(zVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            wp.g("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void z(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.hh.z.g.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                wp.g("PluginUpdater", "Delete file: ".concat(String.valueOf(str2)));
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<z> dl(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                z zVar = new z();
                zVar.z = z(jSONObjectOptJSONObject.optString(an.o));
                zVar.g = jSONObjectOptJSONObject.optInt("version_code");
                zVar.dl = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                zVar.f1131a = jSONObjectOptJSONObject.optString("download_url");
                zVar.gc = jSONObjectOptJSONObject.optString("sign");
                zVar.gz = g(jSONObjectOptJSONObject.optString("min_version"));
                zVar.fo = g(jSONObjectOptJSONObject.optString("max_version"));
                zVar.uy = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                arrayList.add(zVar);
            }
        }
        return arrayList;
    }

    public static String g() {
        String str;
        String strZ = com.bytedance.sdk.openadsdk.core.hh.g.g.z();
        if ("arm64-v8a".equals(strZ)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strZ)) {
            str = "@32";
        } else {
            str = "armeabi".equals(strZ) ? "@armeabi" : "";
        }
        return "com.byted.live.lite".concat(str);
    }

    public static String z(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    private static int g(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void z(String str, int i) {
        SparseArray<Object> sparseArrayG;
        if (this.m == null) {
            return;
        }
        SparseArray<Object> sparseArrayG2 = gc.z().z(false).z(i).z(a.z().z(3, str).g()).g();
        if (gk.dl >= 7000 || gk.dl < 6800) {
            sparseArrayG = a.z().z(1).z(Void.class).z(-99999979, sparseArrayG2).g();
        } else {
            sparseArrayG = a.z(sparseArrayG2).z(1).z(Void.class).g();
        }
        this.m.apply(sparseArrayG);
    }

    private static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1131a;
        public String dl;
        public boolean e;
        public int fo;
        public int g;
        public String gc;
        public int gz;
        public String kb;
        public String m;
        public int uy;
        public String z;

        private z() {
        }

        public String toString() {
            try {
                return new JSONObject().put(an.o, this.z).put("version_code", this.g).put("sign", this.gc).put("max_version", this.fo).put("min_version", this.gz).put("is_revert", this.e).put(TKDownloadReason.KSAD_TK_MD5, this.m).put("plugin_file", this.kb).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        public boolean z() {
            return TextUtils.equals(this.z, "com.byted.mixed");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.hh.z.g$g, reason: collision with other inner class name */
    private static final class C0174g extends Exception {
        private int z;

        public C0174g(int i, String str) {
            super(str);
            this.z = i;
        }

        int z() {
            return this.z;
        }
    }
}
