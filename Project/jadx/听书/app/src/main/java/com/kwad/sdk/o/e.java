package com.kwad.sdk.o;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes4.dex */
final class e extends ContextWrapper implements b {
    private Resources.Theme aqh;
    private int aqi;
    private final Context bdP;
    private LayoutInflater mInflater;

    e(Context context) {
        super(context);
        this.aqi = -1;
        this.bdP = context;
        this.aqi = m.getThemeResId(context);
    }

    @Override // com.kwad.sdk.o.b
    public final Context getDelegatedContext() {
        return this.bdP;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdP.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.bdP.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return j.wrapContextIfNeed(this.bdP.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return f.SS().getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aqi = i;
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
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

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = m.b(this.bdP, this);
            }
            return this.mInflater;
        }
        return this.bdP.getSystemService(str);
    }
}
