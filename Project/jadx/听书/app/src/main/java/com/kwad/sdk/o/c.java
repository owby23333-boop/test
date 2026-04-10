package com.kwad.sdk.o;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes4.dex */
final class c extends ContextThemeWrapper implements b {
    private Resources.Theme aqh;
    private int aqi;
    private final ContextThemeWrapper bdN;
    private LayoutInflater mInflater;

    c(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.bdN = contextThemeWrapper;
        this.aqi = m.getThemeResId(contextThemeWrapper);
    }

    @Override // com.kwad.sdk.o.b
    public final Context getDelegatedContext() {
        return this.bdN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdN.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdN.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return j.wrapContextIfNeed(this.bdN.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return f.SS().getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return f.SS().getResources().getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aqi = i;
        super.setTheme(i);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aqh;
        if (theme2 == null || theme2 == theme) {
            this.aqh = j.replaceTheme(theme, theme2, this.aqi);
        }
        return this.aqh;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return j.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = m.b(this.bdN, this);
            }
            return this.mInflater;
        }
        return this.bdN.getSystemService(str);
    }
}
