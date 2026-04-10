package com.ryg.dynamicload.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.ryg.dynamicload.DLBasePluginActivity;
import com.ryg.dynamicload.DLBasePluginFragmentActivity;
import com.ryg.dynamicload.DLBasePluginService;
import com.ryg.dynamicload.DLProxyActivity;
import com.ryg.dynamicload.DLProxyFragmentActivity;
import com.ryg.dynamicload.DLProxyService;
import com.ryg.reflect.Reflect;
import com.ryg.utils.DLConstants;
import com.ryg.utils.SoLibManager;
import dalvik.system.DexClassLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DLPluginManager {
    public static final int START_RESULT_NO_CLASS = 2;
    public static final int START_RESULT_NO_PKG = 1;
    public static final int START_RESULT_SUCCESS = 0;
    public static final int START_RESULT_TYPE_ERROR = 3;
    private static final String TAG = "DLPluginManager";
    private static DLPluginManager sInstance;
    private String dexOutputPath;
    private Context mContext;
    private String mNativeLibDir;
    private int mResult;
    private final HashMap<String, DLPluginPackage> mPackagesHolder = new HashMap<>();
    private int mFrom = 0;

    public interface OnFetchProxyServiceClass {
        void onFetch(int i, Class<? extends Service> cls);
    }

    private DLPluginManager(Context context) {
        this.mNativeLibDir = null;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mNativeLibDir = applicationContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    private void copySoLib(String str) {
        SoLibManager.getSoLoader().copyPluginSoLib(this.mContext, str, this.mNativeLibDir);
    }

    private AssetManager createAssetManager(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private DexClassLoader createDexClassLoader(String str) {
        this.dexOutputPath = this.mContext.getDir("dex", 0).getAbsolutePath();
        return new DexClassLoader(str, this.dexOutputPath, this.mNativeLibDir, this.mContext.getClassLoader());
    }

    private Resources createResources(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void fetchProxyServiceClass(DLIntent dLIntent, OnFetchProxyServiceClass onFetchProxyServiceClass) {
        String pluginPackage = dLIntent.getPluginPackage();
        if (TextUtils.isEmpty(pluginPackage)) {
            throw new NullPointerException("disallow null packageName.");
        }
        DLPluginPackage dLPluginPackage = this.mPackagesHolder.get(pluginPackage);
        if (dLPluginPackage == null) {
            onFetchProxyServiceClass.onFetch(1, null);
            return;
        }
        String pluginClass = dLIntent.getPluginClass();
        Class<?> clsLoadPluginClass = loadPluginClass(dLPluginPackage.classLoader, pluginClass);
        if (clsLoadPluginClass == null) {
            onFetchProxyServiceClass.onFetch(2, null);
            return;
        }
        Class<? extends Service> proxyServiceClass = getProxyServiceClass(clsLoadPluginClass);
        if (proxyServiceClass == null) {
            onFetchProxyServiceClass.onFetch(3, null);
            return;
        }
        dLIntent.putExtra(DLConstants.EXTRA_CLASS, pluginClass);
        dLIntent.putExtra(DLConstants.EXTRA_PACKAGE, pluginPackage);
        onFetchProxyServiceClass.onFetch(0, proxyServiceClass);
    }

    private void fillPluginApplication(String str, Context context) {
        DLPluginPackage dLPluginPackage = this.mPackagesHolder.get(str);
        if (dLPluginPackage == null || dLPluginPackage.pluginApplication != null) {
            return;
        }
        try {
            Application application = (Application) loadPluginClass(dLPluginPackage.classLoader, dLPluginPackage.packageInfo.applicationInfo.className).newInstance();
            Reflect.on(application).call("attachBaseContext", context.getApplicationContext());
            dLPluginPackage.pluginApplication = application;
            application.onCreate();
        } catch (Exception e) {
            Log.e("tagg", e.toString());
        }
    }

    public static DLPluginManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DLPluginManager.class) {
                if (sInstance == null) {
                    sInstance = new DLPluginManager(context);
                }
            }
        }
        return sInstance;
    }

    private String getPluginActivityFullPath(DLIntent dLIntent, DLPluginPackage dLPluginPackage) {
        String pluginClass = dLIntent.getPluginClass();
        if (pluginClass == null) {
            pluginClass = dLPluginPackage.defaultActivity;
        }
        if (!pluginClass.startsWith(Consts.DOT)) {
            return pluginClass;
        }
        return String.valueOf(dLIntent.getPluginPackage()) + pluginClass;
    }

    private Class<? extends Activity> getProxyActivityClass(Class<?> cls) {
        if (DLBasePluginActivity.class.isAssignableFrom(cls)) {
            return DLProxyActivity.class;
        }
        if (DLBasePluginFragmentActivity.class.isAssignableFrom(cls)) {
            return DLProxyFragmentActivity.class;
        }
        return null;
    }

    private Class<? extends Service> getProxyServiceClass(Class<?> cls) {
        if (DLBasePluginService.class.isAssignableFrom(cls)) {
            return DLProxyService.class;
        }
        return null;
    }

    private Class<?> loadPluginClass(ClassLoader classLoader, String str) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void performStartActivityForResult(Context context, DLIntent dLIntent, int i) {
        Log.d(TAG, "launch " + dLIntent.getPluginClass());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(dLIntent, i);
        } else {
            context.startActivity(dLIntent);
        }
    }

    private DLPluginPackage preparePluginEnv(PackageInfo packageInfo, String str) {
        DLPluginPackage dLPluginPackage = this.mPackagesHolder.get(packageInfo.packageName);
        if (dLPluginPackage != null) {
            return dLPluginPackage;
        }
        DLPluginPackage dLPluginPackage2 = new DLPluginPackage(createDexClassLoader(str), createResources(createAssetManager(str)), packageInfo);
        this.mPackagesHolder.put(packageInfo.packageName, dLPluginPackage2);
        return dLPluginPackage2;
    }

    public int bindPluginService(final Context context, final DLIntent dLIntent, final ServiceConnection serviceConnection, final int i) {
        if (this.mFrom != 0) {
            fetchProxyServiceClass(dLIntent, new OnFetchProxyServiceClass() { // from class: com.ryg.dynamicload.internal.DLPluginManager.2
                @Override // com.ryg.dynamicload.internal.DLPluginManager.OnFetchProxyServiceClass
                public void onFetch(int i2, Class<? extends Service> cls) {
                    if (i2 == 0) {
                        dLIntent.setClass(context, cls);
                        context.bindService(dLIntent, serviceConnection, i);
                    }
                    DLPluginManager.this.mResult = i2;
                }
            });
            return this.mResult;
        }
        dLIntent.setClassName(context, dLIntent.getPluginClass());
        context.bindService(dLIntent, serviceConnection, i);
        return 0;
    }

    public DLPluginPackage getPackage(String str) {
        return this.mPackagesHolder.get(str);
    }

    public DLPluginPackage loadApk(String str) {
        return loadApk(str, true);
    }

    public int startPluginActivity(Context context, DLIntent dLIntent) {
        return startPluginActivityForResult(context, dLIntent, -1);
    }

    @TargetApi(14)
    public int startPluginActivityForResult(Context context, DLIntent dLIntent, int i) {
        if (this.mFrom == 0) {
            dLIntent.setClassName(context, dLIntent.getPluginClass());
            performStartActivityForResult(context, dLIntent, i);
            return 0;
        }
        String pluginPackage = dLIntent.getPluginPackage();
        if (TextUtils.isEmpty(pluginPackage)) {
            throw new NullPointerException("disallow null packageName.");
        }
        DLPluginPackage dLPluginPackage = this.mPackagesHolder.get(pluginPackage);
        if (dLPluginPackage == null) {
            return 1;
        }
        String pluginActivityFullPath = getPluginActivityFullPath(dLIntent, dLPluginPackage);
        Class<?> clsLoadPluginClass = loadPluginClass(dLPluginPackage.classLoader, pluginActivityFullPath);
        if (clsLoadPluginClass == null) {
            return 2;
        }
        Class<? extends Activity> proxyActivityClass = getProxyActivityClass(clsLoadPluginClass);
        if (proxyActivityClass == null) {
            return 3;
        }
        fillPluginApplication(pluginPackage, context);
        dLIntent.putExtra(DLConstants.EXTRA_CLASS, pluginActivityFullPath);
        dLIntent.putExtra(DLConstants.EXTRA_PACKAGE, pluginPackage);
        dLIntent.setClass(this.mContext, proxyActivityClass);
        performStartActivityForResult(context, dLIntent, i);
        return 0;
    }

    public int startPluginService(final Context context, final DLIntent dLIntent) {
        if (this.mFrom != 0) {
            fetchProxyServiceClass(dLIntent, new OnFetchProxyServiceClass() { // from class: com.ryg.dynamicload.internal.DLPluginManager.1
                @Override // com.ryg.dynamicload.internal.DLPluginManager.OnFetchProxyServiceClass
                public void onFetch(int i, Class<? extends Service> cls) {
                    if (i == 0) {
                        dLIntent.setClass(context, cls);
                        context.startService(dLIntent);
                    }
                    DLPluginManager.this.mResult = i;
                }
            });
            return this.mResult;
        }
        dLIntent.setClassName(context, dLIntent.getPluginClass());
        context.startService(dLIntent);
        return 0;
    }

    public int unBindPluginService(final Context context, DLIntent dLIntent, final ServiceConnection serviceConnection) {
        if (this.mFrom == 0) {
            context.unbindService(serviceConnection);
            return 0;
        }
        fetchProxyServiceClass(dLIntent, new OnFetchProxyServiceClass() { // from class: com.ryg.dynamicload.internal.DLPluginManager.3
            @Override // com.ryg.dynamicload.internal.DLPluginManager.OnFetchProxyServiceClass
            public void onFetch(int i, Class<? extends Service> cls) {
                if (i == 0) {
                    context.unbindService(serviceConnection);
                }
                DLPluginManager.this.mResult = i;
            }
        });
        return this.mResult;
    }

    public DLPluginPackage loadApk(String str, boolean z) {
        this.mFrom = 1;
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        DLPluginPackage dLPluginPackagePreparePluginEnv = preparePluginEnv(packageArchiveInfo, str);
        if (z) {
            copySoLib(str);
        }
        return dLPluginPackagePreparePluginEnv;
    }
}
