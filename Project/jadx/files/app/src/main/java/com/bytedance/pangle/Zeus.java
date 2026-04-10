package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h hVarA = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (hVarA.f14600c) {
                hVarA.f14600c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.a aVarA = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (!GlobalParam.getInstance().autoFetch()) {
                com.bytedance.pangle.download.b.a();
                return;
            }
            final com.bytedance.pangle.download.b bVarA = com.bytedance.pangle.download.b.a();
            Runnable runnable = bVarA.f14540c.get(str);
            if (runnable != null) {
                bVarA.b.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.b.1
                final /* synthetic */ String a;

                public AnonymousClass1(final String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (com.bytedance.pangle.util.b.a(Zeus.getAppApplication())) {
                        b.this.b.postDelayed(this, 1800000L);
                    }
                }
            };
            bVarA.f14540c.put(str2, runnable2);
            bVarA.b.postDelayed(runnable2, 1800000L);
            com.bytedance.pangle.download.b.a();
            if (aVarA.a.contains(str2)) {
                return;
            }
            aVarA.a.add(str2);
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
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

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        String did = GlobalParam.getInstance().getDid();
        return !TextUtils.isEmpty(did) ? did : ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return h.a().a;
    }

    public static void init(Application application, boolean z2) {
        h.a().a(application, z2);
        synchronized (wait) {
            wait.notifyAll();
        }
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        if (onPrivacyAgreed) {
            return;
        }
        ApmUtils.getApmInstance().init();
        onPrivacyAgreed = true;
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        h.a().b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h hVarA = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (hVarA.f14600c) {
                hVarA.f14600c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i2, boolean z2) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i2, z2);
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

    public static boolean syncInstallPlugin(String str, String str2) {
        c cVarA = com.bytedance.pangle.servermanager.b.a();
        if (cVarA == null) {
            return false;
        }
        try {
            return cVarA.a(str, str2);
        } catch (RemoteException e2) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e2);
            return false;
        }
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = h.a().b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i2) {
        if (h.a().a) {
            return true;
        }
        synchronized (wait) {
            if (!h.a().a) {
                try {
                    if (i2 == -1) {
                        wait.wait();
                    } else {
                        wait.wait(i2);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return h.a().a;
    }

    public static Plugin getPlugin(String str, boolean z2) {
        return PluginManager.getInstance().getPlugin(str, z2);
    }
}
