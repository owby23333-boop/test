package com.ryg.dynamicload.internal;

import android.content.Intent;
import android.os.Parcelable;
import com.ryg.utils.DLConfigs;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DLIntent extends Intent {
    private String mPluginClass;
    private String mPluginPackage;

    public DLIntent() {
    }

    private void setupExtraClassLoader(Object obj) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        DLConfigs.sPluginClassloader = classLoader;
        setExtrasClassLoader(classLoader);
    }

    public String getPluginClass() {
        return this.mPluginClass;
    }

    public String getPluginPackage() {
        return this.mPluginPackage;
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable parcelable) {
        setupExtraClassLoader(parcelable);
        return super.putExtra(str, parcelable);
    }

    public void setPluginClass(String str) {
        this.mPluginClass = str;
    }

    public void setPluginPackage(String str) {
        this.mPluginPackage = str;
    }

    public DLIntent(String str) {
        this.mPluginPackage = str;
    }

    public void setPluginClass(Class<?> cls) {
        this.mPluginClass = cls.getName();
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Serializable serializable) {
        setupExtraClassLoader(serializable);
        return super.putExtra(str, serializable);
    }

    public DLIntent(String str, String str2) {
        this.mPluginPackage = str;
        this.mPluginClass = str2;
    }

    public DLIntent(String str, Class<?> cls) {
        this.mPluginPackage = str;
        this.mPluginClass = cls.getName();
    }
}
