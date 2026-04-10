package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class g implements Runnable {
    private final String g;
    private File z;

    g(String str, File file) {
        this.z = file;
        this.g = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        z();
    }

    private void g() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.z.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                e.g(this.z.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.z;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File fileZ = z(file2);
                if (fileZ != null && fileZ.exists() && fileZ.isFile()) {
                    this.z = fileZ;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                m.z(e);
            }
        }
    }

    private File z(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private static void z(String str, int i, String str2, int i2, long j, String str3) {
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
            m.z(e);
        }
        com.bytedance.pangle.a.g.z().z(str, jSONObject, jSONObject3, jSONObject2);
    }

    private com.bytedance.pangle.e.z.gc dl() {
        com.bytedance.pangle.dl.z zVarZ;
        if (this.z == null) {
            return null;
        }
        try {
            File file = new File(this.z.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                e.z(file);
                file.mkdirs();
            }
            e.g(this.z.getAbsolutePath(), file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            e.z(this.z);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.z);
            this.z = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (zVarZ = com.bytedance.pangle.dl.g.z(file2, linkedList)) != null) {
                return new com.bytedance.pangle.e.z.gc(zVarZ);
            }
        } catch (Exception e) {
            m.z(e);
        }
        return null;
    }

    boolean z() {
        com.bytedance.pangle.e.z.gc gcVarZ;
        File file = this.z;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            gcVarZ = dl();
            if (gcVarZ != null) {
                z(com.bytedance.pangle.a.g.e, g.z.js, this.g, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (e.g(this.z)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                g();
                z(com.bytedance.pangle.a.g.e, g.z.mc, this.g, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            gcVarZ = com.bytedance.pangle.e.z.a.z(this.z);
        }
        if (gcVarZ == null) {
            ZeusPluginStateListener.postStateChange(this.g, 7, " read local file package info failed !!! pluginPkg = " + this.g + " mApkFile.exists = " + this.z.exists());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!! pluginPkg = " + this.g);
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(gcVarZ.z);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.g, 7, " plugin == null !!! pluginPkg = " + this.g);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + gcVarZ.z);
            return false;
        }
        boolean zInstall = plugin.install(this.z, gcVarZ);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(gcVarZ.z, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(gcVarZ.z, 7, "Internal error.");
        }
        return zInstall;
    }
}
