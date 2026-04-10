package com.kwad.sdk.o;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.kwad.sdk.utils.z;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends Application implements b {
    private final Application bdX;
    private final h bdY;

    public g(Application application, h hVar) {
        this.bdX = application;
        this.bdY = hVar;
        try {
            z.b(this, "mBase", hVar);
        } catch (Throwable unused) {
            attachBaseContext(hVar);
        }
    }

    @Override // com.kwad.sdk.o.b
    public final Context getDelegatedContext() {
        return this.bdX;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this.bdY.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.bdY.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.bdY.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.bdY.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        this.bdX.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr) {
        this.bdX.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, Bundle bundle) {
        this.bdX.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr, Bundle bundle) {
        this.bdX.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ComponentName startForegroundService(Intent intent) {
        return this.bdX.startForegroundService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void sendBroadcast(Intent intent) {
        this.bdX.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.bdX.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unbindService(ServiceConnection serviceConnection) {
        this.bdX.unbindService(serviceConnection);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.bdX.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ComponentName startService(Intent intent) {
        return this.bdX.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean stopService(Intent intent) {
        return this.bdX.stopService(intent);
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.bdX.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.bdX.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
