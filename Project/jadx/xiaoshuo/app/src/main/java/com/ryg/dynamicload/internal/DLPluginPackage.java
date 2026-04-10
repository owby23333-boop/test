package com.ryg.dynamicload.internal;

import android.app.Application;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: classes3.dex */
public class DLPluginPackage {
    public AssetManager assetManager;
    public DexClassLoader classLoader;
    public String defaultActivity = parseDefaultActivityName();
    public PackageInfo packageInfo;
    public String packageName;
    public Application pluginApplication;
    public Resources resources;

    public DLPluginPackage(DexClassLoader dexClassLoader, Resources resources, PackageInfo packageInfo) {
        this.packageName = packageInfo.packageName;
        this.classLoader = dexClassLoader;
        this.assetManager = resources.getAssets();
        this.resources = resources;
        this.packageInfo = packageInfo;
    }

    private final String parseDefaultActivityName() {
        ActivityInfo[] activityInfoArr = this.packageInfo.activities;
        return (activityInfoArr == null || activityInfoArr.length <= 0) ? "" : activityInfoArr[0].name;
    }
}
