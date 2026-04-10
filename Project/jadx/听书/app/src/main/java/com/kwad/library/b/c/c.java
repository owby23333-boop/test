package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.z;

/* JADX INFO: loaded from: classes4.dex */
final class c extends ContextThemeWrapper implements b {
    private final ContextThemeWrapper aqg;
    private Resources.Theme aqh;
    private int aqi;
    private String aqj;

    c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.aqg = contextThemeWrapper;
        this.aqj = str;
        try {
            Object objA = z.a((Object) contextThemeWrapper, "android.view.ContextThemeWrapper", "getThemeResId");
            if (objA != null) {
                this.aqi = ((Integer) objA).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.aqg;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aqg.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aqg.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.j(this.aqg.getApplicationContext(), this.aqj);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aqg;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.aqg.getResources(), this.aqj);
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
            this.aqh = a.a(theme, theme2, this.aqi, this.aqj);
        }
        return this.aqh;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.aqj);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aqg.getSystemService(str), str, this);
    }
}
