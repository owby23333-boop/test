package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

/* JADX INFO: loaded from: classes10.dex */
public class BinderPoolService extends Service {
    private Binder e = new e.BinderC0144e();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        wu.bf("MultiProcess", "BinderPoolService onBind ! ");
        return this.e;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        wu.bf("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        wu.bf("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
