package com.kwai.sodler.lib.kwai.b;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
final class c extends ContextThemeWrapper implements b {
    private String aIP;
    private final ContextThemeWrapper aam;
    private Resources.Theme aan;
    private int aao;

    c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.aam = contextThemeWrapper;
        this.aIP = str;
        try {
            Object objA = r.a((Object) contextThemeWrapper, "getThemeResId", new Object[0]);
            if (objA != null) {
                this.aao = ((Integer) objA).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.au(super.getApplicationContext(), this.aIP);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aam;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.b(super.getClassLoader(), this.aIP);
    }

    @Override // com.kwai.sodler.lib.kwai.b.b
    public final Context getDelegatedContext() {
        return this.aam;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(super.getResources(), this.aIP);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aam.getSystemService(str), str, this);
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
            this.aan = a.a(theme, this.aan, this.aao, this.aIP);
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
