package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a.g;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.e;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.uy;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.z.z;
import com.bytedance.sdk.openadsdk.api.m;
import com.funny.audio.core.utils.FileUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final uy z = uy.z();

    a() {
    }

    boolean z(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        }
        if (plugin.isLoading()) {
            return false;
        }
        if (plugin.isLoaded()) {
            return true;
        }
        synchronized (plugin) {
            if (plugin.isLoaded()) {
                return true;
            }
            plugin.setLifeCycle(4);
            uy uyVar = z;
            uyVar.z(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.z zVarZ = com.bytedance.pangle.log.z.z(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            z(com.bytedance.pangle.a.g.gz, g.z.gk, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean z2 = plugin.isIsDexPlugin() ? com.bytedance.pangle.dl.g.z(plugin, sb) : z(str, plugin, sb);
            if ((plugin instanceof z) && plugin.isIsDexPlugin()) {
                ((z) plugin).z();
            }
            zVarZ.z("loadPluginInternal:".concat(String.valueOf(z2)));
            if (z2) {
                plugin.setLifeCycle(3);
                z(com.bytedance.pangle.a.g.fo, g.z.x, plugin.mPkgName, plugin.getVersion(), zVarZ.z(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                uyVar.z(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:").append(plugin.mPkgName).append(" versionCode:").append(plugin.getVersion()).append("load failed;");
                z(com.bytedance.pangle.a.g.fo, g.z.lq, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                uyVar.z(ZeusPluginEventCallback.EVENT_FINISH_LOAD, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean z(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zG;
        final PackageInfo[] packageInfoArr;
        try {
            if (plugin == null) {
                sb.append("loadPluginInternal, plugin == null;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!");
                return false;
            }
            final String strG = com.bytedance.pangle.gc.dl.g(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strG + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strG).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zG = g(strG, plugin, sb);
            try {
                final File file = new File(com.bytedance.pangle.gc.dl.a(plugin.mPkgName, plugin.getVersion()));
                final File fileZ = z(plugin.mPkgName, plugin.getVersion(), strG);
                boolean z2 = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (fo.js()) {
                    packageInfoArr = packageInfoArr2;
                    z2 = true;
                    com.bytedance.pangle.z.z.z(true, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.a.1
                        @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                        public void z() throws Exception {
                            a.this.z(plugin, strG, file, fileZ, sb);
                        }
                    }, new z.InterfaceC0114z() { // from class: com.bytedance.pangle.plugin.a.2
                        @Override // com.bytedance.pangle.z.z.InterfaceC0114z
                        public void z() throws Throwable {
                            packageInfoArr[0] = a.this.z(str, plugin, sb, strG, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    z(plugin, strG, file, fileZ, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = z(str, plugin, sb, strG, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                z(plugin, sb, packageInfoArr[0]);
                return z2;
            } catch (Throwable th) {
                th = th;
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadPluginInternal stack:" + Arrays.toString(th.getStackTrace()));
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ").append(th.getMessage()).append(";");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zG) {
                    i.z().z(str, plugin.getVersion(), "load");
                    if (i.z().g(str, plugin.getVersion(), "load") > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zG = false;
        }
    }

    private boolean g(String str, Plugin plugin, StringBuilder sb) {
        if (fo.dl() || fo.gz() || fo.js()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((i.z().fo(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zG = com.bytedance.pangle.gc.a.g(Zeus.getAppApplication());
        boolean zE = i.z().e(plugin.mPkgName, plugin.getVersion());
        if (zG && zE) {
            if (!i.z().gz(plugin.mPkgName, plugin.getVersion())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z2 = com.bytedance.pangle.util.g.g.z(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                sb.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                i.z().a(plugin.mPkgName, plugin.getVersion(), true);
                return z2;
            }
            sb.append("removeEntry skip 3;");
            return false;
        }
        sb.append("removeEntry skip 4 ").append(zG).append(" ").append(zE).append(";");
        return false;
    }

    private void z(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (TextUtils.isEmpty(activityInfo.processName) || !activityInfo.processName.contains(":")) {
                    activityInfo.processName = "main";
                } else {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (TextUtils.isEmpty(serviceInfo.processName) || !serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = "main";
                } else {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (TextUtils.isEmpty(activityInfo2.processName) || !activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = "main";
                } else {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) {
                    providerInfo.processName = "main";
                } else {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (plugin.pluginProvider != null && plugin.pluginProvider.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            plugin.mApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo z(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        plugin.mHostApplicationInfoHookSomeField = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.a.3
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }
        });
        sb.append("makeResources cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        z(plugin, str, file, file2);
        sb.append("classLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.bytedance.pangle.gc.gc.z(new Runnable() { // from class: com.bytedance.pangle.plugin.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        plugin.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                z(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
            throw th;
        }
        sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
    }

    private void z(Plugin plugin, String str, File file, File file2) throws Exception {
        if (z()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            z(plugin.mClassLoader, str);
        } else {
            if (fo.dl()) {
                String strZ = e.z(plugin.mPkgName, plugin.getVersion());
                String[] strArrSplit = strZ.split(":");
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z2 = !com.bytedance.pangle.m.g.z(file2.getAbsolutePath(), strArrSplit);
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + z2);
                plugin.mClassLoader = new PluginClassLoader(z2 ? "" : strZ, file2, file.getAbsolutePath(), null);
                return;
            }
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }

    private File z(String str, int i, String str2) {
        File file = new File(com.bytedance.pangle.gc.dl.dl(str, i));
        if (fo.e() && !com.bytedance.pangle.m.g.z(file + File.separator + com.bytedance.pangle.m.g.z(str2))) {
            file = null;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void z(Plugin plugin, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject2.getString(next));
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("forceMappings");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                int iOptInt = jSONObject2.optInt("minApi", 0);
                int iOptInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= iOptInt2 && apiVersionCode >= iOptInt && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map.put(next2, jSONObjectOptJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            ComponentManager.registerActivity(plugin.mPkgName, ((str3 == null || !str3.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) ? plugin.mPkgName + FileUtils.FILE_EXTENSION_SEPARATOR : "") + ((String) map.get(str2)), str2);
        }
    }

    public static void z(String str, int i, String str2, int i2, long j, String str3) {
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

    private static boolean z() {
        return fo.js();
    }

    public static boolean z(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                m.z(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }
}
