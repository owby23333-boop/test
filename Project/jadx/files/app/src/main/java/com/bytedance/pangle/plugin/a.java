package com.bytedance.pangle.plugin;

import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class a implements Runnable {
    private final File a;
    private final String b;

    a(String str, File file) {
        this.a = file;
        this.b = str;
    }

    final boolean a() {
        e eVarA = com.bytedance.pangle.f.a.d.a(this.a);
        if (eVarA == null) {
            ZeusPluginStateListener.postStateChange(this.b, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(eVarA.a);
        if (plugin != null) {
            boolean zInstall = plugin.install(this.a, eVarA);
            if (zInstall) {
                ZeusPluginStateListener.postStateChange(eVarA.a, 6, new Object[0]);
            } else {
                ZeusPluginStateListener.postStateChange(eVarA.a, 7, "Internal error.");
            }
            return zInstall;
        }
        ZeusPluginStateListener.postStateChange(this.b, 7, " plugin == null !!! pluginPkg = " + this.b);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + eVarA.a);
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
