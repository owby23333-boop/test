package com.ryg.dynamicload;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.ryg.dynamicload.internal.DLPluginPackage;
import com.ryg.utils.LOG;

/* JADX INFO: loaded from: classes3.dex */
public class DLBasePluginService extends Service implements DLServicePlugin {
    public static final String TAG = "DLBasePluginService";
    private DLPluginPackage mPluginPackage;
    private Service mProxyService;
    protected Service that = this;
    protected int mFrom = 0;

    @Override // com.ryg.dynamicload.DLServicePlugin
    public void attach(Service service2, DLPluginPackage dLPluginPackage) {
        LOG.d(TAG, "DLBasePluginService attach");
        this.mProxyService = service2;
        this.mPluginPackage = dLPluginPackage;
        this.that = service2;
        this.mFrom = 1;
    }

    public boolean isInternalCall() {
        return this.mFrom == 0;
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public IBinder onBind(Intent intent) {
        LOG.d(TAG, "DLBasePluginService onBind");
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks, com.ryg.dynamicload.DLServicePlugin
    public void onConfigurationChanged(Configuration configuration) {
        LOG.d(TAG, "DLBasePluginService onConfigurationChanged");
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public void onCreate() {
        LOG.d(TAG, "DLBasePluginService onCreate");
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public void onDestroy() {
        LOG.d(TAG, "DLBasePluginService onDestroy");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks, com.ryg.dynamicload.DLServicePlugin
    public void onLowMemory() {
        LOG.d(TAG, "DLBasePluginService onLowMemory");
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public void onRebind(Intent intent) {
        LOG.d(TAG, "DLBasePluginService onRebind");
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public int onStartCommand(Intent intent, int i, int i2) {
        LOG.d(TAG, "DLBasePluginService onStartCommand");
        return 0;
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public void onTaskRemoved(Intent intent) {
        LOG.d(TAG, "DLBasePluginService onTaskRemoved");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2, com.ryg.dynamicload.DLServicePlugin
    public void onTrimMemory(int i) {
        LOG.d(TAG, "DLBasePluginService onTrimMemory");
    }

    @Override // android.app.Service, com.ryg.dynamicload.DLServicePlugin
    public boolean onUnbind(Intent intent) {
        LOG.d(TAG, "DLBasePluginService onUnbind");
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        if (this.mFrom == 0) {
            super.sendBroadcast(intent);
            return;
        }
        Service service2 = this.that;
        if (service2 == null) {
            return;
        }
        service2.sendBroadcast(intent);
    }
}
