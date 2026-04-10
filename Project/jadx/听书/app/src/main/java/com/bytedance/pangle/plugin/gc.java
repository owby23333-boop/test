package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
class gc implements Runnable {
    gc() {
    }

    @Override // java.lang.Runnable
    public void run() {
        z(new File(com.bytedance.pangle.gc.dl.g()));
        String strA = com.bytedance.pangle.gc.dl.a();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        z(new File(strA));
    }

    private void z(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.gc.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (file2.getName().endsWith(".apk") || e.g(file2) || file2.getName().endsWith(".7z.zip") || file2.getName().endsWith(".jar") || file2.getName().endsWith(".dex.zip")) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                }
                if ((file2.getAbsolutePath().endsWith(".temp") || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                } else {
                    e.z(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                }
                return false;
            }
        });
    }
}
