package com.bytedance.sdk.openadsdk.stub.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.gc;
import com.bytedance.sdk.openadsdk.dl.a;

/* JADX INFO: loaded from: classes2.dex */
public class MainServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TTAppContextHolder.setContext(applicationContext);
        if (!gc.z() && (applicationContext instanceof Application)) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(a.z().g());
        }
        return super.onCreate();
    }
}
