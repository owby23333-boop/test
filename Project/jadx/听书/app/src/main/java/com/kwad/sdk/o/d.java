package com.kwad.sdk.o;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes4.dex */
final class d extends ContextThemeWrapper implements b {
    private Resources.Theme aqh;
    private int aqi;
    private final ContextThemeWrapper bdO;
    private LayoutInflater mInflater;

    public d(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.bdO = contextThemeWrapper;
        this.aqi = m.getThemeResId(contextThemeWrapper);
    }

    @Override // com.kwad.sdk.o.b
    public final Context getDelegatedContext() {
        return this.bdO;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdO.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdO.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return j.wrapContextIfNeed(this.bdO.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return f.SS().getResources();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aqi = i;
        super.setTheme(i);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = m.b(this.bdO, this);
            }
            return this.mInflater;
        }
        return this.bdO.getSystemService(str);
    }
}
