package com.dangdang.zframework;

import android.app.Application;
import com.dangdang.zframework.plugin.AppUtil;
import com.dangdang.zframework.plugin.DebugUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        AppUtil.getInstance(getApplicationContext());
        DebugUtils.syncIsDebug(getApplicationContext());
        onCreateIpml();
    }

    public abstract void onCreateIpml();
}
