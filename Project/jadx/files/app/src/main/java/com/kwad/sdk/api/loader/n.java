package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;

/* JADX INFO: loaded from: classes3.dex */
final class n extends ContextThemeWrapper implements ResContext {
    private final ContextThemeWrapper aam;
    private Resources.Theme aan;
    private int aao;

    n(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.aam = contextThemeWrapper;
        this.aao = ((Integer) Reflect.c(contextThemeWrapper).aY("getThemeResId").get()).intValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return Wrapper.wrapContextIfNeed(super.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return Wrapper.wrapContextIfNeed(super.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return Wrapper.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public final Context getDelegatedContext() {
        return this.aam;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return Wrapper.wrapSystemService(this.aam.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e2) {
            e2.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aan;
        if (theme2 == null || theme2 == theme) {
            this.aan = Wrapper.replaceTheme(theme, this.aan, this.aao);
        }
        return this.aan;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aam.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        this.aao = i2;
        super.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aam.unregisterComponentCallbacks(componentCallbacks);
    }
}
