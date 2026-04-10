package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.i;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Plugin {
    private com.bytedance.pangle.dl.z z;

    public z(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void z(com.bytedance.pangle.dl.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.dl.z zVar = this.z;
        if (zVar == null) {
            return null;
        }
        return zVar.m();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[Catch: Exception -> 0x005a, all -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:20:0x0044, B:22:0x0047, B:23:0x0052), top: B:52:0x0044, outer: #1 }] */
    @Override // com.bytedance.pangle.plugin.Plugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void init() {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.z.init():void");
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    boolean install(File file, com.bytedance.pangle.e.z.gc gcVar) {
        boolean z = false;
        if (gcVar != null) {
            try {
                if (gcVar.dl != null) {
                    com.bytedance.pangle.dl.z zVar = gcVar.dl;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + zVar);
                    String strG = zVar.g();
                    int iDl = zVar.dl();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strG + " plugin=" + this);
                        boolean z2 = zVar.z();
                        if (z2 && (z = com.bytedance.pangle.dl.g.z(zVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strG + " version=" + iDl);
                        }
                        synchronized (this) {
                            if (z2) {
                                if (this.mLifeCycle == 3) {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strG + ":" + this.mVersionCode);
                                } else if (z) {
                                    updateToInstalled(iDl);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strG + ":" + iDl);
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strG + ":" + iDl);
                                }
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strG + ":" + iDl);
                            }
                            e.z(file);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strG + " version=" + iDl + " apkFile=" + file);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th);
            }
        }
        return z;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.gc.a.g(Zeus.getAppApplication()) && i.z().fo(this.mPkgName)) {
            i.z().gz(this.mPkgName);
            String strZ = com.bytedance.pangle.gc.dl.z(this.mPkgName);
            e.z(strZ);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strZ);
            g();
            dl();
        }
    }

    private void g() {
        List<String> listI = i.z().i(this.mPkgName);
        if (listI == null || listI.size() <= 0) {
            return;
        }
        for (String str : listI) {
            if (!TextUtils.isEmpty(str)) {
                int iZ = com.bytedance.pangle.dl.g.z(str);
                if (iZ != -1) {
                    i.z().g(str, iZ, false);
                }
                e.z(com.bytedance.pangle.gc.dl.z(str));
            }
        }
        i.z().v(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listI)));
    }

    private void dl() {
        String strKb = i.z().kb(this.mPkgName);
        if (TextUtils.isEmpty(strKb)) {
            return;
        }
        String strZ = com.bytedance.pangle.gc.dl.z(strKb);
        e.z(strZ);
        i.z().wp(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strZ)));
    }

    private void z(int i) {
        if (com.bytedance.pangle.gc.a.g(Zeus.getAppApplication())) {
            g();
            String strKb = i.z().kb(this.mPkgName);
            if (!TextUtils.isEmpty(strKb)) {
                com.bytedance.pangle.dl.g.z(strKb, i);
            } else {
                com.bytedance.pangle.dl.g.z(this.mPkgName, i);
            }
        }
    }

    public void z() {
        String strZ = com.bytedance.pangle.gc.dl.z(this.mPkgName);
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        File[] fileArrListFiles = new File(strZ).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strZ);
            e.z(strZ);
        }
    }
}
