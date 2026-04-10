package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();

    public static Application getAppApplication() {
        if (sApplication == null) {
            g.z();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.gc.z.z(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static void init(Application application) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start init");
        uy.z().z(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.z.z.g().dl();
    }

    public static boolean waitInit(int i) {
        if (uy.z().g()) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!uy.z().g()) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return uy.z().g();
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.bytedance.pangle.receiver.z.z(application);
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.gc.a.g(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.m.m.z();
    }

    public static boolean hasInit() {
        return uy.z().g();
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        uy.z().z(zeusPluginStateListener);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        uy.z().g(zeusPluginStateListener);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        uy.z().z(zeusPluginEventCallback);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        uy.z().g(zeusPluginEventCallback);
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginInstalled(String str, boolean z) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str, false);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, TtmlNode.START);
        dl dlVarZ = com.bytedance.pangle.servermanager.g.z();
        if (dlVarZ == null) {
            return false;
        }
        try {
            return dlVarZ.z(str, str2);
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
            return false;
        }
    }

    public static void registerPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            dl dlVarZ = com.bytedance.pangle.servermanager.g.z();
            if (dlVarZ != null) {
                dlVarZ.z(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.e.g(zeusPluginInstallListener));
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            dl dlVarZ = com.bytedance.pangle.servermanager.g.z();
            if (dlVarZ != null) {
                dlVarZ.z(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void setAllowDownloadPlugin(String str, int i, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.gc.g.z();
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.gc.a.g(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.gc.g.g();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || plugin.mResources == null) {
            return;
        }
        new com.bytedance.pangle.res.z().z(plugin.mResources.getAssets(), str2, false);
    }

    public static void setDecodeCallback(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        uy.z().z(zeusPluginDecodeCallback);
    }

    public static void addPackageDexManager(String str, JSONObject jSONObject) {
        Map<String, JSONObject> mapGc = uy.z().gc();
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        mapGc.put(str, jSONObject);
    }
}
