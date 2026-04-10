package com.bytedance.pangle.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.fo;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.uy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final a pluginLoader = new a();

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private PluginManager() {
    }

    public boolean loadPlugin(String str) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.z(str);
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.g.z()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public Plugin getPluginOnly(String str) {
        return this.mPlugins.get(str);
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public void registerPlugin(String str) {
        Plugin plugins;
        if (str == null || (plugins = parsePlugins(str)) == null) {
            return;
        }
        this.mPlugins.put(plugins.mPkgName, plugins);
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            try {
                for (String str : bundle.keySet()) {
                    if (fo.gc.startsWith("PANGLE_")) {
                        if (str.startsWith(fo.gc) || str.startsWith("ZEUS_PLUGIN_")) {
                            arrayList.add(bundle.getString(str));
                        }
                    } else if (str.startsWith(fo.gc)) {
                        arrayList.add(bundle.getString(str));
                    }
                }
                try {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Plugin plugins = parsePlugins((String) it.next());
                        if (plugins != null) {
                            concurrentHashMap.put(plugins.mPkgName, plugins);
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugins.mPkgName);
                        }
                    }
                    Map<String, JSONObject> mapGc = uy.z().gc();
                    if (mapGc != null && mapGc.size() > 0) {
                        for (Map.Entry<String, JSONObject> entry : mapGc.entrySet()) {
                            String key = entry.getKey();
                            JSONObject value = entry.getValue();
                            if (!TextUtils.isEmpty(key) && value != null) {
                                Plugin plugins2 = parsePlugins(value);
                                concurrentHashMap.put(plugins2.mPkgName, plugins2);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + plugins2.mPkgName);
                            }
                        }
                    }
                    this.mPlugins.putAll(concurrentHashMap);
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);
                }
                this.mIsParsePluginConfig = true;
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager iterator metaData failed.", e2);
            }
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
        }
    }

    private Plugin parsePlugins(String str) {
        if (str == null) {
            return null;
        }
        try {
            return parsePlugins(new JSONObject(str));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str.trim(), e);
            return null;
        }
    }

    private Plugin parsePlugins(JSONObject jSONObject) throws JSONException {
        Plugin plugin;
        if (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) {
            plugin = new z(jSONObject);
        } else {
            plugin = new Plugin(jSONObject);
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugin.mPkgName);
        return plugin;
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.gc.dl.g(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            i.z().e(str);
        }
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            i.z().z(str, i, !z);
        }
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i) {
            return;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
        i.z().gc(str, plugin.getApiVersionCode());
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new g(str, file).z();
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            com.bytedance.pangle.gc.gc.g(new g(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.gc.a.g(Zeus.getAppApplication())) {
            com.bytedance.pangle.gc.gc.g(new gc());
        }
        this.hasInstallFromDownloadDir = true;
    }
}
