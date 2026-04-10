package com.ryg.dynamicload;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.ryg.dynamicload.internal.DLPluginPackage;

/* JADX INFO: loaded from: classes3.dex */
public interface DLServicePlugin {
    void attach(Service service2, DLPluginPackage dLPluginPackage);

    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    void onStart(Intent intent, int i);

    int onStartCommand(Intent intent, int i, int i2);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i);

    boolean onUnbind(Intent intent);
}
