package com.kwai.sodler.lib.kwai.b;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RestrictedApi"})
final class d extends ContextThemeWrapper implements b {
    private String aIP;
    private Resources.Theme aan;
    private int aao;
    private final ContextThemeWrapper aap;

    public d(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.aap = contextThemeWrapper;
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
        return this.aap;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.b(super.getClassLoader(), this.aIP);
    }

    @Override // com.kwai.sodler.lib.kwai.b.b
    public final Context getDelegatedContext() {
        return this.aap;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(super.getResources(), this.aIP);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aap.getSystemService(str), str, this);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
        this.aap.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        this.aao = i2;
        super.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aap.unregisterComponentCallbacks(componentCallbacks);
    }
}
