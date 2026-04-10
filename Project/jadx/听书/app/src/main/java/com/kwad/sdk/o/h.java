package com.kwad.sdk.o;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends ContextThemeWrapper {
    private final Context bdP;
    private final f bdZ;
    private g bea;
    private LayoutInflater mInflater;

    public h(Context context, f fVar) {
        super(context, m.getThemeResId(context));
        this.bdP = context;
        this.bdZ = fVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper
    public final void applyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.bdZ.getResources().getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.bdZ.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createConfigurationContext(Configuration configuration) {
        return m.wrapContextIfNeed(super.createConfigurationContext(configuration));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        g gVar = this.bea;
        if (gVar != null) {
            return gVar;
        }
        Context context = this.bdP;
        if (context instanceof g) {
            g gVar2 = (g) context;
            this.bea = gVar2;
            return gVar2;
        }
        if (context instanceof Application) {
            g gVar3 = (g) m.wrapContextIfNeed(context);
            this.bea = gVar3;
            return gVar3;
        }
        return m.wrapContextIfNeed(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
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
    public final ClassLoader getClassLoader() {
        return this.bdZ.getClassLoader();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
