package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        dl dlVarZ = dl.z();
        if (dlVarZ != null) {
            HashMap map = new HashMap();
            map.put("s", this);
            dlVarZ.z(map, 157);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        dl dlVarZ = dl.z();
        if (dlVarZ != null) {
            HashMap map = new HashMap();
            map.put("i", intent);
            map.put("c", this);
            dlVarZ.z(map, 158);
        }
        stopSelf();
        return 2;
    }
}
